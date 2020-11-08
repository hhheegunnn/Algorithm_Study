import java.util.Scanner;

public class boj_S5_2750_Yearang {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] nlist = new int[n];
        for(int i = 0; i < n ; i++)
        {
            nlist[i] = s.nextInt();
        }

        sort(nlist, 0, nlist.length-1);
        for (int i = 0; i < nlist.length; i++) {
            System.out.println(nlist[i]);
        }

    }
    public static void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];

        do{
            while(data[left] < pivot) left++;
            while(data[right] > pivot) right--;
            if(left <= right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }while (left <= right);

        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
}
