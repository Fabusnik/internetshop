package ru.fab.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fab.model.User;


public interface CrudUserRepository extends JpaRepository<User, Integer> {
}
