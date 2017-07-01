package model;

public class Cargo implements Comparable<Cargo>
{
	String area;
	String cargo;
	
	public Cargo(String area, String cargo)
	{
		this.area = area;
		this.cargo = cargo;
	}
	
	public String getArea()
	{
		return area;
	}
	
	public String getCargo()
	{
		return cargo;
	}
	
	public String toString()
	{
		return area;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj.getClass() != this.getClass())
			return false;
		
		Cargo cargoObj = (Cargo)obj;
		
		if(!cargoObj.area.equals(this.area))
		{
			return false;
		}
		
		return true;
	}

	@Override
	public int compareTo(Cargo obj)
	{
		return this.area.compareTo(obj.area);
	}
	
	
}
