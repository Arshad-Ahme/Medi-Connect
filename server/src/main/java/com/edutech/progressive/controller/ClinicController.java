package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Clinic;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;


@Component
public class ClinicController {

    @GetMapping()
    public ResponseEntity<List<Clinic>> getAllClinics() {
        return null;
    }
    @GetMapping()
    public ResponseEntity<Clinic> getClinicById(int clinicId) {
        return null;
    }
    @PostMapping()
    public ResponseEntity<Integer> addClinic(Clinic clinic) {
        return null;
    }
    
    @PutMapping()
    public ResponseEntity<Void> updateClinic(int clinicId, Clinic clinic) {
        return null;
    }
    @DeleteMapping()
    public ResponseEntity<Void> deleteClinic(int clinicId) {
        return null;
    }
    
    @GetMapping()
    public ResponseEntity<List<Clinic>> getAllClinicByLocation(String location) {
        return null;
    }
    @GetMapping()
    public ResponseEntity<List<Clinic>> getAllClinicByDoctorId(int doctorId) {
        return null;
    }
}
