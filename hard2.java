package problems;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main {
	int n=0;
	public static int[] segment=new int[n+1];
	public static void segmentbuild(int index,int l,int r,int[] b) {
		if(l==r) {
			segment[index]=b[l];
		}
		int mid=(l+r)/2;
		segmentbuild(2*index,l,mid,b);
		segmentbuild(2*index+1,mid+1,r,b);
		segment[index]=Math.max(segment[2*index], segment[2*index+1]);
	}
	public static int query(int index,int l,int r,int ql,int qr) {
		if(ql>r && qr<l) {
			return -1;
		}
		if(l<=ql && r>=qr) {
			return segment[index];
		}
		int mid=(l+r)/2;
		return Math.max(query(2*index,l,mid,ql,qr), query(2*index+1,mid+1,r,ql,qr));
	}
    public static void main(String[] args) throws Exception {
       BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       n=Integer.parseInt(bf.readLine());
       int[] arr=new int[n+1];
       int[] b=new int[n+1];
       System.out.println("solider");
       for(int i=0;i<n;i++) {
    	   arr[i]=Integer.parseInt(bf.readLine());
       }
       System.out.println("power");
       for(int i=0;i<n;i++) {
    	   b[i]=Integer.parseInt(bf.readLine());
       }
       segmentbuild(1,0,n,b);
       for(int i=0;i<n;i++) {
    	   for(int j=i+1;j<n;j++) {
    		   if(arr[j]%arr[i]==0) {
    			   int result=query(1,0,n,i,j);
    			   System.out.println(result);
    		   }
    	   }
       }
    }
}
