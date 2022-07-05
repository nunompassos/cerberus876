package br.com.letscode.modelos.Conta;

public enum Taxa {
	PJ(
			0.005,
			0.005,
			0.005,
			0.010),
	PF(
			0,
			0,
			0.003,
			0.007);

	private final double transferencia;
	private final double saque;
	private final double rendimento;
	private final double juros;

	Taxa(
			double transferencia,
			double saque,
			double rendimento,
			double juros) {
		this.transferencia = transferencia;
		this.saque = saque;
		this.rendimento = rendimento;
		this.juros = juros;
	}

	public double getJuros() {
		return juros;
	}

	public double getTransferencia() {
		return transferencia;
	}

	public double getSaque() {
		return saque;
	}

	public double getRendimento() {
		return rendimento;
	}

}
