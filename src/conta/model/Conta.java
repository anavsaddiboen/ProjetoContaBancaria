package conta.model;

public abstract class Conta {

	private static int idContador;
	private int idConta;
	private String cliente;
	protected float saldo;

	public Conta(String cliente) {
		this.setCliente(cliente);
		Conta.setIdContador();
		this.setIdConta();
	}

	private static int getIdContador() {
		return Conta.idContador;
	}

	private static void setIdContador() {
		Conta.idContador += 1;
	}

	public int getIdConta() {
		return idConta;
	}

	private void setIdConta() {
		this.idConta = Conta.getIdContador();
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(float valor) {
		if (valor > 0) {
			this.saldo += valor;
			return;
		}
		throw new IllegalArgumentException("Valor do depósito deve ser maior que 0 (zero).");
	}

	public void sacar(float valor) {
		if (valor > 0 && valor <= this.saldo) {
			saldo -= valor;
			return;
		}

		if (valor <= 0) {
			throw new IllegalArgumentException("Valor do saque deve ser maior que 0 (zero).");
		}

		if (valor > this.saldo) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Conta) {
			Conta contaAComparar = (Conta) o;

			if (contaAComparar.idConta == this.idConta) {
				return true;
			}
		}
		return false;
	}
}
