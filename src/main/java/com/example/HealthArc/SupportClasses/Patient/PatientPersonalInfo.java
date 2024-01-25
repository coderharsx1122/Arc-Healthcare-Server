package com.example.HealthArc.SupportClasses.Patient;

import com.example.HealthArc.SupportClasses.Address;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PatientPersonalInfo {
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String nationality;
    private Address address;
}