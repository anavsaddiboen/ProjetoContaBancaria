package conta.repository;

import java.util.List;
import java.util.Optional;

import conta.model.Conta;

public class InMemoryRepository implements ContaRepository {

	private List<Conta> contas;

	public InMemoryRepository(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public boolean salvaConta(Conta conta) {
		if (conta != null) {
			this.contas.add(conta);
			return true;
		}
		return false;
	}

	@Override
	public List<Conta> getAllContas() {
		return this.contas;
	}

	@Override
	public Optional<Conta> getConta(int idConta) {

		if (idConta < 0) {
			return Optional.ofNullable(null);
		}

		for (Conta conta : this.contas) {
			if (conta.getIdConta() == idConta) {
				return Optional.of(conta);
			}
		}
		return Optional.ofNullable(null);
	}

	private int getContaIndex(int idConta) {

		if (idConta < 0) {
			return -1;
		}

		for (int i = 0; i < this.contas.size(); i++) {
			if (this.contas.get(i).getIdConta() == idConta) {
				return i;
			}
		}

		return -1;
	}

	@Override
	public boolean atualizarConta(Conta contaAtualizar) {
		Optional<Conta> conta = this.getConta(contaAtualizar.getIdConta());

		if (conta.isPresent()) {
			int index = this.getContaIndex(conta.get().getIdConta());
			this.contas.set(index, contaAtualizar);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int idConta) {
		Optional<Conta> conta = this.getConta(idConta);

		if (conta.isPresent()) {
			int index = this.getContaIndex(idConta);
			this.contas.remove(index);
			return true;
		}
		return false;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
