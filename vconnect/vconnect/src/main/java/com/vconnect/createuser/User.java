package com.vconnect.createuser;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class User {

    @Id
    private String email;
    private String name;
    private LocalDate dob;
    private String phone;
    private String vehicleCategory;
    private String userCategory;
    private String drivingLicenseNumber;
    private String vehicleRegNo;
    private String photoRCPath;
    private String photoLicensePath;
    private String userId;
    private String password;


    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String email, String name, LocalDate dob, String phone, String vehicleCategory,
                String userCategory, String drivingLicenseNumber, String vehicleRegNo,
                String photoRCPath, String photoLicensePath, String password) {
        this.email = email;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.vehicleCategory = vehicleCategory;
        this.userCategory = userCategory;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.vehicleRegNo = vehicleRegNo;
        this.photoRCPath = photoRCPath;
        this.photoLicensePath = photoLicensePath;
        this.userId = generateUserId(userCategory);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public String getPhotoRCPath() {
        return photoRCPath;
    }

    public void setPhotoRCPath(String photoRCPath) {
        this.photoRCPath = photoRCPath;
    }

    public String getPhotoLicensePath() {
        return photoLicensePath;
    }

    public void setPhotoLicensePath(String photoLicensePath) {
        this.photoLicensePath = photoLicensePath;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    // Method to generate unique user ID based on user category
    private String generateUserId(String userCategory) {

        String prefix = "";
        if ("User".equalsIgnoreCase(userCategory)) {
            prefix = "VCONU";
        } else if ("Service Provider".equalsIgnoreCase(userCategory)) {
            prefix = "VCONSP";
        } else {
            throw new IllegalArgumentException("Invalid user category");
        }
        return prefix + UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }


}
