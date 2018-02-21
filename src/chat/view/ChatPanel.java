package chat.view;

import javax.swing.*;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author William Pearson
 *
 */
public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	
	/**
	 * Initializes the data members needed.
	 * @param appController The controller for the chatbot.
	 */
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		chatButton = new JButton("Chat", new ImageIcon(getClass().getResource("/chat/view/images/Chat Image.png")));
		searchButton = new JButton("Search", new ImageIcon(getClass().getResource("/chat/view/images/Search Image.png")));
		saveButton = new JButton("Save", new ImageIcon(getClass().getResource("/chat/view/images/Save Image.png")));
		loadButton = new JButton("Load", new ImageIcon(getClass().getResource("/chat/view/images/Load Image.png")));
		tweetButton = new JButton("Tweet", new ImageIcon(getClass().getResource("/chat/view/images/Tweet Image.png")));
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		infoLabel = new JLabel("Type to chat with Oshabot.");
		appLayout = new SpringLayout();
		chatScrollPane = new JScrollPane();
		checkerButton = new JButton("Check");
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	/**
	 * Sets up the panel with the proper parameters and contents.
	 */
	private void setupPanel()
	{
		this.setBackground(new Color(0, 102, 102));
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(searchButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(tweetButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(checkerButton);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	
	/**
	 * Sets up the layout for each of the content pieces in the panel.
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 35, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, 5, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, infoLabel, -135, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, 0, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, searchButton, 304, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.NORTH, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 0, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, 0, SpringLayout.NORTH, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 98, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 25, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, 0, SpringLayout.SOUTH, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 0, SpringLayout.WEST, searchButton);
		appLayout.putConstraint(SpringLayout.SOUTH, tweetButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, 0, SpringLayout.EAST, searchButton);
	}
	
	/**
	 * Sets up the listeners for actions with the objects in the panel.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
	}
}
