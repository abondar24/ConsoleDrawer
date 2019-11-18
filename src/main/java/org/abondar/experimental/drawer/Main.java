package org.abondar.experimental.drawer;


import org.abondar.experimental.drawer.command.CommandSwitcher;
import org.abondar.experimental.drawer.exception.InvalidCommandException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var switcher = new CommandSwitcher();

        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Command: ");
            var command = scanner.nextLine();
            String[] cmdData = command.split(" ");
            try {
                switcher.executeCommand(cmdData);
            } catch (InvalidCommandException ex){
                System.out.println(ex.getLocalizedMessage());
            }

        }
    }
}
