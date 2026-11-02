package com.Bankcustomermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull    (message = "First name is mandatory")
    private String firstname;

    private String middlename;

    @NotBlank(message = "Last name is mandatory")
    private String lastname;

    private String Gender;

//    @Email(message = "Invalid email format")
//    @NotBlank(message = "Email is mandatory")
//   @Column(unique = true)
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid phone number")
    private String phoneNumber;

    private Double balance;
    private  String address;
    private String city;
    private String state;

}
