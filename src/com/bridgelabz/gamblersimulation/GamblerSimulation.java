package com.bridgelabz.gamblersimulation;

public class GamblerSimulation
{
	public static final int TOTAL_STAKE=100;
	public static final int BET_PER_GAME=1;

	public static int playGame(int availableBalance) {
		double wonOrLost=Math.random();
		if(wonOrLost>0.5) {
			System.out.println("Won the game");
			return availableBalance+BET_PER_GAME;
		}
		else {
			System.out.println("Lost the game");
			return availableBalance-BET_PER_GAME;
		}
	}
	public static void main(String[] args) {
		
		System.out.println("Total stake="+TOTAL_STAKE);
		System.out.println("Bet per game="+BET_PER_GAME);
		int availableBalance=TOTAL_STAKE;
		availableBalance=playGame(availableBalance);
		System.out.println(availableBalance);

	}
}
