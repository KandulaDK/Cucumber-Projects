package org.projectsHyr;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={13,2,3,4,5,9,7,11,10};

		for(int i=0;i<arr.length;i++)
		{
		    int temp;
			for(int j=i+1;j<arr.length;j++)
			{
			   if(arr[i]>arr[j])
			    {
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
		 
			    }
			}
		}

	}

}
