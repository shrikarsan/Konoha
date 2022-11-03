package jp.edu.konoha.repository;

import jp.edu.konoha.model.Attendance;
import jp.edu.konoha.model.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByBatchId(String batchId);
    List<Attendance> findByClassId(String classId);
}
