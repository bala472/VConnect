package com.vconnect.createuser;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean storeUserDetails(User user){
        try{
            userRepository.save(user);
            return true;
        }catch (DataAccessException e) {
            return false;
        } catch (ConstraintViolationException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
