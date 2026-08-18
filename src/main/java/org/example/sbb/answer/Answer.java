package org.example.sbb.answer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.sbb.question.Question;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id     // answer entity --> pk id 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //신규 recode가 insert 일때 자동 id값을 1씩 증가
    private Integer id;

    @Column(columnDefinition = "Text") // field 타입을 text로 지정
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Question question;

}
