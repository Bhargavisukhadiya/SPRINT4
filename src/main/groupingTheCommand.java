package main;

import model.interfaces.IApplicationState;

public class groupingTheCommand implements ICommand,IUndoable{
    private IApplicationState appState;
    private int groupNum=0;
    private Shaping groupedShape;
    public groupingTheCommand(IApplicationState appState, Shaping groupShape){
    this.appState = appState;
    this.groupedShape=groupShape;
}
    @Override
    public void run() {
        CommandStory.add(this);
       for(Shaping s: appState.getShapelist()) {
           if (s.isSelected) {
               groupedShape.setShapeList(s);
               s.setGroupID(groupNum);
               groupedShape.setGroupList(groupedShape.getShapeList());
           }
       }
       groupNum++;
    }

    @Override
    public void undo() {
      for(Shaping s: groupedShape.getGroupList(groupNum-1)){
          if(s.groupID()==groupNum-1) {
              s.setGroupID(-10);
          }
      }
       groupNum--;
    }

    @Override
    public void redo() {
        System.out.println(groupNum);
        for(Shaping s: groupedShape.getGroupList(groupNum)){
            if(s.groupID()!= groupNum)
            s.setGroupID(groupNum);
        }
        groupNum++;
    }
}
