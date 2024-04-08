package com.template.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;

}
