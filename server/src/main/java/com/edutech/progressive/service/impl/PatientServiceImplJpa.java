package com.edutech.progressive.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.exception.PatientNotFoundException;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

@Service("patientjpa")
public class PatientServiceImplJpa implements PatientService {
    
    private  PatientRepository patientRepository;
    

    public PatientServiceImplJpa(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
       return patientRepository.findAll();
    }

    @Override
    public Integer addPatient(Patient patient) {
        Patient p=patientRepository.save(patient);
     return p.getPatientId();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
       List<Patient>patients=patientRepository.findAll();
       Collections.sort(patients);
       return patients;
    }
    
    public  Patient getPatientById(int patientId){
        return patientRepository.findByPatientId(patientId).orElse(null);
    }
     
    public void updatePatient(Patient patient){
        if (patientRepository.existsById(patient.getPatientId())) {
            Patient p=getPatientById(patient.getPatientId());
            p.setAddress(patient.getAddress());
            p.setContactNumber(patient.getContactNumber());
            p.setDateOfBirth(patient.getDateOfBirth());
            p.setEmail(patient.getEmail());
            p.setFullName(patient.getFullName());
            patientRepository.save(p);
        }else{
            throw new PatientNotFoundException("Patient mot found");
        }
    }
    public void deletePatient(int patientId){
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
        }
        else{
            throw new PatientNotFoundException("Patient mot found");
        }
    }

    
}