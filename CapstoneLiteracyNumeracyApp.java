/*
 * 1. Variables
 
Declare Scanner in
Declare boolean exit
Declare ArrayLists
Declare User progress 

*2. Input
 The user enters numbers to check their selections.

*Loops
 Loop while EXIT
loop until the user decides to exit


 Methods/Functions
public static void main (String[] args)-the entry point of the program
public static void literacyLessons(FileDisplayHelper fileHelper){; Displays literacy lesson options
public static void numeracyLessons(FileDisplayHelper fileHelper){; DIsplays numeracy lesson options
public static void takeQuiz(FileDisplayHelper fileHelper){; DIsplays questions, gets user answer, check and update answers. Displays result
public static void viewProgress(FileDisplayHelper fileHelper){;  Display user progress


Arrays/lists
Declare an array to store the quiz questions and answers grades of students; 


* Conditions
   if -the user selects the number of options available: else- print invalid choice and ask user to reselect;  
   Print default as invalid choice

*5. Output
Print results and answers.
 
A final statement indicating that the conditional statement is complete.
Comparing my code with an AI generated response
Packaging the apllication into a runnable file.
Compile the program using javac in submitting the final program.

/**
 *Save program as CapstoneLiteracyNumeracyApp.java
 */

import java.io.*; //Import for the file reading and handling
import java.util.*; //Import scanner

public class CapstoneLiteracyNumeracyApp {
	//This is the main method. I will explain how the app works here. The method will loop until the user is done with the quiz.
private static HashMap<String, Integer> progress = new HashMap<>(); //The progress tracker
	public static void main(String[] args){
            //VARIABLES
Scanner in = new Scanner(System.in); //Create a scanner used to get user input from keyboard
FileDisplayHelper fileHelper = new FileDisplayHelper(); //Class to handle file
 boolean exit = false; //Boolean to control program exit

                //INSTRUCTIONS TO USER

                System.out.println("===This is an interactive literacy and numeracy learning app. You can select any of the modules below to begin. I hope you enjoy!===");
                System.out.println();
                 displayFileContent("instructionsHelp.txt", fileHelper);
                //Display main menu options to the user

                while (!exit) {
                    //loop until the user decides to exit
                    
                    System.out.println("\nLiteracy and Numeracy learning Main menu");
                    System.out.println("1. Literacy lessons");
                    System.out.println("2. Numeracy lessons");
                    System.out.println("3. Take a quiz");
                    System.out.println("4. View my progress");
                    System.out.println("5. Exit");
                    
                    System.out.print("Enter your choice: ");

                    if(in.hasNextInt()){ //Check if the input is an integer
                        
                        int choice = in.nextInt(); //Read the user input to select menu option
                        in.nextLine(); //Go to new line

                        //Handle the choice of the user
                        switch (choice) {
                            case 1:literacyLessons(fileHelper);
                            break;
                            
                            case 2:numeracyLessons(in, fileHelper);
                            break;
                            
                            case 3:  takeQuiz(fileHelper);
                            break;
                            
                            case 4: viewProgress(fileHelper);
                            break;
                            
                            case 5:
                                System.out.println("Thank you for using the App.");
                                exit = true; //Exit to terminate the program
                                break;
                            default: System.out.println("Invalid choice. Please try again.");
                        }
                    } else{
                        System.out.println("Invalid choice. Please input a number; ");
                        in.nextLine(); //Clear invalid input
                    }  } }  
                //Close the scanner
        //Class to handle file
					
	
	//LITERACY LESSONS METHOD
	public static void literacyLessons(FileDisplayHelper fileHelper) {
		
        System.out.println("\n===Literacy Lessons===");
        System.out.println("1. Learn letters of the alphabet");
        System.out.println("2. Learn words");
        System.out.println("3. Learn simple sentences");
        System.out.print("Enter your choice: ");

       Scanner in = new Scanner(System.in); //Create a scanner used to get user input from keyboard

       if (in.hasNextInt()) { //Check if the input is an integer
		int choice = in.nextInt();

        switch (choice) {

            case 1:
            displayFileContent("alphabets.txt", fileHelper);
            break; //Display the contents of the file alphabet.txt
        

            case 2:
                displayFileContent("words.txt", fileHelper);
                    //Display the contents of the file words.txt
    

            case 3 :
                System.out.println("Lessons:Sentences(Example: 'The dog is in the car.')");
                displayFileContent("simpleSentences.txt", fileHelper);
                    //Display the contents of the file simplesentences.txt
            default: System.out.println("Invalid choice.");
        }
      } else {
            System.out.println("Invalid input. Returning to main menu.");
        }
    }


    //NUMERACY LESSONS METHOD
	public static void numeracyLessons(Scanner in, FileDisplayHelper fileHelper){
        //Create scanner to read user input
		
        System.out.println("\n===Numeracy Lessons===");
        System.out.println("1. Learn Numbers");
        System.out.println("2. Learn basic math operations: Additions");
        System.out.println("3. Learn basic math operations: Subtractions");
        System.out.println("4. Learn basic math operations: Multiplications");
        System.out.println("5. Learn basic math operations: Divisions");

        System.out.print("Enter your lesson choice: ");
       if(in.hasNextInt()){ //Check if the input is an integer
		int choice = in.nextInt();

        switch(choice) {
            case 1 -> {
                System.out.println("\n---Learn numbers---");
                displayFileContent("numbers.txt", fileHelper);
                }

            case 2 -> {
                System.out.println("Learn additions");
                displayFileContent("additions.txt", fileHelper);
                }

            case 3 -> {
                System.out.println("\n---Learn subtractions---");
                displayFileContent("subtractions.txt", fileHelper);
                }

            case 4 -> {
                System.out.println("\n---Learn multiplications---");
               displayFileContent("multiplications.txt", fileHelper);
                }

            case 5 -> {
                System.out.println("\n---Learn divisions---");
                displayFileContent("divisions.txt", fileHelper);
                }

            default -> System.out.println("Invalid choice.");
        }
    }
    }

    //QUIZ MODULE

    public static void takeQuiz(FileDisplayHelper fileHelper){
        Scanner in = new Scanner(System.in);
		
        System.out.println("\n===Quiz===");
         System.out.println("1. Take a defined random quiz");
       System.out.println("2. Take a file based quiz");

        System.out.print("Enter your choice: ");

        int choice = in.nextInt();
        in.nextLine(); //Go to new line

         switch(choice) {
            case 1 -> takeRandomQuiz();  //Take a random quiz

            case 2 -> takeFileBasedQuiz(fileHelper);
        //display questions from the external quiz file

 default -> System.out.println("Invalid choice.");
        }
    }

//Random quiz
       public static void takeRandomQuiz() { //To store quiz question and answers
        Scanner in = new Scanner(System.in);
         ArrayList<String>questions = new ArrayList<>(Arrays.asList(
              "What is 2+7? (a)3 (b)9 (c)6",
              "What comes after 'B'? (a) C (b) D (c) E",
                "What is 10 / 2? (a) 3 (b) 5 (c) 6"));

       ArrayList<String>correctAnswers = new ArrayList<>(Arrays.asList("b", "a", "b"));   

    int correctCount = 0; 

    System.out.println("\n===Random based Quiz===");
    for(int i = 0; i < 3; i++) {
        int index = new Random().nextInt(questions.size());

        System.out.println(questions.get(index)); //Display questions
        System.out.println("Enter answer(or 0 to return to main menu): ");

        String answer = in.nextLine().toLowerCase();

       //To validate
       if (answer.equals("0")) {
                System.out.println("Exiting quiz...");
                return;
            }
        if
        (answer.equals(correctAnswers.get(i))) {
         System.out.println("Correct");
         correctCount++;    
           
        }else{
        System.out.println("Incorrect.");
        }
    }
 System.out.println("You answered " + correctCount + " question(s) correctly."); //Display the result
 progress.put("Score on random based quiz ", correctCount);
    }

public static void takeFileBasedQuiz(FileDisplayHelper fileHelper){ //To store quiz question and answers
        Scanner in = new Scanner(System.in);
         ArrayList<String>questions = fileHelper.loadQuestionsFromFile("quiz-questions.txt");//Load quiz questions from the external file
         
         if(questions.isEmpty()){
            System.out.println("No questions found");
            return; //Exit
         }            

    int correctCount = 0;  //Counts correct answers

    System.out.println("\n===File based Quiz===");
    for (String line : questions) { //Split questions and answer
        String[] parts = line.split("\\|");
        if (parts.length != 2) {
            System.out.println("Malformed question: " + line);
            continue;
        }

        String question = parts[0].trim();
        String correctAnswer = parts[1].trim();

System.out.println(question);
System.out.print("Input your Answer (or enter 0 to exit); ");
String userAnswer = in.nextLine().toLowerCase();

       //To validate
        if(userAnswer.equals("0")){
            System.out.println("Exiting quiz ");
            return;

        }else if (userAnswer.equals(correctAnswer)){
            System.out.println("Correct");
            correctCount++;

        }else{
            System.out.println("Wrong answer. The right answer is " + correctAnswer);
        }
        }

        System.out.println("You answered " + correctCount + "questions correctly."); //Display the result
 progress.put("Score on file based quiz ", correctCount);
    }

    //VIEW PROGRESS MODULE 
    public static void viewProgress(FileDisplayHelper fileHelper){
		
        System.out.println("\n===Progress Tracker===");
        if(progress.isEmpty()){
            System.out.println("No progress has been made yet.");
        }else{
            for (Map.Entry<String, Integer> entry : progress.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " correct answers on a quiz or gained knowledge.");
                
            }}}

        //To display file content
public static void displayFileContent(String fileName, FileDisplayHelper fileHelper) {
        ArrayList<String> content = fileHelper.loadQuestionsFromFile(fileName);
 
        if (content.isEmpty()) {
            System.out.println("No content available in " + fileName);
        } else {
            System.out.println("\n--- Contents of " + fileName + " ---");
            for (String line : content) {
                System.out.println(line);
            }
            progress.put(fileName.replace(".txt", ""), content.size());
        }
    }
}
           
           
      //Using Array list to store progress
      class FileDisplayHelper {
      public ArrayList<String> loadQuestionsFromFile(String fileName) {
        ArrayList<String> questions = new ArrayList<>();
        
        try (Scanner fileIn = new Scanner (new File(fileName))){ //Create a scanner called fileIn to read the file
    
                while(fileIn.hasNextLine()){ //Use while loop
                questions.add(fileIn.nextLine());
                }   

        } catch (FileNotFoundException e) {
                  System.out.println("Error: File" + fileName + "cannot be found.");     
            }
      return questions;
    }
 }



/*
*Changes made;
I did not need a progress.txt so I removed it
I divided the quiz module into two, so I could have the questions from the external file and quiz questions and answers
also stored in the ArrayLists within the program.
Packaging my java into a runnable file.

