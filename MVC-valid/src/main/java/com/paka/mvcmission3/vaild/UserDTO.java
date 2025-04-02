package com.paka.mvcmission3.vaild;

import jakarta.validation.constraints.*;

import java.util.Date;

public class UserDTO {

    private int no;
    @NotNull(message = "반드시 입력하셔야 됩니다")
    private String name;
    @Past
    private String birthDate;
    @Email
    private String email;
    @Size(min=4)
    private String id;
    @Size(min=3, max=16 )
    private String password;
    private Date enrollDate;

    public UserDTO(int no, String name, String birthDate, String email, String id, String password, Date enrollDate) {
        this.no = no;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.id = id;
        this.password = password;
        this.enrollDate = enrollDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}
