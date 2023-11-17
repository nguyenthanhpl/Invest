package com.example.invest.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class User {
    private Long id;
    private String publicAddress;
    private String parentAddress;
    private String homeAddress;
    private String phoneNumber;



    public User(Long id) {
        this.id = id;
    }

    public User( String publicAddress, String parentAddress, String homeAddress, String phoneNumber) {
//        this.id = id;
        this.publicAddress = publicAddress;
        this.parentAddress = parentAddress;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }
}
