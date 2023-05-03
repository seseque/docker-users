package com.github.seseque.dockerusers.users;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserReq req);

    UserRes toResponse(User entity);
}
