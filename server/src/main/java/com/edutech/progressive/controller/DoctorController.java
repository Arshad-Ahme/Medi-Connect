package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Component
public class DoctorController {
    @GetMapping()
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return null;
    }
    @GetMapping()
    public ResponseEntity<Doctor> getDoctorById(int doctorId) {
        return null;
    }
    @PostMapping()
    public ResponseEntity<Integer> addDoctor(Doctor doctor) {
        return null;
    }
    @PutMapping()
    public ResponseEntity<Void> updateDoctor(int doctorId, Doctor doctor) {
        return null;
    }
    @DeleteMapping()
    public ResponseEntity<Void> deleteDoctor(int doctorId) {
        return null;
    }
    @GetMapping()
    public ResponseEntity<List<Doctor>> getDoctorSortedByExperience() {
        return null;
    }
}
