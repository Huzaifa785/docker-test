package com.courses.IITB.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "course_title", nullable = false)
    private String courseTitle;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "course_description", nullable = false)
    private String courseDesc;


}
