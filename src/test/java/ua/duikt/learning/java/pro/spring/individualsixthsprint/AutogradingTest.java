package ua.duikt.learning.java.pro.spring.individualsixthsprint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import ua.duikt.learning.java.pro.spring.individualsixthsprint.entities.Account;
import ua.duikt.learning.java.pro.spring.individualsixthsprint.repositories.AccountRepository;
import ua.duikt.learning.java.pro.spring.individualsixthsprint.services.BankService;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(OutputCaptureExtension.class)
class AutogradingTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private BankService bankService;

    @Test
    @DisplayName("Check Logic: Successful Transfer changes balances")
    void checkSuccessLogic(CapturedOutput output) {
        Account sender = new Account(1L, "Alice", new BigDecimal("100.00"));
        Account receiver = new Account(2L, "Bob", new BigDecimal("50.00"));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        bankService.transferMoney(1L, 2L, new BigDecimal("30.00"));

        assertEquals(new BigDecimal("70.00"), sender.getBalance());
        assertEquals(new BigDecimal("80.00"), receiver.getBalance());

        verify(accountRepository, times(2)).update(any(Account.class));

        String logs = output.getOut();
        assertTrue(logs.contains("Alice") || logs.contains("1"), "Log should contain ID or name");
        assertTrue(logs.contains("success") || logs.contains("Success"), "Log should indicate success");
    }

    @Test
    @DisplayName("Check Logic + Logging: Insufficient Funds")
    void checkFailLogic(CapturedOutput output) {
        Account sender = new Account(1L, "Alice", new BigDecimal("10.00"));
        Account receiver = new Account(2L, "Bob", new BigDecimal("50.00"));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

        assertThrows(RuntimeException.class, () ->
                bankService.transferMoney(1L, 2L, new BigDecimal("100.00"))
        );

        assertEquals(new BigDecimal("10.00"), sender.getBalance());

        verify(accountRepository, times(2)).update(any(Account.class));

        String logs = output.getOut();
        assertTrue(logs.contains("Alice") || logs.contains("1"), "Log should contain ID or name");
        assertTrue(logs.contains("success") || logs.contains("Success"), "Log should indicate success");
    }

}