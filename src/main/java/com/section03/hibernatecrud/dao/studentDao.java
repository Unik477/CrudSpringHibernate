package com.section03.hibernatecrud.dao;

import java.util.List;

import com.section03.hibernatecrud.entity.student;

public interface studentDao {

    void save(student theStudent);
    public student findStudentbyId(int id);
    List<student> findAllStudent();
}
