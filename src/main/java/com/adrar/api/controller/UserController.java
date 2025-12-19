package com.adrar.api.controller;

import com.adrar.api.entity.User;
import com.adrar.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
@AllArgsConstructor
public class UserController {

    private UserService userService;

    //ajouter un compte
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    //afficher tous les comptes

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<User> getAllUsers()
    {
        return (ArrayList<User>) userService.getAllUser();
    }

    //afficher un compte avec son email
    @GetMapping("/user/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUserByEmail(@PathVariable("email") String email)
    {
        return Optional.ofNullable(userService.getUserByEmail(email));
    }

    //mettre à jour
    @PutMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User modifyUser(@RequestBody User user)
    {
        return userService.modifyUser(user);
    }

    //supprimer
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable  Integer id)
    {
        //Construire le message
        Map<String, String> reponse = new HashMap<>();
        reponse.put("Info", "Le compte a été supprimé");
        //Supprimer le compte
        userService.removeUser(id);
        //Retourner la réponse
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
