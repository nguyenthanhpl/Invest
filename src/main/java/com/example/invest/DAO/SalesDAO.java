package com.example.invest.DAO;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class SalesDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean status;
    private Double totalPoint;
    @OneToMany(mappedBy = "salesDAO")
    private List<UserDAO> userDAOS = new ArrayList<>();
}
