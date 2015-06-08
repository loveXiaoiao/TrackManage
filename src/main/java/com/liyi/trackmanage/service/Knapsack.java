package com.liyi.trackmanage.service;

public class Knapsack {
    private int[] value, weight;
    private int length;
    private int volume, bestValue, currentValue, currentWeight;
    private int result[]; //记录可选的会议
    private int[] currentResult;

    public Knapsack(int value[], int weight[], int volume) {
        this.value = value;
        this.weight = weight;
        this.length = value.length - 1;
        this.volume = volume;
        this.currentValue = 0;
        this.currentWeight = 0;
        this.bestValue = 0;
        result = new int[weight.length];
        currentResult = new int[value.length];
    }

    public int[] execute() {
        backtrack(0);
        return result;
    }

    private void backtrack(int i) {
        if (i > length) {             //判断是否到达了叶子节点
            if (currentValue > bestValue) {
                System.arraycopy(currentResult, 0, result, 0, result.length);
                bestValue = currentValue;
            }
            return;
        }
        if (currentWeight + weight[i] <= volume) {//搜索右子树
            currentResult[i] = 1;
            currentWeight += weight[i];
            currentValue += value[i];
            backtrack(i + 1);
            currentWeight -= weight[i];
            currentValue -= value[i];
        }
        currentResult[i] = 0;
        backtrack(i + 1); //检查左子树
    }
}