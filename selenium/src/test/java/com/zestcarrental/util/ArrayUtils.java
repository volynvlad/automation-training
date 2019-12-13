package com.zestcarrental.util;

import java.util.Arrays;

public class ArrayUtils {
    public static int findIndex(String[] arr, String element) {
        int index = Arrays.binarySearch(arr, element);
        return (index < 0) ? -1 : index;
    }
}
