package org.example.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id     // answer entity --> pk id 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //신규 recode가 insert 일때 자동 id값을 1씩 증가
    private Integer id;

    @Column(columnDefinition = "Text") // field 타입을 text로 지정
    private Integer content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;

}
