package jp.edu.konoha.service;

import jp.edu.konoha.model.Batch;
import jp.edu.konoha.model.Class;
import jp.edu.konoha.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClassService {
    @Autowired
    private ClassRepository repository;

    public Class addClass(Class cls){
        cls.setClassId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(cls);
    }

    public List<Class> findAllClasses() {
        return repository.findAll();
    }

    public Class getClassByClassId(String classId){
        return repository.findById(classId).get();
    }

    public List<Class> getClassByBatchId(String batchId){
        return  repository.findByBatchId(batchId);
    }

    public Class updateClass(Class classRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Class existingClass = repository.findById(classRequest.getClassId()).get();
        existingClass.setBatchId(classRequest.getBatchId());
        existingClass.setDate(classRequest.getDate());
        existingClass.setStartTime(classRequest.getStartTime());
        existingClass.setEndTime(classRequest.getEndTime());
        return repository.save(existingClass);
    }

    public String deleteClass(String classId){
        repository.deleteById(classId);
        return classId+" class deleted from database";
    }
}
