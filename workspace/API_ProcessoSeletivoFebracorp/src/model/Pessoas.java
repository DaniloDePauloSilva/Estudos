package model;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import httpClient.ClienteHttp;

public class Pessoas
{
	@SerializedName("pessoas")
	List<Pessoa> pessoas;
	
	private ClienteHttp cliente = new ClienteHttp();
	
	public void carregarDados()
	{
		Gson gson = new Gson();
		
		String conteudoRetorno = cliente.enviarRequisicaoGet("http://104.40.16.83:50", "/", null);
		
		Pessoas p = gson.fromJson(conteudoRetorno, Pessoas.class);
		
		this.pessoas = p.pessoas;
	}
	
	public List<Pessoa> getPessoas()
	{
		return this.pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas)
	{
		this.pessoas = pessoas;
	}
	
	public String toString()
	{
		StringBuilder strRetorno = new StringBuilder();
		
		for(Pessoa p : pessoas)
		{
			strRetorno.append(p);
			strRetorno.append(" | ");
		}
		
		return strRetorno.toString();
	}
}
