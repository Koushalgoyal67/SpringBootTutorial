package com.koushal.sceureapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.koushal.sceureapp.dao.UserRepository;
import com.koushal.sceureapp.model.User;
import com.koushal.sceureapp.security.UserPrincipal;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	@Autowired
    private UserRepository userRepository;

//    public UserPrincipalDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }
}
