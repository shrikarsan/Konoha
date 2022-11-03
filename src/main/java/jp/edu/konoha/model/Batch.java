package jp.edu.konoha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "batches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    @Id
    private String batchId;
    private String name;
    private int level;
    private String whatsappGroupLink;
    private String zoomLink;
    private Date startDate;
    private Date endDate;
}

//{
//    "name" : "A1",
//    "level" : 1,
//    "whatsappGroupLink" : "https://chat.whatsapp.com/GjHUKc0aMhQ25kElerVMrS",
//    "zoomLink" : "https://us02web.zoom.us/j/82159279189?pwd=bWlGeU9oN253MThiRVUweE9HN0ZBUT08",
//    "startDate" : "2022-11-03",
//    "endDate" : "2022-11-18"
//}

