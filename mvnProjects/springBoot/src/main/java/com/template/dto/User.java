package com.template.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return new StringBuffer().append(getEmail()).toString();
    }
}
