package com.example.docker.demo.service;

import java.util.List;

import com.example.docker.demo.model.Student;
import com.example.docker.demo.repo.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	public StudentRepo reopsitory;

	public Student saveorupdate(Student student) {
		if(student.getId() != null) {
			Student s2 = reopsitory.findById(student.getId()).get();
			if (student.getName() != null) {
				s2.setName(student.getName());
			}
			if (student.getEmail() != null) {
				s2.setEmail(student.getEmail());
			}
			reopsitory.save(s2);
			return s2;
		}
		
		return reopsitory.save(student);

	}

	public String delete(int id) {
		reopsitory.deleteById(id);

		return "delete successfully";
	}

	public List<Student> findall() {

		return reopsitory.findAll();

	}
}
