package com.example.HealthArc.Controllers.Protected;

import com.example.HealthArc.Models.AppointmentRequest;
import com.example.HealthArc.Services.Doctor.DoctorService;
import com.example.HealthArc.Services.Patient.PatientService;
import com.example.HealthArc.SupportClasses.Address;
import com.example.HealthArc.SupportClasses.Doctor.Availability;
import com.example.HealthArc.SupportClasses.Doctor.ProfessionalInfo;
import com.example.HealthArc.SupportClasses.Doctor.Review;
import com.example.HealthArc.SupportClasses.Patient.UpdatePassword;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth/patient")
@CrossOrigin(origins = "#{@healthArcApplication.getAllowedOrigins()}")
public class ProtectedPatientController {

    @Autowired
    DoctorService doctorService;
    @Autowired
    PatientService patientService;

    // update patient data
    @PutMapping("/update-password")
    ResponseEntity<?> updatePatientPassword(@RequestBody UpdatePassword password, @RequestHeader("Authorization") String header, HttpServletResponse response){
        return patientService.updatePassword(password.getOldPassword(),password.getPassword(),header,response);
    }

    @PutMapping("/update-avatar")
    ResponseEntity<?> updatePatientAvatar(@RequestBody String avatarBase64, @RequestHeader("Authorization") String header){
        return patientService.updateAvatar(avatarBase64,header);
    }
    @PutMapping("/update-weight")
    ResponseEntity<?> updateWeight(@RequestBody double weight, @RequestHeader("Authorization") String header){
        return patientService.updateWeight(weight,header);
    }
    @PutMapping("/update-height")
    ResponseEntity<?> updateHeight(@RequestBody int height, @RequestHeader("Authorization") String header){
        return patientService.updateHeight(height,header);
    }

    // ************************ Add Review *******************************//
    @PostMapping("/add-review")
    ResponseEntity<?> addDoctorReview(@RequestBody Review review, @RequestParam String id){
        return doctorService.addReview(review,id); // add review to doctor
    }

    // *********************** Add Appointment request *******************//
    @PostMapping("/add-appointmentRequest")
    ResponseEntity<?> addAppointmentRequest(@RequestBody AppointmentRequest appointmentRequest,@RequestHeader("Authorization") String header){
        return patientService.addAppointmentRequest(appointmentRequest,header); // add review to doctor
    }

    // ************************ Get Dashboard *******************************//
    @GetMapping("/dashboard")
    ResponseEntity<?> getDashboard(@RequestHeader("Authorization") String header){
        return patientService.getPatientDashboard(header);
    }

    // ************************ Get doctor profile for patient *******************************//
    @GetMapping("/profile/{id}")
    ResponseEntity<?> getDoctorProfileForPatient(@PathVariable("id") String dcotorId,@RequestHeader("Authorization") String header){
        return patientService.getDoctorProfileForPatient(dcotorId,header);
    }

}