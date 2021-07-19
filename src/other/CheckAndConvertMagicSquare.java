package other;

public class CheckAndConvertMagicSquare {

    public static void main(String[] args) {
        /*int mat[][] = {{ 2, 7, 6 },
                { 9, 5, 1 },
                { 4, 3, 8 }};*/
        int mat[][] = {{ 5, 3, 4 },
                { 1, 5, 8 },
                { 6, 4, 2 }};

        if (!isMagicSquare(mat)){
            System.out.println("given matrix is not a magic square converting possibilities now :");

            int result = formingMagicSquare(mat);

        }

        else
            System.out.println("given matrix is magic square");
    }

    static int N=3;



    // Display matrix with label
    static void displayMatrix(String label, int[][] m) {
        System.out.println(label + ": ");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(m[row][col] + " ");
                if (col == 2)
                    System.out.println();
            }
        }
        System.out.println();
    }

    // Rotate matrix
    static int[][] rotate(int[][] mat) {


        int[][] tran = new int[][] {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};

        // **** transpose matrix ****
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                tran[i][j] = mat[j][i];
            }
        }

        // **** interchange the rows of transpose to get rotated matrix ****
        for (int i = 0, j = tran.length - 1; i != j; i++, j--) {
            for (int k = 0; k < tran.length; k++) {
                swap(i, k, j, k, tran);
            }
        }

        // **** return rotated matrix ****
        return tran;
    }

    // Swap
    static void swap(int a, int b, int c, int d, int[][] arr) {
        int temp 	= arr[a][b];
        arr[a][b] 	= arr[c][d];
        arr[c][d] 	= temp;
    }

    // Reflection or rotation of specified matrix
    static int[][] rotationOrReflection(int req) {

        int[][] r = new int[][] {	{8, 1, 6},
                {3, 5, 7},
                {4, 9, 2}};

        // **** ****
        int tmp = 0;
        switch (req) {
            case 0:						// original matrix

                // **** nothing else to do ****

                break;

            case 1:						// vertical reflection
                for (int row = 0; row < 3; row++) {
                    tmp 		= r[row][0];
                    r[row][0] 	= r[row][2];
                    r[row][2] 	= tmp;
                }
                break;

            case 2:						// horizontal reflection
                for (int col = 0; col < 3; col++) {
                    tmp 		= r[0][col];
                    r[0][col] 	= r[2][col];
                    r[2][col] 	= tmp;
                }
                break;

            case 3:						// rotation
                r = rotate(r);
                r = rotate(r);
                break;

            case 4:						// diagonal reflection
                tmp 	= r[0][1];
                r[0][1] = r[1][0];
                r[1][0] = tmp;

                tmp 	= r[0][2];
                r[0][2] = r[2][0];
                r[2][0] = tmp;

                tmp 	= r[2][1];
                r[2][1] = r[1][2];
                r[1][2] = tmp;
                break;

            case 5:						// rotation
                r = rotate(r);
                r = rotate(r);
                r = rotate(r);
                break;

            case 6:						// rotation
                r = rotate(r);
                break;

            case 7:						// diagonal reflection
                tmp 	= r[0][0];
                r[0][0] = r[2][2];
                r[2][2] = tmp;

                tmp 	= r[0][1];
                r[0][1] = r[1][2];
                r[1][2] = tmp;

                tmp 	= r[1][0];
                r[1][0] = r[2][1];
                r[2][1] = tmp;
                break;
        }

        // **** ****
        return r;
    }


    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        // **** save original matrix ****
        int[][] ss = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                ss[r][c] = s[r][c];
            }
        }

        // **** loop selecting the minimum cost ****
        int minCost = Integer.MAX_VALUE;
        for (int pass = 0; pass < 8; pass++) {

            // **** restore original matrix ****
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    s[r][c] = ss[r][c];
                }
            }

            // **** get a magic square ****
            int[][] ms = rotationOrReflection(pass);

//        	// **** display this magic square ****
            displayMatrix("ms", ms);

            // **** compute cost for this pass ****
            int cost	= 0;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (ms[row][col] != s[row][col]) {
                        cost += Math.abs(s[row][col] - ms[row][col]);
                    }
                }
            }

//	    	// **** display resulting matrix ****
//	    	displayMatrix("s", s);
//
//	    	// **** display cost ****
	    	System.out.println("cost: " + cost);

            // **** update minimum cost ****
            minCost = Math.min(minCost, cost);
        }

        // **** return minimum cost ****
        return minCost;
    }

    static boolean isMagicSquare(int mat[][])
    {

        // sumd1 and sumd2 are the sum of the two diagonals
        int sumd1 = 0,sumd2=0;
        for (int i = 0; i < N; i++)
        {
            // (i, i) is the diagonal from top-left -> bottom-right
            // (i, N - i - 1) is the diagonal from top-right -> bottom-left
            sumd1 += mat[i][i];
            sumd2 += mat[i][N-1-i];
        }
        // if the two diagonal sums are unequal then it is not a magic square
        if(sumd1!=sumd2)
            return false;

        // calculating sums of Rows and columns and checking if they are equal to each other,
        // as well as equal to diagonal sum or not
        for (int i = 0; i < N; i++) {

            int rowSum = 0, colSum = 0;
            for (int j = 0; j < N; j++)
            {
                rowSum += mat[i][j];
                colSum += mat[j][i];
            }
            if (rowSum != colSum || colSum != sumd1)
                return false;
        }


        return true;
    }
}
