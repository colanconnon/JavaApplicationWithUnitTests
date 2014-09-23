
public class Item 
{
	
	int itemnumber;
	String Itemname;
	float itemprice;
	int quanity;
	
	
	public Item(int itemnumber , String Itemname, float itemprice, int quanity)
	{
		this.itemnumber = itemnumber;
		this.Itemname = Itemname;
		this.itemprice = itemprice;
		this.quanity = quanity;
	}
	
	public int getitemnumber()
	{
		return itemnumber;
	}
	public String getItemname()
	{
		return Itemname;
	}
	
	public float getitemprice()
	{
		return itemprice;
	}
	public int getquanity()
	{
		return quanity;
	}
	public void setitemnumber(int Itemnumber)
	{
		this.itemnumber = Itemnumber;
	}
	public void setItemname(String Itemname)
	{
		this.Itemname = Itemname;
	}

	public void setitemprice(float itemprice)
	{
		this.itemprice = itemprice;
	}
	public void setitemquanity(int quanity)
	{
		this.quanity = quanity;
	}
	public void printall()
	{
		System.out.println(itemnumber+"  " +Itemname+" " +itemprice+" "+ quanity);
	}

}
