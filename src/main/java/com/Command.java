 
package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.data.Record;

public class Command {

	public static void main(String[] args) {
		Record record = new Record();
		Scanner scanner = new Scanner(System.in);
		String process = "yes";
		do {

			System.out.println("Option 1 -> List top n pages that were viewed the most.");
			System.out.println("Option 2 -> List top n pages where most time was spent.");
			System.out.println("Option 3 -> List top n active users (by most time spent).");
			System.out.println("Option 4 -> Daily, monthly and quarterly report.");
			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.println(record.getListOfTopViewPages());
					break;
				case 2:
					System.out.println(record.getListOfMostTimeSpent());
					break;
				case 3:
					System.out.println(record.getListOfActiveUsersMostTimeSpent());
					break;
				case 4:
					System.out.println("Please enter from date and this format yyyy-MM-dd:");
					String from = scanner.next();
					System.out.println("Please enter to date and this format yyyy-MM-dd:");
					String to = scanner.next();
					try {
						LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						LocalDate toDate = LocalDate.parse(to, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
						System.out.println(record.getPagesViewedListBasedOnDate(fromDate, toDate));

					} catch (Exception e) {
						System.err.println("Please enter date in correct format.");
					}
					break;
				default:
					System.out.println("you enter wrong input.");
			}
			System.out.println("you want continue ? yes/no");
			process = scanner.next();
		} while ("yes".equalsIgnoreCase(process) || process.startsWith("y"));
		System.out.println("*******Viva la rasa***********");
		scanner.close();
	}

}