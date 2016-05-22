public class BinarySearch{
	public static void main(String[]args){
		BinarySearch bs = new BinarySearch();
		int[] arr={1,1,2,3,3,4,5,6};
		int result=bs.binarySearch(arr,7);
		System.out.println(result);
	}

	public static int binarySearch(int[] arr, int target){
		if(arr==null || arr.length==0) return -1;
		int left=0;
		int right=arr.length-1;
		while(left+1<right){
			int middle=left+(right-left)/2;
			if(arr[middle]==target) return middle;
			else if(arr[middle]<target) left=middle;
			else right=middle;
		}
		if(arr[left]==target) return left;
		if(arr[right]==target) return right;
		return -1;
	}
}