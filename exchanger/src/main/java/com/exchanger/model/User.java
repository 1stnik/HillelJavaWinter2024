package com.exchanger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "users")
public class User extends BaseEntity  {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean status;
    private Long telegramChatId;

}
