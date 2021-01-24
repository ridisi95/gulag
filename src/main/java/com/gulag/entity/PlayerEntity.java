package com.gulag.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayerEntity {

    Integer id;

    String nickName;
}
