package com.tickets.tickest.Pojo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Ticket {
    private  String id;
    private  String name;
    private  String issue;
    private LocalDate date;
    private  Status status;
}

