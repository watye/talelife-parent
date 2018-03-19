package com.talelife.designmode.strategy;

public class Main {

	public static void main(String[] args) {
		Price price = new Price(new AdvancedMemberStrategy());
		System.out.println(price.getPrice(100));
	}

}
