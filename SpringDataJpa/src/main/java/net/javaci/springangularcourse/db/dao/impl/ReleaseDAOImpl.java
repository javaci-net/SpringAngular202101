package net.javaci.springangularcourse.db.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import net.javaci.springangularcourse.db.dao.ReleaseDAO;
import net.javaci.springangularcourse.db.entity.Release;

@Transactional
@Repository
public class ReleaseDAOImpl implements ReleaseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRelease(Release entity) {
        entityManager.persist(entity);
    }

    @Override
    public Release getReleaseById(Integer id) {
        return entityManager.find(Release.class, id);
    }
}
