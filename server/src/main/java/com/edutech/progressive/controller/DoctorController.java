package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping()
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId) {
        return ResponseEntity.ok(doctorService.getDoctorById(doctorId));
    }
    @PostMapping()
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(201).body(doctorService.addDoctor(doctor));
    }
    @PutMapping("/{doctorId}")
    public ResponseEntity<Void> updateDoctor(@PathVariable int doctorId, @RequestBody Doctor doctor) {
        doctor.setDoctorId(doctorId);
        doctorService.updateDoctor(doctor);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int doctorId) {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/experience")
    public ResponseEntity<List<Doctor>> getDoctorSortedByExperience() {
        return ResponseEntity.ok(doctorService.getDoctorSortedByExperience());
    }
}
