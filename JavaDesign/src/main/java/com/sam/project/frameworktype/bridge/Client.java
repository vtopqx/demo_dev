package com.sam.project.frameworktype.bridge;

/**
 * @ClassName: Client 
 * @Description: Java设计模式(桥接模式)
 * @author mqx 
 * @date 2017年9月26日 上午10:18:17
 */
public class Client {
	private static void study() {
		School middle = new MiddleSchool();
		middle.student = new BoyStudent();
		middle.lesson();
		middle.student = new GirlStudent();
		middle.lesson();

		School high = new HighSchool();
		high.student = new BoyStudent();
		high.lesson();
		high.student = new GirlStudent();
		high.lesson();
	}

	public static void main(String[] args) {
		study();
	}
}
