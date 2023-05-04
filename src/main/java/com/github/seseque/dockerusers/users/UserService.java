package com.github.seseque.dockerusers.users;

public interface UserService {
    UserRes createUser(UserReq user);

    UserRes getUser(Long id);

    void deleteUser(Long id);

    UserRes updateUsername(Long id, UserReq user);
    UserRes updateUserPostsAmount(Long id, UserPostsAmountReq user);
}
