package algorithm;

import java.util.HashMap;
import java.util.Map;


public class ArraySerch {
	
	//¶þ·Ö·¨
	public static int serch(int[] a,int key){
		
		int min=0,max=a.length-1,mid;
		
		while(min<=max){
			mid=(max+min)/2;
			if(key>a[mid]){
				min=mid+1;
			}else if(key<a[mid]){
				max=mid-1;
			}else{
				return mid;
			}
		}
		
		return -1;
		
	}
	
	//Ã°ÅÝÅÅÐò
	public static void sort(int[] a){
		boolean flag=true;
		for(int i=0;i<a.length&&flag;i++){
			flag=false;
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
//		int[] a=new int[]{12,33,45,64,89,21,56,32,99,24,13,54};
//		sort(a);
//		for(int i:a){
//			System.out.print(i+",");
//		}
//		System.out.println(serch(a, 54));
		
		
		Map<String,String> map=new HashMap<String,String>();
		System.out.println(map.get("aa"));
		System.out.println(map.containsKey("aa"));
		
	}
	
}
