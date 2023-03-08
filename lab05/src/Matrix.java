public class Matrix {

    private int nrows;
    private int ncols;
    private int[][] matrix;

    public Matrix(int nrows, int ncols){
        this.nrows = nrows;
        this.ncols = ncols;
        matrix = new int[nrows][ncols];
    }

    public Matrix(int[][] arr){
        nrows = arr.length;
        ncols = arr[0].length;
        matrix = arr;
    }

    public Matrix transpose(){
        Matrix n = new Matrix(ncols,nrows);
        for(int i = 0; i<ncols; i++){
            for(int j = 0; j<nrows; j++){
                n.matrix[j][i] = matrix[i][j];
            }
        }
        return n;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i<ncols; i++){
            for(int j = 0; j<nrows; j++){
                str = str + matrix[i][j] + " ";
            }
            str = str + "\n";
        }
        return str;
    }

    public static void main(String[] args){

        int[][] arr = {{0,1,0},{2,4,1},{3,4,5}};
        Matrix m = new Matrix(arr);
        System.out.println(m);
        Matrix t = m.transpose();
        System.out.println(t);

    }

}
