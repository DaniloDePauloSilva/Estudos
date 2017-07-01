package httpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import com.google.gson.Gson;

import model.Pessoas;


public class ClienteHttp
{

	public String enviarRequisicaoGet(String strTarget, String strPath, Map<String, String> params)
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(strTarget);
		
		if(params != null)
		{	
			for(String param : params.keySet())
			{
				target = target.queryParam(param, params.get(param));
			}
		}
		
		String conteudoRetorno = target.path(strPath).request().get(String.class);
		
		
		return conteudoRetorno;
	}
	
}
