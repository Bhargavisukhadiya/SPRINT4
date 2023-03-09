package main;

import model.interfaces.IApplicationState;

public class copyTheCommand implements ICommand, IUndoable {
    private IApplicationState appState;
    public copyTheCommand(IApplicationState appState) {
        this.appState = appState;
    }

    @Override
    public void run() {
        CommandStory.add(this);
        for (Shaping s : appState.getShapelist()) {
            if (s.isSelected == true) {
                appState.setCopylist(s);
            }
        }
    }
    @Override
    public void undo() {
        System.out.println("copyCommand");
    }
    @Override
    public void redo() {
    }
}
