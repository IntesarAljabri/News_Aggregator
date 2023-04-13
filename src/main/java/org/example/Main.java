package org.example;

import java.util.Scanner;
public class Main {
    public static Object main(String[] args) {
        Scanner scan = new Scanner(System.in);
        JDBC db = new JDBC();

        while (true) {
            System.out.println("==========================================================");
            System.out.println("[1] LOGIN");
            System.out.println("[2]  Initialize database");
            System.out.println("[3]  Fetch Data of ArticlesTable from API");
            System.out.println("[4]  INSERT INTO JDBC");
            System.out.println("[5]  REMOVE TABLES FROM DATABASE");
            System.out.println("[6]  FETCH ArticlesTable FROM DB");
            System.out.println("[7]  SEARCH FROM DATABASE");
            System.out.println("[8]   DISPLAY THE MOST POPULAR ARTICLES");
            System.out.println("[9]  Exit program");
            System.out.println("=========================================================");

            int op;
            try {
                System.out.print("Enter option number: ");
                op = scan.nextInt();
            } catch (Exception e) {
                System.err.println("Please enter a number only.");
                scan.next(); // discard non-integer input
                continue; // go back to the beginning of the loop
            }

            // continue with switch statement
            switch (op) {
                case 1:
                    db.login();
                    break;

                case 2:
                    db.initializeDatabase();

                    break;
                case 3:
                    API.getAPI();
                    break;
                case 4:
                    db.INSERT_ArticleTable();
                    break;
                case 5:
                    db.removeArticles();
                    break;
                case 6:
                    db.fetchArticles();
                    break;
                case 7:
                    db.searchFromDatabase();
                    break;
                case 8:
                    API.getAPIMostPopularArticles();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid option number");
                    break;
            }
         }
      }
    }






