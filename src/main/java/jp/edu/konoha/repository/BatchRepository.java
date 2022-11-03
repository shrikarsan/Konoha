package jp.edu.konoha.repository;

import jp.edu.konoha.model.Batch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BatchRepository extends MongoRepository<Batch, String> {
    List<Batch> findByLevel(int level);
}
