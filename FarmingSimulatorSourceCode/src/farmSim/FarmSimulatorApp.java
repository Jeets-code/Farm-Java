package farmSim;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.Enumeration;

import javax.swing.border.LineBorder;

import java.awt.Component;

/**
 * GUI and driving class for farm simulator application.
 * @author James Harris, Manjeet Panwar
 * @version 10/05/2020
 */
public class FarmSimulatorApp {

	/**
	 * Games logical handler.
	 */
	private GuiGameEnviroment gameEnviroment;
	
	/**
	 * Game state of game. Holds all information about current state. 
	 */
	private GameState gameState;
	
	//GUI Variables
	private JFrame frame;
	private JTextField setUpScreenFarmerNameTextFeild;
	private JTextField setUpScreenFarmNameTextField;
	private final ButtonGroup gameSetupFarmTypeButtons = new ButtonGroup();
	private JTextField setUpScreenNumberOfDaysTextField;
	private JRadioButton rdbtnFarmSelectBetterAnimals;
	private JRadioButton rdbtnFarmSelectStartingCash;
	private JRadioButton rdbtnFarmSelectHardMode;
	private JRadioButton rdbtnFarmSelectFastCrops;
	private JLabel setUpScreenIlegalFarmerNameLabel;
	private JLabel setUpScreenIllegalFarmNameLabel;
	private JLabel setUpScreenIllegalNumberLabel;
	private JPanel mainGamePanel;
	private JPanel setUpScreenPanel;
	private JLabel mainMoneyLabel;
	private JLabel mainDailyActionsRemaningLabel;
	private JLabel mainDayLabel;
	private JPanel shopPanel;
	private JLabel shopMoneyLabel;
	private JTextPane shopOnwedItemsTextPane;
	private JPanel shopShopPanel;
	private JPanel shopPanelOne;
	private JLabel shopPanelOneLabel;
	private JTextPane shopPanelOneDecription;
	private JTextPane shopPanelTwoDescription;
	private JLabel shopPanelTwoLabel;
	private JLabel shopPanelFourLabel;
	private JTextPane shopPanelFourDescription;
	private JLabel shopPanelFiveLabel;
	private JTextPane shopPanelFiveDescription;
	private JLabel shopPanelSixLabel;
	private JTextPane shopPanelSixDescription;
	private JLabel shopPanelSevenLabel;
	private JTextPane shopPanelSevenDescription;
	private JLabel shopPanelEightLabel;
	private JTextPane shopPanelEightDescription;
	private JLabel shopPanelNineLabel;
	private JTextPane shopPanelNineDescription;
	private JLabel shopPanelTenLabel;
	private JTextPane shopPanelTenDescription;
	private JLabel shopPanelElevenLabel;
	private JTextPane shopPanelElevenDescription;
	private JLabel shopPanelTwelveLabel;
	private JTextPane shopPanelTwelveDescription;
	private JLabel shopPanelThirteenLabel;
	private JTextPane shopPanelThirteenDescription;
	private JLabel shopPanelFourteenLabel;
	private JTextPane shopPanelFourteenDescription;
	private JLabel shopPanelFifteenLabel;
	private JTextPane shopPanelFifteenDescription;
	private JTextPane shopPanelThreeDescription;
	private JLabel shopPanelThreeLabel;
	private JLabel shopHeaderLabel;
	private JTextPane shopOwnedCropsTextPane;
	private JTextPane shopOwnedAnimalsTextPane;
	private JTextPane mainAnimalOneDescription;
	private JTextPane mainAnimalTwoDescription;
	private JTextPane mainAnimalThreeDescription;
	private JTextPane mainAnimalFourDescription;
	private JButton mainConfirmActionButton;
	private JPanel mainActionListPanel;
	private final ButtonGroup actionButtonsButtonGroup = new ButtonGroup();
	private JLabel mainActionLabel;
	private JButton mainConfirmCropSelectionButton;
	private JTextPane mainFieldOneDescription;
	private JTextPane mainFieldFourDescription;
	private JTextPane mainFieldThreeDescription;
	private JTextPane mainFieldTwoDescription;
	private JPanel gameEndPanel;
	private JLabel gameEndUserName;
	private JTextPane gameEndScoreTextPane;
	private JButton mainSaveGameButton;
	private JPanel loadInPanel;
	private JButton loadInLoadGameButton;
	private JLabel loadInErrorLabel;
	private JLabel mainAnimalOneIconLabel;
	private JLabel mainAnimalTwoIconLabel;
	private JLabel mainAnimalThreeIconLabel;
	private JLabel mainAnimalFourIconLabel;
	private JLabel mainFieldOneIcon;
	private JLabel mainFieldTwoIcon;
	private JLabel mainFieldThreeIcon;
	private JLabel mainFieldFourIcon;
	


	/**
	 * Launch Application.
	 * Create GUI window and create event queue
	 * @param args contains command-line arguments passed to the Java program upon invocation
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarmSimulatorApp window = new FarmSimulatorApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public FarmSimulatorApp() {
		this.gameEnviroment = new GuiGameEnviroment();
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		shopPanel = new JPanel();
		shopPanel.setBackground(new Color(240, 255, 240));
		shopPanel.setBounds(0, 0, 1904, 1041);
		frame.getContentPane().add(shopPanel);
		shopPanel.setLayout(null);
		
		JPanel shopMoneyPanel = new JPanel();
		shopMoneyPanel.setBounds(1604, 0, 300, 100);
		shopMoneyPanel.setLayout(null);
		shopMoneyPanel.setBackground(new Color(250, 240, 230));
		shopPanel.add(shopMoneyPanel);
		
		shopMoneyLabel = new JLabel("$0");
		shopMoneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shopMoneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		shopMoneyLabel.setBounds(0, 22, 300, 56);
		shopMoneyPanel.add(shopMoneyLabel);
		
		JPanel shopThingsOwnedPanel = new JPanel();
		shopThingsOwnedPanel.setBackground(new Color(240, 248, 255));
		shopThingsOwnedPanel.setBounds(1499, 100, 405, 696);
		shopPanel.add(shopThingsOwnedPanel);
		shopThingsOwnedPanel.setLayout(null);
		
		JLabel shopOwnedItemsLabel = new JLabel("Your Owned Items:");
		shopOwnedItemsLabel.setBounds(209, 11, 172, 44);
		shopOwnedItemsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shopOwnedItemsLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		shopThingsOwnedPanel.add(shopOwnedItemsLabel);
		
		shopOnwedItemsTextPane = new JTextPane();
		shopOnwedItemsTextPane.setBounds(209, 59, 172, 626);
		shopOnwedItemsTextPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopOnwedItemsTextPane.setEditable(false);
		shopThingsOwnedPanel.add(shopOnwedItemsTextPane);
		
		shopOwnedAnimalsTextPane = new JTextPane();
		shopOwnedAnimalsTextPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopOwnedAnimalsTextPane.setEditable(false);
		shopOwnedAnimalsTextPane.setBounds(25, 59, 172, 281);
		shopThingsOwnedPanel.add(shopOwnedAnimalsTextPane);
		
		JLabel shopOwnedAnimalsLabel = new JLabel("Your Owned Animals:");
		shopOwnedAnimalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shopOwnedAnimalsLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		shopOwnedAnimalsLabel.setBounds(10, 11, 189, 44);
		shopThingsOwnedPanel.add(shopOwnedAnimalsLabel);
		
		JLabel shopOwnedCropsLabel = new JLabel("Your Owned Crops:");
		shopOwnedCropsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shopOwnedCropsLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		shopOwnedCropsLabel.setBounds(25, 364, 174, 44);
		shopThingsOwnedPanel.add(shopOwnedCropsLabel);
		
		shopOwnedCropsTextPane = new JTextPane();
		shopOwnedCropsTextPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopOwnedCropsTextPane.setEditable(false);
		shopOwnedCropsTextPane.setBounds(27, 419, 172, 266);
		shopThingsOwnedPanel.add(shopOwnedCropsTextPane);
		
		JPanel shopGotoFarmPanel = new JPanel();
		shopGotoFarmPanel.setBounds(1499, 795, 406, 100);
		shopPanel.add(shopGotoFarmPanel);
		shopGotoFarmPanel.setLayout(null);
		
		JButton shopGotoFarmButton = new JButton("Goto Farm");
		shopGotoFarmButton.setBounds(0, 0, 406, 100);
		shopGotoFarmPanel.add(shopGotoFarmButton);
		shopGotoFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeToMainGameScreen();
			}
		});
		shopGotoFarmButton.setBackground(new Color(240, 255, 255));
		shopGotoFarmButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel shopHeaderPanel = new JPanel();
		shopHeaderPanel.setBackground(new Color(255, 228, 196));
		shopHeaderPanel.setBounds(0, 0, 1604, 100);
		shopPanel.add(shopHeaderPanel);
		shopHeaderPanel.setLayout(null);
		
		shopHeaderLabel = new JLabel("General Store");
		shopHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shopHeaderLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		shopHeaderLabel.setBounds(10, 11, 1573, 84);
		shopHeaderPanel.add(shopHeaderLabel);
		
		JPanel shopMainPanel = new JPanel();
		shopMainPanel.setBackground(new Color(240, 255, 255));
		shopMainPanel.setBounds(0, 100, 1500, 941);
		shopPanel.add(shopMainPanel);
		shopMainPanel.setLayout(null);
		
		shopShopPanel = new JPanel();
		shopShopPanel.setBackground(new Color(240, 255, 255));
		shopShopPanel.setBounds(10, 11, 1480, 920);
		shopMainPanel.add(shopShopPanel);
		shopShopPanel.setLayout(new GridLayout(3, 5, 10, 10));
		
		shopPanelOne = new JPanel();
		shopShopPanel.add(shopPanelOne);
		shopPanelOne.setBackground(new Color(255, 255, 240));
		shopPanelOne.setLayout(null);
		
		shopPanelOneLabel = new JLabel("Shop Item Title");
		shopPanelOneLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelOneLabel.setBounds(10, 11, 288, 25);
		shopPanelOne.add(shopPanelOneLabel);
		
		shopPanelOneDecription = new JTextPane();
		shopPanelOneDecription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelOneDecription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelOneDecription.setBounds(10, 44, 268, 168);
		shopPanelOne.add(shopPanelOneDecription);
		
		JButton shopPanelOnePurchaseButton = new JButton("Purchase");
		shopPanelOnePurchaseButton.setBackground(new Color(248, 248, 255));
		shopPanelOnePurchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				purchaseFromShop(1);
			}
		});
		shopPanelOnePurchaseButton.setBounds(10, 223, 268, 66);
		shopPanelOne.add(shopPanelOnePurchaseButton);
		
		JPanel shopPanelTwo = new JPanel();
		shopPanelTwo.setLayout(null);
		shopPanelTwo.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelTwo);
		
		shopPanelTwoLabel = new JLabel("Shop Item Title");
		shopPanelTwoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelTwoLabel.setBounds(10, 11, 288, 25);
		shopPanelTwo.add(shopPanelTwoLabel);
		
		shopPanelTwoDescription = new JTextPane();
		shopPanelTwoDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelTwoDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelTwoDescription.setBounds(10, 44, 268, 168);
		shopPanelTwo.add(shopPanelTwoDescription);
		
		JButton shopPanelTwoButton = new JButton("Purchase");
		shopPanelTwoButton.setBackground(new Color(248, 248, 255));
		shopPanelTwoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(2);
			}
		});
		shopPanelTwoButton.setBounds(10, 223, 268, 66);
		shopPanelTwo.add(shopPanelTwoButton);
		
		JPanel shopPanelThree = new JPanel();
		shopPanelThree.setLayout(null);
		shopPanelThree.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelThree);
		
		shopPanelThreeLabel = new JLabel("Shop Item Title");
		shopPanelThreeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelThreeLabel.setBounds(10, 11, 288, 25);
		shopPanelThree.add(shopPanelThreeLabel);
		
		shopPanelThreeDescription = new JTextPane();
		shopPanelThreeDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelThreeDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelThreeDescription.setBounds(10, 44, 268, 168);
		shopPanelThree.add(shopPanelThreeDescription);
		
		JButton shopPanelThreeButton = new JButton("Purchase");
		shopPanelThreeButton.setBackground(new Color(248, 248, 255));
		shopPanelThreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(3);
			}
		});
		shopPanelThreeButton.setBounds(10, 223, 268, 66);
		shopPanelThree.add(shopPanelThreeButton);
		
		JPanel shopPanelFour = new JPanel();
		shopPanelFour.setLayout(null);
		shopPanelFour.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelFour);
		
		shopPanelFourLabel = new JLabel("Shop Item Title");
		shopPanelFourLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelFourLabel.setBounds(10, 11, 288, 25);
		shopPanelFour.add(shopPanelFourLabel);
		
		shopPanelFourDescription = new JTextPane();
		shopPanelFourDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelFourDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelFourDescription.setBounds(10, 44, 268, 168);
		shopPanelFour.add(shopPanelFourDescription);
		
		JButton shopPanelFourButton = new JButton("Purchase");
		shopPanelFourButton.setBackground(new Color(248, 248, 255));
		shopPanelFourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(4);
			}
		});
		shopPanelFourButton.setBounds(10, 223, 268, 66);
		shopPanelFour.add(shopPanelFourButton);
		
		JPanel shopPanelFive = new JPanel();
		shopPanelFive.setLayout(null);
		shopPanelFive.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelFive);
		
		shopPanelFiveLabel = new JLabel("Shop Item Title");
		shopPanelFiveLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelFiveLabel.setBounds(10, 11, 288, 25);
		shopPanelFive.add(shopPanelFiveLabel);
		
		shopPanelFiveDescription = new JTextPane();
		shopPanelFiveDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelFiveDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelFiveDescription.setBounds(10, 44, 268, 168);
		shopPanelFive.add(shopPanelFiveDescription);
		
		JButton shopPanelFiveButton = new JButton("Purchase");
		shopPanelFiveButton.setBackground(new Color(248, 248, 255));
		shopPanelFiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(5);
			}
		});
		shopPanelFiveButton.setBounds(10, 223, 268, 66);
		shopPanelFive.add(shopPanelFiveButton);
		
		JPanel shopPanelSix = new JPanel();
		shopPanelSix.setLayout(null);
		shopPanelSix.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelSix);
		
		shopPanelSixLabel = new JLabel("Shop Item Title");
		shopPanelSixLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelSixLabel.setBounds(10, 11, 288, 25);
		shopPanelSix.add(shopPanelSixLabel);
		
		shopPanelSixDescription = new JTextPane();
		shopPanelSixDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelSixDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelSixDescription.setBounds(10, 44, 268, 168);
		shopPanelSix.add(shopPanelSixDescription);
		
		JButton shopPanelSixButton = new JButton("Purchase");
		shopPanelSixButton.setBackground(new Color(248, 248, 255));
		shopPanelSixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(6);
			}
		});
		shopPanelSixButton.setBounds(10, 223, 268, 66);
		shopPanelSix.add(shopPanelSixButton);
		
		JPanel shopPanelSeven = new JPanel();
		shopPanelSeven.setLayout(null);
		shopPanelSeven.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelSeven);
		
		shopPanelSevenLabel = new JLabel("Shop Item Title");
		shopPanelSevenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelSevenLabel.setBounds(10, 11, 288, 25);
		shopPanelSeven.add(shopPanelSevenLabel);
		
		shopPanelSevenDescription = new JTextPane();
		shopPanelSevenDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelSevenDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelSevenDescription.setBounds(10, 44, 268, 168);
		shopPanelSeven.add(shopPanelSevenDescription);
		
		JButton shopPanelSevenButton = new JButton("Purchase");
		shopPanelSevenButton.setBackground(new Color(248, 248, 255));
		shopPanelSevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(7);
			}
		});
		shopPanelSevenButton.setBounds(10, 223, 268, 66);
		shopPanelSeven.add(shopPanelSevenButton);
		
		JPanel shopPanelEight = new JPanel();
		shopPanelEight.setLayout(null);
		shopPanelEight.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelEight);
		
		shopPanelEightLabel = new JLabel("Shop Item Title");
		shopPanelEightLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelEightLabel.setBounds(10, 11, 288, 25);
		shopPanelEight.add(shopPanelEightLabel);
		
		shopPanelEightDescription = new JTextPane();
		shopPanelEightDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelEightDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelEightDescription.setBounds(10, 44, 268, 168);
		shopPanelEight.add(shopPanelEightDescription);
		
		JButton shopPanelEightButton = new JButton("Purchase");
		shopPanelEightButton.setBackground(new Color(248, 248, 255));
		shopPanelEightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(8);
			}
		});
		shopPanelEightButton.setBounds(10, 223, 268, 66);
		shopPanelEight.add(shopPanelEightButton);
		
		JPanel shopPanelNine = new JPanel();
		shopPanelNine.setLayout(null);
		shopPanelNine.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelNine);
		
		shopPanelNineLabel = new JLabel("Shop Item Title");
		shopPanelNineLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelNineLabel.setBounds(10, 11, 288, 25);
		shopPanelNine.add(shopPanelNineLabel);
		
		shopPanelNineDescription = new JTextPane();
		shopPanelNineDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelNineDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelNineDescription.setBounds(10, 44, 268, 168);
		shopPanelNine.add(shopPanelNineDescription);
		
		JButton shopPanelNineButton = new JButton("Purchase");
		shopPanelNineButton.setBackground(new Color(248, 248, 255));
		shopPanelNineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(9);
			}
		});
		shopPanelNineButton.setBounds(10, 223, 268, 66);
		shopPanelNine.add(shopPanelNineButton);
		
		JPanel shopPanelTen = new JPanel();
		shopPanelTen.setLayout(null);
		shopPanelTen.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelTen);
		
		shopPanelTenLabel = new JLabel("Shop Item Title");
		shopPanelTenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelTenLabel.setBounds(10, 11, 288, 25);
		shopPanelTen.add(shopPanelTenLabel);
		
		shopPanelTenDescription = new JTextPane();
		shopPanelTenDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelTenDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelTenDescription.setBounds(10, 44, 268, 168);
		shopPanelTen.add(shopPanelTenDescription);
		
		JButton shopPanelTenButton = new JButton("Purchase");
		shopPanelTenButton.setBackground(new Color(248, 248, 255));
		shopPanelTenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(10);
			}
		});
		shopPanelTenButton.setBounds(10, 223, 268, 66);
		shopPanelTen.add(shopPanelTenButton);
		
		JPanel shopPanelEleven = new JPanel();
		shopPanelEleven.setLayout(null);
		shopPanelEleven.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelEleven);
		
		shopPanelElevenLabel = new JLabel("Shop Item Title");
		shopPanelElevenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelElevenLabel.setBounds(10, 11, 288, 25);
		shopPanelEleven.add(shopPanelElevenLabel);
		
		shopPanelElevenDescription = new JTextPane();
		shopPanelElevenDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelElevenDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelElevenDescription.setBounds(10, 44, 268, 168);
		shopPanelEleven.add(shopPanelElevenDescription);
		
		JButton shopPanelElevenButton = new JButton("Purchase");
		shopPanelElevenButton.setBackground(new Color(248, 248, 255));
		shopPanelElevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(11);
			}
		});
		shopPanelElevenButton.setBounds(10, 223, 268, 66);
		shopPanelEleven.add(shopPanelElevenButton);
		
		JPanel shopPanelTwelve = new JPanel();
		shopPanelTwelve.setLayout(null);
		shopPanelTwelve.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelTwelve);
		
		shopPanelTwelveLabel = new JLabel("Shop Item Title");
		shopPanelTwelveLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelTwelveLabel.setBounds(10, 11, 288, 25);
		shopPanelTwelve.add(shopPanelTwelveLabel);
		
		shopPanelTwelveDescription = new JTextPane();
		shopPanelTwelveDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelTwelveDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelTwelveDescription.setBounds(10, 44, 268, 168);
		shopPanelTwelve.add(shopPanelTwelveDescription);
		
		JButton shopPanelTwelveButton = new JButton("Purchase");
		shopPanelTwelveButton.setBackground(new Color(248, 248, 255));
		shopPanelTwelveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(12);
			}
		});
		shopPanelTwelveButton.setBounds(10, 223, 268, 66);
		shopPanelTwelve.add(shopPanelTwelveButton);
		
		JPanel shopPanelThirteen = new JPanel();
		shopPanelThirteen.setLayout(null);
		shopPanelThirteen.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelThirteen);
		
		shopPanelThirteenLabel = new JLabel("Shop Item Title");
		shopPanelThirteenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelThirteenLabel.setBounds(10, 11, 288, 25);
		shopPanelThirteen.add(shopPanelThirteenLabel);
		
		shopPanelThirteenDescription = new JTextPane();
		shopPanelThirteenDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelThirteenDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelThirteenDescription.setBounds(10, 44, 268, 168);
		shopPanelThirteen.add(shopPanelThirteenDescription);
		
		JButton shopPanelThirteenButton = new JButton("Purchase");
		shopPanelThirteenButton.setBackground(new Color(248, 248, 255));
		shopPanelThirteenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(13);
			}
		});
		shopPanelThirteenButton.setBounds(10, 223, 268, 66);
		shopPanelThirteen.add(shopPanelThirteenButton);
		
		JPanel shopPanelFourteen = new JPanel();
		shopPanelFourteen.setLayout(null);
		shopPanelFourteen.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelFourteen);
		
		shopPanelFourteenLabel = new JLabel("Shop Item Title");
		shopPanelFourteenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelFourteenLabel.setBounds(10, 11, 288, 25);
		shopPanelFourteen.add(shopPanelFourteenLabel);
		
		shopPanelFourteenDescription = new JTextPane();
		shopPanelFourteenDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelFourteenDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelFourteenDescription.setBounds(10, 44, 268, 168);
		shopPanelFourteen.add(shopPanelFourteenDescription);
		
		JButton shopPanelFourteenButton = new JButton("Purchase");
		shopPanelFourteenButton.setBackground(new Color(248, 248, 255));
		shopPanelFourteenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(14);
			}
		});
		shopPanelFourteenButton.setBounds(10, 223, 268, 66);
		shopPanelFourteen.add(shopPanelFourteenButton);
		
		JPanel shopPanelFifteen = new JPanel();
		shopPanelFifteen.setLayout(null);
		shopPanelFifteen.setBackground(new Color(255, 255, 240));
		shopShopPanel.add(shopPanelFifteen);
		
		shopPanelFifteenLabel = new JLabel("Shop Item Title");
		shopPanelFifteenLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		shopPanelFifteenLabel.setBounds(10, 11, 288, 25);
		shopPanelFifteen.add(shopPanelFifteenLabel);
		
		shopPanelFifteenDescription = new JTextPane();
		shopPanelFifteenDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		shopPanelFifteenDescription.setText("Cost: \r\nAtribute a\r\nAtribute b\r\nMoney returned");
		shopPanelFifteenDescription.setBounds(10, 44, 268, 168);
		shopPanelFifteen.add(shopPanelFifteenDescription);
		
		JButton shopPanelFifteenButton = new JButton("Purchase");
		shopPanelFifteenButton.setBackground(new Color(248, 248, 255));
		shopPanelFifteenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				purchaseFromShop(15);
			}
		});
		shopPanelFifteenButton.setBounds(10, 223, 268, 66);
		shopPanelFifteen.add(shopPanelFifteenButton);
		shopPanel.setVisible(false);
		//mainGamePanel.setVisible(false);
		
		setUpScreenPanel = new JPanel();
		setUpScreenPanel.setBackground(new Color(255, 255, 204));
		setUpScreenPanel.setBounds(0, 0, 1904, 1041);
		frame.getContentPane().add(setUpScreenPanel);
		setUpScreenPanel.setLayout(null);
		
		JPanel setUpScreenDaysSelectionPanel = new JPanel();
		setUpScreenDaysSelectionPanel.setBackground(new Color(250, 240, 230));
		setUpScreenDaysSelectionPanel.setBounds(435, 11, 1080, 222);
		setUpScreenPanel.add(setUpScreenDaysSelectionPanel);
		setUpScreenDaysSelectionPanel.setLayout(null);
		
		JLabel setUpScreenSelectDaysLabel = new JLabel("Enter "
		        + "The Number Of Days You Would Like The Game To Last");
		setUpScreenSelectDaysLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		setUpScreenSelectDaysLabel.setBounds(29, 29, 1025, 53);
		setUpScreenDaysSelectionPanel.add(setUpScreenSelectDaysLabel);
		
		setUpScreenNumberOfDaysTextField = new JTextField();
		setUpScreenNumberOfDaysTextField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		setUpScreenNumberOfDaysTextField.setColumns(10);
		setUpScreenNumberOfDaysTextField.setBounds(414, 104, 285, 52);
		setUpScreenDaysSelectionPanel.add(setUpScreenNumberOfDaysTextField);
		
		setUpScreenIllegalNumberLabel = new JLabel("");
		setUpScreenIllegalNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setUpScreenIllegalNumberLabel.setBounds(187, 167, 742, 22);
		setUpScreenDaysSelectionPanel.add(setUpScreenIllegalNumberLabel);
		
		JButton setUpScreenConfirmationButton = new JButton("Confirm");
		setUpScreenConfirmationButton.setBackground(new Color(240, 255, 240));
		setUpScreenConfirmationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkValidSetupScreenInputs();
			}
		});
		setUpScreenConfirmationButton.setFont(new Font("Tahoma", Font.PLAIN, 39));
		setUpScreenConfirmationButton.setBounds(1587, 816, 272, 111);
		setUpScreenPanel.add(setUpScreenConfirmationButton);
		
		JPanel setUpScreenFarmerNamePanel = new JPanel();
		setUpScreenFarmerNamePanel.setBackground(new Color(250, 240, 230));
		setUpScreenFarmerNamePanel.setBounds(435, 244, 1080, 181);
		setUpScreenPanel.add(setUpScreenFarmerNamePanel);
		setUpScreenFarmerNamePanel.setLayout(null);
		
		JLabel setUpScreenFarmerNameLabel = new JLabel("Enter A Name For Your Farmer");
		setUpScreenFarmerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		setUpScreenFarmerNameLabel.setBounds(296, 11, 509, 53);
		setUpScreenFarmerNamePanel.add(setUpScreenFarmerNameLabel);
		
		setUpScreenFarmerNameTextFeild = new JTextField();
		setUpScreenFarmerNameTextFeild.setFont(new Font("Tahoma", Font.PLAIN, 26));
		setUpScreenFarmerNameTextFeild.setBounds(423, 75, 285, 52);
		setUpScreenFarmerNamePanel.add(setUpScreenFarmerNameTextFeild);
		setUpScreenFarmerNameTextFeild.setColumns(10);
		
		setUpScreenIlegalFarmerNameLabel = new JLabel("");
		setUpScreenIlegalFarmerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setUpScreenIlegalFarmerNameLabel.setBounds(152, 138, 818, 22);
		setUpScreenFarmerNamePanel.add(setUpScreenIlegalFarmerNameLabel);
		
		JPanel setUpScreenFarmNamePanel = new JPanel();
		setUpScreenFarmNamePanel.setBackground(new Color(250, 240, 230));
		setUpScreenFarmNamePanel.setLayout(null);
		setUpScreenFarmNamePanel.setBounds(435, 436, 1080, 181);
		setUpScreenPanel.add(setUpScreenFarmNamePanel);
		
		JLabel setUpScreenFarmNameLabel = new JLabel("Enter A Name For Your Farm");
		setUpScreenFarmNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		setUpScreenFarmNameLabel.setBounds(303, 11, 509, 53);
		setUpScreenFarmNamePanel.add(setUpScreenFarmNameLabel);
		
		setUpScreenFarmNameTextField = new JTextField();
		setUpScreenFarmNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		setUpScreenFarmNameTextField.setColumns(10);
		setUpScreenFarmNameTextField.setBounds(423, 75, 285, 52);
		setUpScreenFarmNamePanel.add(setUpScreenFarmNameTextField);
		
		setUpScreenIllegalFarmNameLabel = new JLabel("");
		setUpScreenIllegalFarmNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setUpScreenIllegalFarmNameLabel.setBounds(168, 138, 805, 22);
		setUpScreenFarmNamePanel.add(setUpScreenIllegalFarmNameLabel);
		
		JPanel setUpScreenFarmTypePanel = new JPanel();
		setUpScreenFarmTypePanel.setBackground(new Color(250, 240, 230));
		setUpScreenFarmTypePanel.setLayout(null);
		setUpScreenFarmTypePanel.setBounds(435, 628, 1080, 390);
		setUpScreenPanel.add(setUpScreenFarmTypePanel);
		
		JLabel setUpScreenSelectFarmTypeLabel = new JLabel("Select A Farm Type");
		setUpScreenSelectFarmTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		setUpScreenSelectFarmTypeLabel.setBounds(387, 0, 334, 53);
		setUpScreenFarmTypePanel.add(setUpScreenSelectFarmTypeLabel);
		
		JPanel setUpScreenRadioButtonPanel = new JPanel();
		setUpScreenRadioButtonPanel.setBackground(new Color(250, 240, 230));
		setUpScreenRadioButtonPanel.setBounds(10, 299, 1060, 80);
		setUpScreenFarmTypePanel.add(setUpScreenRadioButtonPanel);
		setUpScreenRadioButtonPanel.setLayout(null);
		
		rdbtnFarmSelectBetterAnimals = new JRadioButton("Better Animals");
		rdbtnFarmSelectBetterAnimals.setBackground(new Color(250, 235, 215));
		gameSetupFarmTypeButtons.add(rdbtnFarmSelectBetterAnimals);
		rdbtnFarmSelectBetterAnimals.setBounds(322, 7, 109, 23);
		setUpScreenRadioButtonPanel.add(rdbtnFarmSelectBetterAnimals);
		
		rdbtnFarmSelectStartingCash = new JRadioButton("Starting Cash");
		rdbtnFarmSelectStartingCash.setBackground(new Color(250, 235, 215));
		gameSetupFarmTypeButtons.add(rdbtnFarmSelectStartingCash);
		rdbtnFarmSelectStartingCash.setBounds(594, 7, 109, 23);
		setUpScreenRadioButtonPanel.add(rdbtnFarmSelectStartingCash);
		
		rdbtnFarmSelectHardMode = new JRadioButton("Hard Mode");
		rdbtnFarmSelectHardMode.setBackground(new Color(250, 235, 215));
		gameSetupFarmTypeButtons.add(rdbtnFarmSelectHardMode);
		rdbtnFarmSelectHardMode.setBounds(858, 7, 109, 23);
		setUpScreenRadioButtonPanel.add(rdbtnFarmSelectHardMode);
		
		rdbtnFarmSelectFastCrops = new JRadioButton("Fast Crops");
		rdbtnFarmSelectFastCrops.setBackground(new Color(250, 235, 215));
		rdbtnFarmSelectFastCrops.setSelected(true);
		rdbtnFarmSelectFastCrops.setBounds(73, 7, 109, 23);
		gameSetupFarmTypeButtons.add(rdbtnFarmSelectFastCrops);
		setUpScreenRadioButtonPanel.add(rdbtnFarmSelectFastCrops);
		
		JPanel setUpScreenStartingCashPanel = new JPanel();
		setUpScreenStartingCashPanel.setBackground(new Color(250, 240, 230));
		setUpScreenStartingCashPanel.setLayout(null);
		setUpScreenStartingCashPanel.setBounds(546, 53, 258, 235);
		setUpScreenFarmTypePanel.add(setUpScreenStartingCashPanel);
		
		JTextPane txtpnMoreStartingCash = new JTextPane();
		txtpnMoreStartingCash.setEditable(false);
		txtpnMoreStartingCash.setText("Starting Cash: $400\r\nCrop Growth Multiplier: 0.8x\r\nAnimals Health Lost Each Day: 10%\r\nAnimal Happiness  Lost Each Day: 10%\r\n\r\n");
		txtpnMoreStartingCash.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnMoreStartingCash.setBounds(10, 11, 238, 213);
		setUpScreenStartingCashPanel.add(txtpnMoreStartingCash);
		
		JPanel setUpScreenHardModePanel = new JPanel();
		setUpScreenHardModePanel.setBackground(new Color(250, 240, 230));
		setUpScreenHardModePanel.setLayout(null);
		setUpScreenHardModePanel.setBounds(814, 53, 256, 235);
		setUpScreenFarmTypePanel.add(setUpScreenHardModePanel);
		
		JTextPane txtpnHardMode = new JTextPane();
		txtpnHardMode.setEditable(false);
		txtpnHardMode.setText("Starting Cash: $200\r\nCrop Growth Multiplier: 0.8x\r\nAnimals Health Lost Each Day: 15%\r\nAnimal Happiness  Lost Each Day: 15%\r\n\r\n");
		txtpnHardMode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnHardMode.setBounds(10, 11, 238, 213);
		setUpScreenHardModePanel.add(txtpnHardMode);
		
		JPanel setUpScreenBetterAnimalsPanel = new JPanel();
		setUpScreenBetterAnimalsPanel.setBackground(new Color(250, 240, 230));
		setUpScreenBetterAnimalsPanel.setLayout(null);
		setUpScreenBetterAnimalsPanel.setBounds(278, 53, 258, 235);
		setUpScreenFarmTypePanel.add(setUpScreenBetterAnimalsPanel);
		
		JTextPane txtpnBetterAnimals = new JTextPane();
		txtpnBetterAnimals.setEditable(false);
		txtpnBetterAnimals.setText("Starting Cash: $200\r\nCrop Growth Multiplier: 1x\r\nAnimals Health Lost Each Day: 5%\r\nAnimal Happiness  Lost Each Day: 5%\r\n\r\n");
		txtpnBetterAnimals.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnBetterAnimals.setBounds(10, 11, 238, 213);
		setUpScreenBetterAnimalsPanel.add(txtpnBetterAnimals);
		
		JPanel setUpScreenFastCropsPanel = new JPanel();
		setUpScreenFastCropsPanel.setBackground(new Color(250, 240, 230));
		setUpScreenFastCropsPanel.setLayout(null);
		setUpScreenFastCropsPanel.setBounds(10, 53, 258, 235);
		setUpScreenFarmTypePanel.add(setUpScreenFastCropsPanel);
		
		JTextPane txtpnFastCropsGives = new JTextPane();
		txtpnFastCropsGives.setEditable(false);
		txtpnFastCropsGives.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnFastCropsGives.setText("Starting Cash: $200\r\nCrop Growth Multiplier: 2x\r\nAnimals Health Lost Each Day: 10%\r\nAnimal Happiness  Lost Each Day: 10%\r\n\r\n");
		txtpnFastCropsGives.setBounds(10, 11, 238, 213);
		setUpScreenFastCropsPanel.add(txtpnFastCropsGives);
		setUpScreenPanel.setVisible(false);
		
		loadInPanel = new JPanel();
		loadInPanel.setBackground(new Color(255, 222, 173));
		loadInPanel.setBounds(0, 0, 1904, 1041);
		frame.getContentPane().add(loadInPanel);
		loadInPanel.setLayout(null);
		
		JButton loadInNewGameButton = new JButton("New Game");
		loadInNewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newGameSetup();
			}
		});
		loadInNewGameButton.setBackground(new Color(255, 182, 193));
		loadInNewGameButton.setFont(new Font("Tahoma", Font.PLAIN, 44));
		loadInNewGameButton.setBounds(423, 344, 476, 234);
		loadInPanel.add(loadInNewGameButton);
		
		loadInLoadGameButton = new JButton("Load Game");
		loadInLoadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadGame();
			}
		});
		loadInLoadGameButton.setFont(new Font("Tahoma", Font.PLAIN, 44));
		loadInLoadGameButton.setBackground(new Color(216, 191, 216));
		loadInLoadGameButton.setBounds(1032, 344, 476, 234);
		loadInPanel.add(loadInLoadGameButton);
		
		loadInErrorLabel = new JLabel("");
		loadInErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadInErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		loadInErrorLabel.setBounds(508, 140, 923, 88);
		loadInPanel.add(loadInErrorLabel);
		
		JLabel lblNewLabel = new JLabel("Welcome To Farming Simulator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(681, 24, 934, 88);
		loadInPanel.add(lblNewLabel);
		loadInPanel.setVisible(true);
		
		gameEndPanel = new JPanel();
		gameEndPanel.setBackground(new Color(240, 255, 240));
		gameEndPanel.setBounds(0, 0, 1904, 1041);
		frame.getContentPane().add(gameEndPanel);
		gameEndPanel.setLayout(null);
		
		JPanel gameEndHeaderPanel = new JPanel();
		gameEndHeaderPanel.setBounds(400, 0, 1080, 197);
		gameEndHeaderPanel.setBackground(new Color(255, 255, 224));
		gameEndPanel.add(gameEndHeaderPanel);
		gameEndHeaderPanel.setLayout(new GridLayout(3, 0, 0, 1));
		
		JLabel gameEndGameEndLabel = new JLabel("Game End");
		gameEndGameEndLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameEndGameEndLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		gameEndHeaderPanel.add(gameEndGameEndLabel);
		
		gameEndUserName = new JLabel("New label");
		gameEndUserName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		gameEndUserName.setHorizontalAlignment(SwingConstants.CENTER);
		gameEndHeaderPanel.add(gameEndUserName);
		
		JPanel gameEndScorePanel = new JPanel();
		gameEndScorePanel.setBounds(706, 197, 508, 452);
		gameEndPanel.add(gameEndScorePanel);
		gameEndScorePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		gameEndScoreTextPane = new JTextPane();
		gameEndScoreTextPane.setEditable(false);
		gameEndScoreTextPane.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gameEndScorePanel.add(gameEndScoreTextPane);
		
		JButton gameEndNewGameButton = new JButton("New Game");
		gameEndNewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restartGame();
			}
		});
		gameEndNewGameButton.setBackground(new Color(250, 240, 230));
		gameEndNewGameButton.setFont(new Font("Tahoma", Font.PLAIN, 52));
		gameEndNewGameButton.setBounds(1371, 735, 391, 157);
		gameEndPanel.add(gameEndNewGameButton);
		
		mainGamePanel = new JPanel();
		mainGamePanel.setBackground(new Color(255, 245, 238));
		mainGamePanel.setBounds(0, 0, 1904, 1041);
		frame.getContentPane().add(mainGamePanel);
		mainGamePanel.setLayout(null);
		
		JPanel mainMoneyPanel = new JPanel();
		mainMoneyPanel.setBackground(new Color(255, 250, 250));
		mainMoneyPanel.setBounds(1604, 0, 300, 100);
		mainGamePanel.add(mainMoneyPanel);
		mainMoneyPanel.setLayout(null);
		
		mainMoneyLabel = new JLabel("$0");
		mainMoneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainMoneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mainMoneyLabel.setBounds(0, 33, 300, 56);
		mainMoneyPanel.add(mainMoneyLabel);
		
		JPanel mainDailyActionsPanel = new JPanel();
		mainDailyActionsPanel.setBackground(new Color(255, 255, 224));
		mainDailyActionsPanel.setBounds(1454, 0, 150, 100);
		mainGamePanel.add(mainDailyActionsPanel);
		mainDailyActionsPanel.setLayout(null);
		
		JLabel mainDailyActionsLabel = new JLabel("Actions Remaining\r\n");
		mainDailyActionsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		mainDailyActionsLabel.setBounds(7, 25, 144, 24);
		mainDailyActionsPanel.add(mainDailyActionsLabel);
		
		mainDailyActionsRemaningLabel = new JLabel("0");
		mainDailyActionsRemaningLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		mainDailyActionsRemaningLabel.setBounds(67, 43, 36, 35);
		mainDailyActionsPanel.add(mainDailyActionsRemaningLabel);
		
		JPanel mainDayPanel = new JPanel();
		mainDayPanel.setBackground(new Color(224, 255, 255));
		mainDayPanel.setBounds(1304, 0, 150, 100);
		mainGamePanel.add(mainDayPanel);
		mainDayPanel.setLayout(null);
		
		mainDayLabel = new JLabel("Day");
		mainDayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainDayLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainDayLabel.setBounds(10, 28, 109, 50);
		mainDayPanel.add(mainDayLabel);
		
		JPanel mainNextDayPanel = new JPanel();
		mainNextDayPanel.setBounds(1604, 941, 300, 100);
		mainGamePanel.add(mainNextDayPanel);
		mainNextDayPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("Next Day");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goNextDay();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButton.setBackground(new Color(255, 235, 205));
		btnNewButton.setBounds(0, 0, 300, 100);
		mainNextDayPanel.add(btnNewButton);
		
		JPanel mainVisitShopPanel = new JPanel();
		mainVisitShopPanel.setBounds(1304, 100, 150, 100);
		mainGamePanel.add(mainVisitShopPanel);
		mainVisitShopPanel.setLayout(null);
		
		JButton mainVisitShopButton = new JButton("Visit Shop");
		mainVisitShopButton.setBackground(new Color(230, 230, 250));
		mainVisitShopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeToShopScreen();
			}
		});
		mainVisitShopButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		mainVisitShopButton.setBounds(0, 0, 150, 100);
		mainVisitShopPanel.add(mainVisitShopButton);
		
		JPanel mainAnimalPanel = new JPanel();
		mainAnimalPanel.setBounds(716, 211, 888, 830);
		mainGamePanel.add(mainAnimalPanel);
		mainAnimalPanel.setLayout(new GridLayout(2, 2, 5, 5));
		
		JPanel mainAnimalOnePanel = new JPanel();
		mainAnimalOnePanel.setBackground(new Color(250, 250, 210));
		mainAnimalPanel.add(mainAnimalOnePanel);
		mainAnimalOnePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainAnimalOneLabel = new JLabel("Animal Pen 1");
		mainAnimalOneLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		mainAnimalOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainAnimalOnePanel.add(mainAnimalOneLabel, BorderLayout.NORTH);
		
		JPanel mainAnimalOneSubPanel = new JPanel();
		mainAnimalOneSubPanel.setBackground(new Color(255, 239, 213));
		mainAnimalOnePanel.add(mainAnimalOneSubPanel, BorderLayout.SOUTH);
		mainAnimalOneSubPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalOneDescription = new JTextPane();
		mainAnimalOneSubPanel.add(mainAnimalOneDescription);
		mainAnimalOneDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainAnimalOneDescription.setEditable(false);
		
		JPanel mainAnimalOneImagePanel = new JPanel();
		mainAnimalOneImagePanel.setBackground(new Color(255, 240, 245));
		mainAnimalOnePanel.add(mainAnimalOneImagePanel, BorderLayout.CENTER);
		mainAnimalOneImagePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalOneIconLabel = new JLabel("");
		mainAnimalOneIconLabel.setIcon(null);
		mainAnimalOneImagePanel.add(mainAnimalOneIconLabel);
		
		JPanel mainAnimalTwoPanel = new JPanel();
		mainAnimalTwoPanel.setBackground(new Color(250, 250, 210));
		mainAnimalPanel.add(mainAnimalTwoPanel);
		mainAnimalTwoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainAnimalTwoLabel = new JLabel("Animal Pen 2");
		mainAnimalTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainAnimalTwoLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		mainAnimalTwoPanel.add(mainAnimalTwoLabel, BorderLayout.NORTH);
		
		JPanel mainAnimalTwoSubPanel = new JPanel();
		mainAnimalTwoSubPanel.setBackground(new Color(255, 239, 213));
		mainAnimalTwoPanel.add(mainAnimalTwoSubPanel, BorderLayout.SOUTH);
		mainAnimalTwoSubPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalTwoDescription = new JTextPane();
		mainAnimalTwoSubPanel.add(mainAnimalTwoDescription);
		mainAnimalTwoDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainAnimalTwoDescription.setEditable(false);
		
		JPanel mainAnimalTwoIconPanel = new JPanel();
		mainAnimalTwoIconPanel.setBackground(new Color(255, 240, 245));
		mainAnimalTwoPanel.add(mainAnimalTwoIconPanel, BorderLayout.CENTER);
		mainAnimalTwoIconPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalTwoIconLabel = new JLabel("");
		mainAnimalTwoIconLabel.setIcon(null);
		mainAnimalTwoIconPanel.add(mainAnimalTwoIconLabel);
		
		JPanel mainAnimalThreePanel = new JPanel();
		mainAnimalThreePanel.setBackground(new Color(250, 250, 210));
		mainAnimalPanel.add(mainAnimalThreePanel);
		mainAnimalThreePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainAnimalThreeLabel = new JLabel("Animal Pen 3");
		mainAnimalThreeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainAnimalThreeLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		mainAnimalThreePanel.add(mainAnimalThreeLabel, BorderLayout.NORTH);
		
		JPanel mainAnimalThreeSubPanel = new JPanel();
		mainAnimalThreeSubPanel.setBackground(new Color(255, 239, 213));
		mainAnimalThreePanel.add(mainAnimalThreeSubPanel, BorderLayout.SOUTH);
		mainAnimalThreeSubPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalThreeDescription = new JTextPane();
		mainAnimalThreeSubPanel.add(mainAnimalThreeDescription);
		mainAnimalThreeDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainAnimalThreeDescription.setEditable(false);
		
		JPanel mainAnimalThreeIconPanel = new JPanel();
		mainAnimalThreeIconPanel.setBackground(new Color(255, 240, 245));
		mainAnimalThreePanel.add(mainAnimalThreeIconPanel, BorderLayout.CENTER);
		mainAnimalThreeIconPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalThreeIconLabel = new JLabel("");
		mainAnimalThreeIconLabel.setIcon(null);
		mainAnimalThreeIconPanel.add(mainAnimalThreeIconLabel);
		
		JPanel mainAnimalFourPanel = new JPanel();
		mainAnimalFourPanel.setBackground(new Color(250, 250, 210));
		mainAnimalPanel.add(mainAnimalFourPanel);
		mainAnimalFourPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainAnimalFourLabel = new JLabel("Animal Pen 4");
		mainAnimalFourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainAnimalFourLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		mainAnimalFourPanel.add(mainAnimalFourLabel, BorderLayout.NORTH);
		
		JPanel mainAnimalFourSubPanel = new JPanel();
		mainAnimalFourSubPanel.setBackground(new Color(255, 239, 213));
		mainAnimalFourPanel.add(mainAnimalFourSubPanel, BorderLayout.SOUTH);
		mainAnimalFourSubPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalFourDescription = new JTextPane();
		mainAnimalFourSubPanel.add(mainAnimalFourDescription);
		mainAnimalFourDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		mainAnimalFourDescription.setEditable(false);
		
		JPanel mainAnimalFourIconPanel = new JPanel();
		mainAnimalFourIconPanel.setBackground(new Color(255, 240, 245));
		mainAnimalFourPanel.add(mainAnimalFourIconPanel, BorderLayout.CENTER);
		mainAnimalFourIconPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		mainAnimalFourIconLabel = new JLabel("");
		mainAnimalFourIconLabel.setIcon(null);
		mainAnimalFourIconPanel.add(mainAnimalFourIconLabel);
		
		JPanel mainActionsPanel = new JPanel();
		mainActionsPanel.setBackground(new Color(255, 239, 213));
		mainActionsPanel.setBounds(1604, 100, 300, 841);
		mainGamePanel.add(mainActionsPanel);
		mainActionsPanel.setLayout(null);
		
		mainActionListPanel = new JPanel();
		mainActionListPanel.setBackground(new Color(224, 255, 255));
		mainActionListPanel.setBounds(10, 65, 280, 665);
		mainActionsPanel.add(mainActionListPanel);
		mainActionListPanel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel mainConfirmActionPanel = new JPanel();
		mainConfirmActionPanel.setBounds(0, 741, 300, 100);
		mainActionsPanel.add(mainConfirmActionPanel);
		mainConfirmActionPanel.setLayout(null);
		
		mainConfirmActionButton = new JButton("Confirm Action");
		mainConfirmActionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkActionSelected();
			}
		});
		mainConfirmActionButton.setBounds(0, 2, 300, 98);
		mainConfirmActionButton.setBackground(new Color(255, 222, 173));
		mainConfirmActionButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mainConfirmActionPanel.add(mainConfirmActionButton);
		
		mainConfirmCropSelectionButton = new JButton("Confirm Crop Selection");
		mainConfirmCropSelectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tendCrop();
			}
		});
		mainConfirmCropSelectionButton.setBounds(0, 0, 300, 98);
		mainConfirmActionPanel.add(mainConfirmCropSelectionButton);
		mainConfirmCropSelectionButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mainConfirmCropSelectionButton.setBackground(new Color(255, 222, 173));
		
		mainActionLabel = new JLabel("Select Action:");
		mainActionLabel.setBounds(0, 0, 300, 60);
		mainActionsPanel.add(mainActionLabel);
		mainActionLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainActionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel mainFarmPanel = new JPanel();
		mainFarmPanel.setBackground(new Color(255, 228, 196));
		mainFarmPanel.setBounds(0, 0, 706, 1041);
		mainGamePanel.add(mainFarmPanel);
		mainFarmPanel.setLayout(new GridLayout(4, 1, 0, 5));
		
		JPanel mainFarmOnePanel = new JPanel();
		mainFarmOnePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainFarmOnePanel.setBackground(new Color(222, 184, 135));
		mainFarmPanel.add(mainFarmOnePanel);
		mainFarmOnePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainFieldOneLabel = new JLabel("Field One");
		mainFieldOneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainFieldOneLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFarmOnePanel.add(mainFieldOneLabel, BorderLayout.NORTH);
		
		JPanel mainFieldOnePanel = new JPanel();
		mainFieldOnePanel.setBackground(new Color(222, 184, 135));
		mainFarmOnePanel.add(mainFieldOnePanel, BorderLayout.CENTER);
		mainFieldOnePanel.setLayout(new BorderLayout(0, 0));
		
		mainFieldOneDescription = new JTextPane();
		mainFieldOneDescription.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mainFieldOnePanel.add(mainFieldOneDescription, BorderLayout.WEST);
		mainFieldOneDescription.setEditable(false);
		mainFieldOneDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFieldOneDescription.setBackground(new Color(222, 184, 135));
		
		JPanel mainFieldOneIconPanel = new JPanel();
		mainFieldOneIconPanel.setBackground(new Color(222, 184, 135));
		mainFieldOnePanel.add(mainFieldOneIconPanel, BorderLayout.EAST);
		
		mainFieldOneIcon = new JLabel("");
		mainFieldOneIcon.setIcon(null);
		mainFieldOneIconPanel.add(mainFieldOneIcon);
		
		JPanel mainFarmTwoPanel = new JPanel();
		mainFarmTwoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainFarmTwoPanel.setBackground(new Color(222, 184, 135));
		mainFarmPanel.add(mainFarmTwoPanel);
		mainFarmTwoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainFieldTwoLabel = new JLabel("Field Two");
		mainFieldTwoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainFieldTwoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFarmTwoPanel.add(mainFieldTwoLabel, BorderLayout.NORTH);
		
		JPanel mainFieldTwoPanel = new JPanel();
		mainFieldTwoPanel.setBackground(new Color(222, 184, 135));
		mainFarmTwoPanel.add(mainFieldTwoPanel, BorderLayout.CENTER);
		mainFieldTwoPanel.setLayout(new BorderLayout(0, 0));
		
		mainFieldTwoDescription = new JTextPane();
		mainFieldTwoPanel.add(mainFieldTwoDescription, BorderLayout.WEST);
		mainFieldTwoDescription.setEditable(false);
		mainFieldTwoDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFieldTwoDescription.setBackground(new Color(222, 184, 135));
		
		JPanel mainFieldTwoIconPanel = new JPanel();
		mainFieldTwoIconPanel.setBackground(new Color(222, 184, 135));
		mainFieldTwoPanel.add(mainFieldTwoIconPanel, BorderLayout.EAST);
		
		mainFieldTwoIcon = new JLabel("");
		mainFieldTwoIcon.setIcon(null);
		mainFieldTwoIconPanel.add(mainFieldTwoIcon);
		
		JPanel mainFarmThreePanel = new JPanel();
		mainFarmThreePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainFarmThreePanel.setBackground(new Color(222, 184, 135));
		mainFarmPanel.add(mainFarmThreePanel);
		mainFarmThreePanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainFieldThreeLabel = new JLabel("Field Three");
		mainFieldThreeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainFieldThreeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFarmThreePanel.add(mainFieldThreeLabel, BorderLayout.NORTH);
		
		JPanel mainFieldThreePanel = new JPanel();
		mainFieldThreePanel.setBackground(new Color(222, 184, 135));
		mainFarmThreePanel.add(mainFieldThreePanel, BorderLayout.CENTER);
		mainFieldThreePanel.setLayout(new BorderLayout(0, 0));
		
		mainFieldThreeDescription = new JTextPane();
		mainFieldThreePanel.add(mainFieldThreeDescription, BorderLayout.WEST);
		mainFieldThreeDescription.setEditable(false);
		mainFieldThreeDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFieldThreeDescription.setBackground(new Color(222, 184, 135));
		
		JPanel mainFieldThreeIconPanel = new JPanel();
		mainFieldThreeIconPanel.setBackground(new Color(222, 184, 135));
		mainFieldThreePanel.add(mainFieldThreeIconPanel, BorderLayout.EAST);
		
		mainFieldThreeIcon = new JLabel("");
		mainFieldThreeIconPanel.add(mainFieldThreeIcon);
		
		JPanel mainFarmFourPanel = new JPanel();
		mainFarmFourPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mainFarmFourPanel.setBackground(new Color(222, 184, 135));
		mainFarmPanel.add(mainFarmFourPanel);
		mainFarmFourPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel mainFieldFourLabel = new JLabel("Field Four");
		mainFieldFourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainFieldFourLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFarmFourPanel.add(mainFieldFourLabel, BorderLayout.NORTH);
		
		JPanel mainFieldFourPanel = new JPanel();
		mainFarmFourPanel.add(mainFieldFourPanel, BorderLayout.CENTER);
		mainFieldFourPanel.setBackground(new Color(222, 184, 135));
		mainFieldFourPanel.setLayout(new BorderLayout(0, 0));
		
		mainFieldFourDescription = new JTextPane();
		mainFieldFourPanel.add(mainFieldFourDescription, BorderLayout.WEST);
		mainFieldFourDescription.setText("This field is unuseable until you tend the farm land");
		mainFieldFourDescription.setEditable(false);
		mainFieldFourDescription.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mainFieldFourDescription.setBackground(new Color(222, 184, 135));
		
		JPanel mainFieldFourIconPanel = new JPanel();
		mainFieldFourIconPanel.setBackground(new Color(222, 184, 135));
		mainFieldFourPanel.add(mainFieldFourIconPanel, BorderLayout.EAST);
		
		mainFieldFourIcon = new JLabel("");
		mainFieldFourIcon.setIcon(null);
		mainFieldFourIconPanel.add(mainFieldFourIcon);
		
		mainSaveGameButton = new JButton("Save Game");
		mainSaveGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnviroment.createSaveFile();
			}
		});
		mainSaveGameButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mainSaveGameButton.setBackground(new Color(240, 255, 255));
		mainSaveGameButton.setBounds(994, 0, 204, 100);
		mainGamePanel.add(mainSaveGameButton);
		
				mainGamePanel.setVisible(false);
		
		gameEndPanel.setVisible(false);
	}
	
	
	/**
	 * Checks whether the setUpScreen User inputs are valid.
	 * If valid calls setUpGameState with values from data entry fields on setup screen
	 */
	public void checkValidSetupScreenInputs(){
		boolean validInput = true;
		String farmType = "";
		if(rdbtnFarmSelectBetterAnimals.isSelected()){
			farmType = "Better Animals";
		    }
		else if(rdbtnFarmSelectFastCrops.isSelected()){
			farmType = "Fast Crops";
		    }
		else if(rdbtnFarmSelectStartingCash.isSelected()){
			farmType = "Starting Cash";
			
		    }
		else if(rdbtnFarmSelectHardMode.isSelected()){
			farmType = "Hard Mode";
		    }
		else {
			validInput = false;
		     }
		
		String numOfDays = setUpScreenNumberOfDaysTextField.getText();
		String farmerName = setUpScreenFarmerNameTextFeild.getText();
		String farmName = setUpScreenFarmNameTextField.getText();
		
		if(!gameEnviroment.checkLegalName(farmerName)){
			validInput = false;
			setUpScreenIlegalFarmerNameLabel.setText("Rejected: Farmers name must be between"
			        + " 3 and 15 charters. It must also not contain any special charaters");
		    }
		if(!gameEnviroment.checkLegalName(farmName)){
			validInput = false;
			setUpScreenIllegalFarmNameLabel.setText("Rejected: Farm name must be between 3 "
			        + "and 15 charters. It must also not contain any special charaters");
		     }
		
		int numDays = 0;
		
		if(!gameEnviroment.checkLegalNumberOfDays(numOfDays)){
			validInput = false;
			setUpScreenIllegalNumberLabel.setText("Rejected: Number of days must"
			        + " be an integer between 5 and 10 inclusive");
		    }
		else{
			numDays = Integer.parseInt(numOfDays);
		    }
		
		if(validInput){
			setUpGameState(numDays, farmerName, farmName, farmType);
		    }
		else{
			validInput = true;
		}
		
	}
	
	/**
	 * Sets the gameState to a new GameState object using passed in parameters.
	 * Updates gameEnv gameState to this gameState
	 * Calls changeToMainGameScreen then buildShopScreen
	 * 
	 * @param numOfDays The number of days the fame should last
	 * @param farmerName The name of the farmer
	 * @param farmName The name of the farm
	 * @param farmType The type of the farm
	 */
	public void setUpGameState(int numOfDays, String farmerName, String farmName, String farmType){
		this.gameState = new GameState(numOfDays, farmerName, farmName, farmType);
		this.gameEnviroment.setGameState(this.gameState);
		changeToMainGameScreen();
		buildShopScreen();
	}
	
	
	/**
	 * Changes the current panel the main game panel. Hides
	 * other panels. Calls update main screen
	 */
	public void changeToMainGameScreen(){
		setUpScreenPanel.setVisible(false);
		mainGamePanel.setVisible(true);
		shopPanel.setVisible(false);
		updateMainScreen();
	}
	
	
	/**
	 * Updates all fields on main screen.
	 * Including money label, actions remaining label, day label, animal pens, actions panel, and crop farms.
	 * Then validates and repaints main screen.
	 */
	public void updateMainScreen(){
		mainMoneyLabel.setText("$" + gameState.getFarm().getMoney());
		mainDailyActionsRemaningLabel.setText(Integer.toString(gameState.getActionsLeft()));
		mainDayLabel.setText("Day: " + Integer.toString(gameState.getCurrentDay()));
		updateAnimalPens();
		generateActionButtons();
		mainConfirmActionButton.setVisible(true);
		mainConfirmCropSelectionButton.setVisible(false);
		updateCropFarms();
		mainGamePanel.validate();
		mainGamePanel.repaint();
	}
	
	
	
	/**
	 * Calls gameEnv to check if game can progress to next day.
	 * If it can, calls gameEnv to process next day and updates main screen
	 * Otherwise calls gameEnd
	 */
	public void goNextDay(){
		if(gameEnviroment.checkCanGoNextDay()){
			gameEnviroment.processEndOfDay();
			updateMainScreen();
		    }
		else{
			gameEnd();
		    }
	}	

	
	
	/**
	 * Changes the current panel the shop panel. Hides
	 * main game panel, Resets shop header, calls update shop screen
	 */
	public void changeToShopScreen(){
		mainGamePanel.setVisible(false);
		shopPanel.setVisible(true);
		shopHeaderLabel.setText("General Store");
		updateShopScreen();
	}
	
	
	
	/**
	 * Updates all fields on main screen.
	 * Fields:
	 * shopMoneyLabel
	 * shopOnwedItemsTextPane
	 * shopOwnedCropsTextPane
	 * shopOwnedAnimalsTextPane
	 */
	public void updateShopScreen(){
		shopMoneyLabel.setText("$" + gameState.getFarm().getMoney());
		
		shopOnwedItemsTextPane.setText(gameEnviroment.getItemList());
		
		shopOwnedCropsTextPane.setText(gameEnviroment.getCropsList());
		
		shopOwnedAnimalsTextPane.setText(gameEnviroment.getAnimalsList());	
	}
	
	
	/**
	 * Retrieve static descriptions of different purchasable classes and change shop displays to them.
	 */
	public void buildShopScreen(){
		shopPanelOneLabel.setText("Cow");
		shopPanelOneDecription.setText(Cow.description);
		shopPanelTwoLabel.setText("Chicken");
		shopPanelTwoDescription.setText(Chicken.description);
		shopPanelThreeLabel.setText("Sheep");
		shopPanelThreeDescription.setText(Sheep.description);
		shopPanelFourLabel.setText("Carrot");
		shopPanelFourDescription.setText(Carrot.description);
		shopPanelFiveLabel.setText("Corn");
		shopPanelFiveDescription.setText(Corn.description);
		shopPanelSixLabel.setText("Lettuce");
		shopPanelSixDescription.setText(Lettuce.description);
		shopPanelSevenLabel.setText("Beetroot");
		shopPanelSevenDescription.setText(Beetroot.description);
		shopPanelEightLabel.setText("Potato");
		shopPanelEightDescription.setText(Potato.description);
		shopPanelNineLabel.setText("Wheat");
		shopPanelNineDescription.setText(Wheat.description);
		shopPanelTenLabel.setText("CommonFood");
		shopPanelTenDescription.setText(CommonFood.description);
		shopPanelElevenLabel.setText("LuxuryFood");
		shopPanelElevenDescription.setText(LuxuryFood.description);
		shopPanelTwelveLabel.setText("Fertilizer");
		shopPanelTwelveDescription.setText(Fertilizer.description);
		shopPanelThirteenLabel.setText("Pesticide");
		shopPanelThirteenDescription.setText(Pesticide.description);
		shopPanelFourteenLabel.setText("ProteinBar");
		shopPanelFourteenDescription.setText(ProteinBar.description);
		shopPanelFifteenLabel.setText("Hat");
		shopPanelFifteenDescription.setText(Hat.description);
	}

	
	
	/**
	 * Takes the integer referring to a shop panel attempting to be purchased from.
	 * 
	 * If class of purchase animal: calls gameEnv to check if there is space for new animal, 
	 * calls gameEnv to check if there is enough money for new animal. If so calls gameEnv to purchase animal,
	 * otherwise calls unpurchaseable() with reason purchase couldn't be completed
	 * 
	 * If class of purchase crop: calls gameEnv to check if there is space for new crop, 
	 * calls gameEnv to check if there is enough money for new crop. If so calls gameEnv to purchase crop,
	 * otherwise calls unpurchaseable() with reason purchase couldn't be completed
	 * 
	 * If class of purchase item: calls gameEnv to check if there is enough money for new item. 
	 * If so calls gameEnv to purchase item, otherwise calls unpurchaseable() with reason purchase 
	 * couldn't be completed
	 * 
	 * Then calls update shop screen
	 * 
	 * @param panel The integer referring to the panel purchased from
	 */
	public void purchaseFromShop(int panel){
		if(panel == 1 || panel == 2 || panel == 3){												//Purchasing Animal
			if(!gameEnviroment.checkSpaceForAnimals()){ 										//No Space for new Animal
				unpurchaseable("No more animals can fit on the farm");
			}
			else{																				//Space for new Animal
				String animalType = "";
				int purchasePrice = 0;
				if(panel == 1){
					animalType = "Cow";															//User purchasing Cow
					purchasePrice = Cow.purchasePrice;
				}
				else if(panel == 2){	
					animalType = "Chicken";														//User purchasing Chicken
					purchasePrice = Chicken.purchasePrice;
				}
				else if(panel == 3){
					animalType = "Sheep";														//User purchasing Sheep
					purchasePrice = Sheep.purchasePrice;
				}
				
				if(gameEnviroment.checkAfforadable(purchasePrice)){								//Can afford purchase
					gameEnviroment.purchaseAnimal(animalType, purchasePrice);
				}
				else{																			//Can't afford Given Animal
					unpurchaseable("Insufficent Funds");
				}
			}
		}
		
		
		if(panel == 4 || panel == 5 || panel == 6  || panel == 7  || panel == 8  || panel == 9){//Purchasing crop
			if(!gameEnviroment.checkSpaceForCrops()){ 											//No Space for new crop
				unpurchaseable("No more crops can fit on the farm");
			}
			else{																				//Space for new crop
				String cropType = "";
				int purchasePrice = 0;
				
				if(panel == 4){
					cropType = "Carrot";														//User purchasing Carrot
					purchasePrice = Carrot.purchasePrice;
				}
				
				else if(panel == 5){
					cropType = "Corn";															//User purchasing Corn
					purchasePrice = Corn.purchasePrice;
				}
				
				else if(panel == 6){
					cropType = "Lettuce";														//User purchasing Lettuce
					purchasePrice = Lettuce.purchasePrice;
				}
				
				else if(panel == 7){
					cropType = "Beetroot";														//User purchasing Beetroot
					purchasePrice = Beetroot.purchasePrice;
				}
				
				else if(panel == 8){
					cropType = "Potato";														//User purchasing Potato
					purchasePrice = Potato.purchasePrice;
				}
				
				else if(panel == 9){
					cropType = "Wheat";															//User purchasing Wheat
					purchasePrice = Wheat.purchasePrice;
				}
				
				if(gameEnviroment.checkAfforadable(purchasePrice)){								//Can afford purchase
					gameEnviroment.purchaseCrop(cropType, purchasePrice);
				}
				else{																			//Can't afford Given crop
					unpurchaseable("Insufficent Funds");
				}
			}
		}
		
		if(panel == 10 || panel == 11 || panel == 12 || panel == 13 || panel == 14 || panel == 15){//Purchasing Item	
			String itemType = "";
			int purchasePrice = 0;
			
			if(panel == 10){
				itemType = "CommonFood";														//User purchasing CommonFood
				purchasePrice = CommonFood.purchasePrice;
			}
			else if(panel == 11){
				itemType = "LuxuryFood";														//User purchasing LuxuryFood
				purchasePrice = LuxuryFood.purchasePrice;
			}
			else if(panel == 12){
				itemType = "Fertilizer";														//User purchasing Fertilizer
				purchasePrice = Fertilizer.purchasePrice;
			}
			else if(panel == 13){
				itemType = "Pesticide";															//User purchasing Pesticide
				purchasePrice = Pesticide.purchasePrice;
			}
			else if(panel == 14){
				itemType = "ProteinBar";														//User purchasing ProteinBar
				purchasePrice = ProteinBar.purchasePrice;
			}
			else if(panel == 15){
				itemType = "Hat";																//User purchasing Hat
				purchasePrice = Hat.purchasePrice;
			}
			
			if(gameEnviroment.checkAfforadable(purchasePrice)){									//Can afford purchase
				gameEnviroment.purchaseItem(itemType, purchasePrice);
			}
			else{																				//Can't afford Given Animal
				unpurchaseable("Insufficent Funds");
			}
		}
		
		updateShopScreen();
	}
		
	
	/**
	 * Called if shop item was unpurchaseable. Sets shop header to reason
	 * item was unpurchaseable
	 * @param reason The text to update the shop header to
	 */
	public void unpurchaseable(String reason){
		shopHeaderLabel.setText(reason);
	}
	
	
	/**
	 * Updates the Animals pens by checking the number of animals in the farm.
	 * For each animal on the farm, gets the animals type, then updates the icon 
	 * and description of the corresponding pen to those of the animal type.
	 */
	public void updateAnimalPens() {
		int numOfAnimals = gameState.getFarm().getAnimalArrayList().size();
		if (numOfAnimals == 4){
			mainAnimalFourDescription.setText(gameState.getFarm().getAnimalArrayList().get(3).getAnimalDescription());
			String animalType = gameState.getFarm().getAnimalArrayList().get(3).getAnimalType();
			if (animalType.equals("Cow")){
				mainAnimalFourIconLabel.setIcon(new ImageIcon("Images/Cow.png"));
			    }
			else if (animalType.equals("Sheep")){
				mainAnimalFourIconLabel.setIcon(new ImageIcon("Images/Sheep.png"));
			    }
			else if (animalType.equals("Chicken")){
				mainAnimalFourIconLabel.setIcon(new ImageIcon("Images/Chicken.png"));
			    }
		    }
		
		else {
			mainAnimalFourDescription.setText("");
			mainAnimalFourIconLabel.setIcon(null);
		    }
		
		if (numOfAnimals > 2){
			mainAnimalThreeDescription.setText(gameState.getFarm().getAnimalArrayList().get(2).getAnimalDescription());
			String animalType = gameState.getFarm().getAnimalArrayList().get(2).getAnimalType();
			if(animalType.equals("Cow")){
				mainAnimalThreeIconLabel.setIcon(new ImageIcon("Images/Cow.png"));
			    }
			else if(animalType.equals("Sheep")){
				mainAnimalThreeIconLabel.setIcon(new ImageIcon("Images/Sheep.png"));
			    }
			else if(animalType.equals("Chicken")){
				mainAnimalThreeIconLabel.setIcon(new ImageIcon("Images/Chicken.png"));
			    }
		}
		else{
			mainAnimalThreeDescription.setText("");
			mainAnimalThreeIconLabel.setIcon(null);
		}
		
		if(numOfAnimals > 1){
			mainAnimalTwoDescription.setText(gameState.getFarm().getAnimalArrayList().get(1).getAnimalDescription());
			String animalType = gameState.getFarm().getAnimalArrayList().get(1).getAnimalType();
			if(animalType.equals("Cow")){
				mainAnimalTwoIconLabel.setIcon(new ImageIcon("Images/Cow.png"));
			}
			else if(animalType.equals("Sheep")){
				mainAnimalTwoIconLabel.setIcon(new ImageIcon("Images/Sheep.png"));
			}
			else if(animalType.equals("Chicken")){
				mainAnimalTwoIconLabel.setIcon(new ImageIcon("Images/Chicken.png"));
			}
		}
		else{
			mainAnimalTwoDescription.setText("");
			mainAnimalTwoIconLabel.setIcon(null);
		}
		
		if(numOfAnimals > 0){
			mainAnimalOneDescription.setText(gameState.getFarm().getAnimalArrayList().get(0).getAnimalDescription());
			String animalType = gameState.getFarm().getAnimalArrayList().get(0).getAnimalType();
			if(animalType.equals("Cow")){
				mainAnimalOneIconLabel.setIcon(new ImageIcon("Images/Cow.png"));
			}
			else if(animalType.equals("Sheep")){
				mainAnimalOneIconLabel.setIcon(new ImageIcon("Images/Sheep.png"));
			}
			else if(animalType.equals("Chicken")){
				mainAnimalOneIconLabel.setIcon(new ImageIcon("Images/Chicken.png"));
			}
			
		}else{
			mainAnimalOneDescription.setText("");
			mainAnimalOneIconLabel.setIcon(null);
		}
	}
	
	
	/**
	 * Determines which of the action button is selected. Calls other methods as appropriate.
	 */
	public void checkActionSelected(){
		String buttonText = "";
		for (Enumeration<AbstractButton> buttons = actionButtonsButtonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
            	buttonText = button.getText();
            }
        }
		
		if(buttonText == "Feed Animals"){					//Feed Animals
			generateItemSubOptions(new String[]{"CommonFood", "LuxuryFood"}, "Seclect an item to use:");
		}
		else if (buttonText == "Play With Animals"){		//Play With Animals
			playWithAnimals();
		}
		else if (buttonText == "Use Farmer Item"){			//Use Farmer Item
			generateItemSubOptions(new String[]{"ProteinBar", "Hat"}, "Seclect an item to use:");
		}
		else if (buttonText == "Tend Crops"){				//Tend Crops
			generateItemSubOptions(new String[]{"Water", "Fertilizer", "Pesticide"}, "Seclect an item to tend with:");
		}
		else if (buttonText == "Harvest Crops"){			//Harvest Crops
			harvestCrops();
		}
		else if (buttonText == "Tend Farmland"){			//Tend Farmland
			tendFarmLand();
		}
		
		//Tend Crop Options
		else if (buttonText == "Water"){					//Tend Crops With Water
			gameState.setItemToTendWith("Water");	
			generateCropSubOptions("Select a Crop");
		}
		else if (buttonText == "Fertilizer"){				//Tend Crops With Fertilizer
			gameState.setItemToTendWith("Fertilizer");	
			generateCropSubOptions("Select a Crop");
		}
		else if (buttonText == "Pesticide"){				//Tend Crops With Pesticide
			gameState.setItemToTendWith("Pesticide");	
			generateCropSubOptions("Select a Crop");
		}
		
		//Feed Animal Options
		else if (buttonText == "CommonFood"){				//Feed Animals With CommonFood
			feedAnimals("CommonFood");
		}
		else if (buttonText == "LuxuryFood"){				//Feed Animals With LuxuryFood
			feedAnimals("LuxuryFood");
		}
		//Farmer Items
		else if (buttonText == "ProteinBar"){				//Use FamerItem ProteinBar
			useFarmerItem("ProteinBar");
		}
		else if (buttonText == "Hat"){						//Use FamerItem Hat
			 useFarmerItem("Hat");
		}
		
		else{												//No Action Selected
			;												
		}
	}
	
	
	
	/**
	 * Removes all action buttons from action button group.
	 */
	public void removeActionButtons(){
		for (Enumeration<AbstractButton> buttons = actionButtonsButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			actionButtonsButtonGroup.remove(button);
		}
	}
	
	
	/**
	 * Populate the action buttons panel with radio buttons corresponding to the actions currently available to the user
	 * First removes all currently displayed radio buttons. Then has gameEnv check if different actions are performable
	 * If they are, adds corresponding buttons to action button panel. Updates main action label to whether or not
	 * users can perform actions
	 */
	public void generateActionButtons(){
		
		boolean actionToPerform = false;
		
		//Reset Action Panel
		mainActionListPanel.removeAll();
		mainActionListPanel.validate();
		mainActionListPanel.repaint();
		actionButtonsButtonGroup.clearSelection();
		removeActionButtons();
		removeActionButtons();
		removeActionButtons();
        removeActionButtons();
		
		
		//If user had farmer items, add use farmer item Button
		if(gameEnviroment.checkUserHasItems(new String[]{"FarmerItem", "Hat", "ProteinBar"})){
			JRadioButton useFarmerItemButton = new JRadioButton("Use Farmer Item");
			actionButtonsButtonGroup.add(useFarmerItemButton);
			mainActionListPanel.add(useFarmerItemButton);
			Color rdbntColor = new Color(250, 240, 230);
			useFarmerItemButton.setBackground(rdbntColor);
			actionToPerform = true;
		}
		

		if(gameState.getActionsLeft() > 0){// User has at-least one daily action remaining, so can potentially perform the following
			
			//If user has animals, add Play with animals Button
			if(gameEnviroment.checkUserHasAnimals()){
				JRadioButton playWithAnimalsButton = new JRadioButton("Play With Animals");
				actionButtonsButtonGroup.add(playWithAnimalsButton);
				mainActionListPanel.add(playWithAnimalsButton);
				Color rdbntColor = new Color(250, 240, 230);
				playWithAnimalsButton.setBackground(rdbntColor);
				actionToPerform = true;
			}
			
			//If user has animals, and user has animal items, add Feed Animals button
			if(gameEnviroment.checkUserHasAnimals() && gameEnviroment.checkUserHasItems(new String[]{"CommonFood", "LuxuryFood"})){
				JRadioButton feedAnimalsButton = new JRadioButton("Feed Animals");
				actionButtonsButtonGroup.add(feedAnimalsButton);
				mainActionListPanel.add(feedAnimalsButton);
				Color rdbntColor = new Color(250, 240, 230);
				feedAnimalsButton.setBackground(rdbntColor);
				actionToPerform = true;
				}
		
			//If user has crops, add tend crop button
			if(gameEnviroment.checkUserHasCrops()){
				JRadioButton tendCropButton = new JRadioButton("Tend Crops");
				actionButtonsButtonGroup.add(tendCropButton);
				mainActionListPanel.add(tendCropButton);
				Color rdbntColor = new Color(250, 240, 230);
				tendCropButton.setBackground(rdbntColor);
				actionToPerform = true;
			}
			
			//If user has harvestable crops, add harvest crops button
			if(gameEnviroment.checkIfHarvestableCrops()){
				JRadioButton harvestCropButton = new JRadioButton("Harvest Crops");
				actionButtonsButtonGroup.add(harvestCropButton);
				mainActionListPanel.add(harvestCropButton);
				Color rdbntColor = new Color(250, 240, 230);
				harvestCropButton.setBackground(rdbntColor);
				actionToPerform = true;
			}
			
			//If user had not tended farm, add tend farm button
			if(gameEnviroment.checkIfFarmTendable()){
				JRadioButton tendFarmButton = new JRadioButton("Tend Farmland");
				actionButtonsButtonGroup.add(tendFarmButton);
				mainActionListPanel.add(tendFarmButton);
				Color rdbntColor = new Color(250, 240, 230);
				tendFarmButton.setBackground(rdbntColor);
				actionToPerform = true;
			}
		}
		if(actionToPerform){
			mainActionLabel.setText("Select Action");
		}else{
			mainActionLabel.setText("No Actions Available");
		}	
	}
	
	
	/**
	 * Calls gameEnv play with animals then updates main screen.
	 */
	public void playWithAnimals(){
		gameEnviroment.playWithAnimals();
		updateMainScreen();
	}
	
	
	/**
	 * Populate the action buttons panel with radio buttons which represent the items the user can use.
	 * Then update the message above the actions list
	 * @param itemTypes the type of items to present to the user
	 * @param message the message to be displayed
	 */
	public void generateItemSubOptions(String[] itemTypes, String message){
		//Reset Action Panel
		mainActionListPanel.removeAll();
		mainActionListPanel.validate();
		mainActionListPanel.repaint();
		actionButtonsButtonGroup.clearSelection();
		removeActionButtons();
		removeActionButtons();
		
		
		//Array of usable items
		for(Item item: gameEnviroment.getUseableItemsOfType(itemTypes)){
			JRadioButton rdbnt = new JRadioButton(item.getItemName());
			actionButtonsButtonGroup.add(rdbnt);
			Color rdbntColor = new Color(250, 240, 230);
			rdbnt.setBackground(rdbntColor);
			mainActionListPanel.add(rdbnt);
		}
		
		mainActionLabel.setText(message);
		
		//Repaint Action List
		mainActionListPanel.validate();
		mainActionListPanel.repaint();
	}
	
	
	/**
	 * Calls gameEnv feed animals and passes itemToFeed.
	 * Then calls update main screen
	 * @param itemToFeed The type of item to feed
	 */
	public void feedAnimals(String itemToFeed){
		gameEnviroment.feedAnimals(itemToFeed);
		updateMainScreen();
	}
	
	
	/**
	 * Calls gameEnv useFarmerItem and passes itemToUse.
	 * Then calls update main screen
	 * @param itemToUse  The type of item to use
	 */
	public void useFarmerItem(String itemToUse){
		gameEnviroment.useFarmerItem(itemToUse);
		updateMainScreen();
	}
	
	/**
	 * Calls gameEnv harvestCrops.
	 * Then calls update main screen
	 */
	public void harvestCrops(){
		gameEnviroment.harvestCrops();
		updateMainScreen();			
	}
	
	
	/**
	 * Calls gameEnv harvestCrops.
	 * Clears mainFieldFours description
	 * Then calls update main screen
	 * 
	 */
	public void tendFarmLand(){
		gameEnviroment.tendFarmLand();
		mainFieldFourDescription.setText("");
		updateMainScreen();
	}
	
	
	/**
	 * Tends Crops
	 * Gets cropArrayPostition by looping over actionButtons to see which is selected.
	 * gameEnviroments tendCrop with this value
	 * updates main screen
	 */
	public void tendCrop(){
		int cropArrayPostition = -1;
		int i = 0;
		for (Enumeration<AbstractButton> buttons = actionButtonsButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			//System.out.println(button.());
			i ++;
			
		 if (button.isSelected()) {
			 cropArrayPostition = i-1; 
            }
		}
		
		try{
		    gameEnviroment.tendCrop(cropArrayPostition);
		}
		catch(Exception e){
		    gameEnviroment.tendCrop(cropArrayPostition-1);
		}
		updateMainScreen();
	}
	
	
	
	/**
	 * Populates the action buttons panel with radio buttons which represent the crops the
	 * user can tend to.
	 * Then update the message above the actions list
	 * @param message the message to be displayed
	 */
	public void generateCropSubOptions(String message){
		mainActionListPanel.removeAll();
		mainActionListPanel.validate();
		mainActionListPanel.repaint();
		actionButtonsButtonGroup.clearSelection();
		
		
		removeActionButtons();
        removeActionButtons();
		removeActionButtons();
		removeActionButtons();
		
		mainConfirmActionButton.setVisible(false);
		mainConfirmCropSelectionButton.setVisible(true);
		

		for(Crop crop: gameEnviroment.getCrops()){
			JRadioButton rdbnt = new JRadioButton(crop.getCropType());
			actionButtonsButtonGroup.add(rdbnt);
			Color rdbntColor = new Color(250, 240, 230);
			rdbnt.setBackground(rdbntColor);
			mainActionListPanel.add(rdbnt);
		}
		mainActionLabel.setText(message);
		
		//Repaint Action List
		mainActionListPanel.validate();
		mainActionListPanel.repaint();
		actionButtonsButtonGroup.clearSelection();
	}
	
	
	
	/**
	 * Updates the crop farms
	 * Done by checking the number of crops in the farm, then
	 * for each crop on the farm, get the crop type, then updates the icon 
	 * and description of the corresponding farm for those of the crop.
	 * Icon is dependent on crop growth
	 * If no crop for given farm, sets icon to dirt
	 */
	public void updateCropFarms(){
		int numOfCrops = gameState.getFarm().getCropArrayList().size();
		
		if(numOfCrops == 4){
			mainFieldFourDescription.setText(gameState.getFarm().getCropArrayList().get(3).getCropDescription());
			
			String cropType = gameState.getFarm().getCropArrayList().get(3).getCropType();
			int cropGrowth = gameState.getFarm().getCropArrayList().get(3).getCurrentGrowth();
			
			String imageFileName = "Images/";
			
			if(cropGrowth < 30){
				imageFileName += "TilledDirt";
			}
			else if(cropGrowth < 100){
				imageFileName += cropType + "MediumGrowth";
			}
			else{
				imageFileName += cropType + "Grown";
			}
			imageFileName += ".png";
			
			mainFieldFourIcon.setIcon(new ImageIcon(imageFileName));
			
		}
		else{
			
			if(gameState.isHasTendedFarm()){
				mainFieldFourDescription.setText("");
				mainFieldFourIcon.setIcon(new ImageIcon("Images/Dirt.png"));
			}
			else{
				mainFieldFourIcon.setIcon(null);
			}
		}
		
		
		if(numOfCrops > 2){
			mainFieldThreeDescription.setText(gameState.getFarm().getCropArrayList().get(2).getCropDescription());
			

			String cropType = gameState.getFarm().getCropArrayList().get(2).getCropType();
			int cropGrowth = gameState.getFarm().getCropArrayList().get(2).getCurrentGrowth();
			
			String imageFileName = "Images/";
			
			if(cropGrowth < 30){
				imageFileName += "TilledDirt";
			}
			else if(cropGrowth < 100){
				imageFileName += cropType + "MediumGrowth";
			}
			else{
				imageFileName += cropType + "Grown";
			}
			imageFileName += ".png";
			
			mainFieldThreeIcon.setIcon(new ImageIcon(imageFileName));
			
		}
		else{
			mainFieldThreeDescription.setText("");
			mainFieldThreeIcon.setIcon(new ImageIcon("Images/Dirt.png"));
		}
		
		
		if(numOfCrops > 1){
			mainFieldTwoDescription.setText(gameState.getFarm().getCropArrayList().get(1).getCropDescription());
			
			String cropType = gameState.getFarm().getCropArrayList().get(1).getCropType();
			int cropGrowth = gameState.getFarm().getCropArrayList().get(1).getCurrentGrowth();
			
			String imageFileName = "Images/";
			
			if(cropGrowth < 30){
				imageFileName += "TilledDirt";
			}
			else if(cropGrowth < 100){
				imageFileName += cropType + "MediumGrowth";
			}
			else{
				imageFileName += cropType + "Grown";
			}
			imageFileName += ".png";
			
			mainFieldTwoIcon.setIcon(new ImageIcon(imageFileName));
		}
		else{
			mainFieldTwoDescription.setText("");
			mainFieldTwoIcon.setIcon(new ImageIcon("Images/Dirt.png"));
		}
		
		
		if(numOfCrops > 0){
			mainFieldOneDescription.setText(gameState.getFarm().getCropArrayList().get(0).getCropDescription());
			
			String cropType = gameState.getFarm().getCropArrayList().get(0).getCropType();
			int cropGrowth = gameState.getFarm().getCropArrayList().get(0).getCurrentGrowth();
			
			String imageFileName = "Images/";
			
			if(cropGrowth < 30){
				imageFileName += "TilledDirt";
			}
			else if(cropGrowth < 100){
				imageFileName += cropType + "MediumGrowth";
			}
			else{
				imageFileName += cropType + "Grown";
			}
			imageFileName += ".png";
			
			mainFieldOneIcon.setIcon(new ImageIcon(imageFileName));
			
		}
		else{
			mainFieldOneDescription.setText("");
			mainFieldOneIcon.setIcon(new ImageIcon("Images/Dirt.png"));
		}
	}
	
	
	/**
	 * Processes Game end.
	 * Changes panel to gameEndPanel
	 * Sets gameEndUserName to getUserThanks from gameEnv
	 * Sets gameEndScoreTextPane to getScore from gameEnv
	 * Calls for gameEnv to delete saveFile
	 */
	public void gameEnd(){
		
		gameEndPanel.setVisible(true);
		mainGamePanel.setVisible(false);
		shopPanel.setVisible(false);
		
		
		gameEndUserName.setText(gameEnviroment.getUserThanks());
		gameEndScoreTextPane.setText(gameEnviroment.getScore());
		
		gameEnviroment.deleteSaveFile();
		
	}
	
	/**
	 * Sets up game for game Restart by setting select fields.
	 * back to default values and changing visibility of certain panels
	 */
	public void restartGame(){
		gameEndPanel.setVisible(false);
		mainGamePanel.setVisible(false);
		shopPanel.setVisible(false);
		setUpScreenPanel.setVisible(true);
		
		setUpScreenFarmerNameTextFeild.setText("");
		setUpScreenFarmNameTextField.setText("");
		setUpScreenIlegalFarmerNameLabel.setText("");
		setUpScreenNumberOfDaysTextField.setText("");
		setUpScreenIllegalFarmNameLabel.setText("");
		setUpScreenIllegalNumberLabel.setText("");
		mainFieldFourDescription.setText("This field is unuseable until you tend the farm land");
		
	}
	
	
	
	
	
	/**
	 * Sets up panel visibility for new game.
	 */
	public void newGameSetup(){
		gameEndPanel.setVisible(false);
		mainGamePanel.setVisible(false);
		shopPanel.setVisible(false);
		loadInPanel.setVisible(false);
		setUpScreenPanel.setVisible(true);
	}
	
	
	/**
	 * Calls gameEnv checkSaveFileExists to see if save-file exists
	 * It it does, calls loadGameFromSavefile, changes to main screen, 
	 * and calls update main screen. Otherwise sets loadInErrorLabel to display 
	 * false and disables loadGameButton
	 */
	public void loadGame(){
		if(!gameEnviroment.checkSaveFileExists()){
			loadInLoadGameButton.setEnabled(false);
			loadInErrorLabel.setText("No Save File Found");
		}
		else{
			loadFromSaveFile();
			loadInPanel.setVisible(false);
			mainGamePanel.setVisible(true);
			buildShopScreen();
			updateMainScreen();
		}	
	}
	
	
	/**
	 * Updates current to gameState returned from call to gameEnviroment loadFromSaveFile.
	 * Updates gameEnviroments gameState to this gameState
	 */
	public void loadFromSaveFile(){
		this.gameState = gameEnviroment.loadFromSaveFile();
		gameEnviroment.setGameState(this.gameState);
	}
	
	
	
}
