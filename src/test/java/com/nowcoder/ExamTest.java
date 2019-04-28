package com.nowcoder;

/**
 * Created by dell--pc on 2016/8/30.
 */
public class ExamTest {
    public static int findMin(int n){

        int[] nums=new int[n];
        int min=dfs(nums,0,n);
        return min;

    }
    public static int dfs(int[] nums,int count,int n){  //使用深度优先遍历

        if(n==0){
            return count;
        }
        int temp=nums[n-1];
        if(temp!=0){
            return count+temp;
        }

        int min=9999;
        int k=(int)Math.sqrt(n);
        for(int i=k;i>=(i/2+1);i--){
            int num=n-(int)Math.pow(i, 2);
            int c=dfs(nums, count+1, num);              //递归查找
            min=Math.min(c, min);
        }
        nums[n-1]=min;
        return min;
    }


    public static void main(String[] args) {
        int n=12;
        System.out.print(n+"的最少完全平方数有");
        System.out.println(findMin(n)+"个");
        n=13;
        System.out.print(n+"的最少完全平方数有");
        System.out.println(findMin(n)+"个");

    }
}
