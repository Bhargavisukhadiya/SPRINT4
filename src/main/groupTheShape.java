package main;

import java.util.ArrayList;

public class groupTheShape extends Shaping{
   private  ArrayList<Shaping> shapeList = new ArrayList<>();
   private ArrayList<ArrayList<Shaping>> groupList= new ArrayList<>();
   public  void setShapeList(Shaping shape){
       shapeList.add(shape);
   }
   public  ArrayList<Shaping> getShapeList(){
       return shapeList;
   }
   public  void setGroupList(ArrayList<Shaping> shape){
       groupList.add(shape);
   }
   public  ArrayList<Shaping> getGroupList(int index) {
        ArrayList<Shaping> Group=groupList.get(index);
        return Group;
   }
   public ArrayList<ArrayList<Shaping>> getGroup(){
       return groupList;
    }
}


