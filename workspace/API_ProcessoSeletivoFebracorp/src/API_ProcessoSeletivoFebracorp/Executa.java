package API_ProcessoSeletivoFebracorp;

import java.util.Collections;

import javax.swing.JOptionPane;

import model.*;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Executa
{
	public static void main(String[] args)
	{
		System.out.println("CARREGANDO...");
		Pessoas pessoas = new Pessoas();
		
		pessoas.carregarDados();
		
		Collections.sort(pessoas.getPessoas());
		
		StringBuilder strHtml = new StringBuilder();
		
		strHtml.append("<html>");
		strHtml.append("<head>");
		strHtml.append("<link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>");
		strHtml.append("<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>");
		strHtml.append("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		strHtml.append("</head>");
		strHtml.append("<body class='w3-light-grey'>");
		
		strHtml.append("<div class='w3-container'>");
		
		for(int i = 0; i < pessoas.getPessoas().size(); i++)
		{
			Pessoa pessoa = pessoas.getPessoas().get(i);
			
			if(i == 0)
			{
				strHtml.append(tituloTabela(pessoa.getCargo().toString()));
				
				strHtml.append(cabecalhoTabela());
			}
			else if(!pessoa.getCargo().equals(pessoas.getPessoas().get(i - 1).getCargo()))
			{
				strHtml.append("</table>");
				
				strHtml.append(tituloTabela(pessoa.getCargo().toString()));
				
				strHtml.append(cabecalhoTabela());
				
			}
			
			
			strHtml.append(linhaTabela(pessoa));
			
			System.out.println(pessoa);
		}
		
		strHtml.append("</div>");
		strHtml.append("</body>");
		strHtml.append("</html>");
		
		try
		{
			FileWriter writer = new FileWriter(new File("teste.html"));
			writer.write(strHtml.toString());
			writer.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		File htm = new File("teste.html");
        
        try{
        
            Desktop.getDesktop().open(htm);
        
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	JOptionPane.showMessageDialog(null,"Falha no Arquivo");
        
        }
		
        
	}
	
	public static String tituloTabela(String titulo)
	{
		StringBuilder strHtml = new StringBuilder();
		
		strHtml.append("<h3>");
		strHtml.append(titulo);
		strHtml.append("</h3>");
		
		return strHtml.toString();
	}
	
	public static String linhaTabela(Pessoa p)
	{
		StringBuilder strHtml = new StringBuilder();
		
		strHtml.append("<tr class='w3-grey'>");
		strHtml.append("<td>");
		strHtml.append(p.getPrimeiroNome());
		strHtml.append("</td>");
		strHtml.append("<td>");
		strHtml.append(p.getSobrenome());
		strHtml.append("</td>");
		strHtml.append("<td>");
		strHtml.append(p.getEmail());
		strHtml.append("</td>");
		strHtml.append("<td>");
		strHtml.append(p.getCargo().getCargo());
		strHtml.append("</td>");
		strHtml.append("</tr>");
		
		return strHtml.toString();
	}
	
	public static String cabecalhoTabela()
	{
		StringBuilder strHtml = new StringBuilder();
		
		strHtml.append("<table class='w3-table w3-light-gray'>");
		strHtml.append("<tr>");
		strHtml.append("<td>");
		strHtml.append("NOME");
		strHtml.append("</td>");
		strHtml.append("<td>");
		strHtml.append("SOBRENOME");
		strHtml.append("</td>");
		strHtml.append("<td>");
		strHtml.append("EMAIL");
		strHtml.append("</td>");
		strHtml.append("<td>");
		strHtml.append("CARGO");
		strHtml.append("</td>");
		strHtml.append("</tr>");
		
		return strHtml.toString();
	}
}
