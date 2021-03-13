package net.javaci.springangularcourse.db.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.javaci.springangularcourse.db.dao.ApplicationDAO;
import net.javaci.springangularcourse.db.entity.Application;

@Transactional
@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addApplication(Application entity) {
        entityManager.persist(entity);
    }

    @Override
    public Application getApplicationById(Integer id) {
        return entityManager.find(Application.class, id);
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
        Application app = getApplicationById(id);
        app.setName(name);
        app.setOwner(owner);
        entityManager.flush();
    }

    @Override
    public void removeApplicationById(Integer id) {
        Application app = getApplicationById(id);
        entityManager.remove(app);
    }

    
}
