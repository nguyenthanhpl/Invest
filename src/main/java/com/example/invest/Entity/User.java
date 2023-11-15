package com.example.invest.Entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String publicAddress;
    private String parentAddress;
    private String homeAddress;
    private String phoneNumber;
}
