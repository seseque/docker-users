package com.github.seseque.dockerusers.users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUsersPostsReq {
    Integer newAmount;
}
