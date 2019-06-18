package com.sam.project.frameworktype.combination;

/**
 * @ClassName: Client
 * @Description: Java设计模式(组合模式)
 * @author mqx
 * @date 2017年9月22日 下午3:16:50
 */
public class Client {

	private static void pay() {
		// 创建总店(总店也是分店的一种)
		MarketBranchScore leaderMark = new MarketBranchScore("总店");
		// 创建分店
		MarketBranchScore gzMark = new MarketBranchScore("广州分店");
		MarketBranchScore shMark = new MarketBranchScore("上海分店");
		// 消费
		gzMark.setCardScore(100);
		shMark.setCardScore(500);

		leaderMark.add(gzMark);
		leaderMark.add(shMark);
		// 刷卡支付时在各分店累计积分
		leaderMark.pay();
	}

	public static void main(String[] args) {
		pay();
	}
}
