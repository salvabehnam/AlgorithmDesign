package Algorithms;

import java.io.*;
import java.util.*;

public class StableMatching {

    private void matchMaking(int[][] men, int[][] women, String path) throws IOException {
        FileWriter outFile = new FileWriter(path);
        HashMap<Integer, Integer> couples = findCouples(men, women);
        Set<Integer> set = couples.keySet();
        for (int key : set) {
            System.out.println(key + ", " + couples.get(key));
            outFile.write(key + ", " + couples.get(key) + "\n");
        }
        outFile.close();
    }

    private HashMap<Integer, Integer> findCouples(int[][] men, int[][] women) {

        //couples map will contain all the matches, with women as key and her match (men) as value
        HashMap<Integer, Integer> couples = new HashMap<>();

        //add all the women to couples map with their matches as NULL (initially)
        for (int i = 0; i < women.length ; i++) {
            couples.put(i, null);
        }

        //create a list of all bachelors
        Set<Integer> bachelors = new HashSet<>();
        for (int i = 0; i <men.length ; i++) bachelors.add(i);


        int bachelorCount = bachelors.size();

        //do till all the bachelors are nor engaged
        while(bachelorCount>0){

            int currentBachelor = bachelors.iterator().next();

            // check for all the women preferences of current bachelor in preference order
            for (int wmen = 0; wmen <men[currentBachelor].length ; wmen++) {

                //check if current woman is available for current bachelor
                if(couples.get(wmen) == null){
                    //this woman is available for this man, make the match
                    couples.put(wmen, currentBachelor);
                    bachelors.remove(currentBachelor);
                    break;
                }else{
                    //current woman had already accepted the proposal from some other man check if women is interested accepting current bachelor and dumping the man which she had accepted earlier
                    int alreadyAcceptedMan = couples.get(wmen);
                    if(willChangePartner(currentBachelor, alreadyAcceptedMan, wmen, women)){

                        //current women will accept
                        couples.put(wmen, currentBachelor);
                        // add the dumped man in bachelor list
                        bachelors.add(alreadyAcceptedMan);
                        bachelors.remove(currentBachelor);

                        break; //
                    }
                }
            }
            //get the size again
            bachelorCount = bachelors.size();
        }
        //return the couples
        return couples;
    }

    private boolean willChangePartner(int currentBachelor, int alreadyAcceptedMan, int currentWomen, int[][] women){

        int pref_currentBachelor = -1;
        int pref_alreadyAcceptedMan = -1;

        //get the preferences of both the men
        for (int i = 0; i <women[currentWomen].length ; i++) {

            if(women[currentWomen][i]==currentBachelor)
                pref_currentBachelor = i;

            if(women[currentWomen][i]==alreadyAcceptedMan)
                pref_alreadyAcceptedMan = i;
        }

        //women will accept the current bachelor only if he has higher preference than the man she had accepted earlier
        return pref_currentBachelor < pref_alreadyAcceptedMan;
    }

    public static void start(String path) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter men count");
        int MenCount = scanner.nextInt();

        StableMatching sm = new StableMatching();
        int[][] men = new int[MenCount][MenCount], women = new int[MenCount][MenCount];

        System.out.println("Enter table men elements");
        for (int i = 0 ; i < MenCount * MenCount ; i++) men[i / MenCount][i % MenCount] = scanner.nextInt();

        System.out.println("Enter table women elements");
        for (int i = 0; i < MenCount * MenCount; i++) women[i / MenCount][i % MenCount] = scanner.nextInt();

        System.out.println("Matching is:");
        sm.matchMaking(men, women, path);
    }
}
