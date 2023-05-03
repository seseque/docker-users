package com.github.seseque.dockerusers.users;

public interface UserService {
    UserRes createUser(UserReq user);

    UserRes getUser(Long id);

    void deleteUser(Long id);

    UserRes updateUser(Long id, UserReq user);
}
