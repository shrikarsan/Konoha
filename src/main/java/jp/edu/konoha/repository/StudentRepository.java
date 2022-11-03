package jp.edu.konoha.repository;

import jp.edu.konoha.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository  extends MongoRepository<Student, String> {
    List<Student> findByBatchId(String batchId);
    List<Student> findByLevel(int level);
}
