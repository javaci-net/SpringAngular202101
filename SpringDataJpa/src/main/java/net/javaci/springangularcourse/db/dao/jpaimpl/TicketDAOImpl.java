package net.javaci.springangularcourse.db.dao.jpaimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.javaci.springangularcourse.db.dao.TicketDAO;
import net.javaci.springangularcourse.db.entity.Ticket;
import net.javaci.springangularcourse.db.entity.dto.TicketStats;

@Transactional
@Repository
public class TicketDAOImpl implements TicketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTicket(Ticket entity) {
        entityManager.persist(entity);
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return entityManager.find(Ticket.class, id);
    }

    @Override
    public List<TicketStats> findTicketStats() {
        String jpql = "SELECT new "
                + TicketStats.class.getCanonicalName()
                + "(t.status, count(t.id), min(t.createDateTime), max(t.createDateTime) ) "
                + "FROM Ticket t "
                + "GROUP BY t.status";
        return entityManager.createQuery(jpql, TicketStats.class).getResultList();
    }

    @Override
    public void removeTicketById(Integer id) {
        Ticket ticket = getTicketById(id);
        entityManager.remove(ticket);
    }
}
