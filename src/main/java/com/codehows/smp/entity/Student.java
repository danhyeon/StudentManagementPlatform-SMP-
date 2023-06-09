package com.codehows.smp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="student")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {

    @Id
    @Column(name="student_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String phone;

    private String residence;

    private String belong;

    private String Major;

    private String graduate;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private Boolean status;

    @Column(length = 400)
    private String note;

}
