package com.codeup.springblog.services;

import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserWithRoles;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository usersRepository;

    public UserDetailsLoader(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for username: " + username);
        }
        return new UserWithRoles(user);
    }
}