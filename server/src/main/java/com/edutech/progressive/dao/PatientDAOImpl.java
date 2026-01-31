package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Patient;

public class PatientDAOImpl implements PatientDAO{

    private Connection connection;
    public PatientDAOImpl() {
        try {
            connection=DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    @Override
    public int addPatient(Patient patient) {
      String sql="INSERT INTO patient(full_name,date_of_birth,contact_number,email,address) VALUES(?,?,?,?,?)";
      try(PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1, patient.getFullName());
        ps.setDate(2, new Date(patient.getDateOfBirth().getTime()));
        ps.setString(3, patient.getContactNumber());
        ps.setString(4, patient.getEmail());
        ps.setString(5, patient.getAddress());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            int id=rs.getInt(1);
            patient.setPatientId(id);
            return id;
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return 0;
    }
   
    @Override
    public Patient getPatientById(int patientId) {
        String sql="SELECT * FROM  patient WHERE patient_id=?";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setInt(1, patientId);
      
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
        int id=rs.getInt("patient_id");
        String full_name=rs.getString("full_name");
        Date date_of_birth=rs.getDate("date_of_birth");
        String contact_number=rs.getString("contact_number");
        String email=rs.getString("email");
        String address=rs.getString("address");
            Patient patient=new Patient(id, full_name, date_of_birth, contact_number, email, address);
            return patient;
        }


      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {
       String sql="UPDATE  patient SET full_name=? , date_of_birth=? , contact_number=? , email=? , address=? WHERE patient_id=?";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setString(1, patient.getFullName());
        ps.setDate(2, new Date(patient.getDateOfBirth().getTime()));
        ps.setString(3, patient.getContactNumber());
        ps.setString(4, patient.getEmail());
        ps.setString(5, patient.getAddress());
        ps.setInt(6, patient.getPatientId());
        ps.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    @Override
    public void deletePatient(int patientId) {
        String sql="DELETE FROM patient  WHERE patient_id=?";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setInt(1, patientId);
        ps.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient>patientList1=new ArrayList<>();
        String sql="SELECT * FROM  patient ";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
      
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        int id=rs.getInt("patient_id");
        String full_name=rs.getString("full_name");
        Date date_of_birth=rs.getDate("date_of_birth");
        String contact_number=rs.getString("contact_number");
        String email=rs.getString("email");
        String address=rs.getString("address");
            Patient patient=new Patient(id, full_name, date_of_birth, contact_number, email, address);
            patientList1.add(patient);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return patientList1;
    }

}
