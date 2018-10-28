package Lab1;

import java.awt.*;

import javax.swing.*;

public class GameMap extends JPanel{
	
	private static final long serialVersionUID = 1L;

	//初始化地图
	private final int width = 27;  
    private final int height = 27;
	private static final int [][]world= {//20*20
			{0,0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0},//
			{0,0,0, 0,0,0,0,0,1,1,1,0,0,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,1,1,0,0,0,1,1,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,1,0,0,0,0,0,0,0,1,0,0, 0,0,0,0},
			{0,0,0, 0,1,0,0,0,0,0,0,0,0,0,1,0, 0,0,0,0},
			{0,0,0, 0,1,0,0,0,1,1,1,0,0,0,1,0, 0,0,0,0},
			{0,0,0, 1,0,0,0,1,0,0,0,1,0,0,0,1, 0,0,0,0},
			{0,0,0, 1,1,1,1,1,0,0,0,1,1,1,1,1, 0,0,0,0},
			{0,0,0, 1,0,0,0,1,0,0,0,1,0,0,0,1, 0,0,0,0},
			{0,0,0, 0,1,0,0,0,1,1,1,0,0,0,1,0, 0,0,0,0},
			{0,0,0, 0,1,0,0,0,0,0,0,0,0,0,1,0, 0,0,0,0},
			{0,0,0, 0,0,1,0,0,0,0,0,0,0,1,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,1,1,0,0,0,1,1,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,0,0,1,1,1,0,0,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0},//
			{0,0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0},
			{0,0,0, 0,0,0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0}
	};
	
	private int[][] nextStatus = new int[world.length][world[0].length];
	private int[][] tempStatus = new int[world.length][world[0].length];
	
	//初始化
	GameMap() {
		copyMap(world,nextStatus);
		repaint();
		GameTime gt = new GameTime(this);
	}
	
	//每一步
	public void changeMap() {
		mapUpdate();
		repaint();
	}
	
	//调用GameLogic更新地图
	void mapUpdate() {
		copyMap(nextStatus,tempStatus);
		GameLogic gl = new GameLogic(tempStatus);
		copyMap(gl.getNext(),nextStatus);
	}
	
	//画地图
	protected void paintComponent(Graphics g) {  
	        super.paintComponent(g);  
	        for (int i = 0; i < nextStatus.length; i++) {  
	            for (int j = 0; j < nextStatus[i].length; j++) {  
	                if (nextStatus[i][j] == 1) {  
	                    g.fillRect( j * width, i * height, width, height);  
	                   
	                } else {  
	                	 g.drawRect( j * width, i * height, width, height); 
	                }  
	            }  
	        }  
	    }  
		
	//a->b
	private void copyMap(int[][] a ,int[][] b) {  
        for (int row = 0; row < b.length; row++) {  
            for (int col = 0; col < b[row].length; col++) {  
                b[row][col] = a[row][col]; 
            }  
        }  
    }  
}
