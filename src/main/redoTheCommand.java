package main;

public class redoTheCommand implements ICommand {
    @Override
    public void run() {
        CommandStory.redo();
    }
}
