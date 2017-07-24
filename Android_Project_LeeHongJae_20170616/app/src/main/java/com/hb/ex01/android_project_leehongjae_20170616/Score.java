package com.hb.ex01.android_project_leehongjae_20170616;

import java.util.Arrays;

/**
 * Created by HB04-03 on 2017-06-02.
 */

public class Score {
    private int[] scores;
    private int totalScore;

    public Score() {
        scores = new int[9];
        totalScore = 0;
    }

    public void addScore(int index){
        int newScore = scores[index];
        scores[index] = newScore+1;
        totalScore++;
    }

    public double[] getPercentArray(){
        double[] percents = new double[9];
        for (int i=0;i<9;i++){
            percents[i] = getPercent(scores[i]);
        }
        return percents;
    }

    public double getPercent(int score){
        double percentResult = 0;
        if(totalScore!=0){
            percentResult = ((score*1000)/totalScore)/10.0;
        }
        return percentResult;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int[] getScores() {
        return scores;
    }

    public void clearScores(){
        for(int i=0;i<9;i++){
            scores[i]=0;
        }
        totalScore=0;
    }

    public int getLargestIndex(){
        int result=0;
        int[] scores_copy = scores.clone();
        Arrays.sort(scores_copy);
        for(int i=0;i<scores.length;i++){
            if(scores[i]>=scores_copy[8]){
                result = i;
            }
        }
        return result;
    }
}
