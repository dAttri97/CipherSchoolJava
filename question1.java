import java.util.*;
public class Main{
    public static void main(String[] args){
    	part1();
        part2();
    }
    public static void part1(){
    	int n=5;
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++)
    			System.out.print(" ");
    		for(int j=0;j<=i;j++)
    			System.out.print("* ");
    		System.out.println();
    	}
    }
    public static void part2(){
        int count=0,n=4;
        for(int i=n;i>=0;i--){
            for(int j=0;j<2*i;j++)
                System.out.print(" ");
            for(int j=i;j<=n;j++)
                System.out.print((char)('A'+(count++))+" ");
            System.out.println();
        }
    }
}