package com.example.lap7.Service;

import com.example.lap7.Model.Employee;
import com.example.lap7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<Employee>();

    public  ArrayList<Employee> getEmployee() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean updateEmployee(int id ,Employee employee ) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId()==id) {
                employees.set(i, employee);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id ) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId()==id) {
                employees.remove(i);
                return true;
            }
        }
        return false;

    }

    public Employee findEmployeeByName(String name) {
       for (int i = 0; i < employees.size(); i++) {
           if (employees.get(i).getName().equals(name)) {
               return employees.get(i);

           }
       }
       return null;
    }

    public ArrayList<Employee> getAvgAge(int min, int max) {
        ArrayList<Employee> avg= new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getAge()>=min){
                if (employees.get(i).getAge()<=max){
                    avg.add(employees.get(i));

                }
            }
        }
        return avg;
    }

    public ArrayList<Employee> searchEmployeePosition(String position) {
     ArrayList<Employee> employeePos = new ArrayList<>();
     for (int i = 0; i < employees.size(); i++) {
         if (employees.get(i).getPosition().equalsIgnoreCase(position)) {
             employeePos.add(employees.get(i));

         }
     }
     return employeePos;

     }

      public boolean updatePhoneNumber(String phoneNumber,Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getPhoneNumber().equals(phoneNumber)) {
                employees.get(i).setPhoneNumber(phoneNumber);
                return true;
            }
        }
        return false;
        }

      }




