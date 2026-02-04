
package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/clinic")
public class ClinicController {
   @Autowired
   @Qualifier("clinicjpa")
   private ClinicService clinicService;


    public ClinicController(ClinicService clinicService) {
    this.clinicService = clinicService;
}
       @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics()  {
        return ResponseEntity.ok(clinicService.getAllClinics());
    }

    @GetMapping("/{clinicId}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable int clinicId)  {
        return ResponseEntity.ok(clinicService.getClinicById(clinicId));
    }

    @PostMapping
    public ResponseEntity<Integer> addClinic(@RequestBody Clinic clinic)  {
        return new ResponseEntity<>(clinicService.addClinic(clinic),HttpStatus.CREATED);
    }

    @PutMapping("/{clinicId}")
    public ResponseEntity<Void> updateClinic(@PathVariable int clinicId,@RequestBody Clinic clinic)  {
        clinic.setClinicId(clinicId);
        clinicService.updateClinic(clinic);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clinicId}")
    public ResponseEntity<Void> deleteClinic(@PathVariable int clinicId)  {
        clinicService.deleteClinic(clinicId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Clinic>> getAllClinicByLocation(@PathVariable String location) {
        return ResponseEntity.ok(clinicService.getAllClinicByLocation(location));
    }
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Clinic>> getAllClinicByDoctorId(int doctorId) {
         return ResponseEntity.ok(clinicService.getAllClinicByDoctorId(doctorId));
    }

}
