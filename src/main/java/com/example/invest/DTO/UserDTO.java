package com.example.invest.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String publicAddress;
    private String parentAddress;
    private String homeAddress;
    private String phoneNumber;
}
