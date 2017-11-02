package com.teamtreehouse.control;

import com.teamtreehouse.user.User;
import com.teamtreehouse.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Rumy on 10/30/2017.
 */
@Component
@RepositoryEventHandler(Control.class)
public class ControlEventHandler {
    private final UserRepository users;

    @Autowired
    public ControlEventHandler(UserRepository users) {
        this.users = users;
    }


    @HandleBeforeSave
    public void setLastModifiedByBaseOnLoggedInUser(Control control){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        User user=users.findByName(userName);
        control.setLastModifiedBy(user);
    }



}
