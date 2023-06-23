package com.tourguide.user.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class LoginDto {
    private String username;
    private String password;
}
