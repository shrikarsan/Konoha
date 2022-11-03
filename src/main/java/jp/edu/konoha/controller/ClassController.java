package jp.edu.konoha.controller;

import jp.edu.konoha.model.Batch;
import jp.edu.konoha.model.Class;
import jp.edu.konoha.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Class createClass(@RequestBody Class cls){
        return service.addClass(cls);
    }

//    {
//        "batchId" : "e9b5cff6",
//        "date" : "2022-11-18",
//        "startTime" : "17:00:00",
//        "endTime" : "20:00:00"
//    }

    @GetMapping
    public List<Class> getClasses() {
        return service.findAllClasses();
    }

    @GetMapping("/{classId}")
    public Class getClass(@PathVariable String classId){
        return service.getClassByClassId(classId);
    }

    @GetMapping("/batch/{batchId}")
    public List<Class> getClassByBatchId(@PathVariable String batchId){
        return service.getClassByBatchId(batchId);
    }

    @PutMapping
    public Class modifyClass(@RequestBody Class cls){
        return service.updateClass(cls);
    }

    @DeleteMapping("/{classId}")
    public String deleteClass(@PathVariable String classId){
        return service.deleteClass(classId);
    }
}
