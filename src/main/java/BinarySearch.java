import java.io.FileNotFoundException;

public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi =a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]){
                hi = mid - 1;
            }else if(key > a[mid]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return - 1;
    }

    public static void main(String[] args) {
        try {
            In in = new In(args[0]);
            int[] whiteList = in.readAllInts();
            int key = Integer.parseInt(args[1]);
            int result = rank(key,whiteList);
            System.out.println("result = " + result);
        }catch (FileNotFoundException e){
            System.out.println("File not found : " + args[0]);
            e.printStackTrace();
        }

    }

}
