package com.sadio.gestion_de_stock.serivice.serviceImpl;

/*
import com.sadio.gestion_de_stock.model.Role;
import com.sadio.gestion_de_stock.model.TypeRole;
import com.sadio.gestion_de_stock.model.User;
import com.sadio.gestion_de_stock.model.dto.UserDto;
import com.sadio.gestion_de_stock.repository.UserRepository;
import com.sadio.gestion_de_stock.serivice.SendMailService;
import com.sadio.gestion_de_stock.serivice.UserService;
import com.sadio.gestion_de_stock.serivice.ValidationService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ValidationService validationService;


    @Override
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

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }
}
*/