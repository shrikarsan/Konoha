package jp.edu.konoha.repository;

import jp.edu.konoha.model.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClassRepository extends MongoRepository<Class, String> {
    List<Class> findByBatchId(String batchId);
}
