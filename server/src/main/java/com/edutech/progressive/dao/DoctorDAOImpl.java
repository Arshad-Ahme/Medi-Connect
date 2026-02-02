package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Doctor;

public class DoctorDAOImpl implements DoctorDAO {

      private Connection connection;
    public DoctorDAOImpl() {
        try {
            connection=DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    @Override
    public int addDoctor(Doctor doctor) {
         String sql="INSERT INTO doctor(full_name,specialty,contact_number,email,years_of_experience) VALUES(?,?,?,?,?)";
      try(PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
        ps.setString(1, doctor.getFullName());
        ps.setString(2, doctor.getSpecialty());
        ps.setString(3, doctor.getContactNumber());
        ps.setString(4, doctor.getEmail());
        ps.setInt(5, doctor.getYearsOfExperience());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            int id=rs.getInt(1);
            doctor.setDoctorId(id);
            return id;
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return -1;
    }

    @Override
    public Doctor getDoctorById(int doctorId) {
        String sql="SELECT * FROM  doctor WHERE doctor_id=?";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setInt(1, doctorId);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
        int id=rs.getInt("doctor_id");
        String full_name=rs.getString("full_name");
        String specialty=rs.getString("specialty");
        String contact_number=rs.getString("contact_number");
        String email=rs.getString("email");
        int years_of_experience=rs.getInt("years_of_experience");
        Doctor doc=new Doctor(id, full_name, specialty, contact_number, email, years_of_experience);
        return doc;
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;
    }

    @Override
    public void updateDoctor(Doctor doctor) {
       String sql="UPDATE doctor SET full_name=?,specialty=?,contact_number=?,email=?,years_of_experience=? WHERE doctor_id=?";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setString(1, doctor.getFullName());
        ps.setString(2, doctor.getSpecialty());
        ps.setString(3, doctor.getContactNumber());
        ps.setString(4, doctor.getEmail());
        ps.setInt(5, doctor.getYearsOfExperience());
        ps.setInt(6, doctor.getDoctorId());
        ps.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    @Override
    public void deleteDoctor(int doctorId) {
         String sql="DELETE FROM doctor  WHERE doctor_id=?";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
        ps.setInt(1, doctorId);
        ps.executeUpdate();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor>doctorList1=new ArrayList<>();
        String sql="SELECT * FROM  doctor ";
      try(PreparedStatement ps=connection.prepareStatement(sql)){
      
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        int id=rs.getInt("doctor_id");
        String full_name=rs.getString("full_name");
        String specialty=rs.getString("specialty");
        String contact_number=rs.getString("contact_number");
        String email=rs.getString("email");
        int years_of_experience=rs.getInt("years_of_experience");
        Doctor doc=new Doctor(id, full_name, specialty, contact_number, email, years_of_experience);
        doctorList1.add(doc);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return doctorList1;
    }



}
