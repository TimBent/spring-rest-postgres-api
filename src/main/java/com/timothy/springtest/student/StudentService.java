package com.timothy.springtest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 *  Contains Business logic for API
 */
@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        isEmailAvailable(student.getEmail());
        studentRepository.save(student);
    }

    public void removeStudent(Long studentId) {
        getStudent(studentId);
        studentRepository.deleteById(studentId);
    }


    @Transactional
    public void updateStudent(Long studentId,
                              String name,
                              String email){

        Student student = getStudent(studentId);

        if( name != null && !name.isEmpty() && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if( email != null && !email.isEmpty() && !Objects.equals(student.getEmail(), email)){
            isEmailAvailable(email);
            student.setEmail(email);
        }
    }

    private Student getStudent(Long studentId) {
        return studentRepository
                .findById(studentId).orElseThrow(() -> new IllegalStateException(
                        "student with id" + studentId + "does not exist."));
    }

    public void isEmailAvailable(String email){
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);

        studentByEmail.ifPresent(value -> {
            throw new IllegalStateException("Email is already taken");
        });
    }


}
