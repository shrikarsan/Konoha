package jp.edu.konoha.controller;

import jp.edu.konoha.model.Batch;
import jp.edu.konoha.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/batches")
public class BatchController {
    @Autowired
    private BatchService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Batch createBatch(@RequestBody Batch batch){
        return service.addBatch(batch);
    }

//    {
//        "name" : "A1",
//        "level" : 1,
//        "whatsappGroupLink" : "https://chat.whatsapp.com/GjHUKc0aMhQ25kElerVMrS",
//        "zoomLink" : "https://us02web.zoom.us/j/82159279189?pwd=bWlGeU9oN253MThiRVUweE9HN0ZBUT08",
//        "startDate" : "2022-11-03",
//        "endDate" : "2022-11-18"
//    }

    @GetMapping
    public List<Batch> getBatches() {
        return service.findAllBatches();
    }

    @GetMapping("/{batchId}")
    public Batch getBatch(@PathVariable String batchId){
        return service.getBatchByBatchId(batchId);
    }

    @GetMapping("/level/{level}")
    public List<Batch> getBatchByLevel(@PathVariable int level){
        return service.getBatchByLevel(level);
    }

    @PutMapping
    public Batch modifyBatch(@RequestBody Batch batch){
        return service.updateBatch(batch);
    }

    @DeleteMapping("/{batchId}")
    public String deleteBatch(@PathVariable String batchId){
        return service.deleteBatch(batchId);
    }
}
