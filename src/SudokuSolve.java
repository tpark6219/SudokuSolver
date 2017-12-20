
public class SudokuSolve {

	private static int[][]sudoku;

	public static void main(String [] args)
	{
		SudokuSolve inst = new SudokuSolve();
		inst.sudoku = new int[][] { { 1, 0, 3, 0 },
			{ 0, 0, 0, 0 }, { 2, 0, 4, 0},
			{ 0, 0, 0, 0 }, };
				
			sudokuStart();
				
			for (int row = 0; row < 4; row++) {
				if (row % 2 == 0) {
					System.out.println(); 
				}
				for (int col = 0; col < 4; col++) {
					if (col % 2 == 0) {
						System.out.print(" "); 
					}
					System.out.print(inst.sudoku[row][col] + " ");

				}
				System.out.println();
			}
				
	}
	
	public static boolean sudokuStart()
	{
		int[] Blanks = findblank(); 
		int row = Blanks[0];
		int col = Blanks[1];
		if (row == -1) {
			return true;
		}
		for (int i = 1; i <= 4; i++)
		{
			if(!InRow(row, i) && !InColumn(col, i)
					&& !InBox(row - row % 2, col - col % 2, i))
			{
				sudoku[row][col] = i;
				if(sudokuStart())
				{
					return true;
				}
				sudoku[row][col] = 0;
			}
		}
		return false;
	}
	
	public static boolean InRow(int row, int n) {
		for (int i = 0; i < 4; i++) {
			if (sudoku[row][i] == n) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean InColumn(int col, int n) {
		for (int i = 0; i < 4; i++) {
			if (sudoku[i][col] == n) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean InBox(int startrow, int startcol, int n) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				if (sudoku[i + startrow][j + startcol] == n) {
					return true;
				}
			}
		}
		return false;
	}
	public static int[] findblank() {
		int[] cell = new int[2]; 
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (sudoku[i][j] == 0) {
					cell[0] = i;
					cell[1] = j;
					return cell;
				}
			}
		}
		cell[0] = -1;
		cell[1] = -1;
		return cell;
	}
}
