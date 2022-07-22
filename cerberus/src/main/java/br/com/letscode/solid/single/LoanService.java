package br.com.letscode.solid.single;

public class LoanService {

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
