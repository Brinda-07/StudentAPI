package com.example.StudentAPI.Controller;

import com.example.StudentAPI.Entity.Student;
import com.example.StudentAPI.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student)
   {
       studentService.createStudent(student);

   }

   @GetMapping("/getallstudents")
    public List<Student> getAllStudents()
   {
       return studentService.getAllStudents();
   }

   @GetMapping("/getstudentbyid/{id}")
    public Student getStudentById(@PathVariable Long id)
   {
       return studentService.getStudentById(id);

   }
   @PutMapping("/updateStudent/{id}")
   public void updateStudent(@PathVariable Long id,@RequestBody Student student){
        studentService.updateStudent(id,student);

   }
   @DeleteMapping("/deleteStudent/{id}")
   public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);

   }

}
