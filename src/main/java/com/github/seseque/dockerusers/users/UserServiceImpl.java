package com.github.seseque.dockerusers.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserMapper mapper;
    private final UserRepository repository;

    @Override
    public UserRes createUser(UserReq user) {
        return mapper.toResponse(repository.save(mapper.toEntity(user)));
    }

    @Override
    public UserRes getUser(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public UserRes deleteUser(Long id) {
        User saved = repository.findById(id).orElseThrow(UserNotFoundException::new);
        repository.delete(saved);
        return mapper.toResponse(saved);
    }

    @Override
    public UserRes updateUsername(Long id, UserReq userReq) {
        var entity = repository.findById(id).orElseThrow(UserNotFoundException::new);
        entity.setUsername(userReq.username);
        var saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    @Override
    public UserRes updateUserPostsAmount(Long id, UserPostsAmountReq userReq) {
        var entity = repository.findById(id).orElseThrow(UserNotFoundException::new);
        entity.setAmountOfPosts(entity.amountOfPosts + userReq.amount);
        var saved = repository.save(entity);
        return mapper.toResponse(saved);
    }
}
