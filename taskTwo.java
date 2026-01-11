import java.util.Scanner;
public class taskTwo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Subjects ...");
        int numOfSubject = sc.nextInt();
        int totalMarks = 0;
        for(int i=1; i<=numOfSubject;i++){
            System.out.println("Enter the marks of subject " + i + "out of (100) : ");
            int marks = sc.nextInt();
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numOfSubject ;
        char grade;
        if(averagePercentage >=90){
            grade = 'A';
        } else if (averagePercentage >=80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        }else{
            grade = 'F';
        }

        System.out.println("Total Marks : " + totalMarks);
        System.out.println("Average Percentage : " + averagePercentage);
        System.out.println("Grade : " + grade);
    }
}
