import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class TTT extends JPanel implements MouseListener, ActionListener{
	private String move; 
	private boolean invalid; 
	String[][] board = {{"#", "#", "#"}, {"#", "#", "#"}, {"#", "#", "#"}};
	private Rectangle2D[] box = new Rectangle2D[9]; 
	private ImageIcon X, O, gridBg; 
	private JFrame frame = new JFrame();
	private Timer gameTimer; 
	public static void main(String[] args)
	{
		new TTT();
	}	
	public TTT() { 

		move = "X"; 
		invalid = false; 
		
		for (int i = 0; i < box.length; i++) {
			box[i] = new Rectangle2D.Double(0, 0, 0, 0); 
		}

		gridBg = new ImageIcon("97-976890_grid-tic-tac-toe-layout.png");

		addMouseListener(this);
		setFocusable(true);
		requestFocus();

		frame.setContentPane(this);
		frame.setSize(1000, 1000);
		frame.setTitle("TIC TAC TOE");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true);
		setLayout(null);
		gameTimer = new Timer(16, this); 
		gameTimer.start(); 
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(gridBg.getImage(), 0, 0, this); 
		frame.setSize(gridBg.getIconWidth(), gridBg.getIconHeight());
		box[0] = new Rectangle2D.Double(75, 50, 200, 200); 
		box[1] = new Rectangle2D.Double(315, 50, 200, 200); 
		box[2] = new Rectangle2D.Double(550, 50, 200, 200); 
		box[3] = new Rectangle2D.Double(75, 285, 200, 200); 
		box[4] = new Rectangle2D.Double(315, 285, 200, 200); 
		box[5] = new Rectangle2D.Double(550, 285, 200, 200); 
		box[6] = new Rectangle2D.Double(75, 520, 200, 200); 
		box[7] = new Rectangle2D.Double(315, 520, 200, 200); 
		box[8] = new Rectangle2D.Double(550, 520, 200, 200); 
		for (int i = 0; i < box.length; i++) {
			Color red = new Color(255, 0, 0); 
			g2.setColor(red);
			g2.fill(box[i]); 
		}
	}
	public void mouseClicked(MouseEvent e) {
		checkClicked(e.getX(), e.getY()); 
		printBoard(); 
	}
	private void printBoard() {
		System.out.println(); 
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				System.out.print(board[i][k] + " "); 
			}
			System.out.println(); 
		}
	}
	private void checkClicked(int mouseX, int mouseY) {
		for (int i = 0; i < box.length; i++) {
			if (mouseX >= box[i].getX() && mouseX <= box[i].getX() + box[i].getWidth() && mouseY >= box[i].getY() && mouseY <= box[i].getY() + box[i].getHeight()) {

				if (i >= 0 && i <= 2) {
					if (board[0][i] == "#") {
						board[0][i] = move; 
						invalid = true; 
					}
					else {
						invalid = false;  
					}
				}
				else if (i >= 3 && i <= 5) { 
					if (i == 3) {
						board[1][0] = move; 
						invalid = true; 
					}
					else if (i == 4 && board[1][1] == "#") {
						board[1][1] = move; 
						invalid = true; 
					}
					else if (i == 5 && board[1][2] == "#"){
						board[1][2] = move; 
						invalid = true; 
					}
					else {
						invalid = false; 
					}
				}
				else if (i >= 6){ 
					if (i == 6 && board[1][0] == "#") {
						board[2][0] = move; 
						invalid = true; 
					}
					else if (i == 7 && board[1][1] == "#") {
						board[2][1] = move; 
						invalid = true; 
					}
					else if (i == 8 && board[1][2] == "#"){
						board[2][2] = move; 
						invalid = true; 
					}
					else {
						invalid = false; 
					}
				}
			}
		}
		
		if (!invalid) {
			if (move == "X") {
				move = "O"; 
			}
			else if (move == "O") {
				move = "X"; 
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void actionPerformed(ActionEvent e) {
	}
}
