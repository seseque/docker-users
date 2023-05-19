package com.github.seseque.dockerusers.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/greeting")
    String greeting() {
        return "Hello, k8s!";
    }

    @PostMapping("/users")
    UserRes createUser(@RequestBody UserReq user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserRes> getUser(@PathVariable Long id) {
        try {
            UserRes res = userService.getUser(id);
            return ResponseEntity.ok(res);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    UserRes updateUser(@PathVariable Long id, @RequestBody UserReq user) {
        return userService.updateUsername(id, user);
    }

    @PutMapping("/users/{id}/posts")
    UserRes updateUserPosts(@PathVariable Long id, @RequestBody UserPostsAmountReq user) {
        return userService.updateUserPostsAmount(id, user);
    }

}
