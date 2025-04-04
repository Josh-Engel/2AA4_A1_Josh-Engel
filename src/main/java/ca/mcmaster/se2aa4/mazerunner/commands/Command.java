package ca.mcmaster.se2aa4.mazerunner.commands;

//interface for command design pattern
public interface Command<T> {
    
    public T execute(Integer[] coords, char update);
}
