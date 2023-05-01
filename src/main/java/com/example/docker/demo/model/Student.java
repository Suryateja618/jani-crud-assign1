package com.example.docker.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	Integer id;

	@Column
	String name;

	@Column(unique = true)
	String email;

	@Column(name = "created_date_time", nullable = false, updatable = false)
    @CreationTimestamp
	private Date createdDateTime;
	
	@Column(name = "updated_date_time", nullable = false, updatable = true)
	@UpdateTimestamp
    private Date updatedDateTime;

}