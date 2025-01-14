public class  Matrix{
    private int[][] matrix;
    private int rowslen;
    private int colslen;

    public Matrix(int[][] matrix) {
        if (!isValidMatrix(matrix)) {
            throw new IllegalArgumentException("Ошибка! Неверное построение матрицы");
        }
        this.matrix = matrix;
        this.rowslen = matrix.length;
        this.colslen = matrix[0].length;
    }


    private boolean isValidMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int length = matrix[0].length;
        for (int[] row : matrix) {
            if (row.length != length) {
                return false;
            }
        }
        return true;
    }

    public Matrix multiply(Matrix other) {
        if (this.colslen != other.rowslen) {
            throw new IllegalArgumentException("Matrices cannot be multiplied: incompatible dimensions.");
        }

        int[][] result = new int[this.rowslen][other.colslen];
        for (int i = 0; i < this.rowslen; i++) {
            for (int j = 0; j < other.colslen; j++) {
                for (int k = 0; k < this.colslen; k++) {
                    result[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

