package at.altin.modeltester;

import java.awt.*;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);
        String message1 = ("       Hello World"+"!!!    ");
        System.out.println(message1.trim());

        System.out.println(message1.replace("!", "*"));
        System.out.println(message1);
        String message2 = "Hello \"Mosh\"";
        System.out.println(message2);

        System.out.println("Hallo Leon");
        int age = 14;
        System.out.println(age);

        firstScope(scanner);

    }

    private static void firstScope(Scanner scanner) {
        System.out.println("Hello world!");
        //%s -> shkronja prsh: "qikjo"
        //%d -> numra

        System.out.printf("%s osht ni jeri!!\n", "leoni");
        System.out.printf("%d €\n", 12);


        long viewsCount = 3_123_456_789L;
        float price = 10.99F;

        char letter = 'A';
        boolean isEligible =  false;
        Date now = new Date();
        System.out.println(now);

        //################################################
        System.out.print("name:");
        String name1 = scanner.next();

        System.out.print("age:");
        byte age1 = scanner.nextByte();

        System.out.println("birth date:");
        int date1 = scanner.nextInt();


        System.out.print("name:");
        String name2 = scanner.next();

        System.out.print("age:");
        byte age2 = scanner.nextByte();

        System.out.println("birth date:");
        int date2 = scanner.nextInt();

        int date1Year = date1 % 10000;
        int date1Month = (date1 % 1000000) / 10000;
        int date1Day = date1 / 1000000;


        int date2Year = date2 % 10000;
        int date2Month = (date2 % 1000000) / 10000;
        int date2Day = date2 / 1000000;

        //Tabelle
        System.out.println("#######################");

        System.out.printf("|%-10s|%-3s|%2s.%2s.%4s|\n","Name","Age", "dd", "mm", "yyyy");
        System.out.println("---------------------------");
        System.out.printf("|%-10s|%-3d|%02d.%02d.%04d|\n",name1,age1, date1Day, date1Month, date1Year);
        System.out.printf("|%-10s|%-3d|%02d.%02d.%04d|\n",name2,age2, date2Day, date2Month, date2Year);

        System.out.println("#######################");


        int myAge = 14;
        int herAge = myAge;
        System.out.println(herAge);

        int geburdsdatum =149;
        System.out.println(geburdsdatum);
        byte x = 1;
        byte y = x;
        System.out.println(y);

        byte v = 14;
        byte b = v;
        System.out.println(b);
    }
}