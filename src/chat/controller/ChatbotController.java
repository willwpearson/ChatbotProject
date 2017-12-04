package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

public class ChatbotController
{
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame chatFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Oshabot");
		display = new PopupDisplay();
		chatFrame = new ChatFrame(this);
	}
	public void start()
	{
		display.displayText("Hello.");
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "That is a cute meme.\n";
		}
		if(chatbot.userNameChecker(text))
		{
			response += ("Welcome, " + text + "\n");
		}
		if(chatbot.shoppingListChecker(text))
		{
			response += "I shop for that too.\n";
		}
		if(chatbot.movieTitleChecker(text))
		{
			response += "I love that movie\n";
		}
		if(chatbot.movieGenreChecker(text))
		{
			response += "That is an interesting genre of movie\n";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "a;sdlkfj;alskdjf;laksjdf;lkaj\n";
		}
		
		return response;
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
	}
	
	private void close()
	{
		display.displayText("goodbye");
		System.exit(0);
	}
}
