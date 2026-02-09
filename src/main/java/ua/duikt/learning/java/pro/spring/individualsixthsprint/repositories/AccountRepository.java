package ua.duikt.learning.java.pro.spring.individualsixthsprint.repositories;

import org.springframework.stereotype.Repository;
import ua.duikt.learning.java.pro.spring.individualsixthsprint.entities.Account;

import java.util.Optional;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@Repository
public interface AccountRepository {
    Optional<Account> findById(Long id);
    void update(Account account);
}
