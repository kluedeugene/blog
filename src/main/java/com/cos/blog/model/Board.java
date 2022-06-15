package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       //getter setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity     //orm class다 
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private int id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 사용 <html>태그가 섞여서 디자인이되어 용량이커짐.
    
    @ColumnDefault("0") 
    private int count; //조회수

    @ManyToOne  // Many= board, One = user  -> 한명의 유저가 여러개의 게시물을 작성할 수 있다.
    @JoinColumn(name="userId")
    private User user; //Db는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할수있다.

    @CreationTimestamp
    private Timestamp createDate;
}
