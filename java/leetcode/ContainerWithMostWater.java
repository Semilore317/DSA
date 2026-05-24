// LeetCode #11 - Container With Most Water

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int n = height.length;
        //{20,2,3,4,5,20,7}
        int left = 0;
        int right = n-1;
        int maxArea = 0;

        while(left < right){
            int width = right-left;
            int area = width * Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]){
               left++; // moving the left pointer forward
            }else{
               right--; // moving the right pointer backward
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {

        //int[] height ={1,8,6,2,5,4,8,3,7};
        int[] height = {1,2,1};
        //int[] height = {1,1};
        ContainerWithMostWater p = new ContainerWithMostWater();
        System.out.println(p.maxArea(height));
    }
}
