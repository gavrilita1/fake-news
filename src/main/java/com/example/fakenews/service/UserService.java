package com.example.fakenews.service;

import com.example.fakenews.entity.Credentials;
import com.example.fakenews.entity.User;
import com.example.fakenews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.JSONObject;

import java.util.List;


@Service
public class UserService implements iUserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        for (User user : users) {
            userRepository.save(user);
        }
        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserByName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public Credentials login(Credentials credentials) {

        User user =  userRepository.findByUsername(credentials.getUserName());

        if(user!=null){
            if(user.getUserPassword().equals(credentials.getUserPassword())){
                credentials.setUserId(user.getUserId());
                credentials.setLogin(true);
            }
            else {
                credentials.setUserId(user.getUserId());
                credentials.setLogin(false);
            }
        }
        else{
            credentials.setUserId(99);
            credentials.setLogin(false);
        }
        return credentials;
    }

    public Credentials signUp(Credentials credentials) {

        User user =  userRepository.findByUsername(credentials.getUserName());

        if(user!=null)
        {
            credentials.setUserId(user.getUserId());
            credentials.setLogin(false);
        }
        else {
            User user2 = new User();
            user2.setUserName(credentials.getUserName());
            user2.setUserPassword(credentials.getUserPassword());
            credentials.setLogin(true);
            userRepository.save(user2);
        }
        return credentials;
    }


    @Override
    public User getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        existingUser.setUserName(user.getUserName());
        existingUser.setUserPassword(user.getUserPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
