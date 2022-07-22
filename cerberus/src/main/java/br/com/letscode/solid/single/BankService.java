package br.com.letscode.solid.single;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @deprecated
 * @see AccountService
 * @see AccountAuth
 * @see LoanService
 */
public class BankService {

    /**
     * @see AccountService#bankAccounts
     */
    final Map<Integer, BankAccount> bankAccounts = new HashMap<>();
    
    /**
     * @see AccountService#deposit
     */
    public BigDecimal deposit(BigDecimal amount, BankAccount account) {
        account.setSaldo(account.getSaldo().add(amount));
        return account.getSaldo();
    }
    
    /**
     * @see AccountService#withdraw
     */
    public BigDecimal withdraw(BigDecimal amount, BankAccount account) {
        account.setSaldo(account.getSaldo().subtract(amount));
        return account.getSaldo();
    }
    
    /**
     * @see AccountAuth#sendOTP
     */
    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            // Send an email
        }
    }
    
    /**
     * @see AccountService#printMovements
     */
    public void printMovements() {
        // print all movements of an account
    }
    
    /**
     * @see LoanService#getLoanInterestInfo
     */
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            System.out.println("Emprestimo para a casa");
        }
        if (loanType.equals("personalLoan")) {
            System.out.println("Emprestimo pessoal");
        }
        if (loanType.equals("carLoan")) {
            System.out.println("Emprestimo para o carro");
        }
    }

}
