package com.example.demo2.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo2.domain.model.User;
import com.example.demo2.domain.repository.UserMapper;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<User> getUsers(){
        return mapper.findAll();
    }

    public User getUserById(int id){
        return mapper.findOneById(id);
    }

    public int createUser(String name, String mailAddress){
        return mapper.insertOne(name, mailAddress);
    }

    public int updateUser(int userId, String userName, String mailAddress){
        return mapper.updateOne(userId, userName, mailAddress);
    }

    public int deleteUser(int id){
        return mapper.deleteOne(id);
    }

}
