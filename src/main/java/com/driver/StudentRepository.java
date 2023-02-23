package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap;
    HashMap<String,Teacher> teacherHashMap;
    HashMap<String, List<String>> teacherStudentHashMap;

    public StudentRepository() {
        studentHashMap = new HashMap<>();
        teacherHashMap = new HashMap<>();
        teacherStudentHashMap = new HashMap<>();
    }

    public void addStudent(Student student){
        String name = student.getName();
        studentHashMap.put(name,student);
    }

    public void addTeacher(Teacher teacher){
        String name = teacher.getName();
        teacherHashMap.put(name,teacher);
    }

    public void studentTeacherPair(String student, String teacher){
        List<String> studentList = new ArrayList<>();
        if (teacherStudentHashMap.containsKey(teacher)){
            studentList = teacherStudentHashMap.get(teacher);
        }
        studentList.add(student);
        teacherStudentHashMap.put(teacher,studentList);
    }

    public Student getStudentByName(String name){
        return studentHashMap.getOrDefault(name,null);
    }

    public Teacher getTeacherByName(String name){
        return teacherHashMap.getOrDefault(name,null);
    }

    public List<String> getStudentsByTeacherName(String teacher){
        return teacherStudentHashMap.getOrDefault(teacher,null);
    }

    public List<String> getAllStudents(){
        List<String> studentsList = new ArrayList<>();
        for (Map.Entry<String,Student> map: studentHashMap.entrySet()){
            Student student = map.getValue();
            studentsList.add(student.getName());
        }
        return studentsList;
    }

    public void deleteTeacherByName(String teacher){
        if(teacherStudentHashMap.containsKey(teacher)){
            List<String> students = teacherStudentHashMap.get(teacher);

            for (String student: students){
                if (studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }
            teacherStudentHashMap.remove(teacher);
        }
        if (teacherHashMap.containsKey(teacher)){
            teacherHashMap.remove(teacher);
        }
    }

    public void deleteAllTeachers(){
        for(Map.Entry<String,List<String>> map: teacherStudentHashMap.entrySet()){
            String teacher = map.getKey();
            List<String> students = teacherStudentHashMap.get(teacher);
            for (String student: students){
                if (studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }
            teacherStudentHashMap.remove(teacher);
        }
        teacherHashMap.clear();
    }
}
