package com.edutech.progressive.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Doctor;

@Repository
public interface DoctorRepository extends  JpaRepository<Doctor,Integer> {
    @Query("SELECT d FROM Doctor d WHERE d.doctorId=?1")
    Optional<Doctor> findByDoctorId(int doctorId);
}
