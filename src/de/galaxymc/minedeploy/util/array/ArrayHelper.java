package de.galaxymc.minedeploy.util.array;

public class ArrayHelper {

    public static Object[] shiftArrayToLeft(int amount, Object[] toShift) { // TODO: Check if correct method
        Object[] shifted = new Object[toShift.length - amount];
        for (int i = 0; i < shifted.length; i++) {
            shifted[i] = toShift[i + amount];
        }
        return shifted;
    }

}