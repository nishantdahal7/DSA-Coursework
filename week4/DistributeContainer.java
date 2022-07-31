package week4;

// In a certain city there are x number of villages represented in an array where a[i]
// represents their grade. Each village is assigned grades based on their population count.
// you are assigned task to distribute
// wheat container to each village. Write an algorithm to return the minimum number of
// containers required to distribute wheat to each village such that each village must
// get at least one container and villages with higher grade must receive more container;
// input: grades = [5,2,6]
// output:6
// explain you can distribute first 2nd village 1 container and 1st village 2 container and
// third village 3 container

public class DistributeContainer {

    void SortingArray(int array[]) {
        for (int i = 1; i < array.length; i++) { // loops through the array in the parameter.
            int j = i;
            int a = array[i];

            while ((j > 0) && (array[j - 1] > a)) { // comparing current and previous element.
                array[j] = array[j - 1]; // swap current element with previous element
                j--;
            }
            array[j] = a; // assigning current element in the index whose preious element was swapped.
        }
    }

    void TotalContainers(int array[]) {

        SortingArray(array); // sorting the array in ascending order.

        int previousValue = 0; // stores the previous value of the array.
        int CurrentVillageContainer = 0; // stores the current village container.
        int TotalContainer = 0; // stores the total container.

        for (int i = 0; i < array.length; i++) {
            if (array[i] > previousValue) { // if current value is greater than previous value.
                CurrentVillageContainer++; // increment the current village container.
                TotalContainer += CurrentVillageContainer; // add the current village container to the total container.
                previousValue = array[i]; // assign the current value to the previous value.
            } else {
                TotalContainer += CurrentVillageContainer; // add the current village container to the total container.
            }

        }
        System.out.println(TotalContainer);

    }

    public static void main(String[] args) {
        int array[] = { 5, 2, 6 };
        DistributeContainer distributeContainer = new DistributeContainer();
        distributeContainer.TotalContainers(array);
    }
}
