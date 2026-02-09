# Homework: Unit Testing (JUnit 5 + Mockito) & Logging

## Task Description
You are developing a **critical module of a banking system** — a money transfer service.  
Your goal is not only to write working code but also to ensure it is **reliable** (through tests) and **transparent** for diagnostics (through logging).

## Goals
- Master **JUnit 5** and **Mockito** (`@Mock`, `@InjectMocks`, `verify`).  
- Learn to write **unit tests** for the service layer, isolating it from the database.  
- Add **logging (SLF4J)** to track successful operations and errors.

## Technical Requirements

### 1. BankService Implementation
The `BankService` class has the method:  

```java
transferMoney(Long fromId, Long toId, BigDecimal amount)
````

You need to implement the following logic:

1. Find the sender’s account (`fromId`) via the repository. If not found — throw `AccountNotFoundException`.
2. Find the receiver’s account (`toId`). If not found — throw `AccountNotFoundException`.
3. Check if the sender has enough funds. If not — throw `InsufficientFundsException`.
4. Subtract money from the sender and add to the receiver.
5. Save both accounts using the repository.

### 2. Logging

Use a Logger (or Lombok annotation `@Slf4j`):

* **INFO**: At the start of the method (`"Transaction started from {} to {}"`).
* **INFO**: After a successful transfer (`"Transaction success: amount {}"`).
* **ERROR**: In case of any error (before throwing an exception).

### 3. Writing Tests (`BankServiceTest`)

In `src/test/java`, locate the class `BankServiceTest`. Write the following unit tests using Mockito:

1. **testTransfer_Success**: Verify that balances changed and the repository `save` method was called.
2. **testTransfer_AccountNotFound**: Verify that an exception is thrown if the ID is invalid.
3. **testTransfer_InsufficientFunds**: Verify that an exception is thrown if funds are insufficient, and no changes are saved (`save` method is not called).
