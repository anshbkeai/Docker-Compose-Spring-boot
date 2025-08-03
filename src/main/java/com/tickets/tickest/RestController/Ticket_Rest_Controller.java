package com.tickets.tickest.RestController;

import com.tickets.tickest.Pojo.Comment;
import com.tickets.tickest.Pojo.Comment_Dto;
import com.tickets.tickest.Pojo.Ticket;
import com.tickets.tickest.Service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/tickets")
@CrossOrigin("http://localhost:5173/")
public class Ticket_Rest_Controller {

    private final TicketService ticketService;

    public  Ticket_Rest_Controller(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> get_all() {
        return new ResponseEntity<>(ticketService.get_all_tickets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Ticket> getById(@PathVariable String id) {
        log.info(id);
        Ticket ticket = ticketService.findByid(id);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }


    @GetMapping("/{id}/comments")
    public  ResponseEntity<List<Comment>> comments(@PathVariable String id) {
        log.info(id);
        List<Comment> comments = ticketService.get_comments_by_id(id);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

    @PostMapping("/{id}/comment")
    public ResponseEntity<String> add_comment(@PathVariable String id , @RequestBody Comment_Dto comment) {
        ticketService.add_comment(id,comment);
        return new ResponseEntity<>("Added Messaagee" , HttpStatus.OK);
    }

}







