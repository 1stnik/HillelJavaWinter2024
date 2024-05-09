package com.exchanger.dto;

import com.exchanger.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserDto {
    private long id;
    private String username;
    private String phoneNumber;
    private String email;
    private boolean active;

    public static UserDto formEntity(User user) {
        return new UserDto()
            .setId(user.getId())
            .setEmail(user.getEmail())
            .setUsername(user.getFirstName().concat(" ").concat(user.getLastName()))
            .setPhoneNumber(user.getPhone())
            .setActive(user.isStatus());
    }

}
