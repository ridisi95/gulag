package com.gulag.services;

import com.gulag.entity.MatchEntity;

import java.math.BigInteger;

public interface MatchService {

    MatchEntity fetchMatchFromCod(BigInteger id);

    MatchEntity save(MatchEntity matchEntity);
}
