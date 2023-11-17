package com.example.invest.DAO;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserDAO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publicAddress;
    private String parentAddress;
    private String homeAddress;
    private String phoneNumber;


}
