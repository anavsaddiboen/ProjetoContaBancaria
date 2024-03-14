package conta.controller;

import java.util.List;
import java.util.Optional;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController {

	private ContaRepository contaRepository;

	public ContaController(ContaRepository contaRepository) {
		this.setContaRepository(contaRepository);
	}

	public Optional<Conta> procurarPorNumero(int numero) {
		return this.contaRepository.getConta(numero);
	}

	public List<Conta> listarTodas() {
		return contaRepository.getAllContas();
	}

	public boolean cadastrar(Conta conta) {
		return this.contaRepository.salvaConta(conta);
	}

	public boolean atualizar(Conta conta) {
		return this.contaRepository.atualizarConta(conta);
	}

	public boolean deletar(int numero) {
		return this.contaRepository.delete(numero);
	}

	public boolean sacar(int numero, float valor) {
		Optional<Conta> conta = this.contaRepository.getConta(numero);
		if (conta.isPresent()) {
			conta.get().sacar(valor);
			return true;
		}
		return false;
	}

	public boolean depositar(int numero, float valor) {
		Optional<Conta> conta = this.contaRepository.getConta(numero);
		if (conta.isPresent()) {
			conta.get().depositar(valor);
			return true;
		}
		return false;
	}

	public boolean transferir(int numeroOrigem, int numeroDestino, float valor) {
		Optional<Conta> contaOrigem = this.contaRepository.getConta(numeroOrigem);
		Optional<Conta> contaDestino = this.contaRepository.getConta(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			contaOrigem.get().sacar(valor);
			contaDestino.get().depositar(valor);
			return true;
		}

		return false;
	}

	public ContaRepository getContaRepository() {
		return contaRepository;
	}

	public void setContaRepository(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
}
