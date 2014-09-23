import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class projectController implements ActionListener
{
	projectView view;
	Sale sale;
	int i;
	ArrayList<Item> cart;
	public projectController(projectView view)
	{
		this.view = view;
		sale = new Sale();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == view.calculate)
		{
			String itemNumber = view.itemnumber.getText();
			int itemnumber1 = Integer.parseInt(itemNumber);
			try 
			{
				cart = sale.addItem(itemnumber1);
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			view.displayitemcart(cart.get(i));
			i++;
			view.setTotal(sale.calculateTotal());
		}
		else if(e.getSource()== view.calculatechange)
		{
			float change1 = sale.generateChange(Float.parseFloat(view.cashtendered.getText()));
			view.setchangeText(Float.toString(change1));
			sale = new Sale();
			i = 0;
			cart.clear();
			view.resetscreen();
		}
		
	}
}
