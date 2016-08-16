//: com.thinkjava.ch01/Ch01Exe01.java

package com.thinkjava.ch01;

/** Thinking in Java Example program.
 * Displays class fields without initialize.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

/** You can insert list:
 * <ol>
 *   <li>number01</li>
 *   <li>char01</li>
 * </ol>
 */
public class Ch01Exe01 {
	/** Fields with int
	 * public field int number01 without initialize
	 */
	public int number01;

	/** Fields with char
	 * public field char char01 without initialize
	 */
	public char char01;

	/** Main Entry for Ch01Exe01
	 * @param args parameters
	 */
	public static void main(String args[]) {
		Ch01Exe01 test01 = new Ch01Exe01();
		System.out.println(test01.number01);
		System.out.println(test01.char01);
	} 
	/* Output: (55% match)
	0
	''
	*///:~
}