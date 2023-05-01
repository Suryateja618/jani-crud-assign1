package com.example.docker.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.docker.demo.exception.DuplicateEmailException;
import com.example.docker.demo.model.Student;
import com.example.docker.demo.repo.StudentRepo;
import com.example.docker.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CrudTestController {

	@Autowired
	StudentService studentservice;

	@Autowired
	StudentRepo studentrepo;

	@GetMapping(value = "/listallstudents")
	public List<Student> studentgetall() {
		List<Student> slist = new ArrayList<Student>();
		slist = studentservice.findall();

		return slist;
	}

	// save or update
	@PostMapping("/saveorupdate")
	private Student saveBook(@RequestBody Student student) throws DuplicateEmailException {
		try {
			Student s = studentservice.saveorupdate(student);
			return s;
		} catch(Exception e) {
			throw new DuplicateEmailException();
		}
		
	}

//@GetMapping("/student/{studentid}")  
//	private Optional<Student> getStudentbyId(@PathVariable("studentid") int studentid)   
//	{  
//	Optional<Student> s1=studentrepo.findById(studentid);
//	 return s1;
//		
//		
//	}  
//	
//		
//	
////delele student
	@GetMapping("/student/{studentid}")
	private Student deleteStudent(@PathVariable("studentid") int studentid) {

		studentservice.delete(studentid);
		return null;
	}
//	
//		
}
