package model;

import com.google.gson.annotations.SerializedName;

public class RespostaReq
{
	@SerializedName("status")
	String status;
	
	@SerializedName("info")
	Info info;
	
	
	public String getStatus()
	{
		return this.status;
	}
	
	public Info getInfo()
	{
		return this.info;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public void setInfo(Info info)
	{
		this.info = info;
	}
	
}
