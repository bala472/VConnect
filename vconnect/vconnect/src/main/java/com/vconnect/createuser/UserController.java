package com.vconnect.createuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/storeuserdetails",method = RequestMethod.POST)
    public boolean storeUserDetails(User user){
        return userService.storeUserDetails(user);
    }
}
