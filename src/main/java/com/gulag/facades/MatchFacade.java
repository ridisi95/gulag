package com.gulag.facades;

import com.gulag.entity.MatchEntity;

import java.math.BigInteger;

public interface MatchFacade {

    MatchEntity addMatchToGulag(BigInteger id, Long tournamentId);
}
