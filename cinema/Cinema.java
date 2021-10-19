package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        char[][] cinema = new char[rows][seats];
        for (char[] chars : cinema) {
            Arrays.fill(chars, 'S');
        }

        while (true) {
            showMenu();
            int menuOption = scanner.nextInt();
            switch (menuOption) {
                case 0:
                    return;
                case 1:
                    showSeats(rows, seats, cinema);
                    break;
                case 2:
                    buyTicket(rows, seats, cinema);
                    break;
                default:
                    break;
            }
        }
    }


    public static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }


    public static void showSeats(int rows, int seats, char[][] s) {
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; j++) {
                System.out.print(" " + s[i][j]);
            }
            System.out.println();
        }
    }


    public static void buyTicket(int rows, int seats, char[][] s) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter a row number:");
        int selectedRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int selectedSeat = scanner.nextInt();

        int totalSeats = rows * seats;
        int price = 10;
        int selectedPrice;
        if (totalSeats <= 60) {
            selectedPrice = price;
        } else {
            int front = rows / 2;
            int backPrice = 8;
            if (selectedRow <= front) {
                selectedPrice = price;
            } else {
                selectedPrice = backPrice;
            }
        }
        s[selectedRow - 1][selectedSeat - 1] = 'B';
        System.out.println("Ticket price: $" + selectedPrice);
    }
}