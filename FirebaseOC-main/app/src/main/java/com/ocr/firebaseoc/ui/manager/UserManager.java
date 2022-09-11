package com.ocr.firebaseoc.ui.manager;

import com.google.firebase.auth.FirebaseUser;
import com.ocr.firebaseoc.ui.repository.UserRepository;

public class UserManager {

    private static volatile UserManager instance;
    private  UserRepository userRepository;

    private UserManager() {
        userRepository = UserRepository.getInstance();
    }

    public static UserManager getInstance() {
        UserManager result = instance;
        if (result != null) {
            return result;
        }
        synchronized(UserRepository.class) {
            if (instance == null) {
                instance = new UserManager();
            }
            return instance;
        }
    }

    public Boolean isCurrentUserLogged(){
        return (this.getCurrentUser() != null);
    }
    public FirebaseUser getCurrentUser(){
        return userRepository.getCurrentUser();
    }



}
