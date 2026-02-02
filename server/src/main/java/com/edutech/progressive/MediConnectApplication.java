package com.edutech.progressive;

import java.sql.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutech.progressive.dao.PatientDAO;
import com.edutech.progressive.dao.PatientDAOImpl;
import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.impl.PatientServiceImplJdbc;


@SpringBootApplication
public class MediConnectApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to MediConnect Progressive Project!");

        // PatientDAOImpl pt=new PatientDAOImpl();
        // PatientServiceImplJdbc jd=new PatientServiceImplJdbc(pt);
        // Patient p1=new Patient(0, "asdas", Date.valueOf("10-10-2012"), "345678", "asdasd", "asdasd");
        // jd.addPatient(p1);

    }
}
