package com.company.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);

    @Query("SELECT u FROM User u WHERE "
            + " CONCAT(u.firstName,' ', u.lastName, ' ',u.email) "
            + " LIKE %?1%")
    public List<User> findAll(String keyword);

    @Query("SELECT u FROM User u WHERE "
            + " CONCAT(u.firstName, ' ',u.lastName, ' ',u.email) "
            + " LIKE %?1%")
    public Page<User> findAll(String keyword, Pageable pageable);

}
