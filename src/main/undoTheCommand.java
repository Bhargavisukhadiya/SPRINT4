package main;

public class undoTheCommand implements ICommand{
    @Override
    public void run() {
        CommandStory.undo();
    }
}
