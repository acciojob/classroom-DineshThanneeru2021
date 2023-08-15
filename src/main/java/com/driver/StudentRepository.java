package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository

public class StudentRepository {
    //HashMap<Integer,Student> sMap=new HashMap<Integer, Student>();
    HashMap<String,Student> studentList=new HashMap<>();
    HashMap<String,Teacher> teacherList=new HashMap<>();
    HashMap<String,List<String>> teacherStudentMap=new HashMap<>();
    public void addStudent(Student student)
    {
        studentList.put(student.getName(),student);

    }
    public void addTeacher(Teacher teacher)
    {
        teacherList.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String teacherName,String studentName)
    {
        //myMap.put(i,myMap.getOrDefault(i,0)+1);
        List<String> studentsList=new ArrayList<>();
        if(teacherStudentMap.containsKey(teacherName))
        {
            studentsList=teacherStudentMap.get(teacherName);
            studentsList.add(studentName);
            teacherStudentMap.put(teacherName,studentsList);
        }
        else {
            studentsList.add(studentName);
            teacherStudentMap.put(teacherName,studentsList);
        }

    }
    public List<String> getStudentsByTeacherName(String teacherName)
    {

        List<String> ans=new ArrayList<>();
        if(teacherStudentMap.containsKey(teacherName))
        {
            ans=teacherStudentMap.get(teacherName);
        }
        return ans;

    }
    public List<String> getAllStudents()
    {
        List<String> students=new ArrayList<>();
        for(String student:studentList.keySet())
        {
            students.add(student);
        }
        return students;
    }
    public Student getStudentByName(String studentName)
    {

        for(String sName:studentList.keySet()) {
            if (sName.equals(studentName))
                return studentList.get(sName);
        }
        return null;
    }
    public Teacher getTeacherByName(String teacherName)
    {
        for(String tName:teacherList.keySet()) {
            if (tName.equals(teacherName))
                return teacherList.get(tName);
        }
        return null;

    }
    public void deleteTeacherByName(String teacherName)
    {
        teacherStudentMap.remove(teacherName);
        teacherList.remove(teacherName);
    }
    public void deleteAllTeachers()
    {
        for (String tName : teacherStudentMap.keySet()) {
            List<String> students = teacherStudentMap.get(tName);
            for (String sName : students) {
                if (studentList.containsKey(sName))
                    students.remove(sName);
            }
        }
        teacherList.clear();
        teacherStudentMap.clear();
    }


}
