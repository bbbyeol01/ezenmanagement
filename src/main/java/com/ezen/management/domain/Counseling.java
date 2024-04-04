package com.ezen.management.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Counseling extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Student student;

    @Column(nullable = false)
    private LocalDateTime counselingDate;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
//    0은 대면, 1 전화, 2 온라인
    private int method;

    public void changeContent(String content, int method){
        this.content = content;
        this.method = method;
    }

}
