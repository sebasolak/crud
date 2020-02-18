package com.sebastian.spring_boot_essential_tr.dao;

import com.sebastian.spring_boot_essential_tr.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements StudentDao {

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        UUID studentId2 = UUID.randomUUID();
        UUID studentId3 = UUID.randomUUID();
        UUID studentId4 = UUID.randomUUID();
        database.put(studentId,
                new Student(studentId, 24, "Alex", "Montana", "Computer Science")
        );
        database.put(studentId2,
                new Student(studentId2, 33, "Maria", "Beth", "Medicine")
        );
        database.put(studentId3,
                new Student(studentId3, 21, "Jake", "Lamb", "Finance")
        );
        database.put(studentId4,
                new Student(studentId4, 26, "Ana", "Smith", "Finance")
        );

    }


    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {

        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudent() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentById(UUID id, Student updateStudent) {
        database.put(id, updateStudent);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 0;
    }



}
