package Lab1;

import java.awt.event.*;

import javax.swing.*;

public class GameTime extends JPanel {

	private static final long serialVersionUID = 1L;

	GameMap gm;
	private final int DELAY_TIME = 1000;

	GameTime(GameMap gmtemp) {
		gm = gmtemp;
		Timer timer = new Timer(DELAY_TIME, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gm.changeMap();
				repaint();
			}
		});
		timer.start();
	}

}
