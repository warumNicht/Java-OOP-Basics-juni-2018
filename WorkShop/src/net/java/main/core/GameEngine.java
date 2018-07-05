package net.java.main.core;

import net.java.main.dispachers.CommandDispatcher;
import net.java.main.exceptions.GameException;
import net.java.main.interfaces.Engine;
import net.java.main.interfaces.InputReader;
import net.java.main.interfaces.OutputWriter;
import net.java.main.io.ConsoleReader;
import net.java.main.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameEngine implements Engine {

    private InputReader consoleReader;
    private OutputWriter outputWriter;
    private CommandDispatcher commandDispatcher;
    private boolean isStarted;

    public GameEngine(InputReader consoleReader, OutputWriter outputWriter, CommandDispatcher commandDispatcher) {
        this.consoleReader = consoleReader;
        this.outputWriter = outputWriter;
        this.commandDispatcher = commandDispatcher;
    }

    //@Override
    public void start() throws IOException {
        this.isStarted=true;
        while (isStarted) {
            try {
                String userInput = this.consoleReader.readLine();
                String[] args = userInput.split("\\s+");

                String result = this.commandDispatcher.dispatchCommand(args);

                this.outputWriter.writeLine(result);

                if (result.equals("Game over!")) {
                    this.isStarted=false;
                }
            } catch (GameException | IOException e) {
                this.outputWriter.writeLine(e.getMessage());


            }
        }
    }
}
