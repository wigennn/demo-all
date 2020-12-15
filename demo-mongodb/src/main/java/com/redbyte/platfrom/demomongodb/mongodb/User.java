package com.redbyte.platfrom.demomongodb.mongodb;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangwq
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8347301220344570688L;

    private String id;
    private String name;
    private String age;
}
