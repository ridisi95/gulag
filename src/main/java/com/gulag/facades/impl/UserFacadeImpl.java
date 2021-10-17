package com.gulag.facades.impl;

import com.gulag.api.client.user.CODInizialize;
import com.gulag.api.client.user.CODLogin;
import com.gulag.api.client.user.TRNUserClient;
import com.gulag.entity.UserEntity;
import com.gulag.facades.UserFacade;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserFacadeImpl implements UserFacade {

    CODLogin codLogin;
    CODInizialize codInizialize;
    TRNUserClient trnUserClient;

    @Override
    public UserEntity enrichUnoNumber(String unoTag) {

//        String xsrfHeader = codInizialize.doRequest();
//        Object response = codLogin.doRequest(xsrfHeader);

        trnUserClient.doRequest(unoTag);

        return null;
    }
}
