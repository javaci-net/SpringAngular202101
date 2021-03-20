package net.javaci.springangularcourse.db.dao.springimpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaci.springangularcourse.db.dao.ApplicationDAO;
import net.javaci.springangularcourse.db.entity.Application;

@Profile("springrepo")
@Transactional
@Repository
public interface ApplicationDAORepositoryImpl 
    extends ApplicationDAO, JpaRepository<Application, Integer> {

    @Override
    default boolean applicationExists(String name, String owner) {
        // FIXME
        return false;
    }
    
    @Override
    default boolean applicationExists2(String name, String owner) {
        return applicationExists(name, owner);
    }
    
    @Override
    default void updateNameAndOwnerById(Integer id, String name, String owner) {
        // FIXME
        
    }
    
    @Override
    default Application getApplicationWithTicketsById(Integer id) {
        // FIXME
        return findById(id).get();
    }
}
