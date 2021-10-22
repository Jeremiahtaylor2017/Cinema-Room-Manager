package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void showSeats(int rows, int seats, char[][] s) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
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
        int selectedRow;
        int selectedSeat;
        while (true) {
            System.out.println("Enter a row number:");
            selectedRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            selectedSeat = scanner.nextInt();
            if (selectedRow < 1 || selectedRow > rows
                || selectedSeat < 1 || selectedSeat > seats) {
                System.out.println();
                System.out.println("Wrong input!");
                System.out.println();
            } else if (s[selectedRow - 1][selectedSeat - 1] == 'B') {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
                System.out.println();
            } else {
                break;
            }
        }

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
        System.out.println();
        System.out.println("Ticket price: $" + selectedPrice);
    }

    public static void statistics(int rows, int seats, char[][] s) {
        int count = 0;
        for (char[] array : s) {
            for (char chars : array) {
                if (chars == 'B') {
                    count++;
                }
            }
        }
        System.out.printf("%nNumber of purchased tickets: %d", count);

        int totalSeats = rows * seats;
        float percentSold = (float) count / totalSeats * 100;
        System.out.printf("%nPercentage: %.2f%%", percentSold);

        int front = rows / 2;
        int frontPrice = 10;
        int backPrice = 8;
        int currentIncome = 0;
        if (totalSeats <= 60) {
            currentIncome += frontPrice;
        } else {
            for (int i = 0; i < front; i++) {
                for (int j = 0; j < s[i].length; j++) {
                    if (s[i][j] == 'B') {
                        currentIncome += frontPrice;
                    }
                }
            }
            for (int i = front; i < s.length; i++) {
                for (int j = 0; j < s[i].length; j++) {
                    if (s[i][j] == 'B') {
                        currentIncome += backPrice;
                    }
                }
            }
        }

        System.out.printf("%nCurrent income: $%d", currentIncome);

        int totalIncome;
        if (totalSeats <= 60) {
            totalIncome = totalSeats * frontPrice;
        } else {
            totalIncome = front * frontPrice * seats
                    + (rows - front) * backPrice * seats;
        }
        System.out.printf("%nTotal income: $%d%n", totalIncome);
    }


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
                case 3:
                    statistics(rows, seats, cinema);
                    break;
                default:
                    break;
            }
        }
    }
}