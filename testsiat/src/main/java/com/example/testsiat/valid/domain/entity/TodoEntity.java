package com.example.testsiat.valid.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

// DDL 작업을 하고 싶으면 테이블에 맞는 작업을 모두 해줘야한다.
//@Entity // 테이블과 매핑되는 클래스이다.
@Entity(name = "jpa_todo_entity") // 테이블과 매핑되는 클래스이다. // 생략하면 클래스 이름으로 테이블을 생성한다.
// @Table(name = "todo") // 테이블과 매핑되는 클래스이다. // 생략하면 클래스 이름으로 테이블을 생성한다.
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {
    @Id // PK를 지정해줘야한다.
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // auto increment
    private int     seq;  // jpa에서 자동으로 생성되는 PK라서 필수로 넣어야한다.
    
    @Column(name = "title")
    private String  title;
    @Column(name = "content")
    private String  content;

    @Column(name = "phone")
    private String phone;

    @Column(name = "start_date")
    private String  startDate; // 원래는 삭제
    @Column(name = "end_date")
    private String  endDate; // 원래는 삭제
    
    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private int     priority;
}
