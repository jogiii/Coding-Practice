package arraylist;

public class MaxMin {

    public int [] findMinMax(int arr[]){
        int retArr[] = new int[2];
        int min = 0;
        int max =arr.length-1;
        int t = arr.length;
        for(int i=1;i<arr.length;i++){
            t--;
            if(arr[min]>arr[i]){
                min=i;
            }
            if(arr[max]<arr[t]){
                max=t;
            }
        }
        retArr[0] = arr[min];
        retArr[1] = arr[max];

        return retArr;
    }

    public static void main(String[] args) {
        int inpArr[] = {1,3,5,6,7,9,2};
        MaxMin m = new MaxMin();
       int output[] =  m.findMinMax(inpArr);

        System.out.println("Minimum Value :"+output[0]);
        System.out.println("Maximum Value :"+output[1]);
    }
}
