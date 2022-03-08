import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class RollerMain {
	public static void main(String[] args)  {
		
		Scanner userInput=new Scanner(System.in);
		System.out.println("Enter Character Name if it is unused, a new one will be created");
		String CharName=userInput.next();
		userInput.nextLine();
		File charInfo=new File(CharName+".txt");
		int  stats []= {
				0,0,0,0,0,0
		};
		int level=0;
		
		
		
		
		Scanner CharScanner;
		try {
			 CharScanner = new Scanner(charInfo);
			
				level=CharScanner.nextInt();
				stats[0]=CharScanner.nextInt();
				stats[1]=CharScanner.nextInt();
				stats[2]=CharScanner.nextInt();
				stats[3]=CharScanner.nextInt();
				stats[4]=CharScanner.nextInt();
				stats[5]=CharScanner.nextInt();
				CharScanner.close();
				System.out.println("Character found");
				
				
				
			
		} catch (FileNotFoundException e) {
			
		System.out.println("New Character, Enter level.");
		level=userInput.nextInt();
		System.out.println("Enter Strength");
		stats[0]=userInput.nextInt();
		System.out.println("Enter Dexterity");
		stats[1]=userInput.nextInt();	
		System.out.println("Enter Constitution");
		stats[2]=userInput.nextInt();
		System.out.println("Enter Intelligence");
		stats[3]=userInput.nextInt();
		System.out.println("Enter Wisdom");
		stats[4]=userInput.nextInt();
		System.out.println("Enter Charisma");
		stats[5]=userInput.nextInt();
			userInput.nextLine();
		
		}
		Random rand=new Random();
		
		boolean stayInLoop=true;
		
		do {
			
			System.out.println("Enter Str/Dex/Con/Int/Wis/Cha depending on what roll you need, if you have proficiency, add a P ex: ChaP. If advantage or disadvantage add a\"+\" or a \"-\" ex:Cha+");		
			
			String rollChoice=userInput.nextLine();
			
			int roll1=rand.nextInt(20)+1;
			int roll2=rand.nextInt(20)+1;
			
			if(rollChoice.contains("+")||rollChoice.contains("-")) {
				System.out.println("roll 1= "+roll1+" & roll 2= "+roll2);
			}
			else {
				System.out.println("roll = "+roll1);				
			}
			if(rollChoice.contains("+")&&roll2>roll1) {
				roll1=roll2;
			}else if(rollChoice.contains("-")&&roll2<roll1) {
				roll1=roll2;
			}
			
			if(rollChoice.contains("P")) {
				roll1+=(level-1)/4+2;
			}
			
			if(rollChoice.contains("S")) {
				roll1+=(stats[0]-10)%2;
			}else if(rollChoice.contains("D")) {
				roll1+=(stats[1]-10)%2;
			}else if(rollChoice.contains("Co")) {
				roll1+=(stats[2]-10)%2;
			}else if(rollChoice.contains("I")) {
				roll1+=(stats[3]-10)%2;
			}else if(rollChoice.contains("W")) {
				roll1+=(stats[4]-10)%2;
			}else if(rollChoice.contains("Ch")) {
				roll1+=(stats[5]-10)%2;
			}
			System.out.println("Final roll = "+roll1);
			System.out.println("Would you like to roll again? Y/N");
			 rollChoice=userInput.nextLine();
			if(rollChoice.contains("N")) {
				stayInLoop=false;
			}
			
				
				
		}while(stayInLoop);
		
		
		
		
		
		
		
		try {
			//print to character.txt
			PrintStream CharWriter=new PrintStream(charInfo);
			CharWriter.println(level);
			CharWriter.println(stats[0]);
			CharWriter.println(stats[1]);
			CharWriter.println(stats[2]);
			CharWriter.println(stats[3]);
			CharWriter.println(stats[4]);
			CharWriter.println(stats[5]);
			
			
			
		} catch (FileNotFoundException e) {
			
		
		}
		

		
		
		
	}
}