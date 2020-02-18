package com.sebastian.spring_boot_essential_tr.dao;

import com.sebastian.spring_boot_essential_tr.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    int insertNewStudent(UUID studentId, Student student);

    Student selectStudentById(UUID studentId);

    List<Student> selectAllStudent();

    int updateStudentById(UUID id, Student updateStudent);

    int deleteStudentById(UUID studentId);


}
