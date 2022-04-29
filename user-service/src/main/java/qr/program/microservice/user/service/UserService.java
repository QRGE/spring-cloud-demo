package qr.program.microservice.user.service;

import qr.program.microservice.user.mapper.UserMapper;
import qr.program.microservice.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.findById(id);
    }
}