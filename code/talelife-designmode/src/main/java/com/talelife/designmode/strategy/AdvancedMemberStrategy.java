package com.talelife.designmode.strategy;

public class AdvancedMemberStrategy implements MemberStrategy {

	public double calcPrice(double marketPrice) {
		return marketPrice*0.5;
	}

}
