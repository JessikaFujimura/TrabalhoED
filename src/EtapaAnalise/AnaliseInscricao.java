package EtapaAnalise;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Base.Arquivos;
import Base.Fila;


public class AnaliseInscricao extends JFrame {
	private JLabel nome, sobrenome, email, lattes;
	private JButton btAprovar, btReprovar;
	private JTextField tfNome, tfSobrenome, tfEmail, tfLattes;
	private static String[] conj;
	private static Fila<String> filaAnalise = new Fila<String>();
	
	public static void main(String[] args){
		try{
			BufferedReader buffer = new BufferedReader(new FileReader("C:/Users/Jéssika/Desktop/FATEC-ZL/FilaDeCandidatos"+".txt"));
			Object item = buffer.readLine();
			while(((String) item) != null){
				String s = (String) item;
				filaAnalise.enfileira(s);
				item = buffer.readLine();
			}
			buffer.close();
		} catch(IOException erro){
			erro.printStackTrace();
		} 
		chamaProximo();
	}
	
	public static void chamaProximo(){
		try{
			conj =  filaAnalise.topo().split(",");
			JFrame frame = new AnaliseInscricao();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		} catch (NullPointerException e){
			e.printStackTrace();
		}
		
	}
	
	
	public AnaliseInscricao(){
		inicializarComponentes();
		definirEventos();
	}
	
	public void inicializarComponentes(){
		setTitle("Candidato - " + conj[0]);
		setBounds(250,50,400,250);
		setBackground(new Color(150,150,150));
		nome = new JLabel("Nome");
		sobrenome = new JLabel("Sobrenome");
		email = new JLabel("Email");
		lattes = new JLabel("Curriculo lattes");
		btReprovar = new JButton("Reprovar");
		btAprovar = new JButton("Aprovar");
		tfNome = new JTextField(conj[2]);
		tfSobrenome = new JTextField(conj[3]);
		tfEmail = new JTextField(conj[4]);
		tfLattes = new JTextField(conj[5]);
		setLayout(null);
		nome.setBounds(10,15,60,20);
		sobrenome.setBounds(10,40,80,20);
		email.setBounds(10,90,100,20);
		lattes.setBounds(10,115,120,20);
		btReprovar.setBounds(80,160,100,20);
		btAprovar.setBounds(200,160,100,20);
		tfNome.setBounds(120,15,200,20);
		tfNome.setEditable(false);
		tfSobrenome.setBounds(120,40,200,20);
		tfSobrenome.setEditable(false);
		tfEmail.setBounds(120,90,200,20);
		tfEmail.setEditable(false);
		tfLattes.setBounds(120,115,200,20);
		tfLattes.setEditable(false);
		add(nome);
		add(sobrenome);
		add(email);
		add(lattes);
		add(btAprovar);
		add(btReprovar);
		add(tfNome);
		add(tfSobrenome);
		add(tfEmail);
		add(tfLattes);
	}

	
	public void definirEventos(){
		btReprovar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				filaAnalise.desinfileira();
				dispose();
				chamaProximo();
			}
		});
		
		btAprovar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = Arquivos.criarDir();
				Arquivos.gravar(filaAnalise.desinfileira(),path);
				dispose();
				chamaProximo();
			}
			
		});
	}



}
