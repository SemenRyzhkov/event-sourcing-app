package ru.ryzhkov.core.web.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

    private String access;
    private String refresh;

}
