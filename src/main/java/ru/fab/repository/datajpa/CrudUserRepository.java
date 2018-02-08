package ru.fab.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.fab.model.User;


public interface CrudUserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id=?1")
    int delete(Integer id);

    User findByName(String name);
}
