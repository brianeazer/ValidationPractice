import java.util.Scanner;
import java.util.Arrays;

public class RecognizeInvalidInputs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] studentNames = {"Brian", "Lucy", "Matt", "Trevor", "Goose", "Patek", "Shirley Maclaine",
				"Frolly", "Smokey the Bear", "Tortiphul", "Henry", "Bob", "Larry", "Gus", "Rod", "Uma", "Ana",
				"Kanga", "Pust", "Sunshine"
				};
		
		String[] favFood = {"Korean smoothie", "cheese whiz", "grass", "glue", "just meat", "dog food", "tomatoes", 
				"particles", "corn extract", "endangered species", "milkberry steak", "tuna straight out the can", "duck tenders",
				"goo", "old beans", "wonder bread", "green tea extract", "foie gras", "white wine turnip butter",
				"just a lot of really smelly carrots"};
		
		String[] hometown = {"San Diego", "Detroit", "Warren", "Ann Arbour", "Gross Point", "East Point", "New York", 
				"San Francisco", "Tokyo", "Taipei", "San Juan", "Heaven", "Tempe", "Tampa", "Denver", "Los Angeles", 
				"Cool guy Mountain", "Monkey Mt.", "Paris", "Flint"};
		input(studentNames, favFood, hometown);
	}
	
	public static void input(String[] studentNames, String[] favFood, String[] hometown) {
		Scanner sc = new Scanner(System.in);
		int index = -1;
		String name = "";
		System.out.println("What student would you like to learn about? Here are their names. "
				+ "You can access the student by number or name:");
		printStudentNames(studentNames);
		try 
		{
			if (sc.hasNextInt()) {
			index = sc.nextInt() - 1;
			name = studentNames[index];
		    } else if (sc.hasNextLine()) {
			name = sc.nextLine();
			index = getIndex(studentNames, name);
			}
		printStudentsInfo(name, index, favFood, hometown, studentNames); 
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Looks like you didn't enter a whole number in the range of 1-20. Try again");
			input(studentNames, favFood, hometown);
		} catch(IllegalArgumentException ex) {
			System.out.println("Try again");
			input(studentNames, favFood, hometown);
		} 
	}

	public static void printStudentNames(String[] studentNames) {
		for (int i = 0; i < studentNames.length-1; i++) {
			System.out.print(studentNames[i] + ", ");
		}
		System.out.println("and " + studentNames[studentNames.length-1] + ".");
	}
	
	private static int getIndex(String[] studentNames, String name) {
		// TODO Auto-generated method stub
		int index = -1;
		for (int i=0; i < studentNames.length; i++) {
		    if (studentNames[i].equals(name)) {
		        index = i;
		        break;
		    }
	}
		return index;
	}
	
	private static void printStudentsInfo(String name, int index, String[] favFood, String[] hometown, String[] studentNames) {
		System.out.println(name + "'s favorite food is " + favFood[index] + " and he/she is from " + hometown[index] + ".");
		askToKeepGoing(name, index,favFood, hometown, studentNames);
	}

	private static void askToKeepGoing(String name, int index, String[] favFood, String[] hometown, String[] studentNames) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to ask about another student?");
		String answer = sc.nextLine();
		if (answer.matches("^[yY]+e*s*")) {
			input(studentNames, favFood, hometown);
		} else if (answer.matches("[nN][oO].*")) {
			System.out.println("See you around kid");
		}
		else {
			System.out.println("Huh?");
			askToKeepGoing(name, index, favFood, hometown, studentNames);
		}
	}
}
