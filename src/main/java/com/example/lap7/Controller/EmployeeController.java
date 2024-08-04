package com.example.lap7.Controller;

import com.example.lap7.Api.ApiResponse;
import com.example.lap7.Model.Employee;
import com.example.lap7.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity getEmployees() {
        ArrayList<Employee> employees = employeeService.getEmployee();
        return ResponseEntity.status(200).body(employees);
    }
    @PostMapping("/add")
    public ResponseEntity addEmployee(@Valid @RequestBody Employee employee , Errors errors) {
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(employee);
        }
       employeeService.addEmployee(employee);
        return ResponseEntity.status(200).body(new ApiResponse("Employee Added "));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateEmployee(@PathVariable int id ,@Valid @RequestBody Employee employee , Errors errors) {
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = employeeService.updateEmployee(id, employee);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Employee Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Employee not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {
        boolean isDeleted= employeeService.deleteEmployee(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponse("Employee Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Employee not found"));
    }

    @GetMapping("/get/employee/{name}")
    public ResponseEntity findEmployeeByName(@PathVariable String name) {
        return ResponseEntity.status(200).body(employeeService.findEmployeeByName(name));
    }

   @GetMapping("/avg/{min}/{max}")
    public ResponseEntity getAvgAge(@PathVariable int min,@PathVariable int max) {
        return ResponseEntity.status(200).body(employeeService.getAvgAge(min, max));
    }

    @GetMapping("/search/{position}")
   public ResponseEntity searchEmployeePosition(@PathVariable String position) {
     return ResponseEntity.status(200).body(employeeService.searchEmployeePosition(position));
   }

   @PutMapping("/update/{phoneNumber}")
    public ResponseEntity updatePhoneNumber(@PathVariable String phoneNumber,@Valid @RequestBody Employee employee, Errors errors) {
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdatePhoneNumber= employeeService.updatePhoneNumber(phoneNumber, employee);
        if (isUpdatePhoneNumber) {
            return ResponseEntity.status(200).body(new ApiResponse("Phone Number Updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Phone Number not found"));

   }


}
