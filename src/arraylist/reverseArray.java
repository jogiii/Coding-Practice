package arraylist;

public class reverseArray {


    public int[] revArray(int[] arr){
        int start=0;
        int last=arr.length-1;
        int temp;

        while(start<last){
            temp=arr[start];
            arr[start]=arr[last];
            arr[last]=temp;

            start++;
            last--;
        }

        return arr;
    }

   /* public int[] revArray(int arr[]){
        int last=arr.length -1;
        int start = 0;
        int temp ;

        while(start<last){

           temp = arr[start];
           arr[start] = arr[last];
           arr[last] = temp;

           start++;
           last--;

        }


        return arr;
    }*/

    public static void main(String[] args) {

        int inputArr[] = {1,2,3,4,5,6};
        reverseArray arr = new reverseArray();
        int revArr[] = arr.revArray(inputArr);


        for(int i=0;i<revArr.length;i++){
            System.out.print(revArr[i]);

        }
    }
}
