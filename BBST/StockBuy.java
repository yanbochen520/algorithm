package BBST;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: ybchen
 * @Date: 2020/03/23/9:32
 * @Description
 */

public class StockBuy {
    int sum=0;
    public static int maxProfit(int[] num ){
      int minPrice=Integer.MAX_VALUE;
      int maxProfit=-1;
      for(int i=0;i<num.length;i++){
          minPrice=Math.min(minPrice,num[i]);
          if(num[i]>minPrice){
              maxProfit=Math.max(num[i]-minPrice,maxProfit);
          }
      }
      return maxProfit;
    }
    public int[] twoSum(int[] nums, int target) {
        //int [] result= new int[2];
        int i=0;
        int j= nums.length-1;
        int temp=nums[i]+nums[j];
        while(i<j){
            if (temp<target){
                i=i+1;
            }else if(temp>target){
                j=j-1;
            }else{
                break;
            }
        }
        return new int[]{nums[i],nums[j]};
    }
    public int cuttingRope(int n) {
        if(n==0||n==1||n==2){
            return 1;
        }else if(n==3){
            return 2;
        }
        int[] result = new int[n + 1];
        result[0]=1;
        result[1]=1;
        result[2]=1;
        result[3]=2;
        for (int i = 4; i <= n; i++) {
            for (int L = 1; L < 4; L++) {
                result[i] = Math.max(L*(i-L), L * result[i - L]);
            }
        }
        return result[n];
    }
    /**
     * 树得深度
     * @param root
     * @return
     */
    public  int depth(TreeNode root){
        if(root==null){
            return -1;
        }else{
            int left=depth(root.left);
            int right=depth(root.right);
            if(Math.abs(left-right)>1){
                sum=sum+1;
            }
                return Math.max(left,right)+1;

        }
    }
//    public static boolean isBalanced(TreeNode root){
//        if (root==null){
//            return true;
//        }else{
//          boolean left= isBalanced(root.left);
//          boolean right= isBalanced(root.right);
//          return 0;
//        }
//    }

    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        int res=maxProfit(arr);
        System.out.println(res);
    }
}
