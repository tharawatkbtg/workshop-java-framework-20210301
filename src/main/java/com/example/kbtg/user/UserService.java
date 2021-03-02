package com.example.kbtg.user;

import com.example.kbtg.ConstantClass;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserResponse getInfo(int id) {
        if(id <= 10) {
            // Success
            return new UserResponse(id, ConstantClass.User, 30);
        }
        // Fail
        throw new UserNotFoundException("User not found id="+ id);
    }
}
