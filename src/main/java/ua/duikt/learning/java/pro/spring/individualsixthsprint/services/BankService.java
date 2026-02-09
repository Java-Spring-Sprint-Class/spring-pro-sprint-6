package ua.duikt.learning.java.pro.spring.individualsixthsprint.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.duikt.learning.java.pro.spring.individualsixthsprint.repositories.AccountRepository;

import java.math.BigDecimal;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
// TODO: Add logging (can use @Slf4j or LoggerFactory.getLogger)
@Service
@Slf4j
public class BankService {

    private final AccountRepository accountRepository;

    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferMoney(Long fromId, Long toId, BigDecimal amount) {
        // TODO: 1. Add log "Transfer started..."

        // TODO: 2. Find accounts (findById). Throw RuntimeException if not found.

        // TODO: 3. Check sender's balance. If insufficient - RuntimeException.
        // Remember to log ERROR before throwing the exception.

        // TODO: 4. Update balances

        // TODO: 5. Save changes using repository.update()

        // TODO: 6. Add log "Transfer success..."
    }
}
