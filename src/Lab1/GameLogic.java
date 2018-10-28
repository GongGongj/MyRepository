package Lab1;

public class GameLogic {
	
	private int next[][];//新地图
	private int temp[][];//原地图
	
	GameLogic(int t[][]){
		next = new int[t.length][t[0].length];
		temp = new int[t.length][t[0].length];
		copyMap(t,temp);
		copyMap(t,next);
		changeCellStatus();
	}
	//循环判断每个点周围的生细胞
    private void changeCellStatus() {//细胞生死状态，1生，0死
        for (int row = 0; row < temp.length; row++) {  
            for (int col = 0; col < temp[row].length; col++) { 
            	int nCount = neighborsCount(row, col);
            	if(nCount==3) next[row][col] = 1;
            	else if(nCount==2) ;
            	else next[row][col] = 0;
            }  
        } 
    }  
    
    //每个点周围生细胞计数
    private int neighborsCount(int row, int col) {  
        int count = 0, r = 0, c = 0;  
  
        for (r = row - 1; r <= row + 1; r++) {  
            for (c = col - 1; c <= col + 1; c++) {  
                if (r < 0 || r >= temp.length || c < 0  
                        || c >= temp[0].length) {  
                    continue;  
                }  
                if (temp[r][c] == 1) {  
                    count++;  
                }  
            }  
        }  
        if (temp[row][col] == 1) {  
            count--;  
        }  
        return count;  
    }  
	
    public int[][] getNext() {
		return next;
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
