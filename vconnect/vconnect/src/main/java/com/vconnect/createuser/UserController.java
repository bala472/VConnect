package com.vconnect.createuser;

import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "createuser",method = RequestMethod.POST)
    public boolean createUser(User user){
        return userService.createUser(user);
    }
}
