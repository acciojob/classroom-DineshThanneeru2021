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
    public List<String> getAllStudents()
    {
        return studentRepository.getAllStudents();
    }
    public Student getStudentByName(String studentName)
    {
        return studentRepository.getStudentByName(studentName);
    }
    public Teacher getTeacherByName(String teacherName)
    {
        return studentRepository.getTeacherByName(teacherName);
    }

    public void deleteTeacherByName(String teacherName)
    {
        studentRepository.deleteTeacherByName(teacherName);
    }
    public void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachers();
    }
}

