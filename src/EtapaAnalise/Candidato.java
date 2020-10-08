package EtapaAnalise;

public class Candidato {
	String nome;
	int cod;
	double pontuacao;
	Candidato anterior;

	public Candidato(String nome, int cod, double pontuacao) {
		this.nome = nome;
		this.cod = cod;
		this.pontuacao = pontuacao;
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
