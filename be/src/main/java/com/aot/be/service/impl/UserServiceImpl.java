package com.aot.be.service.impl;

import com.aot.be.entities.core.User;
import com.aot.be.repository.UserRepository;
import com.aot.be.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User>user = userRepository.findByEmail(email);
        return user.orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
