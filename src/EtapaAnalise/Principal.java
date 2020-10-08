package EtapaAnalise;

import javax.swing.JOptionPane;

import Base.Fila;

public class Principal {

	public static void main(String[] args) {
	
		Fila<Candidato> aprovados = new Fila<Candidato>();
		String nome = JOptionPane.showInputDialog("Nome");

		Candidato cand1 = new Candidato("Fulano", 1, 10);
		Candidato cand2 = new Candidato("Ciclano", 2, 30);
		Candidato cand3 = new Candidato("Beltrano", 10, 40);
		Candidato cand4 = new Candidato("Dilano", 20, 20);

		aprovados.enfileira(cand1);

		System.out.println(aprovados.desinfileira());

	}

}
