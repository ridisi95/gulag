package com.gulag.controller;

import com.gulag.api.client.user.TRNUserClient;
import com.gulag.facades.UserFacade;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for doing some actions related to 'Call of Duty' api and other systems
 */

@RequiredArgsConstructor
@RestController()
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/cod")
public class CODController {


    TRNUserClient trnUserClient;

    @GetMapping
    public ResponseEntity<?> loginToCOD(@RequestParam String unoTag) {

        trnUserClient.verifyUser(unoTag);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
