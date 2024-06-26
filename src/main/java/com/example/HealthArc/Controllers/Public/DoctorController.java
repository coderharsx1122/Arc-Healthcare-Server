package com.example.HealthArc.Controllers.Public;

import com.example.HealthArc.Models.Doctor;
import com.example.HealthArc.Services.Doctor.DoctorService;
import com.example.HealthArc.SupportClasses.UserRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/doctor")
public class DoctorController {

//    service
    @Autowired
    DoctorService doctorService;

    // *************************** doctor signup ******************************* //
    @PostMapping("/add")
    ResponseEntity<?> addDoctor(@RequestBody Doctor doctor,HttpServletResponse response){
        return doctorService.addDoctor(doctor,response);
    }

    //**************************** Doctor login ********************************//
    @PostMapping("/login")
    ResponseEntity<?> loginDoctor(@RequestBody UserRequest userRequest,HttpServletResponse response) {
        return doctorService.loginDoctor(userRequest,response);
    }

    // ****************************  get all doctors    *********************************** //
    @GetMapping("/all")
    ResponseEntity<?> getAllDoctor() {
        return doctorService.getAllDoctors();
    }

}
