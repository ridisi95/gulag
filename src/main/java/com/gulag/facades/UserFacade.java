package com.gulag.facades;

import com.gulag.entity.UserEntity;

public interface UserFacade {

    /**
     * Fetches user data from Call of duty api. Verify and enrich unoNumber using.
     * @param unoTag input for searching
     * @return updated user
     */
    UserEntity enrichUnoNumber(String unoTag);

}
