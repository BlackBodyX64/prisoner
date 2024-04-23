package com.example.prisoner.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Prisoner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Date docDate;
    private String userCode;
    private String docNo;
    private String userNo;
    private String namePrefix;
    private String firstNameTh;
    private String middleNameTh;
    private String lastNameTh;
    private String firstNameEn;
    private String middleNameEn;
    private String lastNameEn;
    private String userType;
    private String status;
    private Boolean isImprison;
}
