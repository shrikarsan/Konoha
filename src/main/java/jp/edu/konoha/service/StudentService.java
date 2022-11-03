package jp.edu.konoha.service;

import jp.edu.konoha.model.Class;
import jp.edu.konoha.model.Student;
import jp.edu.konoha.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student addStudent(Student student){
        student.setStudentId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(student);
    }

    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    public Student getStudentByStudentId(String studentId){
        return repository.findById(studentId).get();
    }

    public List<Student> getStudentByBatchId(String batchId){
        return  repository.findByBatchId(batchId);
    }

    public List<Student> getStudentByLevel(int level){
        return  repository.findByLevel(level);
    }

    public Student updateStudent(Student studentRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Student existingStudent = repository.findById(studentRequest.getStudentId()).get();
        existingStudent.setFirstName(studentRequest.getFirstName());
        existingStudent.setLastName(studentRequest.getLastName());
        existingStudent.setEmail(studentRequest.getEmail());
        existingStudent.setWhatsappNumber(studentRequest.getWhatsappNumber());
        existingStudent.setLevel(studentRequest.getLevel());
        existingStudent.setBatchId(studentRequest.getBatchId());
        return repository.save(existingStudent);
    }

    public String deleteStudent(String studentId){
        repository.deleteById(studentId);
        return studentId+" student deleted from database";
    }
}
