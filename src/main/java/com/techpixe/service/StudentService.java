package com.techpixe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techpixe.entity.Student;
import com.techpixe.entity.StudentDTO;
import com.techpixe.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository studentRepository;
	
	public Student save(Student student)
	{
		return studentRepository.save(student);
	}
	
	
	public List<Student> all()
	{
		return studentRepository.findAll();
	}
	
	public Student fetchById(Long id)
    {
		//return studentRepository.findById(id).get();
		return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("User Id '"+id+"' is not present"));
    	
    }
	
	
	//------DTO for Multiple objects Retrieving some properties
	public List<StudentDTO> getAllStudents()
	{
        return studentRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private StudentDTO convertEntityToDTO(Student student) 
    {
        return new StudentDTO(student.getId(), student.getName(), student.getBranch());
    }
    
     
}
