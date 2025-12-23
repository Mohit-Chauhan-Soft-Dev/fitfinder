package com.fitfinder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "companies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company {


    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String industry;

    @Column(nullable = false)
    private String phone;

    private boolean isPhoneVerified;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
