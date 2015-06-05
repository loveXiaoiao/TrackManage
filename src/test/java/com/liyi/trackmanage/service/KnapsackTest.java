package com.liyi.trackmanage.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author liyi
 * @date 2015年5月31日
 * @desc Test for Knapsack
 */
public class KnapsackTest {

	@Test
	public void testKnapGet() {
		int p[] = {60,5,30,45,45,40,30};
		int maxWeight = 180;
		Knapsack ks = new Knapsack(p, p, maxWeight);
		int []result = ks.execute();
		Assert.assertEquals(1, result[0]);
	}
	
	@Test
	public void testOptimalPruduce(){
		int p[] = {3,4,5,6};
		int maxWeight = 10;
		Knapsack ks = new Knapsack(p, p, maxWeight);
		int []result = ks.execute();
		int sum = 0;
		for(int i=0; i<result.length; i++){
			if(result[i] == 1){
				sum += p[i];
			}
		}
		Assert.assertEquals(10, sum);
		
	}
}