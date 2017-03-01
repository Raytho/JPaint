package jpaint;

import java.awt.Color;
import java.awt.Point;

public class ModelShape {
    private Point pointStart;
    private Point pointEnd;
    private Color color;
    private Color bgColor;
    private EnumShapes shapeType;
    private boolean selected;


    public ModelShape(Point pointStart, Point pointEnd, Color color, Color bgColor,  EnumShapes shapeType) {
        this.pointStart = pointStart;
        this.pointEnd = pointEnd;
        this.color = color;
        this.bgColor = bgColor;
        this.shapeType = shapeType;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }
    
    public Point getPointStart() {
        return pointStart;
    }

    public void setPointStart(Point pointStart) {
        this.pointStart = pointStart;
    }

    public Point getPointEnd() {
        return pointEnd;
    }

    public void setPointEnd(Point pointEnd) {
        this.pointEnd = pointEnd;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public EnumShapes getShapeType() {
        return shapeType;
    }

    public void setShapeType(EnumShapes shapeType) {
        this.shapeType = shapeType;
    }
    
     public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
