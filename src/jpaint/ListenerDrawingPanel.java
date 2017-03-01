package jpaint;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ListenerDrawingPanel implements MouseListener, MouseMotionListener{
    Point pointStart = null, pointEnd = null, originalPointStart = null, originalPointEnd = null;
    Application app;
    ViewDrawingPanel vdp;
    int lastSelected = -1;
    
    public ListenerDrawingPanel(Application app, ViewDrawingPanel vdp) {
        this.app = app;
        this.vdp = vdp;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        pointStart = me.getPoint();
        int x = me.getX();
        int y = me.getY();
        for(int i = app.getModelDrawingPanel().shapePoints.size()-1; i >= 0; i--){
            if(null != app.getModelDrawingPanel().shapePoints.get(i).getShapeType())switch (app.getModelDrawingPanel().shapePoints.get(i).getShapeType()) {
                case LINE:{
                    Point start = app.getModelDrawingPanel().shapePoints.get(i).getPointStart();
                    Point end = app.getModelDrawingPanel().shapePoints.get(i).getPointEnd();
                    if(app.getModelDrawingPanel().isIntoLine(start, end, x, y)){
                        if(app.getModelDrawingPanel().getEnumeration() == EnumTools.FILL){
                            app.getModelDrawingPanel().shapePoints.get(i).setColor(app.getMainFrame().toolBar.viewColorChooserPanel.frontgroundButton.getColor());
                            vdp.repaint();
                            i = -1;
                        }else if(app.getModelDrawingPanel().getEnumeration() == EnumTools.SELECT){
                            app.getModelDrawingPanel().shapePoints.get(i).setSelected(true);
                            if((lastSelected!=-1) && (lastSelected!=i)) app.getModelDrawingPanel().shapePoints.get(lastSelected).setSelected(false);
                            vdp.repaint();
                            lastSelected = i;
                            i = -1;
                        }
                    }       
                    break;
                }
                case RECTANGLE:{
                    Point start = app.getModelDrawingPanel().shapePoints.get(i).getPointStart();
                    Point end = app.getModelDrawingPanel().shapePoints.get(i).getPointEnd();
                    if(x > start.x && x < end.x && y > start.y && y < end.y){
                        if(app.getModelDrawingPanel().getEnumeration() == EnumTools.FILL){
                            app.getModelDrawingPanel().shapePoints.get(i).setColor(app.getMainFrame().toolBar.viewColorChooserPanel.frontgroundButton.getColor());
                            vdp.repaint();
                            i = -1;
                        }else if(app.getModelDrawingPanel().getEnumeration() == EnumTools.SELECT){
                            app.getModelDrawingPanel().shapePoints.get(i).setSelected(true);
                            if((lastSelected != -1) && (lastSelected!=i)) app.getModelDrawingPanel().shapePoints.get(lastSelected).setSelected(false);
                            vdp.repaint();
                            lastSelected = i;
                            i = -1;
                        }
                    } 
                    break;
                }
                case OVAL:{
                    Point start = app.getModelDrawingPanel().shapePoints.get(i).getPointStart();
                    Point end = app.getModelDrawingPanel().shapePoints.get(i).getPointEnd();
                    if(app.getModelDrawingPanel().isIntoOval(start, end, x, y)){
                        if(app.getModelDrawingPanel().getEnumeration() == EnumTools.FILL){
                            app.getModelDrawingPanel().shapePoints.get(i).setColor(app.getMainFrame().toolBar.viewColorChooserPanel.frontgroundButton.getColor());
                            vdp.repaint();
                            i = -1;
                        }else if(app.getModelDrawingPanel().getEnumeration() == EnumTools.SELECT){
                            app.getModelDrawingPanel().shapePoints.get(i).setSelected(true);
                            if((lastSelected!=-1) && (lastSelected!=i)) app.getModelDrawingPanel().shapePoints.get(lastSelected).setSelected(false);
                            vdp.repaint();
                            lastSelected = i;
                            i = -1;
                        }
                    }    
                    break;
                }
                default:
                    break;
            }
        }
        if((app.getModelDrawingPanel().getEnumeration() == EnumTools.SELECT) && (lastSelected!=-1)){
            originalPointStart = app.getModelDrawingPanel().shapePoints.get(lastSelected).getPointStart();
            originalPointEnd = app.getModelDrawingPanel().shapePoints.get(lastSelected).getPointEnd();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(app.getModelDrawingPanel().getEnumeration() != EnumTools.LINE){
            if(pointEnd.x>pointStart.x && pointEnd.y<pointStart.y){
                int temp = pointStart.y;
                pointStart.y = pointEnd.y;
                pointEnd.y = temp;
            }else if(pointEnd.x<pointStart.x && pointEnd.y<pointStart.y){
                Point temp = pointStart;
                pointStart = pointEnd;
                pointEnd = temp;
            }else if(pointEnd.x<pointStart.x && pointEnd.y>pointStart.y){
                int temp = pointStart.x;
                pointStart.x = pointEnd.x;
                pointEnd.x = temp;
            }
        }
        if(app.getModelDrawingPanel().getEnumeration() == EnumTools.LINE){
            Color frontColor = app.getMainFrame().toolBar.viewColorChooserPanel.frontgroundButton.getColor();
            ModelShape newLine = new ModelShape(pointStart, pointEnd, frontColor ,Color.BLACK, EnumShapes.LINE);
            app.getModelDrawingPanel().shapePoints.add(newLine);
        }else if (app.getModelDrawingPanel().getEnumeration() == EnumTools.RECTANGLE){
            Color frontColor = app.getMainFrame().toolBar.viewColorChooserPanel.frontgroundButton.getColor();
            Color bgColor = app.getMainFrame().toolBar.viewColorChooserPanel.backgroundButton.getColor();
            ModelShape newRectangle = new ModelShape(pointStart, pointEnd, frontColor, bgColor, EnumShapes.RECTANGLE);
            app.getModelDrawingPanel().shapePoints.add(newRectangle);   
        }else if(app.getModelDrawingPanel().getEnumeration() == EnumTools.OVAL){
            Color frontColor = app.getMainFrame().toolBar.viewColorChooserPanel.frontgroundButton.getColor();
            Color bgColor = app.getMainFrame().toolBar.viewColorChooserPanel.backgroundButton.getColor();
            ModelShape newOval = new ModelShape(pointStart, pointEnd, frontColor, bgColor, EnumShapes.OVAL);
            app.getModelDrawingPanel().shapePoints.add(newOval);
        }
        pointStart = null;
        vdp.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if((app.getModelDrawingPanel().getEnumeration() == EnumTools.LINE) ||
           (app.getModelDrawingPanel().getEnumeration() == EnumTools.RECTANGLE) ||
           (app.getModelDrawingPanel().getEnumeration() == EnumTools.OVAL)){
            pointEnd = me.getPoint();
        }else if((app.getModelDrawingPanel().getEnumeration() == EnumTools.SELECT) && (lastSelected != -1)){
            pointEnd = me.getPoint();
            int moveX = pointEnd.x - pointStart.x;
            int moveY = pointEnd.y - pointStart.y;
            app.getModelDrawingPanel().shapePoints.get(lastSelected).setPointStart(new Point(originalPointStart.x+moveX, originalPointStart.y+moveY));
            app.getModelDrawingPanel().shapePoints.get(lastSelected).setPointEnd(new Point(originalPointEnd.x+moveX, originalPointEnd.y+moveY));
            vdp.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        pointEnd = me.getPoint();
    }
    
}
