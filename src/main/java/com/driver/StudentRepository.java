package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap;
    HashMap<String,Teacher> teacherHashMap;
    HashMap<String, List<Student>> teacherStudentHashMap;

    public StudentRepository() {
        studentHashMap = new HashMap<>();
        teacherHashMap = new HashMap<>();
        teacherStudentHashMap = new HashMap<>();
    }


}
