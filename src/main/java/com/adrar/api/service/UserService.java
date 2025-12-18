package com.adrar.api.service;

import com.adrar.api.entity.User;
import com.adrar.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    private UserRepository userRepository;

    //Afficher tous les utilisateurs
    public ArrayList<User> findAll()
    {
        //Test si la liste est vide
        if (userRepository.count() == 0) {
            throw new RuntimeException("Il n'y à pas d'utilisateur");
        }
        return (ArrayList<User>) userRepository.findAll();
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
}
