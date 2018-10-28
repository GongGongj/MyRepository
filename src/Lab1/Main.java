package Lab1;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	private static final long serialVersionUID = 1L;

	Main(){
		this.setSize(545,580);  
        this.setTitle("…˙√¸”Œœ∑[LifeGame]DEMO");  
        this.add(new GameMap());  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);  
        this.setResizable(false);  
	}

	public static void main(String[] args) {
		 Main game = new Main();  
	     game.setVisible(true);
	}

}
