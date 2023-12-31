// Runtime: 2 ms (Top 99.39%) | Memory: 51.9 MB (Top 97.80%)
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int average=0,count=0,start=0,sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(i>=k-1){
                average=sum/k;
                if(average>=threshold) count++;
                sum-=arr[start];
                start++;
            }
        }
        return count;
    }
}