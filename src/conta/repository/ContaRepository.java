package conta.repository;

import java.util.List;
import java.util.Optional;

import conta.model.Conta;

public interface ContaRepository {

	public boolean salvaConta(Conta conta);

	public List<Conta> getAllContas();

	public Optional<Conta> getConta(int idConta);

	public boolean atualizarConta(Conta conta);

	public boolean delete(int idConta);

}
