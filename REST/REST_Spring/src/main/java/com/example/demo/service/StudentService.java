package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
	public Student updateStudent(Long id,Student student){
		return studentRepository.save(student);
	}
	public void deleteStudent(Long id){
		studentRepository.deleteById(id);
	}
}

