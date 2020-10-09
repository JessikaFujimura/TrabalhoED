package EtapaAnalise;

public class Candidato {
	String nome;
	static int cod;
	double pontuacao;
	Candidato anterior;

	public Candidato(String nome, double pontuacao) {
		this.nome = nome;
		this.pontuacao = pontuacao;
		cod++;
	}

	public Candidato getAnterior() {
		return anterior;
	}

	public void setAnterior(Candidato anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		return "Candidato: " + cod + " - " + nome + " - pontuação: " + pontuacao;
	}
}
