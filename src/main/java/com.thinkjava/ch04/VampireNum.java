//: com.thinkjava.ch04/VampireNum.java

package com.thinkjava.ch04;

/** Thinking in Java Example program.
 * Displays Vampire Number.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class VampireNum implements IComputeNum 
{
	/** Normal method to get VampireNum
	 * It will compare more than 3000+ times.
	 */
	public void normalMethod() {
		int compareCount = 1;
		for (int i=10; i<=99; i++){
			for (int j=i+1; j<=99; j++) {
				int sum = i*j;
				if (sum<=9999 && sum>=1000) {
					String[] t1 = (sum + "").split("");

					// Sort ASC
					Arrays.sort(t1);

					String[] t2 = ("" + i + j).split("");
					Arrays.sort(t2);

					compareCount++;

					if (Arrays.equals(t1, t2)) {
						System.out.println(i + "*" + j + "=" + i * j);
					}
				}
			}
		}
		System.out.println("Total compare count: " + compareCount);
	}/* Output: (55% match)
	  	15*93=1395
		21*60=1260
		21*87=1827
		27*81=2187
		30*51=1530
		35*41=1435
		80*86=6880

		Total compare count: 3272
	*///:~

	/** Improved method to get VampireNum
	 * It will compare only 232 times.
	 */
	public void improvedMethod() {
		String[] arStr1, arStr2;
		int sum = 0, from, to, iVal, count = 0;

		// i 和 j 的双重循环,用到剪枝
		for (int i=10; i<100; i++) {

			// j=i+1 避免重复
			from = Math.max(1000/i, i+1);
			to = Math.min(10000/i, 100);

			// System.out.println("From: " + from + " -- to: " + to);

			for (int j=from; j<to; j++) {
				iVal = i * j;
				if (iVal%100 == 0 || (iVal -i -j)%9 != 0) {
					continue;
				}
				count++;
				arStr1 = String.valueOf(iVal).split("");
				arStr2 = (String.valueOf(i) + String.valueOf(j)).split("");
				Arrays.sort(arStr1);
				Arrays.sort(arStr2);

				// 排序后找到两者相等的一组
				if (Arrays.equals(arStr1, arStr2)) {
					sum++;
					System.out.println("第" + sum + "组: " + i + "*" + j + "=" + iVal);
				}
			}
		}

		System.out.println("共找到" + sum + "组吸血鬼数");  
    	System.out.println(count); 
	}/* Output: (55% match)	  	
		Total compare count: 232
	*///:~

	/** Implements interface method
	 */
	public void compute() {
		this.improvedMethod();
	}
}