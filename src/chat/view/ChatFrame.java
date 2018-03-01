package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPanel;
	
	/**
	 * Initializes the data members needed.
	 * @param appController The controller for the Chatbot.
	 */
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ChatPanel(appController);
		setupFrame();
	}
	
	/**
	 * Sets the frame up with the proper parameters.
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Chatting with Oshabot");
		this.setResizable(false);
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	public ChatbotController getAppController()
	{
		return appController;
	}
}
