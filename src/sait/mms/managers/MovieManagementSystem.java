package sait.mms.managers;

import java.sql.*;
import java.util.*;

import sait.mms.contracts.DatabaseDriver;
import sait.mms.drivers.MariaDBDriver;

public class MovieManagementSystem {
	private DatabaseDriver db;
	
	public MovieManagementSystem() throws SQLException {
		this.db = new MariaDBDriver();
		this.db.connect();
	}
	
	public void displayMenu() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Jim's Movie Manager");
		System.out.printf("%-7d %s%n",1,"Add New Movie");
		System.out.printf("%-7d %s%n",2,"Print movies released in year");
		System.out.printf("%-7d %s%n",3,"Print random list of movies");
		System.out.printf("%-7d %s%n",4,"Delete a movie");
		System.out.printf("%-7d %s%n",5,"Exit");
		System.out.println();
		System.out.print("Enter an option: ");
		int option = in.nextInt();
		System.out.println();
		switch(option) {
		case 1:
			addMovie();
			break;
		case 2:
			printMoviesInYear();
			break;
		case 3:
			printRandomMovies();
			break;
		case 4:
			deleteMovie();
			break;
		case 5:
			System.out.println("Goodbye!");
			break;
		default:
			System.out.println("Invalid Input!");
		}
		in.close();
	}
	
	public void addMovie() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter movie title: ");
		String title = in.nextLine();
		System.out.print("Enter duration: ");
		int duration = in.nextInt();
		System.out.print("Enter year: ");
		int year = in.nextInt();
		
		String query = "insert into movies (duration,title,year) values(" + duration + ",'" + title + "'," + year + ")";
		
		db.update(query);
		System.out.println("Added movie to database");
		System.out.println();
		displayMenu();
		in.close();
	}
	
	public void printMoviesInYear() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter in year: ");
		int year = in.nextInt();
		System.out.println();
		System.out.println("Movie List");
		System.out.printf("%-14s %-5s %s%n","Duration","Year","Title");
		String query = "select * from movies where year =" + year;
		
		ResultSet result = db.get(query);
		int totalDuration = 0;
		int duration;
		while(result.next()) {
			duration = result.getInt(2);
			totalDuration += duration;
			System.out.printf("%-14d %-5d %s%n",duration, result.getInt(4),result.getString(3));
		} 
		System.out.println("\nTotal duration: "+ totalDuration + " minutes");
		displayMenu();
		in.close();
	}
	
	public void printRandomMovies() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of movies: ");
		int movies = in.nextInt();
		System.out.println("Movie List");
		System.out.printf("%-14s %-5s %s%n","Duration","Year","Title");
		String query = "select * from movies order by rand() limit "+ movies;
		ResultSet result = db.get(query);
		int totalDuration = 0;
		int duration;
		while(result.next()) {
			duration = result.getInt(2);
			totalDuration += duration;
			System.out.printf("%-14d %-5d %s%n",duration, result.getInt(4),result.getString(3));
		} 
		System.out.println("\nTotal duration: "+ totalDuration + " minutes");
		displayMenu();
		in.close();
	}
	
	public void deleteMovie() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the movie ID that you want to delete: ");
		int id = in.nextInt();
		System.out.println();
		String query = "delete from movies where id = " + id;
		db.update(query);
		System.out.println("Movie " + id + " is deleted");
		displayMenu();
		in.close();
	}
	public void disconnect() throws SQLException {
		this.db.disconnect();
	}
}
