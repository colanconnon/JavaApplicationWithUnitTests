import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class projectView extends JFrame 
{
	JTextPane itemdisplay;
	JTextField itemnumber; 
	JLabel total;
	JLabel displaytotal;
	JLabel displayitemprice;
	JButton calculate;
	JButton viewinventory;
	JButton save;
	JTextField cashtendered;
	JLabel change;
	JButton calculatechange;
	public projectView()
	{
		super("Store Program");
		makegui();
		
	}
	public void registerListeners(projectController controller)
	{ 
		calculate.addActionListener((ActionListener) controller);
		calculatechange.addActionListener((ActionListener) controller);
	}
	
	public void makegui()
	{
	   
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Font f = new Font("Serif",Font.PLAIN,10);
		JPanel panel1 = new JPanel();
		itemdisplay = new JTextPane();
		panel1.setLayout(new GridLayout(0,1));
		panel1.setBackground(Color.black);
		itemdisplay.setFont(new Font("Monspace",Font.PLAIN, 25));
		StyledDocument mydoc =itemdisplay.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		mydoc.setParagraphAttributes(0, mydoc.getLength(),center,false);
		itemdisplay.setEditable(false);
		itemdisplay.setForeground(Color.WHITE);
		itemdisplay.setBackground(Color.BLACK);
		JScrollPane scroll = new JScrollPane(itemdisplay);
		panel1.add(scroll);
	
	
		
		
		
		JPanel panel2 = new JPanel();
		itemnumber = new JTextField("Enter Item Number");
		displayitemprice = new JLabel("Price:");
		calculate = new JButton("calculate");
		panel2.setLayout(new GridLayout(0,3));
		panel2.add(itemnumber);
		panel2.add(displayitemprice);
		panel2.add(calculate);
		itemnumber.setBorder(blackline);
		displayitemprice.setBorder(blackline);
		calculate.setBackground(Color.white);
		itemnumber.setBackground(Color.white);
		displayitemprice.setBackground(Color.white);
		displayitemprice.setOpaque(true);
		
		
		
		
		JPanel panel3 = new JPanel();
		total = new JLabel("TOTAL");
		displaytotal = new JLabel("0.00");
		panel3.setLayout(new GridLayout(2,0));
		panel3.add(total);
		panel3.add(displaytotal);
		total.setBorder(blackline);
		displaytotal.setBorder(blackline);
		total.setBackground(Color.white);
		displaytotal.setBackground(Color.white);
		total.setOpaque(true);
		displaytotal.setOpaque(true);
		
		
		JPanel panel4 = new JPanel();
		
		cashtendered =new JTextField("0.00");
		change = new JLabel("Change:");
		calculatechange = new JButton("Calculate Change");
		calculatechange.setPreferredSize(new Dimension(40,40));
		calculatechange.setBackground(Color.WHITE);
		change.setBorder(blackline);
		change.setBackground(Color.WHITE);
		change.setOpaque(true);
		panel4.setLayout(new GridLayout(3,0));
		panel4.add(cashtendered);
		panel4.add(change);
		panel4.add(calculatechange);
		
		
		
		
		Container mainPanel = this.getContentPane();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(panel1, BorderLayout.CENTER);
		mainPanel.add(panel2, BorderLayout.SOUTH);
		mainPanel.add(panel3, BorderLayout.WEST);
		mainPanel.add(panel4, BorderLayout.EAST);
		
	
	}
	public void displayitemcart(Item item)
	{
		itemdisplay.setText(itemdisplay.getText() +"\n"+item.getitemnumber()+"  "+"  "+item.getItemname()+"  "+item.getitemprice());
	}
	public void resetscreen()
	{
		itemdisplay.setText(null);
		setTotal(0);
	}
	public void setTotal(float price1)
	{
		String totalText = Float.toString(price1);
		displaytotal.setText(totalText);
	}
	public void editLabelPrice(float price)
	{
		String priceText = Float.toString(price);
		displayitemprice.setText(priceText);
	}
	public void setchangeText(String change3)
	{
		change.setText(change3);
	}

}
