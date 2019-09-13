package de.galaxymc.minedeploy.util.array;

import java.util.ArrayList;

public class ArrayHelper {

    public static Object[] shiftArrayToLeft(int amount, Object[] toShift) { // TODO: Check if correct method
        Object[] shifted = new Object[toShift.length - amount];
        for (int i = 0; i < shifted.length; i++) {
            shifted[i] = toShift[i + amount];
        }
        return shifted;
    }

    public static String[] objectArrayToStringArray(Object[] array) {
        String[] a = new String[array.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = array[i].toString();
        }
        return a;
    }

    public static Object[] arrayListToArray(ArrayList<Object> list) {
        Object[] a = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

}