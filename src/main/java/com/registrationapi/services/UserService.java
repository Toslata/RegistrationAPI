package com.registrationapi.services;

import com.registrationapi.models.User;
import com.registrationapi.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public boolean checkExists(String username)
    {
        return userRepository.existsByUsername(username);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getByUsername(String username)
    {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        Optional<User> user = userRepository.findByUsername(s);

        if (user.isPresent()){
            return user.get();
        }else{
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }
    }
}
