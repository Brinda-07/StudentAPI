package com.example.StudentAPI.Service;

import com.example.StudentAPI.Entity.Student;
import com.example.StudentAPI.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public void createStudent(Student student) {
        studentRepo.save(student);

    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void updateStudent(Long id, Student student) {
        Optional<Student> st=studentRepo.findById(id);
        if(st.isPresent())
        {
            Student st1=st.get();
            st1.setName(student.getName());
            st1.setEmail(student.getEmail());

            st1.setStandard(student.getStandard());
            studentRepo.save(st1);

        }
    }

    public void deleteStudent(Long id) {
        Optional<Student> stbox=studentRepo.findById(id);
        if(stbox.isPresent())
            studentRepo.delete(stbox.get());
    }
}
