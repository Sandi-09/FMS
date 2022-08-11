package com.mvc.fraudmanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin")
public class Admin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "user_id", nullable = false, length = 20)
	@Size(min=5, message="Enter at least 5 Characters...")
    private String userId;
     
    @Column(name = "password", nullable = false, length = 20)
    @Size(min=8, message="Enter at least 8 Characters...")
    private String password;
    
    public Admin() {
    	super();
    }
    
	public Admin(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}
