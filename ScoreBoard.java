package Cricketboard;
import java.util.Random;
import java.util.*;

public class ScoreBoard {
	
	public static final String [] balls = {"1","2","3","4","6","w","wb","nb"};
	
	public static List <String> totalballs() {
		List <String> Totalballs = new ArrayList<>();
		Random random = new Random();
	    int totalovers=5;
		String ball= " ";
		
	for(int j=0; j<totalovers; j++) {
		int overballs = 6;
		for(int i =0 ; i<overballs ; i++) {
			ball= "";
			ball = balls[random.nextInt(balls.length)];
			if(checkball(ball)) {
				
				Totalballs.add(i,ball); 
				
				overballs++;
			}
			
			else{
				Totalballs.add(i,ball); 
			}
			
		   }
	     }
			
		return Totalballs;
	}
	
	
	public static boolean checkball(String ball) {
		boolean balltype = false;
		if( null != ball) {
			switch(ball) {
			case "wb":
				balltype = true;
				break;
			case "nb" :
				balltype = true;
				break;
			default:
				balltype = false;
				break;
			}
			}
		return balltype;
	}
	
	public static String calculatescore(List <String> over) {
		 int runsininning = 0 ;
		 int wicketininning =0;
		if(null != over) {
			Iterator <String> overItr = over.iterator();
			while(overItr.hasNext()) {
				String ball = overItr.next();
				switch(ball) {
				case "1":
					runsininning+=1;
					break;
				case "2":
					runsininning +=2;
					break;
				case "3":
					runsininning +=3;
					break;
				case "4":
					runsininning +=4;
					break;
				case "6":
					runsininning +=6;
					break;
				case"w":
					wicketininning+=1;
					break;
				case "wb":
					runsininning+=1;
					break;
				case "nb":
					runsininning+=1;
					break;
				}
			 }
			}
		String TotalScoreInInning = String.valueOf(runsininning);
		
		String TotalWicketsInInning= String.valueOf(wicketininning);
		
		System.out.println("Total Score ="+TotalScoreInInning );
		System.out.println("Total Wickets ="+TotalWicketsInInning );
		
		return TotalScoreInInning;
		
		}
		
	
	 public static double calculateRunRate(String score ) {
		   double noofOvers=5.00;
		   Double Score = Double.parseDouble(score);
           double runRate = Score/noofOvers;  
           System.out.println("Total Runrate of Team-" +runRate);
		   return runRate;
	}
	 
	 public static void finalresult(String score1,String score2) {
		 int Score1=Integer.parseInt(score1);
		 int Score2=Integer.parseInt(score2);
		 
		 if(Score1>Score2) {
			 System.out.println("**********Team1 is win by"+ " "+(Score1-Score2)+" "+"runs**********");
		 }
		 else if(Score1<Score2) {
			 System.out.println(("**********Team2 is win by"+ " "+(Score2-Score1)+" "+"runs**********"));
		 }
			 
		 else {
			 System.out.println("**********Match is Drow**********");
		 }
			 
	 }
	 
	public static String Team1ScoreBoard() {
		System.out.println("###### Team1 ScoreBoard is ######");
		List <String> Totalballs = ScoreBoard.totalballs();
		String Score1= ScoreBoard.calculatescore(Totalballs);
		ScoreBoard.calculateRunRate(Score1);
		return Score1;	
	}
	
	public static String Team2ScoreBoard() {
		System.out.println("###### Team2 ScoreBoard is ######");
		List <String> Totalballs = ScoreBoard.totalballs();
		String Score2= ScoreBoard.calculatescore(Totalballs);
		ScoreBoard.calculateRunRate(Score2);
		return Score2;	
	}

	public static void main(String[] args) {
	
		System.out.println("********* Welcome to Criket Match **********");
		System.out.println(" Team1 Vs Team2");
		ScoreBoard.finalresult(ScoreBoard.Team1ScoreBoard(),ScoreBoard.Team1ScoreBoard());
	
	}	
}
	