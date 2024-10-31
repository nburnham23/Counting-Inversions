// CS 3240A / CS 5250A Fall 2024
// starter code for Assignment #4

public class Main {

    public static void main(String argv[]) {
        Object rtnval[] = testOne();
        Object rtnval[] = testTwo();
        Object rtnval[] = testThree();

        int arr[] = (int[]) rtnval[1];
        int numInversions = (int) rtnval[0];
        System.out.println("# inversions = " + numInversions);
        System.out.print("[");
        for (int i=0; i<arr.length; ++i)
            System.out.print(" " + arr[i]);
        System.out.println("]");
    }

    //---------------------------------------------------

    public static Object[] sortAndCount(int values[]) {
        // implement this
        /*
        if the list have one element
            there are no inversions
        else
            divide the list into two halves:
                A contains the first (n/2) *ceiling* elements
                B contains the remaining (n/2) *floor* elements
                (rA,A) = sortAndCount(A)
                (rB,B) = sortAndCount(B)
                (r,L) = mergeAncCount(A,b)
         return r = rA + rB +   r, and the sorted list L
         */
        if(values.length == 1){
            // there are no inversions
            // what to do in this? return?
        } else{
            int[] values_a = new int[values.length/2 +1];
            int[] values_b = new int[values.length/2];

            for(int i = 0; i < values.length; i++){
                if(i <= values.length/2){
                    values_a[i] = values[i];
                } else{
                    values_b[i] = values[i];
                }
            }

        }
    }

    //---------------------------------------------------

    public static Object[] mergeAndCount(int A[], int B[]) {
        // implement this
        /*
        maintain a current pointer into each list, initialized to point to the front elements
        maintain a variable Count for the number of inversions, initialized to 0
        while both lists are nonempty:
            let ai and bj be the elements pointed to by the Current pointer
            append the smaller of these two to the output lists
            if bj is the smaller element then
                increment Count by the number of elements remaining in A
            advance the Current pointer in the list from which the smaller element was selected
        once one list is empty, append the remainer of the other list to the output
        return count and the merged list
         */
        Object[] returnVal = new Object[A.length + B.length];
        // TODO: how to do pointers?
        int currA = A[0];
        int currB = B[0];
        int counter = 0;
        int original_length_a = A.length;
        int original_length_b = B.length;
        // while both lists nonempty
        while(A.length > 0 && B.length > 0) {
            int aI = currA;
            int bJ = currB;
            // append the smaller of the two to the output list
            // TODO: figure out how to find the index
            if(aI < bJ){
                returnVal[index] = aI;
            } else{
                returnVal[index] = bJ;
                // increment counter by number of elements left in A

            }
            // advance the curr in list from which the smaller element was selected
        }
        // append remainder of other list to the output
        if(A.length> 0){
            for(int i = 0; i < A.length; ++i){
                returnVal[original_length_b + i -1] = A[i];
            }
        } else{
            for(int i = 0; i < B.length; ++i){
                returnVal[original_length_a + i -1] = B[i];
            }
        }
        // return count and the merged list
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
