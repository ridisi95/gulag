package com.gulag.controller;

import com.gulag.dto.UserDTO;
import com.gulag.entity.UserEntity;
import com.gulag.facades.UserFacade;
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
    UserFacade userFacade;
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDTO> registerUser(@Validated(OnCreate.class) @Valid @RequestBody UserDTO inputUserDTO) {
        var userEntity = userMapper.mapDTOToEntity(inputUserDTO);
        var userDTO = userMapper.mapEntityToDTO(userFacade.createUser(userEntity));
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping()
    public ResponseEntity<UserDTO> updateUser(@Validated(OnUpdate.class) @Valid @RequestBody UserDTO inputUserDTO) {
        UserEntity outputEntity = userFacade.updateUser(userMapper.mapDTOToEntity(inputUserDTO));
        return ResponseEntity.ok(userMapper.mapEntityToDTO(outputEntity));
    }

    @GetMapping()
    public ResponseEntity<UserDTO> findUserById(@RequestParam Long id) {
        return ResponseEntity.ok(userMapper.mapEntityToDTO(userService.findByUserId(id)));
    }
}
