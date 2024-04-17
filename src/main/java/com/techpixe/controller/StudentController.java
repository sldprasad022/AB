package com.techpixe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techpixe.entity.Student;
import com.techpixe.entity.StudentDTO;
import com.techpixe.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> save(@RequestBody Student student)
	{
		Student saved = studentService.save(student);
		return new ResponseEntity<Student>(saved,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/fetchById/{id}")
	public Student fetch(@PathVariable("id") Long id)
	{
		return studentService.fetchById(id);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> all()
	{
		List<Student> fetchAll = studentService.all();
		return new ResponseEntity<List<Student>>(fetchAll,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	//------DTO for Multiple objects While Retrieving some properties from the Database
	@GetMapping("/fetchAll")
	public List<StudentDTO> getAllStudents()
	{
        return studentService.getAllStudents();
    }

	
	////------DTO for Single objects Retrieving some properties
	@GetMapping("/retrieveById/{id}")
	public StudentDTO fetchById(@PathVariable("id") Long id)
	{
//		Student fetchById = studentService.fetchById(id);
//		return new ResponseEntity<Student>(fetchById,HttpStatus.OK);
		
		Student student = studentService.fetchById(id);
        if (student != null)
        {
            return new StudentDTO(student.getId(), student.getName(), student.getBranch());
        }
        return null;
	}
	
	
}
