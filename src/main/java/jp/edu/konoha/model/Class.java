package jp.edu.konoha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.Date;

@Document(collection = "classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    private String classId;
    private String batchId;
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
}

//{
//    "batchId" : "e9b5cff6",
//    "date" : "2022-11-18",
//    "startTime" : "17:00:00",
//    "endTime" : "20:00:00"
//}
