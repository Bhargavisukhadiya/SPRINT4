package model;
import model.interfaces.IApplicationState;

import javax.management.InstanceAlreadyExistsException;
import java.awt.*;
import java.util.EnumMap;

public enum ShapeColor {



    BLACK,
    BLUE,
    CYAN,
    DARK_GRAY,
    GRAY,
    GREEN,
    LIGHT_GRAY,
    MAGENTA,
    ORANGE,
    PINK,
    RED,
    WHITE,
    YELLOW;




    public static Color getColor(ShapeColor color) {
        EnumMap<ShapeColor, Color> colorChoice = new EnumMap<>(ShapeColor.class);
        colorChoice.put(ShapeColor.GREEN, Color.GREEN);
        colorChoice.put(ShapeColor.RED, Color.RED);
        colorChoice.put(ShapeColor.PINK, Color.PINK);
        colorChoice.put(ShapeColor.GRAY, Color.GRAY);
        colorChoice.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        colorChoice.put(ShapeColor.CYAN, Color.CYAN);
        colorChoice.put(ShapeColor.MAGENTA, Color.MAGENTA);
        colorChoice.put(ShapeColor.ORANGE, Color.ORANGE);
        colorChoice.put(ShapeColor.YELLOW, Color.YELLOW);
        colorChoice.put(ShapeColor.WHITE, Color.WHITE);
        colorChoice.put(ShapeColor.BLACK, Color.BLACK);
        colorChoice.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        colorChoice.put(ShapeColor.BLUE, Color.BLUE);
        return colorChoice.get(color);

    }
}
