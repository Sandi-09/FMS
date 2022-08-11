package com.mvc.fraudmanagement.entities;

//import java.io.Serializable;
import java.util.Date;
//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

//import lombok.Data;

//import javax.annotation.Generated;
//import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;

@Entity
@Table(name = "PERSONNEL")
public class Personnel {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column(name = "userId", nullable = false)
@Size(min=1, message="Create a User ID")
private String userId;
@Column(name = "first_name", nullable = false)
@Size(min=1, message="Enter at least 5 Characters...")
private String firstName;
@Column(name = "last_name", nullable = false)
@Size(min=1, message="Enter at least 5 Characters...")
private String lastName;
@Column(name = "dob", nullable = false)
@Past(message="Date of Birth can not be a future date")
private Date dob;


@Column(name = "gender", nullable = false)
@Size(min=1, message="Please select a gender type")
private String gender;

@Column(name="contact_No",unique = true)
@Size(min=10, message="Enter a Valid Phone Number")
@Size(max=10, message="Enter a Valid Phone Number")
private String contactNo;

@Column(unique = true)
private String email;
@Size(min=8,message="Password is not Strong")
private String password;

@Column(nullable = true)
private int isAuthorized=1;




public Personnel() {
    super();
    // TODO Auto-generated constructor stub
}


public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getUserId() {
    return userId;
}

public void setUserId(String userId) {
    this.userId = userId;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public Date getDob() {
    return dob;
}

public void setDob(Date dob) {
    this.dob = dob;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getContactNo() {
    return contactNo;
}

public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public int getIsAuthorized() {
    return isAuthorized;
}

public void setIsAuthorized(int isAuthorized) {
    this.isAuthorized = isAuthorized;
}


@Override
public String toString() {
    return "Personnel [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
            + ", dob=" + dob + ", gender=" + gender + ", contactNo=" + contactNo + ", email=" + email
            + ", password=" + password + ", isAuthorized=" + isAuthorized  +"]";
}
}
