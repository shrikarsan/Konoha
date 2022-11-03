package jp.edu.konoha.service;

import jp.edu.konoha.model.Batch;
import jp.edu.konoha.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BatchService {
    @Autowired
    private BatchRepository repository;

    public Batch addBatch(Batch batch){
        batch.setBatchId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(batch);
    }

    public List<Batch> findAllBatches() {
        return repository.findAll();
    }

    public Batch getBatchByBatchId(String batchId){
        return repository.findById(batchId).get();
    }

    public List<Batch> getBatchByLevel(int level){
        return  repository.findByLevel(level);
    }

    public Batch updateBatch(Batch batchRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Batch existingBatch = repository.findById(batchRequest.getBatchId()).get();
        existingBatch.setName(batchRequest.getName());
        existingBatch.setLevel(batchRequest.getLevel());
        existingBatch.setWhatsappGroupLink(batchRequest.getWhatsappGroupLink());
        existingBatch.setZoomLink(batchRequest.getZoomLink());
        existingBatch.setStartDate(batchRequest.getStartDate());
        existingBatch.setEndDate(batchRequest.getEndDate());
        return repository.save(existingBatch);
    }

    public String deleteBatch(String batchId){
        repository.deleteById(batchId);
        return batchId+" batch deleted from database";
    }
}
