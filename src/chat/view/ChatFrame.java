package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatbotController appController;
	private ChatPanel appPane;
	
	public ChatFrame(ChatbotController appController)
	{
		super();
		this.appController = appController;
		appPane = new ChatPanel(appController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPane);
		this.setTitle("Chatting with Oshabot");
		this.setResizable(false);
		this.setSize(600, 600);
		this.setVisible(true);
	}
}
