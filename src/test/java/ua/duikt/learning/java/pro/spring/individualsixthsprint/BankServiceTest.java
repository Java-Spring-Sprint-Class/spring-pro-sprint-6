package ua.duikt.learning.java.pro.spring.individualsixthsprint;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.duikt.learning.java.pro.spring.individualsixthsprint.repositories.AccountRepository;
import ua.duikt.learning.java.pro.spring.individualsixthsprint.services.BankService;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@ExtendWith(MockitoExtension.class)
class BankServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private BankService bankService;

    @Test
    void testTransfer_Success() {
        // TODO: Configure mock behavior (when)
        // TODO: Call bankService.transferMoney(...)
        // TODO: Verify the result (assert) and repository calls (verify)
    }

    @Test
    void testTransfer_InsufficientFunds() {
        // TODO: Verify that an exception is thrown and money is not deducted
    }

}
