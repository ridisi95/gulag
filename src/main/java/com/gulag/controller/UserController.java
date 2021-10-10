package com.gulag.controller;

import com.gulag.dto.UserDTO;
import com.gulag.exception.UpdateObjectException;
import com.gulag.mapper.UserEntityDTOMapper;
import com.gulag.services.UserService;
import com.gulag.validation.marker.OnCreate;
import com.gulag.validation.marker.OnUpdate;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    UserEntityDTOMapper userMapper;
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> registerUser(@Valid @Validated(OnCreate.class) @RequestBody UserDTO inputUserDTO) {
        var userEntity = userMapper.mapDTOToEntity(inputUserDTO);
        var userDTO = userMapper.mapEntityToDTO(userService.saveOrUpdate(userEntity));
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping()
    public ResponseEntity<UserDTO> updateUser(@Valid @Validated(OnUpdate.class) @RequestBody UserDTO inputUserDTO) {
        var userEntity = userService.findByUserId(inputUserDTO.getId());
        if (userEntity == null) {
            throw new UpdateObjectException("updating object not found id: " + inputUserDTO.getId());
        }
        userMapper.safetyMapToEntity(inputUserDTO, userEntity);
        userService.saveOrUpdate(userEntity);
        return ResponseEntity.ok(userMapper.mapEntityToDTO(userEntity));
    }

    @GetMapping()
    public ResponseEntity<UserDTO> findUserById(@RequestParam Long id) {
        return ResponseEntity.ok(userMapper.mapEntityToDTO(userService.findByUserId(id)));
    }
}
