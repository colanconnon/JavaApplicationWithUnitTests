import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
public class InventoryTest extends TestCase
{
	/*
	 * Test cases by Colan Connon
	 * These are testing four components of my System
	 * Added on 4/21/2014
	 * 
	 * 
	 * 
	 */
	Inventory inventory;
	
	
	/*
	 * 
	 * ID: Test 1
		Brief Description: Make sure that The ReadItem function reading the file correctly.
		Test Steps: Pass an item number into the ReadItem function, and make sure that function is return the correct item from the file.
		Pre Conditions: The file must be populated with data, that can be read, and that item number that you are trying to read is in the file.
		Post conditions: The item is being returned so other parts of the systems can call that function and retrieve items.
		Status: Pass
	 */
	public void testIO() throws Exception
	{
		inventory = new Inventory();
		Item item = new Item(100,"gas",(float) 2.99,-72);
		//Testing to see if the inventory is getting the right items from the file
		assertEquals("Must return a ArrayList of Items", item.getItemname() , inventory.getItem(100).getItemname());
	}
	/*
	 * ID: Test2
Brief Description:  Testing the sales total function properly returning the correct total of the sale.
Test Steps: Add a few items to a sale object and then call the function calculateTotal and make that it is return the correct value
Pre Conditions: There must be items in the sale object for the function to add up
Post conditions: The total is being returned so it can be used in other parts of the system.
Status: Pass

	 */
	public void testSaletotal() throws Exception 
	{
		
		Sale sale = new Sale();
		sale.addItem(100);
		sale.addItem(200);
		sale.addItem(300);
		inventory = new Inventory();
		Item item = inventory.getItem(100);
		//2.99 + 2.99 +3.99 must equal 9.97 
		assertEquals("Must be equal price", (float) 9.97 , sale.calculateTotal() );
	}
	/*]
	 * ID: Test3
Brief Description:  Test to make sure the generateChange function is returning the proper amount.
Test Steps: Provide the function with a float argument and then provide the total variable with another value and make sure the output is correct.
Pre condition: make sure the total variable has a value;
Post-condition:  return the change value for other parts of the system to use.
Status: pass

	 */
	public void testSalegeneratechange() throws Exception
	{
		Sale sale = new Sale();
		sale.total = (float) 10.53;
		//must generate a float with value of 4.47
		assertEquals("15 - 10.53 must equal 4.47", (float) 4.47, sale.generateChange(15));
		
	}
	/*
	 * ID: Test4
Brief Description: Testing to make sure the add Item function in the sale object correctly adds an item to the array list.
Test Steps: Add an item and then see if the array list has an item in it.
Pre Conditions: Make sure there is an Item in the data file to retrieve and add to the sale object. The sale object must also be constructed.
Post Conditions: The Sale object’s array list that holds the cart must have another item in it.
Status: pass

	 */
	public void testSaleadditem() throws Exception
	{
		inventory = new Inventory();
		Sale sale = new Sale();
		//testing to see if sale.addItem is equal to sale.getItem() if these weren't equal this would be a bug
		assertEquals(sale.addItem(100).equals(sale.getItems()), true);
	}
	
	

}
