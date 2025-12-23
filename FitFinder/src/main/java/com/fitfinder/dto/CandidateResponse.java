package com.fitfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CandidateResponse {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String role;

}
