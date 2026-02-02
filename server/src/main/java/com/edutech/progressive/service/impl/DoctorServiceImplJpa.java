package com.edutech.progressive.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

public class DoctorServiceImplJpa implements DoctorService {

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        return null;
    }

}