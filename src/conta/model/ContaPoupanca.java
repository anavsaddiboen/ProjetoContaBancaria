package conta.model;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

	private LocalDate dataCadastro;
	private double taxaJuros;

	public ContaPoupanca(String cliente) {
		super(cliente);
		this.setDataCadastro(LocalDate.now());
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	private void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public double getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	//TODO: lógica de taxa de juros aplicado sobre o saldo

}
