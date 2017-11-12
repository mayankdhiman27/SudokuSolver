package sudokusolverrecursion;
import java.util.*;

/**
 *
 * @author dmayank
 */
public class SudokuSolverRecursion {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
            int mat[][] =
        {{5,3,0,0,7,0,0,0,0},
        {6,0,0,1,9,5,0,0,0},
        {0,9,8,0,0,0,0,6,0},
        {8,0,0,0,6,0,0,0,3},
        {4,0,0,8,0,3,0,0,1},
        {7,0,0,0,2,0,0,0,6},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,8,0,0,7,9}};
            
            
            print(mat,n);
            System.out.println();
            solveSudoku(mat,0,0,n);
    }

    static void print(int[][] mat, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean solveSudoku(int[][] mat, int i, int j, int n) {
        //Base case
        if(i==n){
            print(mat,n);
            return true;
        }
        if(j==n){
            return solveSudoku(mat,i+1,0,n);
        }
        
        //skip the blue cell,i.e filled cell
        if(mat[i][j]!=0){
            return solveSudoku(mat,i,j+1,n);
        }
        
        //white cell, i.e, cell to be filled
        for(int no=1;no<=n;no++){
            if(canPlace(mat,no,i,j,n)){
                
                mat[i][j]=no;
                boolean solvehuikya=solveSudoku(mat,i,j+1,n);
                if(solvehuikya){
                    return true;
                }
                //Backtracking
                mat[i][j]=0;
            }
        }
        return false;
    }

    static boolean canPlace(int[][] mat, int no, int i, int j, int n) {
        //Row check
        
        for(int x=0;x<n;x++){
            if(mat[i][x]==no){
                return false;
            }
        }
        
        //Col check
        
        for(int y=0;y<n;y++){
            if(mat[y][j]==no){
                return false;
            }
        }
        
        //Subgrid check  (sqrt(n)*sqrt(n))
        
        int rn=(int )Math.sqrt(n);
        int sx=(i/rn)*rn;       //just like i for subgrid
        int sy=(j/rn)*rn;       //just like j for subgrid
        
        for(int x=sx;x<sx+rn;x++){
            for(int y=sy;y<sy+rn;y++){
                if(mat[x][y]==no){
                    return false;
                }
            }
        }
        return true;
    }
    
}

