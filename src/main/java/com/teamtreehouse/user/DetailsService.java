package com.teamtreehouse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Rumy on 10/26/2017.
 */
@Component
public class DetailsService implements UserDetailsService {
    @Autowired
    UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=users.findByName(username);
        if (user==null){
          throw  new UsernameNotFoundException(username+" not found!");
        }

        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoles()));
    }
}
