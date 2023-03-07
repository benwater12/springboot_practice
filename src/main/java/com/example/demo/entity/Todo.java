package com.example.demo.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
//這個一個東西是和資歷庫討要東西的物件
//自動幫你每個變數都生出getter setter
//這個會根據application的文件去和某個資料庫對街
@Entity
@Table
@Getter @Setter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String task;

    @Column
    Integer status;

    @Column
    String createTime;

    @Column
    String updateTime;
}