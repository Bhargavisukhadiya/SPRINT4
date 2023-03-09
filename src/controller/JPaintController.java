package controller;

import main.ICommand;
import main.redoTheCommand;
import main.undoTheCommand;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ICommand copy;
    private final ICommand paste;
    private final ICommand delete;
    private final ICommand group;
    private final ICommand ungroup;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ICommand copy, ICommand paste, ICommand delete, ICommand group, ICommand ungroup) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.copy=copy;
        this.paste=paste;
        this.delete=delete;
        this.group=group;
        this.ungroup=ungroup;

    }


    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        ICommand undo= new undoTheCommand();
        ICommand redo = new redoTheCommand();
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> copy.run());
        uiModule.addEvent(EventName.PASTE,()-> paste.run());
        uiModule.addEvent(EventName.DELETE,( )->delete.run());
        uiModule.addEvent(EventName.REDO,()-> redo.run());
        uiModule.addEvent(EventName.UNDO,()-> undo.run());
        uiModule.addEvent(EventName.GROUP,()->group.run());
        uiModule.addEvent(EventName.UNGROUP,()->ungroup.run());

    }
}
