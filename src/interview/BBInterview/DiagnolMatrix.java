package interview.BBInterview;

public class DiagnolMatrix {
    /**
     * Left top
     * x=0
     * y=0
     * Right bottom
     * x=n
     * y=n
     *
     *
     *
     *
     * Right top
     * x=0
     * y=n
     *
     *
     * Left bottom
     * x=n
     * y=0
     */
    public static char[][] insertDiagnolX(int n)
    {
        char[][] matrix = new char[n][n];
        int x=0,y=0;
        for(int i=0;i<n;i++)
        {
            matrix[x][y]='X';
            matrix[x++][n- y++ -1]='X';
        }
        return matrix;
    }

    public static void main(String[] args)
    {
        for(char[] lines : insertDiagnolX(10))
        {
            for(char k : lines)
            {
                System.out.print(k+" ");
            }
            System.out.println("");
        }
    }

}
