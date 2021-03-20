package net.javaci.springangularcourse.db.dao.jpaimpl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import net.javaci.springangularcourse.db.dao.ApplicationDAO;
import net.javaci.springangularcourse.db.entity.Application;

@Profile("!springrepo")
@Transactional
@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Application entity) {
        entityManager.persist(entity);
    }

    @Override
    public Optional<Application> findById(Integer id) {
        Application result = entityManager.find(Application.class, id);
        return Optional.of(result);
    }

    @Override
    public boolean applicationExists(String name, String owner) {
        
        String jpql = "from Application WHERE name = ?1 and owner = ?2";
        int count = entityManager
            .createQuery(jpql)
            .setParameter(1, name)
            .setParameter(2, owner)
            .getResultList()
            .size();
        
        return count > 0;
    }

    @Override
    public boolean applicationExists2(String name, String owner) {
        
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Application> cq = cb.createQuery(Application.class);
        
        Root<Application> entityRoot = cq.from(Application.class);
        
        // WHERE name = ?1 and owner = ?2
        Expression<Boolean> restriction = cb.and( 
                cb.equal(entityRoot.get("name"), name) ,  // name = ?1
                cb.equal(entityRoot.get("owner"), owner) // owner = ?2
        );
        
        cq.select(entityRoot).where(restriction);
        
        int count = entityManager.createQuery(cq).getResultList().size();
        
        return count > 0;
    }

    @Override
    public void updateNameAndOwnerById(Integer id, String name, String owner) {
        Application app = findById(id).get();
        app.setName(name);
        app.setOwner(owner);
        entityManager.flush();
    }

    @Override
    public void deleteById(Integer id) {
        Application app = findById(id).get();
        entityManager.remove(app);
    }

    @Override
    public Application getApplicationWithTicketsById(Integer id) {
        String jpql = "SELECT a from Application a " + "INNER JOIN FETCH a.tickets t " + "WHERE a.id = ?1";
        Application result = (Application) entityManager
                .createQuery(jpql)
                .setParameter(1, id)
                .getSingleResult();
        return result;
    }
   
}
