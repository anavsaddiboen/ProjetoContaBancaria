package conta.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Cores {
	
	public static final String ANSI_RESET = "\u001B[0m";

	private List<Color> listaDeCores;

	public Cores() {
		this.listaDeCores = new ArrayList<>();
	}

	public void adicionarCor(Color cor) {
		listaDeCores.add(cor);
	}

	public List<Color> getListaCores() {
		return listaDeCores;
	}

}