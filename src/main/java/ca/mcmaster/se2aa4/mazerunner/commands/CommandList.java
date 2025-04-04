package ca.mcmaster.se2aa4.mazerunner.commands;

import ca.mcmaster.se2aa4.mazerunner.status.*;

import java.util.HashMap;
import java.util.Map;

//allows for less cumbersome command management
public class CommandList {
    private Map<String, Command<?>> commandMap = new HashMap<>();
    Coordinates coords;
    Direction direction;
    PreviousMove previous;

    public CommandList(Direction dir, Coordinates coordinates, PreviousMove previous) {
        direction = dir;
        coords = coordinates;
        this.previous = previous;
    }

    public void addCommand(String commandName, Command<?> command) {
        commandMap.put(commandName, command);
    }

    public Command<?> getCommand(String commandName) {
        Command<?> command = commandMap.get(commandName);
        if (command != null) {
            return commandMap.get(commandName);
        } else {
            System.out.println("Command not found: " + commandName);
            return null;
        }
    }

    public void defaultList() {
        commandMap.put("getCoordinates", new GetCoordinatesCommand(coords));
        commandMap.put("getDirection", new GetDirectionCommand(direction));
        commandMap.put("setDirection", new SetDirectionCommand(direction));
        commandMap.put("setCoordinates", new SetCoordinatesCommand(coords));
        commandMap.put("getPreviousMove", new GetPreviousMoveCommand(previous));
        commandMap.put("setPreviousMove", new SetPreviousMoveCommand(previous));
    }
}
