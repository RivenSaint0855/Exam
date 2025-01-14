import java.util.Scanner;

class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		
        System.out.print("Enter the number of students in the class: ");
        int numStudents = input.nextInt();
        input.nextLine();

        System.out.print("Enter the number of assignments (quizzes, homework, exams): ");
        int numAssignments = input.nextInt();
        input.nextLine();

        double classTotal = 0;
        double highestAverage = Double.MIN_VALUE;
        double lowestAverage = Double.MAX_VALUE;

        String[] studentNames = new String[numStudents];
        double[] studentAverages = new double[numStudents];
        String[] letterGrades = new String[numStudents];

        double[] weights = new double[numAssignments];
        System.out.println("Enter the weight for each assignment (must add up to 1.0): ");
        for (int i = 0; i < numAssignments; i++) {
            System.out.print("Weight of assignment " + (i + 1) + ": ");
            weights[i] = input.nextDouble();
        }
        input.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = input.nextLine();

            double totalinputore = 0;
            for (int j = 0; j < numAssignments; j++) {
                double inputore;
                while (true) {
                    try {
                        System.out.print("Enter the Score for assignment " + (j + 1) + ": ");
                        inputore = Double.parseDouble(input.nextLine());
                        if (inputore < 0 || inputore > 100) {
                            System.out.println("input Score must be between 0 and 100. Try again.");
                        }
						else {
                            break;
                        }
                    }
					catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a numeric input.");
                    }
                }
                totalinputore += inputore * weights[j];
            }

            double averageinputore = totalinputore;
            studentAverages[i] = averageinputore;
            classTotal += averageinputore;
			
			//Compute for Average Grades
            if (averageinputore >= 90) {
                letterGrades[i] = "A";
            }
			else if (averageinputore >= 80) {
                letterGrades[i] = "B";
            }
			else if (averageinputore >= 70) {
                letterGrades[i] = "C";
            }
			else if (averageinputore >= 60) {
                letterGrades[i] = "D";
            }
			else {
                letterGrades[i] = "F";
            }

            if (averageinputore > highestAverage) {
                highestAverage = averageinputore;
            }
            if (averageinputore < lowestAverage) {
                lowestAverage = averageinputore;
            }
        }

        System.out.println("\nStudent Information:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Name: " + studentNames[i] +
                    ", Average Score: " + studentAverages[i] +
                    ", Grade: " + letterGrades[i]);
        }

        double classAverage = classTotal / numStudents;
        System.out.println("\nClass Average: " + classAverage);

        System.out.println("Highest Average: " + highestAverage);
        System.out.println("Lowest Average: " + lowestAverage);

        input.close();
    }
}
