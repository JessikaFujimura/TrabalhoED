package EtapaAnalise;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Base.Arquivos;
import Base.Fila;


public class Inscricao extends JFrame {
	private JLabel nome, sobrenome, email, lattes, tipo;
	private JButton btInserir, btLimpar, btAnexos, btGravar;
	private JTextField tfNome, tfSobrenome, tfEmail, tfLattes, tfAnexos;
	private JComboBox tfTipo;
	private FileDialog fdanexos;
	private String[] opcoes = {"normal", "especial"};
	private String arquivo = "";
	private Fila<Candidato> fila;
	private static int i;
	
	
	public static void main(String[] args){
		JFrame frame = new Inscricao();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public Inscricao(){
		inicializarComponentes();
		definirEventos();
	}
	
	public void inicializarComponentes(){
		setTitle("Inscrição no processo seletivo");
		setBounds(500,200,350,320);
		setBackground(new Color(150,150,150));
		nome = new JLabel("Nome");
		sobrenome = new JLabel("Sobrenome");
		tipo = new JLabel("Tipo de inscr.");
		email = new JLabel("Email");
		lattes = new JLabel("Curriculo lattes");
		btAnexos = new JButton("Anexos");
		btInserir = new JButton("Inserir");
		btLimpar = new JButton("Limpar");
		btGravar = new JButton("Salvar");
		tfNome = new JTextField();
		tfSobrenome = new JTextField();
		tfEmail = new JTextField();
		tfLattes = new JTextField();
		tfTipo = new JComboBox(opcoes);
		tfAnexos = new JTextField();
		fdanexos = new FileDialog(this,"Anexar", FileDialog.LOAD);
		setLayout(null);
		nome.setBounds(10,15,60,20);
		sobrenome.setBounds(10,40,80,20);
		tipo.setBounds(10,65,80,20);
		email.setBounds(10,90,100,20);
		lattes.setBounds(10,115,120,20);
		tfAnexos.setBounds(10,170,300,20);
		tfAnexos.setEditable(false);
		btAnexos.setBounds(10,140,100,20);
		btInserir.setBounds(220,200,100,20);
		btLimpar.setBounds(100,200,100,20);
		btGravar.setBounds(220,240,100,20);
		tfNome.setBounds(120,15,200,20);
		tfSobrenome.setBounds(120,40,200,20);
		tfTipo.setBounds(120,65,200,20);
		tfEmail.setBounds(120,90,200,20);
		tfLattes.setBounds(120,115,200,20);
		add(nome);
		add(sobrenome);
		add(tipo);
		add(email);
		add(lattes);
		add(btAnexos);
		add(tfAnexos);
		add(btInserir);
		add(btGravar);
		add(btLimpar);
		add(tfNome);
		add(tfSobrenome);
		add(tfEmail);
		add(tfLattes);
		add(tfTipo);
		fila = new Fila<Candidato>();
	}
	
	public void definirEventos(){
		btLimpar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tfNome.setText("");
				tfSobrenome.setText("");
				tfEmail.setText("");
				tfLattes.setText("");
				tfAnexos.setText("");
			}
		});
		
		btInserir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Candidato candidato = new Candidato(i++);
				candidato.setNome(tfNome.getText());
				candidato.setSobrenome(tfSobrenome.getText());
				candidato.setEmail(tfEmail.getText());
				candidato.setLattes(tfLattes.getText());
				candidato.setTipo(tfTipo.getActionCommand());
				candidato.setAnexos(tfAnexos.getText());
				fila.enfileira(candidato);
				tfNome.setText("");
				tfSobrenome.setText("");
				tfEmail.setText("");
				tfLattes.setText("");
				tfAnexos.setText("");
			}
		});
		
		btAnexos.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				fdanexos.setVisible(true);
				arquivo += fdanexos.getFile();
				tfAnexos.setText(arquivo);
			}
		});
		
		btGravar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String path = Arquivos.criarDir();
				Arquivos.gravar(fila,path);
			}
			
		});
	}
	
}
