package com.adrar.api.service;

import com.adrar.api.dto.user.UserDTO;
import com.adrar.api.dto.user.UserDTOWrapper;
import com.adrar.api.entity.filter.NameOnly;
import com.adrar.api.entity.User;
import com.adrar.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    //Afficher tous les utilisateurs
    public List<User> getAllUser()
    {
        return (List<User>) userRepository.findAll();
    }


    //Ajouter un utilisateur
    public User addUser(User user) throws RuntimeException
    {
        //Vérifier si le compte existe
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
        }
        return userRepository.save(user);
    }

    //Afficher un utilisateur
    public User getUserByEmail(String email)
    {
        return userRepository
                .findByEmail(email)
                .orElseThrow(RuntimeException::new);
    }

    //Mettre à jour un utilisateur
    public User modifyUser(User user)
    {
        //Vérifier si le compte existe
        if (!userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("L'utilisateur n'existe pas");
        }
        return userRepository.save(user);
    }
    //Supprimer un utilisateur
    public void removeUser(Integer id)
    {
        userRepository.deleteById(id);
    }

    public List<NameOnly> getAllUserFilter()
    {
        return userRepository.findAllBy();
    }

    //Retourner un userDTO par son id
    public UserDTO getUserDTO(Integer id)
    {
        return UserDTOWrapper
                .userToUserDTO(
                        userRepository
                                .findById(id)
                                .get()
                );
    }

    //Retourner tous les utilisateurs List<userDTO>
    public List<UserDTO> getAllUserDTOs()
    {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            userDTOs.add(UserDTOWrapper.userToUserDTO(user));
        }
        return userDTOs;
    }
    //Retourner tous les utilisateurs List<userDTO> v2
    public List<UserDTO> getAllUserDTOsV2()
    {
        List<UserDTO> userDTOs = new ArrayList<>();
        userRepository
                .findAll()
                .forEach(u ->
                    userDTOs.add(
                        UserDTOWrapper.userToUserDTO(u)
                )
        );
        return userDTOs;
    }
}
