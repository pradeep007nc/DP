package prac;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int temp = new RemoveElement().removeElement(nums, 3);
        for (int i=0;i<temp;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            if(nums[left] == val){
                while(nums[right] == val && right > left){
                    right--;
                }
                swap(nums, left, right);
                left++;
            }
            else
                left++;
        }

        return left;
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
