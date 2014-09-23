import javax.swing.JFrame;


public class mainClass 
{
	public static void main(String[] args)
	{
		projectView view = new projectView();
		projectController controller = new projectController(view);
		
		view.registerListeners(controller);
		view.setSize(500,500);
		view.setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
