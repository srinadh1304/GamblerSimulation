package com.bridgelabz.gamblersimulation;

public class GamblerSimulation 
{

	public static final int TOTAL_STAKE=100;
	public static final int BET_PER_GAME=1;


	public static void main(String[] args)
	{
		int availableBalance=TOTAL_STAKE;
		System.out.println("Starting Balance:"+availableBalance);
		int noOfDays=30;
		int totalAmount=0;
		totalAmount=gamePlayForDays(noOfDays, availableBalance);
		System.out.println("Amount won after "+ noOfDays+" days of play:"+totalAmount);
		gameForMonth();
		
	}
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
	public static void gameForMonth() 
	{
		int noOfDays=30;
		int amountInADay=0;
		int totalAmount=0;
		for(int day=1; day<=noOfDays;day++) 
		{
			System.out.println();
			System.out.print("Day "+day);
			amountInADay=gameResign(TOTAL_STAKE);
			totalAmount+=amountInADay; 
			if(amountInADay==TOTAL_STAKE+0.5*TOTAL_STAKE) 
			{
				System.out.println(" Won By:"+(int)(TOTAL_STAKE*1.5));
			}
			else 
			{
				System.out.println(" Lost By:"+(int)(0.5*TOTAL_STAKE));
			}


		}
		playNextMonth(totalAmount);

	}
	public static int gameResign(int availableBalance) 
	{
		while(availableBalance<TOTAL_STAKE*1.5 && availableBalance>0.5*TOTAL_STAKE) 
		{
			availableBalance=playGame(availableBalance);


		}
		return availableBalance;

	}
	public static void luckyAndUnluckyDay() 
	{
		int noOfDays=30;
		int amountInADay=0;
		String luckyDays="";
		String unLuckyDays="";
		for(int day=1; day<=noOfDays;day++) 
		{
			amountInADay=gameResign(TOTAL_STAKE);
			if(amountInADay==TOTAL_STAKE+0.5*TOTAL_STAKE)
			{
				luckyDays+=day+" ";
			}
			else 
			{
				unLuckyDays+=day+" ";
			}


		}
		System.out.println("Lucky days:"+luckyDays);
		System.out.println("Unlucky days:"+unLuckyDays);
	}
	public static int gamePlayForDays(int noOfDays, int availableBalance) 
	{
		int totalAmount=availableBalance;
		int amountInOneDay=0;
		for(int day=1; day<=noOfDays;day++) 
		{
			amountInOneDay=gameResign(TOTAL_STAKE);
			totalAmount+=amountInOneDay;
		}
		return totalAmount;

	}
	public static void playNextMonth(int totalAmount) 
	{

		if( totalAmount >= (TOTAL_STAKE*30) )
		{
			System.out.print("Plays Next Month also");
			gameForMonth();
			
		}
		else
			System.out.println("Does not play next month");

	}

}