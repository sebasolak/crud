package com.sebastian.spring_boot_essential_tr.resource;

import com.sebastian.spring_boot_essential_tr.dao.StudentMySqlDao;
import com.sebastian.spring_boot_essential_tr.model.Student;
import com.sebastian.spring_boot_essential_tr.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )

    public Student getStudentById(@PathVariable UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student) {
        studentService.persistNewStudent(UUID.randomUUID(), student);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void updateStudent(@PathVariable UUID studentId, @RequestBody Student student) {
        studentService.updateStudentById(studentId, student);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{studentId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteStudent(@PathVariable UUID studentId) {
        studentService.deleteStudentById(studentId);
    }

    @Autowired
    private StudentMySqlDao studentMySqlDao;

    @GetMapping("dao")
    public List<Student> findAllStudents() {

        return studentMySqlDao.findAll();
    }

    @PostMapping("dao")
    public List<Student> persist(@RequestBody Student student) {
        studentMySqlDao.save(student);
        return studentMySqlDao.findAll();
    }

}
