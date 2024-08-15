
public class DiverseArray {

    /**
     * Returns the sum of the entries in the one-dimensional array arr.
     *
     * @param arr
     * @return
     */
    public static int arraySum( int[] arr ) {
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        return sum;
    }

    /**
     * Returns a one-dimensional array in which the entry at index k is the sum
     * of entries of row k of the two-dimensional array arr2D.
     *
     * @param arr2D
     * @return
     */
    public static int[] rowSums( int[][] arr2D ) {
        int[] ret = new int[arr2D.length];
        for(int i = 0; i<ret.length; i++){
            ret[i] = arraySum(arr2D[i]);
        }
        return ret;
    }

    /**
     * @param arr2D
     * @return true if all rows in arr2D have different row sums; false
     * otherwise
     */
    public static boolean isDiverse( int[][] arr2D ) {
        HashSet<int> set = new HashSet<int>();
        int[] sums = rowSums(arr2D);
        for(int i = 0; i<sums.length; i++){
            if(!set.contains(sums[i])){
                set.add(sums[i]);
            }else{
                return false;
            }
        }
        return true;
    }

}
