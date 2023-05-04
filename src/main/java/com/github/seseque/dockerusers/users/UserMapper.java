package com.github.seseque.dockerusers.users;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "amountOfPosts", ignore = true)
    User toEntity(UserReq req);

    UserRes toResponse(User entity);
}
