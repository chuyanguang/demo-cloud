package com.example.demosec.config;

import com.example.demosec.dao.UserRepository;
import com.example.demosec.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (StringUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        Collection<GrantedAuthority> authList = new ArrayList<>();
        UserDetails userDetails  = org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(passwordEncoder.encode(user.getPassword()))
                .authorities(authList).build();
        return userDetails;
    }

}
