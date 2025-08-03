package com.tickets.tickest.Repositry;

import com.tickets.tickest.Pojo.Comment;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Comment_Repo extends JpaRepository<Comment,String> {

    List<Comment> findByTicketid(String ticketid);
}
