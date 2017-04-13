package com.latysheva.training.compare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Lidziya_Latyshava on 4/11/2017.
 */
public class MapCompare {
    private static final int COUNT = 1000000;
    private static final String CHARECTERS_RANGE = "0123456789ABCDEFGHIJKLMNOPQRSTUXYZabcdefghijkmnopqrstuxyz";
    private static final int SIZE = CHARECTERS_RANGE.length();

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap();
        TreeMap<Integer, String> treeMap = new TreeMap();

        compareAdd(hashMap, treeMap);
        compareSearchValue(hashMap, treeMap);
        compareSearchKey(hashMap, treeMap);
        compareClearOnTheSameData(hashMap,treeMap);
        fillMaps(hashMap, treeMap);
        compareSearchValueOnTheSameData(hashMap, treeMap);
        compareSearchKeyOnTheSameData(hashMap, treeMap);
        compareRemoveOnTheSameData(hashMap, treeMap);

    }

    private static void compareAdd(HashMap hashMap, TreeMap treeMap) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        System.out.println();
        System.out.println("--- ADD Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            hashMap.put(i, String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE))));
        }
        endTime = System.currentTimeMillis();
        deltaHashSet = endTime - startTime;
        System.out.println("HashMap: " + deltaHashSet);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            treeMap.put(i, String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE))));
        }
        endTime = System.currentTimeMillis();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeMap: " + deltaTreeSet);

        System.out.println("HashMap size is: " + hashMap.size());
        System.out.println("TreeMap size is: " + treeMap.size());

        printResult(deltaHashSet, deltaTreeSet);

    }

    private static void compareSearchValue(HashMap hashMap, TreeMap treeMap) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        long hashMapFindCount = 0;
        long treeMapFindCount = 0;
        String str;
        System.out.println();
        System.out.println("--- SEARCH by value Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            str = String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE)));
            if (hashMap.containsValue(str)) {
                hashMapFindCount++;

            }
        }
        endTime = System.currentTimeMillis();
        deltaHashSet = endTime - startTime;
        System.out.println("HashMap: " + deltaHashSet);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            str = String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE)));
            if (treeMap.containsValue(str)) {
                treeMapFindCount++;

            }
        }
        endTime = System.currentTimeMillis();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeMap: " + deltaTreeSet);

        System.out.println("HashMap find count is: " + hashMapFindCount);
        System.out.println("TreeMap find count is: " + treeMapFindCount);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareSearchKey(HashMap hashMap, TreeMap treeMap) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        long hashMapFindCount = 0;
        long treeMapFindCount = 0;
        Integer j = 0;
        System.out.println();
        System.out.println("--- SEARCH by key Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            j = random.nextInt(COUNT);
            if (hashMap.containsKey(j)) {
                hashMapFindCount++;

            }
        }
        endTime = System.currentTimeMillis();
        deltaHashSet = endTime - startTime;
        System.out.println("HashMap: " + deltaHashSet);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            j = random.nextInt(COUNT);
            if (treeMap.containsKey(j)) {
                treeMapFindCount++;

            }
        }
        endTime = System.currentTimeMillis();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeMap: " + deltaTreeSet);

        System.out.println("HashMap find count is: " + hashMapFindCount);
        System.out.println("TreeMap find count is: " + treeMapFindCount);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareSearchKeyOnTheSameData(HashMap hashMap, TreeMap treeMap) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        long hashMapFindCount = 0;
        long treeMapFindCount = 0;
        ArrayList<Integer> keys = new ArrayList();
        System.out.println();
        //fillMaps(hashMap, treeMap);
        for (int i = 0; i < COUNT; i++) {
            keys.add(random.nextInt(COUNT));
        }
        System.out.println("--- SEARCH by key on the same data Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < keys.size(); i++) {
            if (hashMap.containsKey(keys.get(i))) {
                hashMapFindCount++;
            }
        }
        endTime = System.currentTimeMillis();
        deltaHashSet = endTime - startTime;
        System.out.println("HashMap: " + deltaHashSet);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < keys.size(); i++) {
            if (treeMap.containsKey(keys.get(i))) {
                treeMapFindCount++;
            }
        }
        endTime = System.currentTimeMillis();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeMap: " + deltaTreeSet);

        System.out.println("HashMap find count is: " + hashMapFindCount);
        System.out.println("TreeMap find count is: " + treeMapFindCount);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareSearchValueOnTheSameData(HashMap hashMap, TreeMap treeMap) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        long hashMapFindCount = 0;
        long treeMapFindCount = 0;
        String str;
        ArrayList<String> values = new ArrayList();
        System.out.println();
        //fillMaps(hashMap, treeMap);
        for (int i = 0; i < COUNT; i++) {
            values.add(String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE))));
        }
        System.out.println("--- SEARCH by value on the same data Operation ---");

        startTime = System.currentTimeMillis();
        for (String value : values) {
            if (hashMap.containsValue(value)) {
                hashMapFindCount++;
            }
        }
        endTime = System.currentTimeMillis();
        deltaHashSet = endTime - startTime;
        System.out.println("HashMap: " + deltaHashSet);

        startTime = System.currentTimeMillis();
        for (String value : values) {
            if (treeMap.containsValue(value)) {
                treeMapFindCount++;
            }
        }
        endTime = System.currentTimeMillis();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeMap: " + deltaTreeSet);

        System.out.println("HashMap find count is: " + hashMapFindCount);
        System.out.println("TreeMap find count is: " + treeMapFindCount);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareRemoveOnTheSameData(HashMap hashMap, TreeMap treeMap) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        long hashMapFindCount = 0;
        long treeMapFindCount = 0;
        //fillMaps(hashMap, treeMap);
        ArrayList<Integer> keys = new ArrayList();
        for (int i = 0; i < COUNT; i++) {
            keys.add(random.nextInt(COUNT));
        }
        System.out.println();
        System.out.println("--- REMOVE on the same data Operation ---");

        startTime = System.currentTimeMillis();
        for (Integer key : keys) {
            hashMap.remove(key);
            hashMapFindCount++;
        }
        endTime = System.currentTimeMillis();
        deltaHashSet = endTime - startTime;
        System.out.println("HashMap: " + deltaHashSet);

        startTime = System.currentTimeMillis();
        for (Integer key : keys) {
            treeMap.remove(key);
            treeMapFindCount++;
        }
        endTime = System.currentTimeMillis();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeMap: " + deltaTreeSet);

        System.out.println("HashMap removed count is: " + hashMapFindCount);
        System.out.println("TreeMap removed count is: " + treeMapFindCount);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareClearOnTheSameData(HashMap hashMap, TreeMap treeMap) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        long hashMapFindCount = 0;
        long treeMapFindCount = 0;
        //fillMaps(hashMap, treeMap);
        System.out.println();
        System.out.println("--- CLEAR on the same data Operation ---");

        startTime = System.nanoTime();
        hashMap.clear();
        endTime = System.nanoTime();
        deltaHashSet = endTime - startTime;
        System.out.println("HashMap: " + deltaHashSet);

        startTime = System.nanoTime();
        treeMap.clear();
        endTime = System.nanoTime();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeMap: " + deltaTreeSet);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void printResult(long deltaHashMap, long deltaTreeMap) {
        if (deltaHashMap > deltaTreeMap) {
            System.out.println("* TreeMap is faster *");
        } else if (deltaTreeMap > deltaHashMap) {
            System.out.println("* HashMap is faster *");
        } else {
            System.out.println("* TreeMap and HashMap are the same *");
        }
        System.out.println();
    }

    private static void fillMaps(HashMap hashMap, TreeMap treeMap) {
        Random random = new Random();
        String str;
        for (int i = 0; i < COUNT; i++) {
            str = String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE)));
            hashMap.put(i, str);
            treeMap.put(i, str);
        }
    }
}
