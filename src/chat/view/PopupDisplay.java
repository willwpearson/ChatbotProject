package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class PopupDisplay
{
	private ImageIcon icon;
	private String windowTitle;
	
	/**
	 * Initializes the data members needed.
	 */
	public PopupDisplay()
	{
		icon = new ImageIcon(getClass().getResource("images/Oshabot.png"));
		windowTitle = "Oshabot says";
	}
	
	/**
	 * Displays a popup with text.
	 * @param message The text to be displayed.
	 */
	public void displayText(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowTitle, JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	/**
	 * Displays a popup with a question.
	 * @param question The question to be displayed.
	 * @return The answer from the user.
	 */
	public String collectResponse(String question)
	{
		String answer = "";
				
		answer +=JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
	}
}
