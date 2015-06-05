package com.liyi.trackmanage.service;

public class Knapsack {
    private int[] value, weight;
    private int length;
    private int volume, bestp, cp, cw;
    private int result[]; //记录可选的会议
    private int[] cx;

    public Knapsack(int value[], int weight[], int volume) {
        this.value = value;
        this.weight = weight;
        this.length = value.length - 1;
        this.volume = volume;
        this.cp = 0;
        this.cw = 0;
        this.bestp = 0;
        result = new int[weight.length];
        cx = new int[value.length];
    }

    public int[] execute() {
        backtrack(0);
        return result;
    }

    private void backtrack(int i) {
        if (i > length) {             //判断是否到达了叶子节点
            if (cp > bestp) {
                for (int j = 0; j < result.length; j++)
                    result[j] = cx[j];
                bestp = cp;
            }
            return;
        }
        if (cw + weight[i] <= volume) {//搜索右子树
            cx[i] = 1;
            cw += weight[i];
            cp += value[i];
            backtrack(i + 1);
            cw -= weight[i];
            cp -= value[i];
        }
        cx[i] = 0;
        backtrack(i + 1); //检查左子树
    }
}