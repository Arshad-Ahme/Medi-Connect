package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Clinic;

public class ClinicDAOImpl implements ClinicDAO {

    private Connection connection;

    public ClinicDAOImpl() {
        try {
            connection = DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public int addClinic(Clinic clinic) {
        String sql = "INSERT INTO clinic(clinic_name,location,doctor_id,contact_number,established_year) VALUES(?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, clinic.getClinicName());
            ps.setString(2, clinic.getLocation());
            ps.setInt(3, clinic.getDoctorId());
            ps.setString(4, clinic.getContactNumber());
            ps.setInt(5, clinic.getEstablishedYear());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                clinic.setClinicId(id);
                return id;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        String sql = "SELECT * FROM  clinic WHERE clinic_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, clinicId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("clinic_id");
                String clinic_name = rs.getString("clinic_name");
                String location = rs.getString("location");
                int doctor_id = rs.getInt("doctor_id");
                String contact_number = rs.getString("contact_number");
                int established_year = rs.getInt("established_year");
                Clinic clinic = new Clinic(id, clinic_name, location, doctor_id, contact_number, established_year);
                return clinic;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateClinic(Clinic clinic) {
     String sql = "UPDATE clinic SET clinic_name=?,location=?,doctor_id=?,contact_number=?,established_year=? WHERE clinic_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql) ){
            ps.setString(1, clinic.getClinicName());
            ps.setString(2, clinic.getLocation());
            ps.setInt(3, clinic.getDoctorId());
            ps.setString(4, clinic.getContactNumber());
            ps.setInt(5, clinic.getEstablishedYear());
            ps.setInt(6, clinic.getClinicId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClinic(int clinicId) {
        String sql = "DELETE FROM  clinic WHERE clinic_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, clinicId);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Clinic> getAllClinics() {
        List<Clinic> clinics = new ArrayList<>();
        String sql = "SELECT * FROM  clinic ";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clinic_id");
                String clinic_name = rs.getString("clinic_name");
                String location = rs.getString("location");
                int doctor_id = rs.getInt("doctor_id");
                String contact_number = rs.getString("contact_number");
                int established_year = rs.getInt("established_year");
                Clinic clinic = new Clinic(id, clinic_name, location, doctor_id, contact_number, established_year);
                clinics.add(clinic);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return clinics;
    }

}
