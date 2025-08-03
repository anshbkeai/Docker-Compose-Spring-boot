package com.tickets.tickest.Service;

import com.tickets.tickest.Pojo.Comment;
import com.tickets.tickest.Pojo.Comment_Dto;
import com.tickets.tickest.Pojo.Status;
import com.tickets.tickest.Pojo.Ticket;
import com.tickets.tickest.Repositry.Comment_Repo;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class TicketService {

    private List<Ticket> ticketList = new ArrayList<>();
    private Comment_Repo comment_Repo ;
    private Map<String,List<Comment>> comment_map = new HashMap<>();
    public TicketService(Comment_Repo comment_Repo) {
        // hey create about the  predeifined list of them
            this.comment_Repo = comment_Repo;
    }

    @PostConstruct
    private  void intit() {
        ticketList.add(newTicket("John Doe", "Login page crashes", Status.OPEN, LocalDate.of(2025, 7, 10)));
        ticketList.add(newTicket("Jane Smith", "Payment not processing", Status.IN_PROGRESS, LocalDate.of(2025, 7, 15)));
        ticketList.add(newTicket("Amit Sharma", "UI broken on mobile", Status.CLOSED, LocalDate.of(2025, 6, 25)));
        ticketList.add(newTicket("Sara Lee", "Password reset not working", Status.OPEN, LocalDate.of(2025, 7, 1)));
        ticketList.add(newTicket("Mike Jordan", "Dashboard loading slowly", Status.OPEN, LocalDate.of(2025, 6, 20)));
        ticketList.add(newTicket("Priya Singh", "Image upload fails", Status.RESOLVED, LocalDate.of(2025, 7, 30)));
        ticketList.add(newTicket("Carlos Vega", "Session timeout too fast", Status.IN_PROGRESS, LocalDate.of(2025, 6, 28)));
        ticketList.add(newTicket("Emily Turner", "Emails not sending", Status.CLOSED, LocalDate.of(2025, 7, 12)));
        ticketList.add(newTicket("Raj Patel", "User roles not updating", Status.OPEN, LocalDate.of(2025, 7, 25)));
        ticketList.add(newTicket("Nina Kaur", "Crash after logout", Status.IN_PROGRESS, LocalDate.of(2025, 7, 5)));

        for (Ticket ticket : ticketList) {
            List<Comment> comments = new ArrayList<>();

            Comment comment1 = new Comment();
            comment1.setId(ticket.getId());
            comment1.setCommenter("AGENT");
            comment1.setMessage("Initial investigation started.");


            comments.add(comment1);

            comment_Repo.save(comment1);
            
        }

        log.info("Initialized tickets and comment map.");

    }

    private  Ticket newTicket(String name, String issue, Status status, LocalDate date) {
        Ticket ticket = new Ticket();
        ticket.setId(UUID.randomUUID().toString());
        ticket.setName(name);
        ticket.setIssue(issue);
        ticket.setDate(date);
        ticket.setStatus(status);
        return ticket;
    }

    public List<Ticket> get_all_tickets() {
        return ticketList;
    }

    public Ticket findByid(String id) {
        for(Ticket t : ticketList) {
            System.out.println(t.toString() + id);
            if(t.getId().equals(id)) return t;
        }
        return null;

    }

    public  List<Comment> get_comments_by_id(String id) {
        return comment_Repo.findByTicketid(id);
    }
    public void add_comment(String id, Comment_Dto comment) {
        List<Comment> c = comment_map.get(id);

        log.info(comment.toString());
        Comment comment2 = new Comment();
        comment2.setCommenter(comment.getCommenter());
        comment2.setMessage(comment.getMesaage());
        comment2.setId(UUID.randomUUID().toString());
        comment2.setTicketid(id);
        
        comment_Repo.save(comment2);
        log.info("Added coomnet");
    }
}

