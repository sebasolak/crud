package com.sebastian.spring_boot_essential_tr.dao;

import com.sebastian.spring_boot_essential_tr.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("MySqlDao")
public interface StudentMySqlDao extends JpaRepository<Student, UUID> {
}
