package com.sebastian.spring_boot_essential_tr.service;

import com.sebastian.spring_boot_essential_tr.dao.StudentDao;
import com.sebastian.spring_boot_essential_tr.dao.StudentMySqlDao;
import com.sebastian.spring_boot_essential_tr.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;


    @Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student) {
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        student.setId(studentId);
        return studentDao.insertNewStudent(studentUid, student);
    }

    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudent() {
        return studentDao.selectAllStudent();
    }

    public int updateStudentById(UUID id, Student updateStudent) {
        return studentDao.updateStudentById(id, updateStudent);
    }

    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }
}
