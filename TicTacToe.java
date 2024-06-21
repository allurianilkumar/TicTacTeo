import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame
{
	public static void main(String [] args)
	{
		new TicTacToe();
	}

	private JButton buttonObjA1, buttonObjA2, buttonObjA3, buttonObjB1, buttonObjB2, buttonObjB3, buttonObjC1, buttonObjC2, buttonObjC3;

	private TicTacToeBoardInfo tictactoeBoardObject;

	public TicTacToe()
	{
		// Set up the grid
		this.setSize(400,400);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle("Tic-Tac-Toe");
		JPanel panel1 = new JPanel();
	    panel1.setSize(300,300);
	    panel1.setLayout(new GridLayout(3,3));
	    buttonObjA1 = createButton("A1");
	    buttonObjA2 = createButton("A2");
	    buttonObjA3 = createButton("A3");
	    buttonObjB1 = createButton("B1");
	    buttonObjB2 = createButton("B2");
	    buttonObjB3 = createButton("B3");
	    buttonObjC1 = createButton("C1");
	    buttonObjC2 = createButton("C2");
	    buttonObjC3 = createButton("C3");
		panel1.add(buttonObjA1);
		panel1.add(buttonObjA2);
		panel1.add(buttonObjA3);
		panel1.add(buttonObjB1);
		panel1.add(buttonObjB2);
		panel1.add(buttonObjB3);
		panel1.add(buttonObjC1);
		panel1.add(buttonObjC2);
		panel1.add(buttonObjC3);
	    this.add(panel1);
	    this.setVisible(true);
		// Start the game
		tictactoeBoardObject = new TicTacToeBoardInfo();
	}

	private JButton createButton(String square)
	{
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(100, 100));
		Font f = new Font("Dialog", Font.PLAIN, 80);
		button.setFont(f);
		button.addActionListener(e -> buttonClick(e, square));
		return button;
	}

	private void buttonClick(ActionEvent e, String square)
	{
		if (tictactoeBoardObject.getSquare(square) != 0)
			return;

		JButton button = (JButton)e.getSource();
		button.setText("X");


		tictactoeBoardObject.playAt(square, 1);

		if (tictactoeBoardObject.isGameOver() == 3)
		{
			JOptionPane.showMessageDialog(null,"It's a draw!", "Game Over",JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}

		if (tictactoeBoardObject.isGameOver() == 1)
		{
			JOptionPane.showMessageDialog(null,"You beat me!", "Game Over",JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}

		String computerMove = tictactoeBoardObject.getNextMove();
		tictactoeBoardObject.playAt(computerMove,2);

		switch (computerMove)
		{
			case "A1":
				buttonObjA1.setText("O");
				break;
			case "A2":
				buttonObjA2.setText("O");
				break;
			case "A3":
				buttonObjA3.setText("O");
				break;
			case "B1":
				buttonObjB1.setText("O");
				break;
			case "B2":
				buttonObjB2.setText("O");
				break;
			case "B3":
				buttonObjB3.setText("O");
				break;
			case "C1":
				buttonObjC1.setText("O");
				break;
			case "C2":
				buttonObjC2.setText("O");
				break;
			case "C3":
				buttonObjC3.setText("O");
				break;
		}

		if (tictactoeBoardObject.isGameOver() == 2)
		{
			JOptionPane.showMessageDialog(null,"I beat you!", "Game Over",JOptionPane.INFORMATION_MESSAGE);
			resetGame();
			return;
		}
	}

	private void resetGame()
	{
		tictactoeBoardObject.reset();
		buttonObjA1.setText("");
		buttonObjA2.setText("");
		buttonObjA3.setText("");
		buttonObjB1.setText("");
		buttonObjB2.setText("");
		buttonObjB3.setText("");
		buttonObjC1.setText("");
		buttonObjC2.setText("");
		buttonObjC3.setText("");
	}
}
