package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	/**
	 * Initializes all the data members needed.
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Oshabot");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	/**
	 * Builds the program.
	 */
	public void start()
	{
		String response = display.collectResponse("What do you want to talk about?");
		
		// Loops the responses over and over until an invalid response or quit is given.
//		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//		{
//			response = popupChat(response);
//			response = display.collectResponse(response);
//		}
	}
	
	/**
	 * Gives the chatbot response from the chatbot method processController.
	 * @param chat The input from the user from processConversation
	 * @return The string the chatbot displays.
	 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
}
