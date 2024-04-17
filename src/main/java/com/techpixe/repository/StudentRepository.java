package com.techpixe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpixe.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{

}
