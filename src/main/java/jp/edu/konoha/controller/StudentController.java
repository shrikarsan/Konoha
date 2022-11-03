package jp.edu.konoha.controller;

import jp.edu.konoha.model.Student;
import jp.edu.konoha.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    //{
//    "firstName" : "John",
//    "lastName" : "David",
//    "email" : "john@mail.com",
//    "whatsappNumber" : "0775522444",
//    "level" : 3,
//    "batchId" : "e9b5cff6"
//}
    @GetMapping
    public List<Student> getStudents() {
        return service.findAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId){
        return service.getStudentByStudentId(studentId);
    }

    @GetMapping("/batch/{batchId}")
    public List<Student> getStudentByBatchId(@PathVariable String batchId){
        return service.getStudentByBatchId(batchId);
    }

    @GetMapping("/level/{level}")
    public List<Student> getStudentByLevel(@PathVariable int level){
        return service.getStudentByLevel(level);
    }

    @PutMapping
    public Student modifyStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable String studentId){
        return service.deleteStudent(studentId);
    }
}
