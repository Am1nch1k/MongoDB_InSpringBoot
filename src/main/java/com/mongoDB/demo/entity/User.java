package com.mongoDB.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "students")
public class User {

    public User(String studentName, int studentAge, String studentMail) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
    @Id
    private String id;

    @Field("student_name")
    private String studentName;

    @Field("student_age")
    private Integer studentAge;

    @Field("student_mail")
    private String email;

}
