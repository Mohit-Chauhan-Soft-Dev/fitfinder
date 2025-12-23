package com.fitfinder.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidates")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Candidate {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    private boolean isPhoneVerified;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}