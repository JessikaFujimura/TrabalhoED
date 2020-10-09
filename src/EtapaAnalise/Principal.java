package EtapaAnalise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import Base.Arquivos;
import Base.Fila;

public class Principal {

	public static void main(String[] args) {
	
		Fila<Candidato> inscritos = new Fila<Candidato>();
		int cont = 0;
		while(cont < 3){
			String nome = JOptionPane.showInputDialog("Digite o nome do candidato: ");
			double pontuacao = Double.parseDouble(JOptionPane.showInputDialog("Digite a pontuação do candidato "));
			Candidato candidato = new Candidato(nome , pontuacao);
			inscritos.enfileira(candidato);
			cont++;
		}
		
		
//		System.out.println(aprovados.desinfileira());
		
		Arquivos.gravar(inscritos);
		System.out.println("***********");
		System.out.println(Arquivos.ler());
		
	}
	
	
	

}
