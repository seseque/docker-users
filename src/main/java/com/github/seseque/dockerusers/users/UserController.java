package com.github.seseque.dockerusers.users;

import jakarta.validation.Valid;
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
    UserRes createUser(@RequestBody @Valid UserReq user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserRes> getUser(@PathVariable Long id) {
        try {
            UserRes res = userService.getUser(id);
            return ResponseEntity.ok(res);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<UserRes> deleteUser(@PathVariable Long id) {
        try {
            UserRes res = userService.deleteUser(id);
            return ResponseEntity.ok(res);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/users/{id}")
    ResponseEntity<UserRes> updateUser(@PathVariable Long id, @Valid @RequestBody UserReq user) {
        try {
            UserRes res = userService.updateUsername(id, user);
            return ResponseEntity.ok(res);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/users/{id}/posts")
    ResponseEntity<UserRes> updateUserPosts(@PathVariable Long id, @RequestBody UserPostsAmountReq user) {
        try {
            UserRes res = userService.updateUserPostsAmount(id, user);
            return ResponseEntity.ok(res);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
