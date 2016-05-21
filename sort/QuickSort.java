public class QuickSort{
    public static void main(String[]args){
        QuickSort qs=new QuickSort();
        int[] arr={10,-1,0,15,3,5,-5};
        qs.quickSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }
    public void quickSort(int[] arr, int left, int right){
        if(left<right){
            int index=split(arr,left,right);
                quickSort(arr, left, index - 1);
                quickSort(arr, index + 1, right);
        }
    }
    public int split(int[] arr, int left, int right){
        int pivot=arr[left];
        int start=left;
        while(left<right){
            while(arr[left]<=pivot) {left++;}
            while(arr[right]>pivot) {right--;}
            if(left<right) swap(arr,left,right);
        }
        swap(arr,start,right);
        return right;
    }
    public void swap(int[] arr, int x, int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}

//pay attention to final switch: pivot with right index, because left index already moved to the place larger than the pivot
//pay attention to == situation, left index++ need include the == case.