package com.edutech.progressive.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.service.DoctorService;
@Service
public class DoctorServiceImplJpa implements DoctorService {

    private DoctorRepository doctorRepository;

    
    public DoctorServiceImplJpa(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        Doctor d=doctorRepository.save(doctor);
        return d.getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        List<Doctor> list=doctorRepository.findAll();
        Collections.sort(list);
        return list;
    }
    public void updateDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public void deleteDoctor(int doctorId){
        doctorRepository.deleteById(doctorId);
    }
    public Doctor getDoctorById(int doctorId){
        return doctorRepository.findByDoctorId(doctorId).get();
    }

}