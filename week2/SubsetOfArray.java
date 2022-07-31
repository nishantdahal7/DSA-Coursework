package week2;
// you are given an array which includes product of subset of

// array any array 'S' of length l,
// Find element of an array S
// of length L.
// l=3, a [] = {10,10,5,0,2,1,2,5}
// a [] = {2,1,5} will be able to output provided subset product.

public class SubsetOfArray {
    int a[]; // This array stores the input array.
    int l; // This variable stores the length of the input array.

    SubsetOfArray(int[] a, int l) {
        // constructor
        this.a = a; // Initialize the input array.
        this.l = l; // Initialize the length of the input array.
    }

    public static int removeDuplicateElement(int arr[], int n) {
        // This function removes the duplicate elements from the input array.
        if (n == 0 || n == 1)// If the input array is empty or has only one element, return the input array.
            return n;// Return the length of the input array.

        int[] temp = new int[n];// Initialize the temp array.
        int j = 0;// Initialize the j variable.
        for (int i = 0; i < n - 1; i++)// Itterate through the input array.
            if (arr[i] != arr[i + 1])// If the current element is not equal to the next element.
                temp[j++] = arr[i];// Append the current element to the temp array.

        temp[j++] = arr[n - 1];// Append the last element to the temp array.

        // Changing original array
        for (int i = 0; i < j; i++)// Itterate through the temp array.
            arr[i] = temp[i];// Update the input array with the temp array.

        return j;// Return the length of the temp array.
    }

    int[] uniqueIntegers() {
        // This function returns the unique integers from the input array.
        int[] unique = new int[a.length];// Initialize the unique array.
        int length = a.length; // Initialize the length variable.

        for (int i = 0; i < unique.length; i++) { // Itterate through the input array.
            unique[i] = removeDuplicateElement(a, length); // Remove the duplicate elements from the input array.
        }
        return unique; // Return the unique array.

    }

    public static void main(String[] args) {
        int a[] = { 10, 10, 5, 0, 2, 1, 2, 5 };
        int l = 3;
        SubsetOfArray w = new SubsetOfArray(a, l);
        int[] unique = w.uniqueIntegers();
        for (int i = 0; i < unique.length; i++) {
            System.out.println(unique[i]);
        }
    }
}