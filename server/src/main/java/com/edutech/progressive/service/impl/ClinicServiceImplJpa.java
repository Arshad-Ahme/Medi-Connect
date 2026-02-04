package com.edutech.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.service.ClinicService;

@Service("clinicjpa")
public class ClinicServiceImplJpa implements ClinicService {
    @Autowired
    ClinicRepository clinicRepository;

    public ClinicServiceImplJpa(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        return clinicRepository.findById(clinicId).orElse(null);
    }

    @Override
    public Integer addClinic(Clinic clinic)  {
        Clinic c = clinicRepository.save(clinic);
        return c.getClinicId();
    }

    @Override
    public void updateClinic(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    @Override
    public void deleteClinic(int clinicId)  {
        clinicRepository.deleteById(clinicId);
    }

       public List<Clinic> getAllClinicByLocation(String location)  { 
        return clinicRepository.findAllByLocation(location);
        }

    public List<Clinic> getAllClinicByDoctorId(int doctorId)  { 
        return clinicRepository.findAllByDoctorId(doctorId);

     }
}


