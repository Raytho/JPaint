package jpaint;
import java.awt.Point;
import java.util.ArrayList;

public class ModelDrawingPanel {
    private EnumTools toolSelected;
    ArrayList<ModelShape> shapePoints;
    public ModelDrawingPanel() {
        this.shapePoints = new ArrayList<>();
        toolSelected = null;
    }

    public EnumTools getEnumeration() {
        return toolSelected;
    }

    public void setEnumeration(EnumTools enumeration) {
        this.toolSelected = enumeration;
    }
    
    public boolean isIntoLine(Point start, Point end, int x, int y){
        double dist = Math.sqrt(Math.pow(x - start.x, 2) + Math.pow(y - start.y, 2)) + 
                              Math.sqrt(Math.pow(x - end.x, 2) + Math.pow(y - end.y, 2)) -
                              Math.sqrt(Math.pow(start.x-end.x, 2) + Math.pow(start.y-end.y, 2));
        return (dist < 0.1);
    }
    
    public boolean isIntoOval(Point start, Point end, int x, int y){
        Point center = new Point((end.x+start.x)/2,(end.y+start.y)/2);
        double X = end.x - center.x;
        double Y = end.y - center.y;
        double r = Math.pow(((x-center.x)/X), 2) + Math.pow(((y-center.y)/Y),2);
        return (r<1);
    }
    
}
