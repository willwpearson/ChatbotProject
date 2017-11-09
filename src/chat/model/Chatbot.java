package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	// Declaration section.
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.currentTime = null;
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
		buildTopics();
		buildQuestions();
	}

	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildMovieList()
	{
//		movieList.add("Spiderman");
//		movieList.add("Hidden Figures");
//		movieList.add("Inception");
//		movieList.add("Interstellar");
//		movieList.add("Dunkirk");
//		movieList.add("The Prestige");
//		movieList.add("Logan");
//		movieList.add("Ex Machina");
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("protein");
		shoppingList.add("veggies");
		shoppingList.add("Cinnamon Toast Crunch");
		shoppingList.add("Dr. Pepper 12-pack");
		shoppingList.add("Gummy Bears");
		shoppingList.add("Protein Powder");
		shoppingList.add("Halloween Candy");
		shoppingList.add("Bacon");
		shoppingList.add("Eggs");
		shoppingList.add("Kit Kats");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
	}
	
	private void buildTopics()
	{
		topics[0] = "Math";
		topics[1] = "Science";
		topics[2] = "Quantum Physics";
		topics[3] = "Chinese Food";
		topics[4] = "Sushi";
		topics[5] = "Holidays";
		topics[6] = "Memes";
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What is your favorite color?";
		questions[2] = "What is the airspeed of a coconut laden swallow?";
		questions[3] = "Why are you the way that you are?";
		questions[4] = "How are you?";
		questions[5] = "What are you studying in school?";
		questions[6] = "What is your favorite pokemon?";
		questions[7] = "Who is your celebrity crush?";
		questions[8] = "Why?";
		questions[9] = "What is your favorite movie?";
				
	}
	/**
	 * The method takes in user input, and builds a response using that input and the method buildChatbotResponse().
	 * @param input The response the user gives as a String.
	 * @return The method returns a response from the input and the buildChatbotResponse() method.
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	/**
	 * The method uses random numbers, to select various words and topics from arrays to construct a question to ask the user.
	 * @return The method returns a string made of the randomly selected words.
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int) (Math.random() * 2);
				
		if (random % 2 == 0)
		{
			random = (int) (Math.random() * shoppingList.size());
			response += "\n" + shoppingList.get(random) + " is yummy!";
		}
		
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		// Checks to see if each input given is a valid input with a length over 2 characters long.
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		boolean validUser = false;
		
		if(input != null && input != "" && input.indexOf("@") <= 0 && input.indexOf("@") >= 0 && !input.contains("@" + "@"))
		{
			validUser = true;
		}
		
		return validUser;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		boolean validList = false;
		
		// Loops over every item in the list and determines whether it contains the proper items for that list.
		for(int index = 0; index < 11; index ++)
		{
			if (shoppingItem.contains(shoppingList.get(index)))
			{
				validList = true;
			}
		}
		
		return validList;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		boolean validQuit = false;
		
		// Checks to see if the input given is any form of quit, and if it is, the program will terminate.
		if (exitString!= "" && exitString != null && !exitString.equalsIgnoreCase("exit") && exitString.equalsIgnoreCase("quit"))
		{
			validQuit = true;
		}
		
		return validQuit;
	}

	public boolean keyboardMashChecker(String sample)
	{
		boolean validMash = false;
		
		if(sample.contains("sdf") || sample.contains("SDF") || sample.contains("dfg") || sample.contains("cvb") || sample.contains(",./") || sample.contains("kjh") || sample.contains("DFG") || sample.contains("CVB") || sample.contains("KJH"))
		{
			validMash = true;
		}
		else if (sample.contains("S.D.F.") || sample.contains("derf"))
		{
			validMash = false;
		}
		
		return validMash;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return intro;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
