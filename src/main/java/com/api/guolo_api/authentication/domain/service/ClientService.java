package com.api.guolo_api.authentication.domain.service;
import com.api.guolo_api.authentication.application.output.UserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class ClientService implements UserDetailsService  {
    private final UserOutputPort userOutputPort;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        var user = userOutputPort.loadUserByUsername(username);
        if (user == null){
            return null;
        } else {
            return User.builder().username(user.getEmail()).password(user.getPassword()).build();
        }

    }


}
