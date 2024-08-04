package com.example.lap7.Controller;

import com.example.lap7.Api.ApiResponse;
import com.example.lap7.Model.Student;
import com.example.lap7.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

  @GetMapping("/get")
  public ResponseEntity getStudents() {
      ArrayList<Student> students = studentService.getStudents();
      return ResponseEntity.status(200).body(students);
  }

  @PostMapping("/add")
  public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
      if (errors.hasErrors()) {
          String message= errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(message);
      }
      studentService.addStudent(student);
      return ResponseEntity.status(200).body(new ApiResponse("Student Added"));
  }
  @PutMapping("/update/{id}")
  public ResponseEntity updateStudent(@PathVariable int id ,@Valid @RequestBody Student student, Errors errors) {
      if (errors.hasErrors()) {
          String message= errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(message);
      }
      boolean isUpdated = studentService.updateStudent(id, student);
      if (isUpdated) {
          return ResponseEntity.status(200).body(new ApiResponse("Student Updated"));
      }
      return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity deleteStudent(@PathVariable int id) {
      boolean isDeleted= studentService.deleteStudent(id);
      if (isDeleted) {
          return ResponseEntity.status(200).body(new ApiResponse("Student Deleted"));
      }
      return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
  }

  @GetMapping("/get/student/{id}")
  public ResponseEntity findStudentById(@PathVariable int id) {
    return ResponseEntity.status(200).body(studentService.findStudentsById(id));
  }

  @GetMapping("/get/{section}")
  public ResponseEntity searchStudentBySection(@PathVariable String section) {
      return ResponseEntity.status(200).body(studentService.findStudentsBySection(section));
  }
  @GetMapping("/get/grad/{id}")
  public ResponseEntity studentGraduated(@PathVariable int id) {
 return ResponseEntity.status(200).body(studentService.studentGraduated(id));

  }

  @GetMapping("/get/score/{score}")
    public ResponseEntity studentScore(@PathVariable int score) {
      return ResponseEntity.status(200).body(studentService.studentScore(score));
  }


}
