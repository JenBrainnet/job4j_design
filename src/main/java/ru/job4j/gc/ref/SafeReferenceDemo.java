package ru.job4j.gc.ref;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class SafeReferenceDemo {

    public static void main(String[] args) {
        SoftReference<String> cache = new SoftReference<>("Cached data");
        String value = cache.get();
        if (value != null) {
            System.out.println(value);
        } else {
            System.out.println("Cache object was removed");
        }

        WeakReference<String> temp = new WeakReference<>("Temp data");
        String tempValue = temp.get();
        if (tempValue != null) {
            System.out.println(tempValue);
        } else {
            System.out.println("Temp object was removed");
        }
    }

}
