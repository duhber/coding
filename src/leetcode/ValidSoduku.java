package leetcode;

public class ValidSoduku {
	public static void main(String[] args){
		
	}
	
	public boolean isValidSudoku(char [][]board){
		int height = 9;
		int width = 9;
		int [][]hash = new int[height*2][width];
		int[][] box = new int[height][width];
		
		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				char token = board[i][j];
				if(token == '.'){
					continue;
				}
				int hashCode = token - '0';
				int indexCode = (i/3)*3 + j/3;
				if(box[indexCode][hashCode]>0 || hash[i][hashCode]>0 || hash[height+j][hashCode]>0){
					return false;
				}
				box[indexCode][hashCode]++;
				hash[i][hashCode]++;
				hash[height+j][hashCode]++;
			}
		}
		
		
		return true;
	}
}
