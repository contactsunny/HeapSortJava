package com.contactsunny.poc.heapsort;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] array = {10, 7, 11, 30, 20, 38, 2, 45};
        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("------------------------");

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        System.out.println("After heapify: " + Arrays.toString(array));
        System.out.println("------------------------");

        // Swapping the last element with the first element
        // This way, the largest element will move to the end of the array.
        // We're looping backwards. So once we place the largest element at the end
        // of the array, it'll not be touched again.
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // Calling heapify for every swap makes sure that the largest element
            // in the remainder of the array will be brought to the 0th element.
            // This way, during the next swap, the largest element will be moved
            // to the end of the array.
            heapify(array, i, 0);
        }

        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("------------------------");
    }

    /**
     * This method generates the heap such that the greatest element is
     * brought to the top of the array. This will not sort the array. But
     * this is just bubbling the largest element to the top.
     *
     * @param array The given array.
     * @param length The length of the array.
     * @param index The index of the current greatest element.
     */
    private static void heapify(int[] array, int length, int index) {
        int largest = index;
        // Calculating the indices of the left and the right children of the given node.
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Checking if the left node is greater than the root.
        // Changing the index of the largest element if required.
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        // Checking if the right node is greater than the root.
        // Changing the index of the largest element if required.
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        // If the largest element is not the root node passed to this method,
        // we're swapping it with the largest element.
        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;

            // After every swap, the heap has to be rebalanced again so that
            // the largest element is always at the top.
            heapify(array, length, largest);
        }
    }
}
