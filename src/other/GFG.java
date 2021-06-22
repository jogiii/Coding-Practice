package other;

class GFG {

    // Function to find the minimum
    // of the maximum difference of the
    // adjacent elements after removing
    // K elements from the array


    public static int getSecondLargest(int[] a, int total){
        int temp;
        for (int i = 0; i < total; i++)
        {
            for (int j = i + 1; j < total; j++)
            {
                if (a[i] > a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return total-2;
    }

    static int largest(int[] arr)
    {
        //int i;

        // Initialize maximum element


        int max = arr[0];
        int index = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (max < arr[i])
            {
                max = arr[i];
                index = i;
            }
        }

        return index;
    }



    // Driver Code
    public static void main (String[] args)
    {
        int n = 4;
        int k = 2;

        int []a = { 8,8,4,3 };
        System.out.println(largest(a));
        System.out.println(getSecondLargest(a,n));

       // System.out.println(minimumAdjacentDifference(a, n, k));
    }
}