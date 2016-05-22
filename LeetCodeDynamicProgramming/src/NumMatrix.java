public class NumMatrix {
  private int[][] matrix;
  private int row, col;

  public NumMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      row = 0;
      col = 0;
      return;
    }
    row = matrix.length + 1;
    col = matrix[0].length + 1;
    this.matrix = new int[row][col];

    for (int i = 1; i < row; i++)
      for (int j = 1; j < col; j++) {
        this.matrix[i][j] = this.matrix[i - 1][j] + this.matrix[i][j - 1] + matrix[i - 1][j - 1]
            - this.matrix[i - 1][j - 1];
      }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (row2 >= row || col2 >= col)
      return 0;
    return this.matrix[row2 + 1][col2 + 1] - this.matrix[row1][col2 + 1]
        - this.matrix[row2 + 1][col1] + this.matrix[row1][col1];
  }
  
  public static void main(String[] args) {
    int[][] matrix =  {
        {3, 0, 1, 4, 2},
        {5, 6, 3, 2, 1},
        {1, 2, 0, 1, 5},
        {4, 1, 0, 1, 7},
        {1, 0, 3, 0, 5}
      };
 NumMatrix numMatrix = new NumMatrix(matrix);
  System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
  System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
  }
}

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);