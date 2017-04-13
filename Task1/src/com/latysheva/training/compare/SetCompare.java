package com.latysheva.training.compare;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 * Created by Lidziya_Latyshava on 4/10/2017.
 */
public class SetCompare {

    private static final int COUNT = 1500000;
    private static final String CHARECTERS_RANGE = "0123456789ABCDEFGHIJKLMNOPQRSTUXYZabcdefghijkmnopqrstuxyz";
    private static final int SIZE = CHARECTERS_RANGE.length();

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        compareAdd(hashSet, treeSet);
        compareSearch(hashSet, treeSet);
        compareSearchContains(hashSet, treeSet);
        compareClear(hashSet, treeSet);
        fillLists(hashSet, treeSet);
        compareRemove(hashSet, treeSet);
    }

    private static void compareAdd(HashSet hashSet, TreeSet treeSet) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        System.out.println("--- ADD Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            hashSet.add(String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE))));
        }
        endTime = System.currentTimeMillis();
        deltaHashSet = endTime - startTime;
        System.out.println("HashSet: " + deltaHashSet);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            treeSet.add(String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE))));
        }
        endTime = System.currentTimeMillis();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeSet: " + deltaTreeSet);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareSearch(HashSet hashSet, TreeSet treeSet) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        String stringToSearch = String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE)));
        Iterator hashSetIterator = hashSet.iterator();
        Iterator treeSetIterator = treeSet.iterator();

        System.out.println("--- SEARCH Operation ---");

        int i = 0;
        startTime = System.nanoTime();
        while (hashSetIterator.hasNext()) {
            i++;
            if (hashSetIterator.next().equals(stringToSearch)) {
                System.out.println("element is found at the position " + i);
                break;
            }
        }
        endTime = System.nanoTime();
        deltaHashSet = endTime - startTime;
        System.out.println("HashSet (nanoTime): " + deltaHashSet);

        startTime = System.nanoTime();
        i = 0;
        while (treeSetIterator.hasNext()) {
            i++;
            if (treeSetIterator.next().equals(stringToSearch)) {
                System.out.println("element is found at the position " + i);
                break;
            }
        }
        endTime = System.nanoTime();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeSet (nanoTime): " + deltaTreeSet);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareSearchContains(HashSet hashSet, TreeSet treeSet) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        String stringToSearch = String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE)));
        System.out.println("--- SEARCH Contains Operation ---");

        startTime = System.nanoTime();
        if (hashSet.contains(stringToSearch)) {
            System.out.println("Element is found");
        }
        endTime = System.nanoTime();
        deltaHashSet = endTime - startTime;
        System.out.println("HashSet (nanoTime): " + deltaHashSet);

        startTime = System.nanoTime();
        if (treeSet.contains(stringToSearch)) {
            System.out.println("Element is found");

        }
        endTime = System.nanoTime();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeSet (nanoTime): " + deltaTreeSet);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareClear(HashSet hashSet, TreeSet treeSet) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;

        System.out.println("--- Clear Operation ---");

        startTime = System.nanoTime();
        hashSet.clear();
        endTime = System.nanoTime();
        deltaHashSet = endTime - startTime;
        System.out.println("HashSet (nanoTime): " + deltaHashSet);

        startTime = System.nanoTime();
        treeSet.clear();
        endTime = System.nanoTime();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeSet (nanoTime): " + deltaTreeSet);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void compareRemove(HashSet hashSet, TreeSet treeSet) {
        long startTime;
        long endTime;
        long deltaHashSet;
        long deltaTreeSet;
        Random random = new Random();
        String stringToRemove = String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE)));
        System.out.println("--- Remove Operation ---");

        startTime = System.nanoTime();
        if (hashSet.remove(stringToRemove)) {
            System.out.println("Element has been removed");
        } else {
            System.out.println("Element doesn't exist in the HashSet");
        }
        endTime = System.nanoTime();
        deltaHashSet = endTime - startTime;
        System.out.println("HashSet (nanoTime): " + deltaHashSet);

        startTime = System.nanoTime();
        if (treeSet.remove(stringToRemove)) {
            System.out.println("Element has been removed");
        } else {
            System.out.println("Element doesn't exist in the TreeSet");
        }
        endTime = System.nanoTime();
        deltaTreeSet = endTime - startTime;
        System.out.println("TreeSet (nanoTime): " + deltaTreeSet);

        printResult(deltaHashSet, deltaTreeSet);
    }

    private static void printResult(long deltaHashSet, long deltaTreeSet) {
        if (deltaHashSet > deltaTreeSet) {
            System.out.println("* TreeSet is faster *");
        } else if (deltaTreeSet > deltaHashSet) {
            System.out.println("* HashSet is faster *");
        } else {
            System.out.println("* TreeSet and HashSet are the same *");
        }
        System.out.println();
    }

    private static void fillLists(HashSet<String> hashSet, TreeSet<String> treeSet) {
        Random random = new Random();
        String str = null;
        for (int i = 0; i < COUNT; i++) {
            str = String.valueOf(CHARECTERS_RANGE.charAt(random.nextInt(SIZE)));
            hashSet.add(str);
            treeSet.add(str);
        }
    }
}
