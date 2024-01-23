package sv.iuh.SpringJWT.services.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sv.iuh.SpringJWT.entity.User;
import sv.iuh.SpringJWT.repositories.UserRepository;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;



    @Override
    public org.springframework.security.core.userdetails.User loadUserByUsername(String mail) throws UsernameNotFoundException{
        User user = userRepository.findFirstByEmail(mail);
        if(user == null){
            throw new UsernameNotFoundException("User not found with email: " + mail);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
