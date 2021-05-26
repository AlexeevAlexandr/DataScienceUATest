package com.DataScienceUATest.dto;

import com.DataScienceUATest.model.Fio;
import lombok.Data;

@Data
public class UserShortDto {

    private int id;
    private String username;
    private Fio fio;
}
