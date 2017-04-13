package com.latysheva.training.compare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Lidziya_Latyshava on 4/10/2017.
 */
public class ListCompare {
    private static final int COUNT = 150000;

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        compareAdd(arrayList, linkedList);
        compareSearch(arrayList, linkedList);
        compareSetToEnd(arrayList, linkedList);
        compareSetToBegin(arrayList, linkedList);
        compareGetBegin(arrayList, linkedList);
        compareGetMiddle(arrayList, linkedList);
        compareGetEnd(arrayList, linkedList);
        compareDelete(arrayList, linkedList);
        fillLists(arrayList, linkedList);
        compareDeleteFromMiddle(arrayList, linkedList);
        fillLists(arrayList, linkedList);
        compareDeleteFromBegin(arrayList, linkedList);
    }

    private static void printResult(long deltaLinkedList, long deltaArrayList) {
        if (deltaLinkedList > deltaArrayList) {
            System.out.println("ArrayList is faster");
        } else if (deltaArrayList > deltaLinkedList) {
            System.out.println("LinkedList is faster");
        } else {
            System.out.println("LinkedList and ArrayList are the same");
        }
        System.out.println();
    }

    private static void fillLists(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(Integer.toString(i));
        }
        for (int i = 0; i < COUNT; i++) {
            linkedList.add(Integer.toString(i));
        }
    }

    private static void compareAdd(ArrayList<String> arrayList, LinkedList<String> linkedList) {

        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- ADD Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(Integer.toString(i));
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            linkedList.add(Integer.toString(i));
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

    private static void compareSetToEnd(ArrayList<String> arrayList, LinkedList<String> linkedList) {

        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- SET to the end Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            arrayList.set(i, Integer.toString(i + 1));
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            linkedList.set(i, Integer.toString(i + 1));
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

    private static void compareSetToBegin(ArrayList<String> arrayList, LinkedList<String> linkedList) {

        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- SET to the beginning Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            arrayList.set(0, Integer.toString(i));
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            linkedList.set(0, Integer.toString(i));
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

    private static void compareGetEnd(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- GET end element Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            arrayList.get(i);
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            linkedList.get(i);
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

    private static void compareGetBegin(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- GET beginning element Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            arrayList.get(0);
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            linkedList.get(0);
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

    private static void compareGetMiddle(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- GET Middle element Operation ---");
        int j = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            j = COUNT / (i + 1);
            arrayList.get(j - 1);
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            j = COUNT / (i + 1);
            linkedList.get(j - 1);
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

    private static void compareDelete(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- REMOVE Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = COUNT - 1; i >= 0; i--) {
            arrayList.remove(i);
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = COUNT - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }


    private static void compareDeleteFromMiddle(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- REMOVE from the middle Operation ---");
        int j = 0;

        startTime = System.currentTimeMillis();
        for (int i = COUNT - 1; i >= 0; i--) {
            j = i / 2;
            arrayList.remove(j);
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = COUNT - 1; i >= 0; i--) {
            j = i / 2;
            linkedList.remove(j);
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

    private static void compareDeleteFromBegin(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- REMOVE from the beginning Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = COUNT - 1; i >= 0; i--) {
            arrayList.remove(0);
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = COUNT - 1; i >= 0; i--) {
            linkedList.remove(0);
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }


    private static void compareSearch(ArrayList<String> arrayList, LinkedList<String> linkedList) {
        //TODO create code for search in lists

        int randomInt = ThreadLocalRandom.current().nextInt(0, COUNT);
        long startTime;
        long endTime;
        long deltaArrayList;
        long deltaLinkedList;
        System.out.println("--- SEARCH Operation ---");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            if (arrayList.get(i).equals(Integer.toString(randomInt))) break;
        }
        endTime = System.currentTimeMillis();
        deltaArrayList = endTime - startTime;
        System.out.println("ArrayList<String>: " + deltaArrayList);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            if (linkedList.get(i).equals(Integer.toString(randomInt))) break;
        }
        endTime = System.currentTimeMillis();
        deltaLinkedList = endTime - startTime;
        System.out.println("LinkedList<String>: " + deltaLinkedList);

        printResult(deltaLinkedList, deltaArrayList);
    }

}
