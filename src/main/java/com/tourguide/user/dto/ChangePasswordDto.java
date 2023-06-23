package com.tourguide.user.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ChangePasswordDto {
    private Long id;
    private String username;
    private String oldPassword;
    private String newPassword;
    // getters and setters
}
