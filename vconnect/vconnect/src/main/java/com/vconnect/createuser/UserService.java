package com.vconnect.createuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean createUser(User user){
        try{
            userRepository.save(validateUserId(user));
            return true;
        } catch (DataIntegrityViolationException e) {
            // Handle specific constraint violation exceptions (e.g., unique constraint)
            return false;
        } catch (TransactionSystemException e) {
            // Handle transaction-related exceptions
            return false;
        } catch (Exception e) {
            // Handle other unexpected exceptions
            return false;
        }
    }

    private User validateUserId(User user) {
        String prefix = "";
        if ("User".equalsIgnoreCase(user.getUserCategory())) {
            prefix = "VCONU";
        } else if ("Service Provider".equalsIgnoreCase(user.getUserCategory())) {
            prefix = "VCONSP";
        } else {
            throw new IllegalArgumentException("Invalid user category");
        }
        while(userRepository.existsByUserId(user.getUserId())){
            user.setUserId(prefix + UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }
        return user;
    }

}
