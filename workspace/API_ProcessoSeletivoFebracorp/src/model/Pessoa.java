package model;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import httpClient.ClienteHttp;
import com.google.gson.Gson;

public class Pessoa implements Comparable<Pessoa>
{
	private String nome;
	
	private String primeiroNome;
	private String sobrenome;
	private String email;
	private Cargo cargo;
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
		
	}
	
	public void carregarInfo()
	{
		ClienteHttp cliente = new ClienteHttp();
		StringBuilder strPath = new StringBuilder();
		
		Map<String,String> map = new HashMap<String, String>();
		
		map.put("nome", getPrimeiroNome());
		map.put("sobrenome", String.valueOf(getSobrenome().charAt(0)));
		
		String resposta = cliente.enviarRequisicaoGet("http://104.40.16.83:51","/", map);
		
		RespostaReq resp = new Gson().fromJson(resposta, RespostaReq.class);
		
		if(resp.getStatus().equals("ok"))
		{
			this.email = resp.getInfo().getEmail();
			this.cargo = new Cargo(resp.getInfo().retornaSegundoCampoCargo(), resp.getInfo().retornaPrimeiroCampoCargo());
		}
		
	}
	
	public String getEmail()
	{
		if(email == null)
		{
			carregarInfo();
		}
		
		return this.email;
	}
	
	public Cargo getCargo()
	{
		if(cargo == null)
		{
			carregarInfo();
		}
		
		return this.cargo;
	}
	
	public String getPrimeiroNome()
	{
		if(this.primeiroNome == null)
		{
			StringTokenizer strTok = new StringTokenizer(this.nome, " ");
			
			if(strTok.hasMoreTokens())
			{
				this.primeiroNome = strTok.nextToken();
			}
			
			strTok = null;
		}
		
		return this.primeiroNome;
	}
	
	public String getSobrenome()
	{
		if(this.sobrenome == null)
		{
			StringTokenizer strTok = new StringTokenizer(this.nome, " ");
			StringBuilder strAux = new StringBuilder();
					
			boolean primeiro = true;
			
			while(strTok.hasMoreTokens())
			{
				if(primeiro)
				{
					strTok.nextToken();
					primeiro = false;
					continue;
				}
				
				strAux.append(strTok.nextToken());
				strAux.append(" ");
				
			}
			
			this.sobrenome = strAux.toString();
			strAux = null;
			strTok = null;
		}
		
		return this.sobrenome;
	}
	
	public String toString()
	{
		return "nome: " + this.getPrimeiroNome() + " | Sobrenome: " + this.getSobrenome() + " | Email: " + this.getEmail() + "| Cargo: " + this.getCargo().getCargo();
	}
	
	public String retornaNomeFormatado()
	{
		StringBuilder strAux = new StringBuilder();
		
		strAux.append(getPrimeiroNome());
		strAux.append(" ");
		strAux.append(getSobrenome().charAt(0));
		
		return strAux.toString();
	}

	@Override
	public int compareTo(Pessoa o)
	{
		return this.getCargo().compareTo(o.getCargo());
	}
}
