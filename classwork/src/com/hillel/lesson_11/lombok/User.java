package com.hillel.lesson_11.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String email;
    private String phone;

}
