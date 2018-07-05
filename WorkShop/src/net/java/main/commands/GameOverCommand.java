package net.java.main.commands;

import net.java.main.interfaces.Command;

public class GameOverCommand implements Command {


    public String execute(String[] args) {
        return "Game over!";
    }
}
