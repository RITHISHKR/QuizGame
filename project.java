package project;
import java.util.Scanner;
class candidate extends Thread{
	public void run() {
		int[] prizemoney= {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
	try {
	System.out.println(Thread.currentThread().getName()+"Displaying prize distribution");
	Thread.sleep(2000);
	for(int i=1;i<=prizemoney.length;i++) {
		System.out.println("question " + i +"=₹" + prizemoney[i - 1]);
		Thread.sleep(2000);	
	}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
}
public class project {
	static boolean audiencePollUsed = false;
	static boolean phoneCallUsed = false;
	static boolean fiftyFiftyUsed = false;

	public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		candidate c1 = new candidate();
		c1.setName("");
		c1.start();
		System.out.println("Welcome to QuizGame");
		System.out.println(" ");
		System.out.println("📜 Quiz Rules:");
		System.out.println(" ");
		System.out.println("1. There are 10 multiple-choice questions.");
		System.out.println("2. Each question carries an increasing prize amount.");
		System.out.println("3. You have three lifelines: Audience Poll, Phone Call, and 50:50.");
		System.out.println("4. Each lifeline can be used only once.");
		System.out.println("5. One wrong answer will end the game.");
		System.out.println("6. If you fail before question 5, you get only ₹1000 as prize.");
		System.out.println("7. After question 5, you will receive ₹5000 if you answer incorrectly.");
		System.out.println("8. All the best! 🎯\n");
		Thread.sleep(3000); // Pause for dramatic effect
		c1.join();
		System.out.println(" ");
		System.out.println("display questions");
		System.out.println(" ");
		String questions []= {
				"1. Who was the first captain of Royal Challengers Bangalore in the inaugural IPL season (2008)?",
			    "2. Which bowler has taken the most wickets for RCB in IPL history?",
			    "3. In which year did RCB reach the IPL final but lose to Sunrisers Hyderabad?",
			    "4. Who was RCB’s head coach for the 2025 IPL season?",
			    "5. What is the home stadium of RCB, and in which city is it located?",
			    "6. Who is the current President of India (as of 2025)?",
			    "7. What is the longest river in the world?",
			    "8. Which country is known as the Land of the Rising Sun?",
			    "9. Who invented the telephone?",
			    "10. What is the chemical symbol for Gold?"
		};
		int a[]= {1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};

			String[][] options = {
			    {"A) Rahul Dravid", "B) Anil Kumble", "C) Jacques Kallis", "D) Kevin Pietersen"},
			    {"A) Harshal Patel", "B) Yuzvendra Chahal", "C) Zaheer Khan", "D) Mohammad Siraj"},
			    {"A) 2016", "B) 2018", "C) 2015", "D) 2020"},
			    {"A) Daniel Vettori", "B) Sanjay Bangar", "C) Andy Flower", "D) Mike Hesson"},
			    {"A) Brabourne Stadium, Mumbai", "B) M. A. Chidambaram Stadium, Chennai", "C) Eden Gardens, Kolkata", "D) M. Chinnaswamy Stadium, Bengaluru"},
			    {"A) Droupadi Murmu", "B) Ram Nath Kovind", "C) Narendra Modi", "D) Pranab Mukherjee"},
			    {"A) Nile", "B) Amazon", "C) Yangtze", "D) Mississippi"},
			    {"A) China", "B) Japan", "C) South Korea", "D) Thailand"},
			    {"A) Thomas Edison", "B) Nikola Tesla", "C) Alexander Graham Bell", "D) Albert Einstein"},
			    {"A) Au", "B) Ag", "C) Fe", "D) Pb"}
			};
			String answers[] = {
				    "A) Rahul Dravid",
				    "B) Yuzvendra Chahal",
				    "A) 2016",
				    "B) Sanjay Bangar",
				    "D) M. Chinnaswamy Stadium, Bengaluru",
				    "A) Droupadi Murmu",
				    "A) Nile",
				    "B) Japan",
				    "C) Alexander Graham Bell",
				    "A) Au"
				};

		char[] correctoptions = {'A', 'B', 'A', 'B', 'D', 'A', 'A', 'B', 'C', 'A'};
		int temp=0;
		for(int i=0;i<questions.length;i++) {
			System.out.println(questions[i]);
			for (String opt : options[i]) {
                System.out.println(opt);
            }
			System.out.println(" ");
			System.out.println("Do you want to use any lifelines");
			String lifelineInput  = sc.nextLine().toLowerCase();
			if (lifelineInput.equals("yes")) {
			    System.out.println("Available lifelines:");
			    if (!audiencePollUsed)
			     System.out.println("1. Audience Poll");
			    if (!phoneCallUsed) 
			    	System.out.println("2. Phone Call");
			    if (!fiftyFiftyUsed) 
			    	System.out.println("3. 50:50");

			    System.out.println("Enter lifeline number :");
			    String lifelineChoice = sc.nextLine();
			    switch (lifelineChoice) {
			    case "1":
			        if (!audiencePollUsed) {
			        	System.out.println(GREEN+"you selected: audiencePoll"+RESET);
			        	System.out.println(GREEN+"A: 10%  B: 20%  C: 60%  D: 10%"+RESET);
			            audiencePollUsed = true;
			        } else {
			            System.out.println(RED+" Audience Poll you already used .  "+RESET);
			        }
			        break;
			    case "2":
			        if (!phoneCallUsed) {
		                System.out.println(GREEN+"📞 Phone Call: 'I think the answer might be option " + correctoptions[i] + "'"+RESET);
			            phoneCallUsed = true;
			        } 
			        else {
			            System.out.println(RED+" Phone Call already used."+RESET);
			        }
			        break;
			    case "3":
			        if (!fiftyFiftyUsed) {
			        	System.out.println(GREEN+"you selected: fiftyFifty"+RESET);
			        	 System.out.println(GREEN+"-> " + answers[i]+RESET);
			                for (int j = 0; j <= 4; j++) {
			                    if (options[i][j].charAt(0) != correctoptions[i]) {
			                        System.out.println(GREEN+"-> " + options[i][j]+RESET);
			                        break;
			                    }
			                }
			            fiftyFiftyUsed = true;
			        } else {
			            System.out.println(RED+" 50:50 already used."+RESET);
			        }
			        break;
			    default:
			        System.out.println(RED+"❌ Invalid lifeline option."+RESET);    
			}
			}
			System.out.println("enter your answer :");
			char userAnswer = sc.nextLine().toUpperCase().charAt(0);
			if (userAnswer == correctoptions[i]) {
				System.out.println(GREEN+"Correct! 🎉"+RESET);
				System.out.println(GREEN+"u won ₹"+a[i]+RESET);
				temp++;
				System.out.println("================");
			}
		else {
			System.out.println(RED + "Wrong : The correct answer was: " + answers[i] + RESET);
			int totalPrize;
			if (i == 0 ) {
		        totalPrize = 0 ;
		        System.out.println(RED + "You failed within the first  questions." + RESET);
		    } 
			else if (i < 5) {
		        totalPrize = a[0] ;
		        System.out.println(RED + "You failed within the first 5 questions." + RESET);
		    } 
			else {
		        totalPrize = a[4];
		        System.out.println(RED + "You failed after question 5." + RESET);
		    }
		    System.out.println(GREEN + "Final Prize: ₹" + totalPrize + RESET);
		    System.out.println(RED + "Game Over!" + RESET);
		    break;
			}
		}
	}
}