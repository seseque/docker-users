package com.github.seseque.dockerusers.users;

import lombok.Data;

@Data
public class UserRes {
    Long id;
    String username;
    Integer amountOfPosts;
}
