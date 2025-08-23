package com.mongoDB.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "students")
public class User {

    public User(String studentName, int studentAge) {
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
    @Id
    private String id;

    @Field("student_name")
    private String studentName;

    @Field("student_age")
    private Integer studentAge;

    @Override
    public String toString() {
        return String.format(
                "Student[id=%s, studentName='%s'," + "studentAge="+studentAge+"]",
                id, studentName, studentAge);
    }
}
