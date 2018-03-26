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
	
	/**
	 * Initializes the data members needed.
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String [10];
		this.username = username;
		this.content = "xD";
		this.intro = null;
		this.currentTime = LocalTime.now();
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildMovieList();
		buildShoppingList();
		buildCuteAnimals();
		buildTopics();
		buildQuestions();
		buildFollowUps();
	}

	/**
	 * Fills the verbs array.
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	/**
	 * Fills the movie array.
	 */
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
	
	/**
	 * Fills the shoppingList arrayList.
	 */
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
	
	/**
	 * Fills the cuteAnimalMemes arrayList.
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
	}
	
	/**
	 * Fills the topics array.
	 */
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
	
	/**
	 * Fills the questions array.
	 */
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
	
	private void buildFollowUps()
	{
		followUps[0] = " I like playing Fallout 4.";
		followUps[1] = " xD";
		followUps[2] = " I like watching Inception.";
		followUps[3] = " Dreams are cool.";
		followUps[4] = " Ducks are fun.";
	}
	/**
	 * The method takes in user input, and builds a response using that input and the method buildChatbotResponse().
	 * @param input The response the user gives as a String.
	 * @return The method returns a response from the input and the buildChatbotResponse() method.
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + " ";
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
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		return response;
	}
	
	/**
	 * Checks to see if each input is a valid input over 2 characters long.
	 * @param input The users text input.
	 * @return True if a valid input is given.
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null)
		{
			if (input.length() > 2)
			{
				validLength = true;
			}
		}
		
		return validLength;
	}
	
	/**
	 * Checks to see if the html is a valid tag
	 * @param input The users text input.
	 * @return True if a valid input is given.
	 */
	public boolean htmlTagChecker(String input)
	{
		input.toUpperCase();
		boolean validTag = false;
		if(input == null || !input.contains("<"))
		{
			return validTag;
		}
		if(input.equals("<>") || input.equals("< >"))
		{
			return validTag;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">", firstOpen);
		int secondOpen = input.indexOf("</", firstClose);
		int secondClose = input.indexOf(">", secondOpen);
		String tagText = "";
		if(input.substring(firstOpen, firstClose).contains(input.substring(secondOpen, secondClose)))
		{
			validTag = true;
			return validTag;
		}
		
		if(input.substring(firstOpen, firstClose).equals("P") || input.substring(firstOpen, firstClose).equals("BR"))
		{
			validTag = true;
			return validTag;
		}
		
		tagText = input.substring(firstOpen, firstClose);
		
		if(tagText.contains("A HREF"))
		{
			if (!tagText.contains("A HREF=") || !tagText.contains("A HREF ="))
			{
				validTag = false;
			}
		}
		return validTag;
	}
	
	/**
	 * Checks to see if a valid username is given.
	 * @param input The users text input.
	 * @return True if a valid input is given.
	 */
	public boolean userNameChecker(String input)
	{
		boolean validUser = false;
		
		if(input != null && input != "" && input.indexOf("@") <= 0 && input.indexOf("@") >= 0 && !input.contains("@" + "@"))
		{
			validUser = true;
		}
		
		return validUser;
	}
	
	/**
	 * Checks if there a special type of content in the input.
	 * @param contentCheck The users input.
	 * @return True if a valid input is given.
	 */
	public boolean contentChecker(String contentCheck)
	{
		boolean validContent = false;
		
		if(contentCheck.contains(content))
		{
			validContent = true;
		}
		
		return validContent;
	}
	
	/**
	 * Checks to see if the meme given is a valid Cute meme.
	 * @param input The users text input.
	 * @return True if a valid input is given.
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		boolean validCuteMeme = false;
		
		if(!input.equals("pepe") && input.equals("pupper") || input.equals("otter") || input.equals("kittie"))
		{
			validCuteMeme = true;
		}
		
		return validCuteMeme;
	}
	
	/**
	 * Checks to see if every item in the shopping list is valid.
	 * @param shoppingItem The item in the shopping list.
	 * @return True if every item in the shopping list is valid.
	 */
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
		boolean validTitle = false;
		
		for(int index = 0; index < movieList.size(); index++)
		{
			if(title != "" && movieList.contains(title))
			{
				validTitle = true;
			}
		}
		
		return validTitle;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		boolean validGenre = false;
		
		for(int index = 0; index < movieList.size(); index++)
		{
			if(genre != "" && movieList.contains(genre))
			{
				validGenre = true;
			}
		}
		
		return validGenre;
	}

	/**
	 * Checks to see if the input is a valid Quit statement.
	 * @param exitString The valid quit statement.
	 * @return True if the quit statement is valid.
	 */
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

	/**
	 * Checks to see if the keyboard has been mashed.
	 * @param sample The users input.
	 * @return True if the input is valid.
	 */
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
	
	public String toString()
	{
		String description = "";
		
		return description;
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
