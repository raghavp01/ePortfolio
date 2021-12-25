package ePortfolio;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class that has main
 */
public class Assignment3GUI extends JFrame implements ActionListener 
{
	ePortfolio objPortfolio;
	JMenu commands;
	JMenuItem Buy;
	JMenuItem Sell;
	JMenuItem Update;
	JMenuItem GetGain;
	JMenuItem Search;
	JMenuItem Quit;
	int num = 0;

	/**
	 * constructor
	 */
	public Assignment3GUI () 
	{
		objPortfolio = new ePortfolio ();
	}

	/**
	 * Displays the home and has the menu (called by main)
	 */
	public void displayGUI () 
	{
		

		JMenuBar menuBar;
		menuBar = new JMenuBar ();
		menuBar.setPreferredSize(new Dimension(10,32));
		commands = new JMenu ( "Commands" );
		commands.setFont ( new Font ( "sans serif", Font.BOLD, 15 ) );
		Buy = new JMenuItem ( "Buy" );
		Buy.setFont ( new Font ( "sans serif", Font.BOLD, 15 ) );
		Sell = new JMenuItem ( "Sell" );
		Sell.setFont ( new Font ( "sans serif", Font.BOLD, 15 ) );
		Update = new JMenuItem ( "Update" );
		Update.setFont ( new Font ( "sans serif", Font.BOLD, 15 ) );
		GetGain = new JMenuItem ( "Get Gain" );
		GetGain.setFont ( new Font ( "sans serif", Font.BOLD, 15 ) );
		Search = new JMenuItem ( "Search" );
		Search.setFont ( new Font ( "sans serif", Font.BOLD, 15 ) );
		Quit = new JMenuItem ( "Quit" );
		Quit.setFont ( new Font ( "sans serif", Font.BOLD, 15 ) );

		setTitle ( "ePortfolio" );
		setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		setResizable ( false );

		Buy.addActionListener ( this );
		Sell.addActionListener ( this );
		Update.addActionListener ( this );
		GetGain.addActionListener ( this );
		Search.addActionListener ( this );
		Quit.addActionListener ( this );

		commands.add ( Buy );
		commands.add ( Sell );
		commands.add ( Update );
		commands.add ( GetGain );
		commands.add ( Search );
		commands.add ( Quit );
		menuBar.add ( commands );
		setVisible ( true );

		setJMenuBar ( menuBar );
		setBounds ( 150, 150, 800, 600 );
		
		home ();
	}

	private void home () 
	{
		JPanel myPanel;
		myPanel = new JPanel ();
		JLabel myLabel;
		myLabel = new JLabel ( "<html>Welcome to ePortfolio." + "<br/> <br/> <br/>Choose a command from the \"Commands\" menu to buy or sell" + "<br/>an investment, update prices for all investments, get gain for the<br/>" + "portfolio, search for relevant investments, or quit the program</html>", SwingConstants.CENTER );
		myLabel.setFont ( new Font ( "Times New Roman", Font.PLAIN, 20 ) );
		myLabel.setBounds ( 100, 140, 600, 200 );
		getContentPane ();
		myPanel.setLayout ( null );
		myPanel.add ( myLabel );
		
		add ( myPanel );
		setVisible ( true );
	}

	private void buyMenu () 
	{
		JPanel myPanel;
		myPanel = new JPanel ();
		JPanel myPanel2;
		myPanel2 = new JPanel ();
		myPanel2.setBounds ( 0, 0, 350, 230 );

		myPanel2.setLayout ( null );

		JLabel labelTitle;
		labelTitle = new JLabel ( "Buying an investment" );
		labelTitle.setBounds ( 15, 0, 210, 55 );
		labelTitle.setFont ( new Font ( "Times New Roman", Font.BOLD, 20 ) );

		JLabel labelType;
		labelType = new JLabel ( "Type" );
		labelType.setBounds(35, 70, 50, 20);
		labelType.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		String temp [] = { "Stock", "Mutual Fund" };
		JComboBox myComboBox;
		myComboBox = new JComboBox ( temp );
		myComboBox.setBounds ( 140, 70, 150, 20 );

		JLabel labelSymbol;
		labelSymbol = new JLabel ( "Symbol" );
		labelSymbol.setBounds ( 35, 100, 50, 20 );
		labelSymbol.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );
		
		JTextField textForSymbol;
		textForSymbol = new JTextField ();
		textForSymbol.setBounds ( 140, 100, 150, 20 );

		JLabel labelName;
		labelName = new JLabel ( "Name" );
		labelName.setBounds ( 35, 130, 50, 20 );
		labelName.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );
		
		JTextField textForName;
		textForName = new JTextField ();
		textForName.setBounds ( 140, 130, 200, 20 );

		JLabel labelQuantity;
		labelQuantity = new JLabel ( "Quantity" );
		labelQuantity.setBounds ( 35, 160, 70, 20 );
		labelQuantity.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );
		
		JTextField textForQuantity;
		textForQuantity = new JTextField ();
		textForQuantity.setBounds ( 140, 160, 100, 20 );

		JLabel labelPrice;
		labelPrice = new JLabel ( "Price" );
		labelPrice.setBounds ( 35, 190, 50, 20 );
		labelPrice.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );
		
		JTextField textForPrice;
		textForPrice = new JTextField ();
		textForPrice.setBounds ( 140, 190, 100, 20 );

		myPanel2.add ( labelTitle );
		myPanel2.add ( labelType );
		myPanel2.add ( myComboBox );
		myPanel2.add ( labelSymbol );
		myPanel2.add ( textForSymbol );
		myPanel2.add ( labelName );
		myPanel2.add ( textForName );
		myPanel2.add ( labelQuantity );
		myPanel2.add ( textForQuantity );
		myPanel2.add ( labelPrice );
		myPanel2.add ( textForPrice );

		getContentPane ().removeAll ();

		JSeparator separator;
		separator = new JSeparator ( SwingConstants.HORIZONTAL );
		separator.setBounds ( 0, 230, 800, 10 );

		JSeparator separator2;
		separator2 = new JSeparator ( SwingConstants.VERTICAL );
		separator2.setBounds ( 450, 0, 10, 230 );

		myPanel.add ( separator );
		myPanel.add ( separator2 );

		JPanel myPanel3;
		myPanel3 = new JPanel ();
		myPanel3.setLayout ( null );
		myPanel3.setBounds ( 350, 0, 350, 200 );

		JButton resetButton;
		resetButton = new JButton ( "Reset" );
		resetButton.setBounds ( 190, 80, 130, 25 );

		JButton buyButton;
		buyButton = new JButton ( "Buy" );
		buyButton.setBounds ( 190, 140, 130, 25 );

		myPanel3.add ( resetButton );
		myPanel3.add ( buyButton );

		JPanel myPanel4;
		myPanel4 = new JPanel ();
		myPanel4.setLayout ( null );
		myPanel4.setBounds ( 0, 210, 800, 420 );

		JLabel labelMessage;
		labelMessage = new JLabel ( "Messages" );
		labelMessage.setBounds ( 10, 30, 100, 18 );
		
		JTextArea messageText;
		messageText = new JTextArea ();

		JScrollPane scrollPane;
		scrollPane = new JScrollPane ( messageText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

		scrollPane.setBounds ( 5, 50, 750, 247 );

		myPanel4.add ( labelMessage );
		myPanel4.add ( scrollPane );

		myPanel.setLayout ( null );
		myPanel.add ( myPanel2 );
		myPanel.add ( myPanel3 );
		myPanel.add ( myPanel4 );
		
		
		
		add ( myPanel );

		invalidate ();
		validate ();

		resetButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				textForQuantity.setText ( "" );
				textForPrice.setText ( "" );
				messageText.setText ( "" );
				textForSymbol.setText ( "" );
				textForName.setText ( "" );
			}
		} );

		buyButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				int stockOrMutualFund;
				stockOrMutualFund = myComboBox.getSelectedIndex ();
				String stringForSymbol = textForSymbol.getText ();
				String stringForName;
				stringForName = textForName.getText ();
				int quantityInput;
				quantityInput = Integer.parseInt ( textForQuantity.getText () );
				double price;
				price = Double.parseDouble ( textForPrice.getText () );
				if ( stockOrMutualFund == 1 ) 
				{
					Investment investment = objPortfolio.checkThroughSymbol ( stringForSymbol );
					
					if ( investment == null ) 
					{
						String finalString;
						finalString = buyMutualFund ( stringForSymbol, stringForName, quantityInput, price );
						messageText.setText ( finalString );
					} 
					else if ( investment instanceof MutualFund ) 
					{
						MutualFund mf;
						mf = ( MutualFund ) investment;
						double bookValue;
						bookValue = ( ( price * quantityInput ) + mf.returnBookValue () );
						int num;
						num = mf.returnQuantity () + quantityInput;
						mf.setQuantity ( num );
						mf.setBookValue ( bookValue );
						mf.setPrice ( price );
						messageText.setText ( "Updated the quantity!" );
					} 
					else 
					{
						messageText.setText ( "The symbol you entered is a stock!!!" );
					}
				}
				else if  ( stockOrMutualFund == 0 ) 
				{
					Investment investment = objPortfolio.checkThroughSymbol ( stringForSymbol );
					
					if ( investment == null ) 
					{
						String finalString;
						finalString = buyStock ( stringForSymbol, stringForName, quantityInput, price );
						messageText.setText ( finalString );
					} 
					else if ( investment instanceof Stock ) 
					{
						Stock st;
						st = ( Stock ) investment;
						double bookValue;
						bookValue = ( ( price * quantityInput ) + 9.99 ) + st.returnBookValue ();
						int num;
						num = st.returnQuantity () + quantityInput;
						st.setQuantity ( num );
						st.setBookValue ( bookValue );
						st.setPrice ( price );
						messageText.setText ( "Updated the quantity!" );
					} 
					else 
					{
						messageText.setText ( "The symbol you entered is a mutual fund!!!" );
					}

				} 
				
			}
		} );
	}

	private String buyStock ( String symbol, String name, int quantity, double price ) 
	{
		if ( quantity <= 0 || price <= 0 ) 
		{
			return "You can't enter negative values or 0!!!";
		}
		Stock st;
		st = new Stock ( symbol, name, quantity, price, 9.99 );
		st.setBookValue ( ( price * quantity ) + 9.99 );
		if ( !objPortfolio.addInvestment ( st ) ) 
		{
			return "";
			
		}
		return "Investment bought successfully.";
	}

	private String buyMutualFund ( String symbol, String name, int quantity, double price ) 
	{

		if ( quantity <= 0 || price <= 0 ) 
		{
			return "You can't enter negative values or 0!!!";
		}

		MutualFund mf;
		mf = new MutualFund ( symbol, name, quantity, price );
		mf.setBookValue ( price * quantity );
		if ( !objPortfolio.addInvestment ( mf ) ) 
		{
			return "";
			
		}
		return "Investment bought successfully.";
	}

	private void sellMenu () 
	{
		JPanel myPanel;
		myPanel = new JPanel ();
		JPanel myPanel2;
		myPanel2 = new JPanel ();

		myPanel2.setLayout ( null );

		JLabel labelTitle;
		labelTitle = new JLabel ( "Selling an investment" );
		labelTitle.setBounds ( 15, 0, 210, 55 );
		labelTitle.setFont ( new Font ( "Times New Roman", Font.BOLD, 20 ) );

		JLabel labelSymbol;
		labelSymbol = new JLabel ( "Symbol" );
		labelSymbol.setBounds ( 35, 80, 50, 20 );
		labelSymbol.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );
		
		JTextField textForSymbol;
		textForSymbol = new JTextField ();
		textForSymbol.setBounds ( 140, 80, 150, 20 );

		JLabel labelQuantity;
		labelQuantity = new JLabel ( "Quantity" );
		labelQuantity.setBounds ( 35, 120, 70, 20 );
		labelQuantity.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );
		
		JTextField textForQuantity;
		textForQuantity = new JTextField ();
		textForQuantity.setBounds ( 140, 120, 100, 20 );

		JLabel labelPrice;
		labelPrice = new JLabel ( "Price" );
		labelPrice.setBounds ( 35, 160, 50, 20 );
		labelPrice.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );
		
		JTextField textForPrice;
		textForPrice = new JTextField ();
		textForPrice.setBounds ( 140, 160, 100, 20 );

		myPanel2.add ( labelTitle );
		myPanel2.add ( labelSymbol );
		myPanel2.add ( textForSymbol );
		myPanel2.add ( labelQuantity );
		myPanel2.add ( textForQuantity );
		myPanel2.add ( labelPrice );
		myPanel2.add ( textForPrice );

		getContentPane ().removeAll ();

		JSeparator separator;
		separator = new JSeparator ( SwingConstants.HORIZONTAL );
		separator.setBounds ( 0, 230, 800, 10 );

		JSeparator separator2;
		separator2 = new JSeparator ( SwingConstants.VERTICAL );
		separator2.setBounds ( 450, 0, 10, 230 );

		myPanel.add ( separator );
		myPanel.add ( separator2 );

		JPanel myPanel3;
		myPanel3 = new JPanel ();
		myPanel3.setLayout ( null );

		JButton resetButton;
		resetButton = new JButton ( "Reset" );
		resetButton.setBounds ( 190, 80, 130, 25 );

		JButton sellButton;
		sellButton = new JButton ( "Sell" );
		sellButton.setBounds ( 190, 140, 130, 25 );

		myPanel3.add ( resetButton );
		myPanel3.add ( sellButton );

		JPanel myPanel4;
		myPanel4 = new JPanel ();
		myPanel4.setLayout ( null );

		JLabel labelMessage;
		labelMessage = new JLabel ( "Messages" );
		labelMessage.setBounds ( 10, 30, 100, 18 );

		JTextArea messageText;
		messageText = new JTextArea ();

		JScrollPane scrollPane;
		scrollPane = new JScrollPane ( messageText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

		scrollPane.setBounds ( 5, 50, 750, 247 );

		myPanel4.add ( labelMessage );
		myPanel4.add ( scrollPane );

		myPanel.setLayout ( null );
		myPanel.add ( myPanel2 );
		myPanel.add ( myPanel3 );
		myPanel.add ( myPanel4 );
		myPanel2.setBounds ( 0, 0, 350, 230 );
		myPanel3.setBounds ( 350, 0, 350, 200 );
		myPanel4.setBounds ( 0, 210, 800, 450 );
		add ( myPanel );

		invalidate ();
		validate ();

		resetButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed (ActionEvent e) 
			{
				textForPrice.setText ( "" );
				messageText.setText ( "" );
				textForSymbol.setText ( "" );
				textForQuantity.setText ( "" );
				
			}
		});

		sellButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				String stringForSymbol;
				stringForSymbol = textForSymbol.getText ();
				int quantity;
				quantity = Integer.parseInt ( textForQuantity.getText () );
				double price;
				price = Double.parseDouble ( textForPrice.getText () );

				Investment investment;
				investment = objPortfolio.checkThroughSymbol ( stringForSymbol );
				
				if ( investment != null && investment instanceof MutualFund ) 
				{
					String finalString;
					finalString = sellMutualFund ( ( MutualFund ) investment, quantity, price );
					messageText.setText ( finalString );
				} 
				else if ( investment != null && investment instanceof Stock ) 
				{
					String finalString;
					finalString = sellStock ( ( Stock ) investment, quantity, price );
					messageText.setText ( finalString );
				} 
				else 
				{
					System.out.println ( "No investment found!!!" );
				}
			}
		});
	}

	private String sellStock ( Stock st, int quantity, double price ) 
	{
		if ( quantity <= 0 || price <= 0 ) 
		{
			return "You can't enter negative values or 0!!!";
		}
		if (quantity > st.returnQuantity () )
		{
			return "You don't own sufficent stocks to sell!";
		}
		else 
		{
			int num;
			num = st.returnQuantity () - quantity;
			if (num == 0) 
			{
				objPortfolio.returnInvestments ().remove ( st );
			}
			else 
			{
				double bookValue;
				bookValue = st.returnBookValue () * num / st.returnQuantity ();
				st.setBookValue ( bookValue );
				st.setQuantity ( num );
			} 
			return "Sold successfully";
		} 
	}

	private String sellMutualFund ( MutualFund mf, int quantity, double price ) 
	{
		if ( quantity <= 0 || price <= 0 ) 
		{
			return "You can't enter negative values or 0!!!";
		}
		if ( quantity > mf.returnQuantity () ) 
		{
			return "You don't have enough quantity to Sell!";
		}
		else
		{
			int num;
			num = mf.returnQuantity () - quantity;
			if ( num == 0 ) 
			{
				objPortfolio.returnInvestments ().remove ( mf );
			}
			else 
			{
				double bookValue;
				bookValue = mf.returnBookValue () * num / mf.returnQuantity ();
				mf.setBookValue ( bookValue );
				mf.setQuantity ( num );
			} 
			
			return "Sold successfully";
		} 
		
	}

	private void updateMenu () 
	{
		JPanel myPanel;
		myPanel = new JPanel ();
		JPanel myPanel2;
		myPanel2 = new JPanel ();

		myPanel2.setLayout ( null );

		JLabel labelTitle;
		labelTitle = new JLabel ( "Updating investments" );
		labelTitle.setBounds ( 10, 5, 200, 50 );
		labelTitle.setFont ( new Font ( "Times New Roman", Font.BOLD, 20 ) );

		JLabel labelSymbol;
		labelSymbol = new JLabel ( "Symbol" );
		labelSymbol.setBounds ( 35, 70, 50, 20 );
		labelSymbol.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField textForSymbol;
		textForSymbol = new JTextField ();
		textForSymbol.setBounds ( 140, 70, 150, 20 );
		textForSymbol.setEditable(false);

		JLabel labelName;
		labelName = new JLabel ( "Name" );
		labelName.setBounds ( 35, 110, 50, 20 );
		labelName.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField textForName;
		textForName = new JTextField ();
		textForName.setBounds ( 140, 110, 200, 20 );
		textForName.setEditable(false);

		JLabel labelPrice;
		labelPrice = new JLabel ( "Price" );
		labelPrice.setBounds ( 35, 150, 50, 20 );
		labelPrice.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField textForPrice;
		textForPrice = new JTextField ();
		textForPrice.setBounds ( 140, 150, 100, 20 );

		myPanel2.add ( labelTitle );
		myPanel2.add ( labelSymbol );
		myPanel2.add ( textForSymbol );
		myPanel2.add ( labelName );
		myPanel2.add ( textForName );
		myPanel2.add ( labelPrice );
		myPanel2.add ( textForPrice );

		getContentPane ().removeAll ();

		JSeparator separator;
		separator = new JSeparator ( SwingConstants.HORIZONTAL );
		separator.setBounds ( 0, 230, 800, 10 );

		JSeparator separator2;
		separator2 = new JSeparator ( SwingConstants.VERTICAL );
		separator2.setBounds ( 450, 0, 10, 230 );

		myPanel.add ( separator );
		myPanel.add ( separator2 );

		JPanel myPanel3;
		myPanel3 = new JPanel ();
		myPanel3.setLayout ( null );

		JButton previousButton;
		previousButton = new JButton ( "Previous" );
		previousButton.setBounds ( 190, 70, 130, 25 );

		JButton nextButton;
		nextButton = new JButton ( "Next" );
		nextButton.setBounds ( 190, 110, 130, 25 );

		JButton saveButton;
		saveButton = new JButton ( "Save" );
		saveButton.setBounds ( 190, 150, 130, 25 );

		myPanel3.add ( previousButton );
		myPanel3.add ( nextButton );
		myPanel3.add ( saveButton );

		JPanel myPanel4;
		myPanel4 = new JPanel ();
		myPanel4.setLayout ( null );

		JLabel labelMessage;
		labelMessage = new JLabel ( "Messages" );
		labelMessage.setBounds ( 10, 30, 100, 18 );

		JTextArea messageText;
		messageText = new JTextArea ();

		JScrollPane scrollPane;
		scrollPane = new JScrollPane ( messageText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

		scrollPane.setBounds ( 5, 50, 750, 247 );

		myPanel4.add ( labelMessage );
		myPanel4.add ( scrollPane );

		myPanel.setLayout ( null );
		myPanel.add ( myPanel2 );
		myPanel.add ( myPanel3 );
		myPanel.add ( myPanel4 );
		myPanel2.setBounds ( 0, 0, 350, 230 );
		myPanel3.setBounds ( 350, 0, 350, 200 );
		myPanel4.setBounds ( 0, 210, 800, 400 );
		add ( myPanel );

		invalidate ();
		validate ();

		List<Investment> investments = objPortfolio.returnInvestments ();
		if ( investments != null ) 
		{
			Investment investment;
			investment = investments.get ( num );
			if ( investment == null ) 
			{

			}
			else
			{
				textForSymbol.setText ( investment.returnSymbol () );
				textForName.setText ( investment.returnName () );
				textForPrice.setText ( investment.returnPrice () + "" );
			}
		}

		previousButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				if ( num > 0 ) 
				{
					num = num - 1;
					Investment investment;
					investment = investments.get ( num );
					textForSymbol.setText ( investment.returnSymbol () );
					textForName.setText ( investment.returnName () );
					textForPrice.setText ( investment.returnPrice () + "" );
				}
				else
				{
					return;
				}
			}
		});

		nextButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				int temp;
				temp = investments.size() - 1;
				if ( num == temp ) 
				{
					return;
				}
				num = num + 1;
				temp = investments.size();
				if ( investments == null | temp == 0 ) 
				{
					return;
				}
				Investment investment;
				investment = investments.get ( num );
				if ( investment == null ) 
				{
					return;
				}
				textForSymbol.setText ( investment.returnSymbol () );
				textForName.setText ( investment.returnName () );
				textForPrice.setText ( investment.returnPrice () + "" );
			}
		});

		saveButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				Investment investment;
				investment = investments.get ( num );
				if (investment == null) 
				{
					messageText.setText ( "No investment found!" );
				}
				else 
				{
					double price;
					price = Double.parseDouble ( textForPrice.getText () );
					messageText.setText ( update ( investment, price ) );
				} 
				
			}
		});
	}

	private String update ( Investment investment, double price ) 
	{
		investment.setPrice ( price );
		return "Investment updated successfully.";
	}

	private void getGainMenu () 
	{
		JPanel myPanel;
		myPanel = new JPanel ();
		JPanel myPanel2;
		myPanel2 = new JPanel ();

		myPanel2.setLayout ( null );

		JLabel labelTitle;
		labelTitle = new JLabel ( "Getting total gain" );
		labelTitle.setBounds ( 15, 0, 210, 55 );
		labelTitle.setFont ( new Font ( "Times New Roman", Font.BOLD, 20 ) );

		JLabel labelGain;
		labelGain = new JLabel ( "Total gain" );
		labelGain.setBounds ( 35, 120, 80, 20 );
		labelGain.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField totalGainText;
		totalGainText = new JTextField ();
		totalGainText.setBounds ( 140, 120, 150, 20 );

		myPanel2.add ( labelTitle );
		myPanel2.add ( labelGain );
		myPanel2.add ( totalGainText );

		getContentPane ().removeAll ();

		JSeparator separator;
		separator = new JSeparator ( SwingConstants.HORIZONTAL );
		separator.setBounds ( 0, 230, 800, 10 );

		myPanel.add ( separator );

		JPanel myPanel3;
		myPanel3 = new JPanel ();
		myPanel3.setLayout ( null );

		JLabel labelMessage;
		labelMessage = new JLabel ( "Individual gains" );
		labelMessage.setBounds ( 10, 30, 100, 20 );

		JTextArea individualTextArea;
		individualTextArea = new JTextArea ();

		JScrollPane scrollPane;
		scrollPane = new JScrollPane ( individualTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

		scrollPane.setBounds ( 5, 50, 750, 247 );

		myPanel3.add ( labelMessage );
		myPanel3.add ( scrollPane );

		myPanel.setLayout ( null );
		myPanel.add ( myPanel2 );
		myPanel.add ( myPanel3 );
		myPanel2.setBounds ( 0, 0, 350, 230 );
		myPanel3.setBounds ( 0, 210, 800, 400 );
		add ( myPanel );

		invalidate ();
		validate ();

		if ( objPortfolio.returnInvestments() != null ) 
		{
			double netGain = 0.0;
			String gainString = "";
			for ( Investment investment : objPortfolio.returnInvestments () ) 
			{
				if ( investment instanceof Stock ) 
				{
					Stock st;
					st = ( Stock ) investment;
					gainString = gainString + st.toString () + "\n";
					double gainValue;
					gainValue = ( ( st.returnQuantity () * st.returnPrice () ) - 9.99 ) - st.returnBookValue();
					gainString = gainString + "Gain for this stock is : " + gainValue + "\n\n";
					netGain = netGain + gainValue;
				} 
				else if ( investment instanceof MutualFund ) 
				{
					MutualFund mf;
					mf = ( MutualFund ) investment;
					gainString = gainString + mf.toString() + "\n";
					double gainValue;
					gainValue = ( ( mf.returnQuantity () * mf.returnPrice () ) - 45.00 ) - mf.returnBookValue ();
					gainString = gainString + "Gain for this mutualfund is : " + gainValue + "\n\n";
					netGain = netGain + gainValue;
				}
			}
			individualTextArea.setText ( gainString );
			totalGainText.setText ( netGain + "" );
		}
	}

	private void searchMenu () 
	{
		JPanel myPanel;
		myPanel = new JPanel ();
		JPanel myPanel2;
		myPanel2 = new JPanel ();

		myPanel2.setLayout ( null );

		JLabel labelTitle;
		labelTitle = new JLabel ( "Searching investments" );
		labelTitle.setBounds ( 15, 0, 210, 55 );
		labelTitle.setFont ( new Font ( "Times New Roman", Font.BOLD, 20 ) );

		JLabel labelSymbol;
		labelSymbol = new JLabel ( "Symbol" );
		labelSymbol.setBounds ( 35, 50, 50, 20 );
		labelSymbol.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField textForSymbol;
		textForSymbol = new JTextField ();
		textForSymbol.setBounds ( 140, 50, 150, 20 );

		JLabel labelName;
		labelName = new JLabel ( "<html>Name<br/>Keywords</html>" );
		labelName.setBounds ( 35, 80, 80, 50 );
		labelName.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField textForName;
		textForName = new JTextField ();
		textForName.setBounds ( 140, 95, 200, 20 );

		JLabel lessPrice;
		lessPrice = new JLabel ( "Low Price" );
		lessPrice.setBounds ( 35, 140, 80, 20 );
		lessPrice.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField lessPriceText;
		lessPriceText = new JTextField ();
		lessPriceText.setBounds ( 140, 140, 100, 20 );

		JLabel morePrice;
		morePrice = new JLabel ( "High Price" );
		morePrice.setBounds ( 35, 170, 80, 20 );
		morePrice.setFont ( new Font ( "Times New Roman", Font.BOLD, 15 ) );

		JTextField morePriceText;
		morePriceText = new JTextField ();
		morePriceText.setBounds ( 140, 170, 100, 20 );

		myPanel2.add ( labelTitle );
		myPanel2.add ( labelSymbol );
		myPanel2.add ( textForSymbol );
		myPanel2.add ( labelName );
		myPanel2.add ( textForName );
		myPanel2.add ( lessPrice );
		myPanel2.add ( lessPriceText );
		myPanel2.add ( morePrice );
		myPanel2.add ( morePriceText );

		getContentPane ().removeAll ();

		JSeparator separator;
		separator = new JSeparator ( SwingConstants.HORIZONTAL );
		separator.setBounds ( 0, 230, 800, 10 );

		JSeparator separator2;
		separator2 = new JSeparator ( SwingConstants.VERTICAL );
		separator2.setBounds ( 450, 0, 10, 230 );

		myPanel.add ( separator );
		myPanel.add ( separator2 );

		JPanel myPanel3;
		myPanel3 = new JPanel ();
		myPanel3.setLayout ( null );

		JButton resetButton;
		resetButton = new JButton ( "Reset" );
		resetButton.setBounds ( 190, 80, 130, 25 );

		resetButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				lessPriceText.setText ( "" );
				morePriceText.setText ( "" );
				textForSymbol.setText ( "" );
				textForName.setText ( "" );
			
			}
		});

		JButton searchButton;
		searchButton = new JButton ( "Search" );
		searchButton.setBounds ( 190, 140, 130, 25 );

		myPanel3.add ( resetButton );
		myPanel3.add ( searchButton );

		JPanel myPanel4;
		myPanel4 = new JPanel ();
		myPanel4.setLayout ( null );

		JLabel labelMessage;
		labelMessage = new JLabel ( "Search results" );
		labelMessage.setBounds ( 10, 30, 100, 20 );

		JTextArea messageText;
		messageText = new JTextArea ();

		JScrollPane scrollPane;
		scrollPane = new JScrollPane ( messageText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );

		scrollPane.setBounds ( 5, 50, 750, 247 );

		myPanel4.add ( labelMessage );
		myPanel4.add ( scrollPane );

		myPanel.setLayout ( null );
		myPanel.add ( myPanel2 );
		myPanel.add ( myPanel3 );
		myPanel.add ( myPanel4 );
		myPanel2.setBounds ( 0, 0, 350, 230 );
		myPanel3.setBounds ( 350, 0, 350, 200 );
		myPanel4.setBounds ( 0, 210, 800, 400 );
		add ( myPanel );

		invalidate ();
		validate ();

		resetButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				lessPriceText.setText ( "" );
				morePriceText.setText ( "" );
				messageText.setText ( "" );
				textForSymbol.setText ( "" );
				textForName.setText ( "" );
				
			}
		});

		searchButton.addActionListener ( new ActionListener () 
		{
			@Override
			public void actionPerformed ( ActionEvent e ) 
			{
				String stringForSymbol;
				stringForSymbol = textForSymbol.getText ();
				String stringForName;
				stringForName = textForName.getText ();
				String lessPrice;
				lessPrice = lessPriceText.getText ();
				String morePrice;
				morePrice = morePriceText.getText ();

				if ( ( stringForSymbol != null && stringForSymbol.length () > 0 ) && ( stringForName == null | stringForName.length() == 0 ) && ( lessPrice == null | lessPrice.length () == 0 ) && ( morePrice == null | morePrice.length () == 0 ) ) 
				{
					Investment investment;
					investment = objPortfolio.checkThroughSymbol ( stringForSymbol );
					if (investment == null) 
					{
						messageText.setText ( "No investment found!" );
					}
					else 
					{
						if ( investment instanceof MutualFund ) 
						{
							messageText.setText ( ( ( MutualFund ) investment ).toString () );
						}
						else if ( investment instanceof Stock ) 
						{
							messageText.setText( ( ( Stock ) investment ).toString () );
						} 				
					} 
					
				} 
				else if ( ( stringForSymbol == null | stringForSymbol.length () == 0 ) && ( stringForName != null && stringForName.length () > 0 ) && ( lessPrice == null | lessPrice.length () == 0 ) && ( morePrice == null | morePrice.length () == 0 ) ) 
				{
					ArrayList<Investment> investments = objPortfolio.checkThroughKeyword ( stringForName );
					if( investments == null || investments.size() <= 0) 
					{
						messageText.setText ( "No investment found!" );
					}
					else
					{
						String finalString;
						finalString = "";
						for ( Investment i : investments ) 
						{
							if ( i instanceof Stock ) 
							{
								finalString = finalString + ( ( Stock ) i ).toString () + "\n";
							} 
							else if ( i instanceof MutualFund)
							{
								finalString = finalString + ( ( MutualFund ) i ).toString () + "\n";
							}
						}
						if (finalString.length() > 0) 
						{
							messageText.setText ( finalString );
						} 
						else if (finalString.length() < 0)
						{
							messageText.setText ( "" );
						}
					} 
					

				} 
				else if ( ( stringForSymbol != null && stringForSymbol.length () > 0 ) && ( stringForName == null | stringForName.length () == 0 ) && ( lessPrice != null && lessPrice.length () > 0 ) && ( morePrice != null && morePrice.length () > 0 ) ) 
				{
					ArrayList<Investment> investments = objPortfolio.combinedSearch (stringForSymbol, lessPrice + "-" + morePrice );
					if ( investments == null || investments.size() <= 0) 
					{
						messageText.setText ( "No investment found!" );
					}
					else 
					{
						String finalString;
						finalString = "";
						for ( Investment i : investments ) 
						{
							if ( i instanceof Stock ) 
							{
								finalString = finalString + ( ( Stock ) i ).toString () + "\n";
							} 
							else if ( i instanceof MutualFund)
							{
								finalString = finalString +  ( ( MutualFund ) i ).toString () + "\n";
							}
						}
						messageText.setText ( finalString );
					} 
					
				} 
				else 
				{
					messageText.setText ( "No investment found!" );
				}
			}
		});
	}

	@Override
	public void actionPerformed ( ActionEvent e ) 
	{
		if ( e.getSource () == Buy )
		{
			buyMenu();
		}
		else if ( e.getSource () == Sell )
		{
			sellMenu();
		}
		else if ( e.getSource () == Update )
		{
			updateMenu();
		}
		else if ( e.getSource () == GetGain )
		{
			getGainMenu();
		}
		else if ( e.getSource () == Search )
		{
			searchMenu();
		}
		else if ( e.getSource () == Quit )
		{
			System.exit(0);
		}
	}

	/**
	 * Main 
	 * @param args
	 */
	public static void main ( String[] args ) 
	{
		EventQueue.invokeLater ( new Runnable () 
		{
			@Override
			public void run() 
			{
				new Assignment3GUI ().displayGUI ();
			}
		});
	}
}
