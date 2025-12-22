package com.adrar.api.dto.user;

import com.adrar.api.entity.User;

public class UserDTOWrapper {

    public static UserDTO userToUserDTO(User user) {
        return new UserDTO(
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }
}
