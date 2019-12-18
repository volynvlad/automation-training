package com.zestcarrental.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtils {
    public static int findIndex(String[] arr, String element) {
        return new ArrayList<>(Arrays.asList(arr)).indexOf(element.toLowerCase());
    }
}
