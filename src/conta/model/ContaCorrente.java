package conta.model;

public class ContaCorrente extends Conta {

	private float taxaOperacao;
	private float limiteChequeEspecial;

	public ContaCorrente(String cliente, float taxaOperacao) {
		super(cliente);
		this.setTaxaOperacao(taxaOperacao);
	}

	public double getTaxaOperacao() {
		return taxaOperacao;
	}

	public void setTaxaOperacao(float taxaOperacao) {
		if (taxaOperacao >= 0 && taxaOperacao <= 40) {
			this.taxaOperacao = taxaOperacao / 100;
		}

		throw new IllegalArgumentException("Taxa de operação inválida. Valor deve estar entre 0 - 50.");
	}

	@Override
	public void depositar(float valor) {
		super.depositar(valor - (valor * taxaOperacao));
	}

	@Override
	public void sacar(float valor) {
		if (valor > 0 && valor <= super.saldo + this.limiteChequeEspecial) {
			super.saldo -= valor;
			return;
		}

		if (valor <= 0) {
			throw new IllegalArgumentException("Valor do saque deve ser maior que 0 (zero).");
		}

		if (valor > super.saldo + this.limiteChequeEspecial) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		}
	}

	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(float limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}
}
