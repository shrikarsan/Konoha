package jp.edu.konoha.controller;

import jp.edu.konoha.model.Attendance;
import jp.edu.konoha.model.Class;
import jp.edu.konoha.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Attendance createAttendance(@RequestBody Attendance attendance){
        return service.addAttendance(attendance);
    }

    //{
//    "studentId" : "ad7bb70c",
//    "batchId" : "e9b5cff6",
//    "classId" : "dd540166",
//    "isPresent" : true
//}
    @GetMapping
    public List<Attendance> getAttendances() {
        return service.findAllAttendances();
    }

    @GetMapping("/{attendanceId}")
    public Attendance getAttendance(@PathVariable String attendanceId){
        return service.getAttendanceByAttendanceId(attendanceId);
    }

    @GetMapping("/class/{classId}")
    public List<Attendance> getAttendanceByClassId(@PathVariable String classId){
        return service.getAttendanceByClassId(classId);
    }

    @PutMapping
    public Attendance modifyAttendance(@RequestBody Attendance attendance){
        return service.updateAttendance(attendance);
    }

    @DeleteMapping("/{attendanceId}")
    public String deleteAttendance(@PathVariable String attendanceId){
        return service.deleteAttendance(attendanceId);
    }
}
