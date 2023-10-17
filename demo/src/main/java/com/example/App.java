package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 6000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            System.out.println("WELCOME TO THE GUESS THE NUMBER GAME. IN THIS GAME, YOU HAVE TO GUESS THE NUMBER THAT I THUOUGHT, GOOD LUCK!");

            Scanner input = new Scanner(System.in); // Create a Scanner object
            System.out.println("Enter a number from 1 to 100");

            String numberinfromuser;
            String messfromserver = " ";

            while (!messfromserver.equals("AAA") ) {
                numberinfromuser = input.nextLine(); // Read user input
                out.writeBytes(numberinfromuser + "\n");

                messfromserver = in.readLine();

                //System.out.println("sas" + messfromserver);

                if (messfromserver.equals("A")) {
                    System.out.println("NUMBER IS HIGHER THAN THAT, TRY AGAIN!");
                }

                if (messfromserver.equals("AA")) {
                    System.out.println("NUMBER IS LOWER THAN THAT, TRY AGAIN!");
                }
            }

            System.out.println("YOU WIN!! :)");

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
