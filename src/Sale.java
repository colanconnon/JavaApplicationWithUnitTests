import java.util.ArrayList;


public class Sale 
{
	ArrayList<Item> itemsarray;
	float total;
	float change;
	Inventory inventory;
	
	
	public Sale ()
	{
		itemsarray = new ArrayList<Item>();
		try 
		{
			inventory = new Inventory();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public ArrayList<Item> addItem(int itemnumber) throws Exception
	{
		Item item1 = inventory.getItem(itemnumber);
		itemsarray.add(item1);
		return itemsarray;
	}
	public ArrayList<Item> removeItem(Item item1)
	{
		for(int i=0; i<itemsarray.size(); i++)
		{
			if(item1.getitemnumber() == itemsarray.get(i).getitemnumber() && item1.getquanity() == (itemsarray.get(i).getquanity()))
			{
				itemsarray.remove(i);
			}
		}
		return itemsarray;
	}
	public ArrayList<Item> getItems()
	{
		return itemsarray;
	}
	public float calculateTotal()
	{
		total = 0;
		for(int i = 0; i<itemsarray.size(); i++)
		{
			total = total + itemsarray.get(i).getitemprice();
		}
		total = (float)(Math.round(total*100))/100;
		return total;
	}
	public float generateChange(float cashgiven)
	{
		change = cashgiven - total;
		change = (float)(Math.round(change*100))/100;
		
		return change;
	}
}
