package com.tickets.tickest.Pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    private String id;
    private  String commenter;
    private  String message;

    private String ticketid;

}
