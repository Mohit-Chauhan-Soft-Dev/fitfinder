package com.fitfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CompanyResponse {

    private String id;
    private String name;
    private String email;
    private String industry;
    private String phone;
    private String role;

}
