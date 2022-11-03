package jp.edu.konoha.service;

import jp.edu.konoha.model.Attendance;
import jp.edu.konoha.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repository;

    public Attendance addAttendance(Attendance attendance){
        attendance.setAttendanceId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(attendance);
    }

    public List<Attendance> findAllAttendances() {
        return repository.findAll();
    }

    public Attendance getAttendanceByAttendanceId(String attendanceId){
        return repository.findById(attendanceId).get();
    }

    public List<Attendance> getAttendanceByBatchId(String batchId){
        return  repository.findByBatchId(batchId);
    }

    public List<Attendance> getAttendanceByClassId(String classId){
        return  repository.findByClassId(classId);
    }

    public Attendance updateAttendance(Attendance attendanceRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Attendance existingAttendance = repository.findById(attendanceRequest.getClassId()).get();
        existingAttendance.setIsPresent(attendanceRequest.getIsPresent());
        return repository.save(existingAttendance);
    }

    public String deleteAttendance(String attendanceId){
        repository.deleteById(attendanceId);
        return attendanceId+" attendance deleted from database";
    }
}
