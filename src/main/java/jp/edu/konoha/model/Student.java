package jp.edu.konoha.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String whatsappNumber;
    private int level;
    private String batchId;
}
//{
//    "firstName" : "John",
//    "lastName" : "David",
//    "email" : "john@mail.com",
//    "whatsappNumber" : "0775522444",
//    "level" : 3,
//    "batchId" : "e9b5cff6"
//}

