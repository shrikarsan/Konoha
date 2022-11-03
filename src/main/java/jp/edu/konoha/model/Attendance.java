package jp.edu.konoha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "attendances")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    @Id
    private String attendanceId;
    private String studentId;
    private String batchId;
    private String classId;
    private Boolean isPresent;
}

//{
//    "studentId" : "ad7bb70c",
//    "batchId" : "e9b5cff6",
//    "classId" : "dd540166",
//    "isPresent" : true
//}

