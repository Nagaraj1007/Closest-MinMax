
public class Main {
    public static int countOfMinMaxSubArray (int array[]){
        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        int latestMinIndex = -1, latestMaxIndex = -1;
        for (int element : array){
            maxElement = Math.max(element,maxElement);
            minElement = Math.min(element,minElement);
        }
        int countOfSubArray = Integer.MAX_VALUE;
        for (int iterator = 0 ; iterator < array.length ; iterator++){
            if (array[iterator] == maxElement){
                latestMaxIndex = iterator;
                if (latestMinIndex >= 0){
                    countOfSubArray = Math.min(Math.abs(iterator - latestMinIndex )+ 1,countOfSubArray);
                }
            }
            if (array[iterator] == minElement){
                latestMinIndex = iterator;
                if (latestMaxIndex >= 0){
                    countOfSubArray = Math.min(Math.abs(iterator - latestMaxIndex )+ 1,countOfSubArray);
                }
            }
        }
        return countOfSubArray;
    }

    public static void main(String[] args) {
        int array[] = {1,3,2};
        System.out.println(countOfMinMaxSubArray(array));
    }
}