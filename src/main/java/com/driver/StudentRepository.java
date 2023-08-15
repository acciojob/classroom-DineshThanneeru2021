package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository

public class StudentRepository {
    //HashMap<Integer,Student> sMap=new HashMap<Integer, Student>();
    ArrayList<Student> studentList=new ArrayList<>();
    ArrayList<Teacher> teacherList=new ArrayList<>();
    HashMap<String,List<String>> teacherStudentMap=new HashMap<>();
    public void addStudent(Student student)
    {
        studentList.add(student);

    }
    public void addTeacher(Teacher teacher)
    {
        teacherList.add(teacher);
    }
    public void addPair(String teacherName,String studentName)
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
        //return ans;
    }


}
