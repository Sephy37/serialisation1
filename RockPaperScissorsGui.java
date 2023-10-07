import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.security.KeyStore.PrivateKeyEntry;

import javax.security.auth.x500.X500Principal;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Random;
import javax.swing.Timer;
import javax.xml.transform.Source;
public class RockPaperScissorsGui extends JFrame{
    private final Random rand = new Random();
    private final JFrame f = new JFrame();
    private GameStatus gameStatus;

    private final int BEST_OF_THREE_GAMES = 3;
    private final int BEST_OF_FIVE_GAMES = 5;
    private final int BEST_OF_TEN_GAMES = 10;
    private final int BEST_OF_THREE = 1;
    private final int BEST_OF_FIVE = 2;
    private final int BEST_OF_TEN = 3;
    private final int WIDTH = 400;
    private final int HEIGHT = 30;
    private final int X = 170;
    private final int Y = 30;

    private int computerChoice;
    private int playerChoice;
    private int computerScore = 0;
    private int playerScore = 0;
    private int playerRoundScore = 0;
    private int computerRoundScore = 0;
    private int buttonId;
    private int level;
    private int turns;
    private String message;

    private ImageIcon[] gameImagesIcons = GameImages.GAME_IMAGE_ICON;

    private final JLabel rockPaperScissorsHeaderLabel;
    private final JLabel rockPaperScissorsComputerChoiceLabel;
    private final JLabel rockLabel;
    private final JLabel scissorsLabel;
    private final JLabel paperLabel;
    private final JLabel userScoreLabel;
    private final JLabel computerScoreLabel;
    private final JLabel printOutWhoWonLabel;
    private final JLabel bestOfThreeGamesLabel;
    private final JLabel bestOfFiveGamesLabel;
    private final JLabel bestOfTenGamesLabel;
    private final JLabel dashSeparatorForScoresLabel;
    private final JLabel userScoreLbl;
    private final JLabel compScoreLbl;
    private final JLabel roundScoreLabel;
    private final JLabel compRoundScoreLabel;
    private final JLabel userRoundScoreLabel;
    private final JLabel userRoundLabel;
    private final JLabel compRoundLabel;
    private final JLabel roundDashSeparator;


    private final JButton rockButton;
    private final JButton paperButton;
    private final JButton scissorsButton;
    private final JButton bestOfThreeGamesButton;
    private final JButton bestOfFiveGamesButton;
    private final JButton bestOfTenGamesButton;
    private final JButton resetButton;

    private Timer clearScreenTimer;
    private Timer displayWhoWonTimer;

    public RockPaperScissorsGui() {
        gameStatus = GameStatus.GAME_ON;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        rockPaperScissorsHeaderLabel = new JLabel("ROCK PAPER SCISSORS");
        rockPaperScissorsHeaderLabel.setFont(new Font("Times new Roman",Font.BOLD,30));
        rockPaperScissorsHeaderLabel.setForeground(getColor());

        rockLabel = new JLabel("");
        paperLabel = new JLabel("");
        scissorsLabel = new JLabel("");
        bestOfThreeGamesLabel = new JLabel("");
        bestOfFiveGamesLabel = new JLabel("");
        bestOfTenGamesLabel = new JLabel("");
        printOutWhoWonLabel = new JLabel("");
        userScoreLabel = new JLabel("User Score");
        computerScoreLabel = new JLabel("Computer Score");
        dashSeparatorForScoresLabel = new JLabel("-");
        userScoreLbl = new JLabel("");
        compScoreLbl = new JLabel("");
        roundScoreLabel = new JLabel("Round Score");
        rockPaperScissorsComputerChoiceLabel = new JLabel("");
        compRoundScoreLabel = new JLabel("");
        userRoundScoreLabel = new JLabel("");
        compRoundLabel = new JLabel("Computer");
        userRoundLabel = new JLabel("User");
        roundDashSeparator = new JLabel("-");

        getContentPane().setBackground(Color.yellow);
        rockPaperScissorsHeaderLabel.setBounds(X,Y,WIDTH,HEIGHT);

        paperButton = new JButton("Paper");
        rockButton = new JButton("Rock");
        scissorsButton = new JButton("Scissors");
        bestOfThreeGamesButton = new JButton("Best Of Three Games");
        bestOfFiveGamesButton = new JButton("Best Of Five Games");
        bestOfTenGamesButton = new JButton("Best Of Ten Games");
        resetButton = new JButton("Reset");

        //printOutCurrentRoundScores(userRoundScoreLabel,computerRoundScore);
        //printOutCurrentRoundScores(compRoundScoreLabel,playerRoundScore);
        printOutCurrentRoundScores(compRoundScoreLabel,computerRoundScore);
        printOutCurrentRoundScores(userRoundScoreLabel,playerRoundScore);
        //printCurrentScores(userScoreLbl,computerScore);
        //printCurrentScores(compScoreLbl,playerScore);
        printCurrentScores(userScoreLbl,playerScore);
        printCurrentScores(compScoreLbl,computerScore);

        paperButton.setBounds(200,70,90,30);
        rockButton.setBounds(300,70,90,30);
        scissorsButton.setBounds(400,70,90,30);
        bestOfThreeGamesButton.setBounds(30,400,160,30);
        bestOfFiveGamesButton.setBounds(250,400,160,30);
        bestOfTenGamesButton.setBounds(500,400,160,30);
        resetButton.setBounds(500,70,90,30);

        paperLabel.setBounds(100,120,200,239);
        rockLabel.setBounds(100,120,200,239);
        scissorsLabel.setBounds(100,120,200,239);
        bestOfThreeGamesLabel.setBounds(100,430,160,30);
        bestOfFiveGamesLabel.setBounds(330,430,160,30);
        bestOfTenGamesLabel.setBounds(580,430,160,30);
        rockPaperScissorsComputerChoiceLabel.setBounds(400,120,200,239);
        printOutWhoWonLabel.setBounds(300,300,100,100);
        userScoreLabel.setBounds(330,325,100,100);
        computerScoreLabel.setBounds(430,325,100,100);
        dashSeparatorForScoresLabel.setBounds(410,325,100,100);
        userScoreLbl.setBounds(400,325,100,100);
        compScoreLbl.setBounds(415,325,100,100);
        roundScoreLabel.setBounds(50,310,100,100);
        compRoundScoreLabel.setBounds(100,325,100,100);
        userRoundLabel.setBounds(50,325,100,100);
        compRoundLabel.setBounds(110,325,100,100);
        userRoundScoreLabel.setBounds(80,325,100,100);
        roundDashSeparator.setBounds(90,325,100,100);

        add(rockPaperScissorsHeaderLabel);
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        add(resetButton);
        add(bestOfThreeGamesButton);
        add(bestOfFiveGamesButton);
        add(bestOfTenGamesButton);
        add(bestOfThreeGamesLabel);
        add(bestOfFiveGamesLabel);
        add(bestOfTenGamesLabel);
        add(rockLabel);
        add(paperLabel);
        add(scissorsLabel);
        add(rockPaperScissorsComputerChoiceLabel);
        add(printOutWhoWonLabel);
        add(userScoreLabel);
        add(computerScoreLabel);
        add(dashSeparatorForScoresLabel);
        add(userScoreLbl);
        add(compScoreLbl);
        add(roundScoreLabel);
        add(compRoundScoreLabel);
        add(userRoundScoreLabel);
        add(compRoundLabel);
        add(userRoundLabel);
        add(roundDashSeparator);

        rockButton.setEnabled(false);
        scissorsButton.setEnabled(false);
        paperButton.setEnabled(false);

        displayWhoWonTimer = new Timer(2000,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printOutWhoWonLabel.setText("");
                displayWhoWonTimer.stop();
            }
        });
        displayWhoWonTimer.setRepeats(false);

        clearScreenTimer = new Timer(1000,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                clearScreenTimer.stop();
                reset();
            }
        });

        paperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setChoice(e);
                computerChoice = getComputerChoice();
                setComputerImage(e,computerChoice);
                //checkChoice(e);
                checkWhoWon(e,computerChoice);
                //checkWhoWon(e);
            }
        });

        rockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setChoice(e);
                computerChoice = getComputerChoice();
                setComputerImage(e,computerChoice);
                //checkChoice(e);
                checkWhoWon(e,computerChoice);
                //checkWhoWon(e);

            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setChoice(e);
                computerChoice = getComputerChoice();
                setComputerImage(e,computerChoice);
                checkWhoWon(e,computerChoice);
                //checkChoice(e);
                //checkWhoWon(e);
                //checkWhoWon(e);

            }
        });

        bestOfThreeGamesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turns = setNumberOfGames(e);
                turns = level;
            }
        });

        bestOfFiveGamesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turns = setNumberOfGames(e);
                turns = level;
            }
        });

        bestOfTenGamesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turns = setNumberOfGames(e);
                turns = level;
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton();
            }
        });
    }

    private int setNumberOfGames(ActionEvent e) {
        Object source = e.getSource();
        if(source == bestOfThreeGamesButton) {
            buttonId = BEST_OF_THREE;
        }else if(source == bestOfFiveGamesButton) {
            buttonId = BEST_OF_FIVE;
        }else if(source == bestOfTenGamesButton) {
            buttonId = BEST_OF_TEN;
        }else {
            buttonId = 0;
        }
        turns = processNumberOfGames();
        lockInNumberOfGames();
        return buttonId;
    }

    private int processNumberOfGames() {
        switch(buttonId) {
            case BEST_OF_THREE:
                level = BEST_OF_THREE_GAMES;
                printOutNumberOfTurns(bestOfThreeGamesLabel,BEST_OF_THREE_GAMES);
                break;

            case BEST_OF_FIVE:
                level = BEST_OF_FIVE_GAMES;
                printOutNumberOfTurns(bestOfFiveGamesLabel,BEST_OF_FIVE_GAMES);
                break;

            case BEST_OF_TEN:
                level = BEST_OF_TEN_GAMES;
                printOutNumberOfTurns(bestOfTenGamesLabel,BEST_OF_TEN_GAMES);
                break;

            default:
                JOptionPane.showMessageDialog(f,"SOMETHING WENT WRONG!");
        }
        return buttonId;
    }

    private void printOutNumberOfTurns(JLabel label,int numberOfGames) {
        label.setText("" + numberOfGames);
    }

    private void printCurrentScores(JLabel label,int scores) {
        label.setText("" + scores);
    }

    private void printOutCurrentRoundScores(JLabel label,int roundScore) {
        label.setText("" + roundScore);
    }

    private void setChoice(ActionEvent e) {
        Object source = e.getSource();
        if(source == paperButton) {
            printLabel(paperLabel,gameImagesIcons[0]);
            clearScreenTimer.start();
        }else if(source == rockButton) {
            printLabel(rockLabel,gameImagesIcons[1]);
            clearScreenTimer.start();
        }else if(source == scissorsButton) {
            printLabel(scissorsLabel,gameImagesIcons[2]);
            clearScreenTimer.start();
        }
    }

    private void lockInNumberOfGames() {
        bestOfThreeGamesButton.setEnabled(false);
        bestOfFiveGamesButton.setEnabled(false);
        bestOfTenGamesButton.setEnabled(false);
        rockButton.setEnabled(true);
        scissorsButton.setEnabled(true);
        paperButton.setEnabled(true);
    }

    /* Might be implemented later.
     *
     * private void checkChoice(ActionEvent e,JLabel label){
     *
     * }
     *
     *
     *
     * */

    private void checkWhoWon(ActionEvent e,int computerChoice) {
        Object sourceObject = e.getSource();
        if (sourceObject == rockButton) { // Player chooses Rock
            if (computerChoice == 0) { // Computer chooses Paper
                printOutWhoWon("COMPUTER WON!");    // Paper wraps Rock
                computerScore++;
                turns--;
                printCurrentScores(compScoreLbl,computerScore);
                //upDateLevel(label,e);
                checkTurns(computerScore);
            } else if (computerChoice == 1) { // Computer chooses Rock
                printOutWhoWon("DRAW!");    // Rock vs Rock is a draw
            } else { // Computer chooses Scissors
                printOutWhoWon("PLAYER WON!");  // Rock crushes Scissors
                turns--;
                playerScore++;
                printCurrentScores(userScoreLbl,playerScore);
                //upDateLevel(label,e);
                checkTurns(playerScore);
            }
        } else if (sourceObject == paperButton) { // Player chooses Paper
            if (computerChoice == 0) { // Computer chooses Paper
                printOutWhoWon("DRAW!");    // Paper vs Paper is a draw
            } else if (computerChoice == 1) { // Computer chooses Rock
                printOutWhoWon("PLAYER WON!");  // Rock crushes Paper
                playerScore++;
                turns--;
                printCurrentScores(userScoreLbl,playerScore);
                checkTurns(playerScore);
            } else { // Computer chooses Scissors
                printOutWhoWon("COMPUTER WON!");  // Scissors cut Paper
                computerScore++;
                turns--;
                printCurrentScores(compScoreLbl,computerScore);
                checkTurns(computerScore);
            }
        } else if (sourceObject == scissorsButton) { // Player chooses Scissors
            if (computerChoice == 0) { // Computer chooses Paper
                printOutWhoWon("PLAYER WON!");    // Scissors cut Paper
                playerScore++;
                turns--;
                printCurrentScores(userScoreLbl,playerScore);
                checkTurns(playerScore);
            } else if (computerChoice == 1) { // Computer chooses Rock
                printOutWhoWon("COMPUTER WON!");  // Rock crushes Scissors
                computerScore++;
                turns--;
                printCurrentScores(compScoreLbl,computerScore);
                checkTurns(computerScore);
            } else { // Computer chooses Scissors
                printOutWhoWon("DRAW!");   // Scissors vs Scissors is a draw
            }
        }
        displayWhoWonTimer.start();
    }

	/*private void checkChoice(ActionEvent e) {
		System.out.println("Turns: " + turns);
		System.out.println("Level: " + level);
		//JOptionPane.showMessageDialog(f,"I WAS PRESSED!");
		//Object source = e.getSource();
		switch(turns) {
			case BEST_OF_THREE_GAMES:
				//if(source == bestOfThreeGamesButton) {
					checkWhoWon(bestOfThreeGamesLabel,e);
					//JOptionPane.showMessageDialog(f,"I WAS PRESSED!");
				//}
				break;

			case BEST_OF_FIVE_GAMES:
				//if(source == bestOfFiveGamesButton) {
					checkWhoWon(bestOfFiveGamesLabel,e);
				//}
				break;

			case BEST_OF_TEN_GAMES:
				//if(source == bestOfTenGamesButton) {
					checkWhoWon(bestOfTenGamesLabel,e);
				//}
				break;
		}
	}*/

	/*private void checkWhoWon(ActionEvent e,int computerChoice) {
		Object sourceObject = e.getSource();
		if (sourceObject == rockButton) { // Player chooses Rock
		      if (computerChoice == 0) { // Computer chooses Paper
		         printOutWhoWon("COMPUTER WON!");    // Paper wraps Rock
		         computerScore++;
		         //turns--;
		         //upDateLevel(label,e,computerScore);
		         printCurrentScores(compScoreLbl,computerScore);
		         //checkTurns(computerScore);
		         checkTurns();
		      } else if (computerChoice == 1) { // Computer chooses Rock
		         printOutWhoWon("DRAW!");    // Rock vs Rock is a draw
		      } else { // Computer chooses Scissors
		         printOutWhoWon("PLAYER WON!");  // Rock crushes Scissors
		         //turns--;
		         playerScore++;
		         //upDateLevel(label,e,playerScore);
		         printCurrentScores(userScoreLbl,playerScore);
		        // checkTurns(playerScore);
		         checkTurns();

		      }
		   } else if (sourceObject == paperButton) { // Player chooses Paper
		      if (computerChoice == 0) { // Computer chooses Paper
		         printOutWhoWon("DRAW!");    // Paper vs Paper is a draw
		      } else if (computerChoice == 1) { // Computer chooses Rock
		         printOutWhoWon("PLAYER WON!");  // Rock crushes Paper
               playerScore++;
               turns--;
               printCurrentScores(userScoreLbl,playerScore);
               //checkTurns(playerScore);
               checkTurns();
		      } else { // Computer chooses Scissors
		         printOutWhoWon("COMPUTER WON!");  // Scissors cut Paper
               computerScore++;
               turns--;
               printCurrentScores(compScoreLbl,computerScore);
               //checkTurns(computerScore);
               checkTurns();
		      }
		   } else if (sourceObject == scissorsButton) { // Player chooses Scissors
		      if (computerChoice == 0) { // Computer chooses Paper
		         printOutWhoWon("PLAYER WON!");    // Scissors cut Paper
               playerScore++;
               turns--;
               printCurrentScores(userScoreLbl,playerScore);
               //checkTurns(playerScore);
               checkTurns();
		      } else if (computerChoice == 1) { // Computer chooses Rock
		         printOutWhoWon("COMPUTER WON!");  // Rock crushes Scissors
               computerScore++;
               turns--;
               printCurrentScores(compScoreLbl,computerScore);
               //checkTurns(computerScore);
               checkTurns();
		      } else { // Computer chooses Scissors
		         printOutWhoWon("DRAW!");   // Scissors vs Scissors is a draw
		      }
		   }
		   displayWhoWonTimer.start();
    }*/

	/*private void upDate(int score) {

	}*/

    private void upDateLevel(JLabel label,ActionEvent e,int score) {

        if(score == level) {
            level--;
            label.setText(String.valueOf(level));
        }
    }

    private void checkRoundTurns(int roundScore) {
        if(roundScore >= level) {
            computerRoundScore = 0;
            playerRoundScore = 0;
            printOutCurrentRoundScores(compRoundScoreLabel,computerRoundScore);
            printOutCurrentRoundScores(userRoundScoreLabel,playerRoundScore);
            JOptionPane.showMessageDialog(f, " Game over " + message );
            playAgain();
        }
    }



	/*private void checkRoundTurns(int roundScore) {

	}*/

	/*private void checkScore() {
		if(playerScore > computerScore) {
			playerRoundScore++;
			printOutCurrentRoundScores(userRoundScoreLabel,playerRoundScore);
			checkRoundTurns(playerRoundScore);
		}else if(computerScore > playerScore) {
			computerRoundScore++;
			printOutCurrentRoundScores(compRoundScoreLabel,computerRoundScore);
			checkRoundTurns(computerRoundScore);
		}
	}*/

    private String checkScore() {
        if(computerScore > playerScore) {
            message = " Computer Won! ";
            computerRoundScore++;
            printOutCurrentRoundScores(compRoundScoreLabel,computerRoundScore);
            checkRoundTurns(computerRoundScore);
        }else if(playerScore > computerScore) {
            message = " Player Won! ";
            playerRoundScore++;
            printOutCurrentRoundScores(userRoundScoreLabel,playerRoundScore);
            checkRoundTurns(playerRoundScore);
        }
        return message;
    }

    private void checkTurns(int scores) {
        if(scores >= level) {
            checkScore();
            computerScore = 0;
            playerScore = 0;
            printCurrentScores(compScoreLbl,computerScore);
            printCurrentScores(userScoreLbl,playerScore);
        }
    }

	/*private void checkTurns() {
		if(computerScore >= level) {
			  JOptionPane.showMessageDialog(f, " Round over. Computer reached target score!" );
		        computerScore = 0;
		        playerScore =0;
		        printCurrentScores(compScoreLbl,computerScore);
		        printCurrentScores(userScoreLbl,playerScore);
		    } else if (playerScore >= level) {
		        // Player reached desired score, end the round
		        JOptionPane.showMessageDialog(f, " Round over. Player reached target score!" );
		        computerScore = 0;
		        playerScore = 0;
		        printCurrentScores(compScoreLbl,computerScore);
		        printCurrentScores(userScoreLbl,playerScore);
		    }
	}*/





    private void printOutWhoWon(String message) {
        printOutWhoWonLabel.setText(message);
    }

    private void printLabel(JLabel label,ImageIcon game) {
        label.setIcon(game);
    }

    private int getComputerChoice() {
        int choice = rand.nextInt(gameImagesIcons.length);
        System.out.println("Computer choice " + choice);
        return choice;
    }

    private void setComputerImage(ActionEvent e,int computerChoice) {
        rockPaperScissorsComputerChoiceLabel.setIcon(gameImagesIcons[computerChoice]);
    }

    private void reset() {
        rockLabel.setIcon(null);
        paperLabel.setIcon(null);
        scissorsLabel.setIcon(null);
        rockPaperScissorsComputerChoiceLabel.setIcon(null);
    }

    private void resetButton() {
        bestOfThreeGamesLabel.setText("");
        bestOfFiveGamesLabel.setText("");
        bestOfTenGamesLabel.setText("");
        computerRoundScore = 0;
        playerRoundScore = 0;
        computerScore = 0;
        playerScore = 0;
        printCurrentScores(compScoreLbl,computerScore);
        printCurrentScores(userScoreLbl,playerScore);
        printOutCurrentRoundScores(compRoundScoreLabel,computerRoundScore);
        printOutCurrentRoundScores(userRoundScoreLabel,playerRoundScore);
        bestOfThreeGamesButton.setEnabled(true);
        bestOfFiveGamesButton.setEnabled(true);
        bestOfTenGamesButton.setEnabled(true);
        rockButton.setEnabled(false);
        paperButton.setEnabled(false);
        scissorsButton.setEnabled(false);
    }

    private Color getColor() {
        return Color.RED;
    }

    private void playAgain() {
        int askPlayAgain = JOptionPane.showConfirmDialog(f,"Do you want to play Again?");
        if(askPlayAgain == JOptionPane.YES_OPTION || askPlayAgain == JOptionPane.CANCEL_OPTION) {
            resetButton();
        }else if(askPlayAgain == JOptionPane.NO_OPTION) {
            dispose();
        }
    }


















}



