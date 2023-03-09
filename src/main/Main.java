package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        ICommand delete= new deleteTheCommand(appState,paintCanvas);
        Shaping groupTheShape= new groupTheShape();
        ICommand paste= new pasteTheCommand(appState,paintCanvas);
        ICommand copy= new copyTheCommand(appState);
        ICommand group= new groupingTheCommand(appState,groupTheShape);
        ICommand ungroup= new unGroupTheCommand(appState,groupTheShape);
        IJPaintController controller = new JPaintController(uiModule, appState,copy,paste,delete,group,ungroup);
        controller.setup();
        paintCanvas.addMouseListener(new MouseClicked(paintCanvas,appState));
    }
}
