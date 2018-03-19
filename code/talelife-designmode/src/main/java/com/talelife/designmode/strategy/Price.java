package com.talelife.designmode.strategy;

public class Price {
	private MemberStrategy memberStrategy;
	
	Price(MemberStrategy memberStrategy){
		this.memberStrategy = memberStrategy;
	}
	
	public double getPrice(double marketPrice){
		return memberStrategy.calcPrice(marketPrice);
	}
}
