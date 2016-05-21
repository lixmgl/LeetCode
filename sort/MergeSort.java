public class MergeSort{
	public static void main(String[] args){
		int[] arr ={10,0,-2,15,0,1,5};
		mergeSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	public static void mergeSort(int[] arr){
		mergeSort(arr,0,arr.length-1);
	}
	public static void mergeSort(int[] arr, int left, int right){
		int middle=left+(right-left)/2;
		if(left<right){
			mergeSort(arr,left, middle);
			mergeSort(arr,middle+1,right);
		}
		merge(arr,left,middle,right);
	}
	public static void merge(int[] arr, int left, int middle, int right){
		int[] temp=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			temp[i]=arr[i];
		}
		int leftIndex=left;
		int rightIndex=middle+1;
		int index=left;
		while(leftIndex<=middle && rightIndex<=right){
			if(temp[leftIndex]<temp[rightIndex]){
				arr[index]=temp[leftIndex];
				leftIndex++;
				index++;
			}else{
				arr[index]=temp[rightIndex];
				rightIndex++;
				index++;
			}
		}
		int remaining=middle-leftIndex;
		for(int i=0;i<=remaining;i++){
			arr[index+i]=temp[leftIndex+i];
		}
	}
}