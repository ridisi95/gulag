package com.gulag.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Player {

    Integer id;

    String nickName;
}
