package Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import EtapaAnalise.Candidato;

public class Arquivos {
	
	public static String criarDir(){
		String path = JOptionPane.showInputDialog("Digite o caminho do diretório");
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdir();
		}
		String nomeDoArquivo = JOptionPane.showInputDialog("Digite o nome do arquivo");
		return path + "/" + nomeDoArquivo;
	}
	
	public static void gravar(Object estrutura, String path){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter(path +".txt", true));
			pw.println(estrutura);
			pw.flush();
			pw.close();
			JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
		} catch(IOException erro){
			erro.printStackTrace();
		}
	}
	
	
	public static Object ler(){
		try{
			String path = criarDir();
			BufferedReader buffer = new BufferedReader(new FileReader(path+".txt"));
			Object item = buffer.readLine();
			buffer.reset();
			buffer.close();
			return item;
		} catch(IOException erro){
			erro.printStackTrace();
		}
		return null;
	}
	
	public static Object ler(String path){
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(path+".txt"));
			Object item = buffer.readLine();
			buffer.close();
			return item;
		} catch(IOException erro){
			erro.printStackTrace();
		}
		return "";
	}
	

}
