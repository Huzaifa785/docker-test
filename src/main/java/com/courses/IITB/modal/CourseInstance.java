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
@Table(name = "course_Instance")
public class CourseInstance extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "CourseId")
    private Course courseId;

    @Column(name = "course_year", nullable = false)
    private int  courseYear;

    @Column(name = "course_sem", nullable = false)
    private int courseSem;




}
