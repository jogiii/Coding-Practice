package arraylist;

public class Anagram {


    public static boolean isAnagram(String str1,String str2){

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int[] arr = new int[256];

        //int [] ar= {0,0,0};

       /* if(c1.length!=c2.length)
            return false;
        for(int i=0;i<c1.length;i++){
            if(c1[i]=='a'){
                ar[0]=ar[0]+1;
            }

            if(c1[i]=='b'){
                ar[1]=ar[1]+1;
            }
            if(c1[i]=='c'){
                ar[2]=ar[2]+1;
            }

        }

        for(int i=0;i<c2.length;i++){
            if(c2[i]=='a'){
                ar[0]=ar[0]-1;
            }

            if(c2[i]=='b'){
                ar[1]=ar[1]-1;
            }
            if(c2[i]=='c'){
                ar[2]=ar[2]-1;
            }

        }*/

        for(int i=0;i<c1.length;i++){
            int index = (int)c1[i];
            //System.out.println(index);
            arr[index]++;
        }

        for(int i: arr){
            System.out.println("phle chla "+i);
            if(i<0)
                return false;



        }

        for(int i=0;i<c2.length;i++){
            int index = (int)c2[i];
            //System.out.println(index);
            arr[index]--;
        }

        for(int i: arr){
            System.out.println("baad me chla "+i);
            if(i<0)
                return false;



        }

        return true;
    }

    public static void main(String[] args) {
        boolean b=isAnagram("aaba","aaba");
        System.out.println(b);
    }
}
