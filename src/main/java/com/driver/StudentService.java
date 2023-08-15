package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public void addStudent(Student student)
    {
        studentRepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher)
    {
        studentRepository.addTeacher(teacher);
    }
    public void addPair(String teacherName,String studentName)
    {
        studentRepository.addPair(teacherName,studentName);
    }
    public List<String> getStudentsByTeacherName(String teacherName)
    {
        return studentRepository.getStudentsByTeacherName(teacherName);

    }
}
