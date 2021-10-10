package com.gulag.controller;

import com.gulag.dto.UserDTO;
import com.gulag.entity.UserEntity;
import com.gulag.mapper.UserEntityDTOMapper;
import com.gulag.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/users")
public class UserController {

    UserEntityDTOMapper userMapper;
    UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO inputUserDTO) {
        UserEntity userEntity = userMapper.mapDTOToEntity(inputUserDTO);
        UserDTO outputUserDTO = userMapper.mapEntityToDTO(userService.createUser(userEntity));
        return ResponseEntity.ok(outputUserDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> findUserById(@RequestParam Long id) {
        return ResponseEntity.ok(userMapper.mapEntityToDTO(userService.findByUserId(id)));
    }
}
