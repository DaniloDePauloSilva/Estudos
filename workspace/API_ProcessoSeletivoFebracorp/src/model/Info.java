package model;

import com.google.gson.annotations.SerializedName;

public class Info
{
	@SerializedName("email")
	String email;
	
	@SerializedName("cargo")
	String cargo;
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getCargo()
	{
		return this.cargo;
	}
	
	public String retornaSegundoCampoCargo()
	{
		return cargo.split("\\|")[1].trim();
	}
	
	public String retornaPrimeiroCampoCargo()
	{
		return cargo.split("\\|")[0].trim();
	}
}
