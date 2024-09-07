package com.sadio.gestion_de_stock.serivice;

import com.sadio.gestion_de_stock.model.Role;
import com.sadio.gestion_de_stock.model.TypeRole;
import com.sadio.gestion_de_stock.model.User;
import com.sadio.gestion_de_stock.model.dto.UserDto;
import com.sadio.gestion_de_stock.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private  UserRepository userRepository;

    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    private  ValidationService validationService;


    public User save(UserDto userDto) {
        User user = UserDto.toEntity(userDto);

        String mdpCrypt =  this.bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(mdpCrypt);

        Role roleUser = new Role();
        roleUser.setLibelle(TypeRole.UTILISATEUR);
        user.setRole(roleUser);

        user = userRepository.save(user);
        //this.validationService.enregistrement(user);

        return user;
    }


    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(" Information erronées"));
    }
}
