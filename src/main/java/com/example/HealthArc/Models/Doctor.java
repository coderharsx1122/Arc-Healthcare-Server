package com.example.HealthArc.Models;

import com.example.HealthArc.SupportClasses.*;
import com.example.HealthArc.SupportClasses.Doctor.Availability;
import com.example.HealthArc.SupportClasses.Doctor.DoctorPersonalInfo;
import com.example.HealthArc.SupportClasses.Doctor.ProfessionalInfo;
import com.example.HealthArc.SupportClasses.Doctor.Review;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "doctors")
@Getter
@Setter
public class Doctor implements UserDetails, CredentialsContainer {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String phone;

    private String password;
    private String avatar;

    private DoctorPersonalInfo personalInfo;
    private Address address;
    private ProfessionalInfo professionalInfo;
    private Availability availability;
    private int consultationFees;
    private List<String> languages;
    private List<Review> reviews;

    // ************************** UserDetails methods **************************** //
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("DOCTOR"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    // ************************** CredentialsContainer methods ***********************************//
    @Override
    public void eraseCredentials() {

    }
}