package com.DataScienceUATest.dto;

import com.DataScienceUATest.model.Fio;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserFullDto {

    private int id;
    private String username;
    private Fio fio;
    private String email;
    @JsonFormat(pattern="yyyy.MM.dd")
    private Date birthdate;
    private String gender;
}
