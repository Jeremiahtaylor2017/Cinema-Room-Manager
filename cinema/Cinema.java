package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
//        String cinema = "Cinema:";
//        System.out.println(cinema);
//
//        for (int i = 1; i < 9; i++) {
//            System.out.print(" " + i);
//        }
//        System.out.println();
//        for (int j = 1; j < 8; j++) {
//            System.out.print(j + " ");
//            for (int k = 0; k < 8; k++) {
//                System.out.print("S ");
//            }
//            System.out.println();
//        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        int totalSeats = rows * seats;
        int price = 10;
        int totalPrice;
        if (totalSeats <= 60) {
            totalPrice = price * totalSeats;
        } else {
            int front = rows / 2;
            int backPrice = 8;
            int frontTotal = front * price * seats;
            int backTotal = (rows - front) * backPrice * seats;
            totalPrice = frontTotal + backTotal;
        }

        System.out.println("Total income:");
        System.out.print("$" + totalPrice);
    }
}