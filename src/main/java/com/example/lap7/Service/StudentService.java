package com.example.lap7.Service;

import com.example.lap7.Model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<Student>();

    public  ArrayList<Student> getStudents() {
       return students;
    }

   public void addStudent(Student student) {
        students.add(student);
   }

   public boolean updateStudent(int id ,Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
   }

   public boolean deleteStudent(int id ) {
      for (int i = 0; i < students.size(); i++) {
          if (students.get(i).getId()==id) {
              students.remove(i);
              return true;
          }
      }
      return false;

   }

   public Student findStudentsById(int id) {
       for (int i = 0; i < students.size(); i++) {
           if (students.get(i).getId() == id) {
               return students.get(i);
           }
       }
       return null;
   }

   public ArrayList<Student> findStudentsBySection(String section) {
        ArrayList<Student> temp1 = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSection().equals(section)) {
                temp1.add(students.get(i));
            }
        }
        return temp1;
   }

    public Student studentGraduated(int id ){
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getId() == id) {
           if(students.get(i).getIsGraduated().equals(false)){
               students.get(i).setIsGraduated(true);
               return students.get(i);

           }
        }
    }
    return null;
    }

    public ArrayList<Student> studentScore(int score){
        ArrayList<Student> scores = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getScore() == score) {
                scores.add(students.get(i));
            }
        }
        return scores;
    }




   }



