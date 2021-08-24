package com.bridgelabz.gamblersimulation;

public class GamblerSimulation 
{

	public static final int TOTAL_STAKE=100;
	public static final int BET_PER_GAME=1;

	public static int playGame(int availableBalance)
	{
		double wonOrLost=Math.random();
		if(wonOrLost>0.5)
		{
			return availableBalance+BET_PER_GAME;
		}
		else 
		{
			return availableBalance-BET_PER_GAME;
		}
	}
	public static void main(String[] args)
	{

		System.out.println("Total stake="+TOTAL_STAKE);
		System.out.println("Bet per game="+BET_PER_GAME);
		int availableBalance=TOTAL_STAKE;
		while(availableBalance<=1.5*TOTAL_STAKE && availableBalance>=0.5*TOTAL_STAKE) 
		{
			availableBalance=playGame(availableBalance);
		}
		if(availableBalance>1.5*TOTAL_STAKE)
			System.out.println("Player resigned by winning 50%");
		else
			System.out.println("Player resigned by losing 50%");
			
		System.out.println("Balance available:"+availableBalance);

	}

}