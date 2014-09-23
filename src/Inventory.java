import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Inventory 
{
	ArrayList <Item> inventorylist;
	public Inventory() throws Exception
	{
		inventorylist = new ArrayList<Item>();
		readItem();
	}
	private void readItem() throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader("inventory.txt"));
		String[] holder;
		int itemnumber;
		String itemname;
		float itemprice;
		int quanity;
		String line = br.readLine();
		while(line != null)
		{
			line = br.readLine();
			if(line == null)
			{
				break;
			}
			else
			{
				holder = line.split(",");
				itemnumber = Integer.parseInt(holder[0]);
				itemname = holder[1];
				itemprice = Float.parseFloat(holder[2]);
				quanity = Integer.parseInt(holder[3]);
				Item item1 = new Item(itemnumber , itemname , itemprice , quanity);
				inventorylist.add(item1);
			}
		}
		br.close();
	}
	public Item getItem(int itemnumber) throws Exception
	{
		for(int i = 0; i < inventorylist.size(); i++)
		{
			if(inventorylist.get(i).getitemnumber() == itemnumber)
			{
				Item returnitem = inventorylist.get(i);
				inventorylist.get(i).setitemquanity(inventorylist.get(i).getquanity() - 1 );
				returnitem.setitemquanity(1);
				
				save();
				return returnitem;
			}
		}
		return null;
	}
	public void save() throws Exception
	{
		PrintWriter out = new PrintWriter(new FileWriter("inventory.txt"));
		out.println("itemnumber"+","+"itemname"+","+"price"+","+"quanity");
		for (Item d: inventorylist)
		{
			int itemnumber = d.getitemnumber();
			double price = d.getitemprice();
			String itemname = d.getItemname();
			int quanity = d.getquanity();
			out.println(itemnumber + "," + itemname + "," + price + "," + quanity);
			
		}
		out.close();
	}
}
