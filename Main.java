// CS 3240A / CS 5250A Fall 2024
// starter code for Assignment #4

public class Main {

    public static void main(String argv[]) {
        Object rtnval1[] = testOne();
        Object rtnval2[] = testTwo();
        Object rtnval3[] = testThree();

        int arr[] = (int[]) rtnval1[1];
        int numInversions = (int) rtnval1[0];
        System.out.println("# inversions = " + numInversions);
        System.out.print("[");
        for (int i=0; i<arr.length; ++i)
            System.out.print(" " + arr[i]);
        System.out.println("]");
    }

    //---------------------------------------------------

    public static Object[] sortAndCount(int values[]) {
        System.out.println("sortAndCount");
        // implement this

        Object[] rtnval = new Object[2];
        Object[] merged = new Object[values.length];


        if(values.length == 1){
            // there are no inversions
            // TODO: what to do here? return null?
            rtnval[0] = 0;
            rtnval[1] = values;
            return rtnval;
        } else{
            int [] first_half;
            if(values.length % 2 == 0){
                first_half = new int[values.length / 2];
            }else{
                first_half = new int[values.length / 2 + 1];
            }
            int[] second_half = new int[values.length/2];

            for(int i = 0; i < values.length; ++i){
                if(i < first_half.length){
                    first_half[i] = values[i];
                } else{
                    second_half[i - first_half.length] = values[i];
                }
            }

            Object result_first_half[] = sortAndCount(first_half);
            int numInversions = (int) result_first_half[0];
            int sortedList[] = (int[]) result_first_half[1];

            Object result_second_half[] = sortAndCount(second_half);
            int numInversions2 = (int) result_second_half[0];
            int sortedList2[] = (int[]) result_second_half[1];

            Object result_merged = mergeAndCount(first_half, second_half);
            int numInversions3 = (int) result_merged[0];
            int sortedList3[] = (int[]) result_merged[1];
            rtnval[0] = numInversions + numInversions2 + numInversions3;
            rtnval[1] = sortedList3;
            return rtnval;
        }
    }

    //---------------------------------------------------

    public static Object[] mergeAndCount(int A[], int B[]) {
        System.out.println("mergeAndCount");
        // implement this
        Object[] sorted = new Object[A.length + B.length];
        Object[] returnVal = new Object[2];

        // these are the current elements in A and B
        int currA;
        int currB;
        // these are the current indices in A and B
        int indexA = 0;
        int indexB = 0;

        int counter = 0;
        // current index of the sorted array
        int currentIndex = 0;

        while(indexA < A.length && indexB < B.length) {
            currA = A[indexA];
            currB = B[indexB];
//            indexA = currA;
//            indexB = currB;
            // append the smaller of the two to the output list
            // TODO: figure out how to find the index
            // advance the curr in list from which the smaller element was selected
            if(currA < currB){
                sorted[currentIndex] = currA;
                ++currentIndex;
                ++indexA;
            } else{
                sorted[currentIndex] = currB;
                ++currentIndex;
                // increment counter by number of elements left in A
                counter += A.length - indexA + 1;
                ++indexB;
            }
        }
        // append remainder of other list to the output
        while(indexA < A.length) {
            sorted[indexA] = A[indexA];
            ++indexA;
        }
        while(indexB < B.length) {
            sorted[indexB] = B[indexB];
            ++indexB;
        }
        // return count and the merged list
        returnVal[0] = counter;
        returnVal[1] = sorted;
        return returnVal;
    }

    //---------------------------------------------------

    public static Object[] testOne() {
        // five inversions
        int A[] = {3, 1, 5, 4, 2};
        Object[] rtnval = sortAndCount(A);
        int count = (int) rtnval[0];
        if (count != 5) {
            System.out.println("Test Three error: expect count = 5; got " + count);
        }
        return rtnval;
    }

    //---------------------------------------------------

    public static Object[] testTwo() {
        // 42 inversions
        int A[] = {2, 1, 16, 4, 12, 8, 6, 9, 11, 3, 13, 7, 14, 5, 10, 15};
        Object[] rtnval = sortAndCount(A);
        int count = (int) rtnval[0];
        if (count != 42) {
            System.out.println("Test Two error: expect count = 42; got " + count);
        }
        return rtnval;
    }

    //---------------------------------------------------

    public static Object[] testThree() {
        // 8 * 7 / 2 = 28 inversions
        int A[] = {8, 7, 6, 5, 4, 3, 2, 1};
        Object[] rtnval = sortAndCount(A);
        int count = (int) rtnval[0];
        if (count != 28) {
            System.out.println("Test One error: expect count = 28; got " + count);
        }
        return rtnval;
    }

} // class Main
