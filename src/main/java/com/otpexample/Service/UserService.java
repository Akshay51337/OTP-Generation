package com.otpexample.Service;

import com.otpexample.Entity.User;
import com.otpexample.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

@Autowired
    private UserRepository userRepository;

public User userRegister(User user){
    return userRepository.save(user);
}
public User getUserByEmail(String email){
    User user = userRepository.findByEmail(email);
    return user;
}
public void verifyEmail(User user){
    user.setEmailVerified(true);
    userRepository.save(user);
}

    public boolean isEmailVerified(String email) {
        User user = userRepository.findByEmail(email);
       return user!=null && user.isEmailVerified();
    }
}
