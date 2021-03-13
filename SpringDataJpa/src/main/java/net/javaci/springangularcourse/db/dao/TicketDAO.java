package net.javaci.springangularcourse.db.dao;

import java.util.List;

import net.javaci.springangularcourse.db.entity.Ticket;
import net.javaci.springangularcourse.db.entity.dto.TicketStats;

public interface TicketDAO {

    void addTicket(Ticket entity);
    
    Ticket getTicketById(Integer id);
    
    List<TicketStats> findTicketStats(); 
    
    void removeTicketById(Integer id);
}
