package org.ddmed.ris.service;

import org.ddmed.ris.model.Role;
import org.ddmed.ris.model.User;
import org.ddmed.ris.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return user;
    }

    public void createDefaultUser(){
        User userAd = (User) loadUserByUsername("admin");

        if(userAd == null) {
            Role role = new Role();
            role.setName("ROLE_ADMIN");

            User user = new User();
            user.setFirstName("Dmytro");
            user.setLastName("Melnyk");
            user.setUsername("admin");
            user.setPassword("admin");
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setRoles(List.of(role));

            userRepository.save(user);
        }
    }

}