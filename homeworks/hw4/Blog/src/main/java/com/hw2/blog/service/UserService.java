package com.hw2.blog.service;


import com.hw2.blog.config.WebSecurityConfig;
import com.hw2.blog.entity.User;
import com.hw2.blog.exception.UserException;
import com.hw2.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", username));
        }
    }


    public User getUserByUsername(String username){

        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent())
            return user.get();
        else{
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", username));
        }
    }

    public User registerUser(User user) throws UserException, Exception{


        if(userRepository.existsUserByEmail(user.getEmail())){
                throw new UserException("email", "User with " + user.getEmail() + " email already exist!");
        }else if(userRepository.existsUserByUsername(user.getUsername())){
                throw new UserException("username", "User with " + user.getUsername() + " username already exist!");
        }else if(user.getUsername().equalsIgnoreCase(user.getPassword())){
            throw new UserException("password", "Password cannot be same with username");
        }

        final String encryptedPassword = new BCryptPasswordEncoder(12).encode(user.getPassword());
        user.setPassword(encryptedPassword);
        final User created_user = userRepository.save(user);
        return created_user;
    }

}
