package jpaint;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ViewDrawingPanel extends JPanel{
    Application app;
    ListenerDrawingPanel ldp;
    public ViewDrawingPanel(Application app) {
        super();
        this.app = app;
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        ldp = new ListenerDrawingPanel(app, this);
        this.addMouseListener(ldp);
        this.addMouseMotionListener(ldp);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*if(app.modelDrawingPanel.getEnumeration() == EnumTools.LINE){
            if (ldp.pointStart != null) {
                redraw(g);
                g.setColor(app.mainFrame.toolBar.viewColorChooserPanel.frontgroundButton.getColor());
                g.drawLine(ldp.pointStart.x, ldp.pointStart.y, ldp.pointEnd.x, ldp.pointEnd.y);
            }
        }else if(app.modelDrawingPanel.getEnumeration() == EnumTools.RECTANGLE){
            if (ldp.pointStart != null) {
                redraw(g);
                g.setColor(app.mainFrame.toolBar.viewColorChooserPanel.frontgroundButton.getColor());
                g.fillRect(ldp.pointStart.x, ldp.pointStart.y,ldp.pointEnd.x-ldp.pointStart.x, ldp.pointEnd.y-ldp.pointStart.y);
            }
        }*/
        redraw(g);
    }
    
    public void redraw(Graphics g){
        int startX, endX, startY, endY;
        int selectedOne = -1;
        for(int i=0; i<app.getModelDrawingPanel().shapePoints.size(); i++){
            startX = app.getModelDrawingPanel().shapePoints.get(i).getPointStart().x;
            startY = app.getModelDrawingPanel().shapePoints.get(i).getPointStart().y;
            endX = app.getModelDrawingPanel().shapePoints.get(i).getPointEnd().x;
            endY = app.getModelDrawingPanel().shapePoints.get(i).getPointEnd().y;
            switch (app.getModelDrawingPanel().shapePoints.get(i).getShapeType()) {
                case LINE:
                    if(app.getModelDrawingPanel().shapePoints.get(i).isSelected()){
                        selectedOne = i;
                    }else{
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(i).getColor());
                        g.drawLine(startX, startY, endX, endY);
                    }
                    break;
                case RECTANGLE:
                    if(app.getModelDrawingPanel().shapePoints.get(i).isSelected()){
                        selectedOne = i;
                    }else{
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(i).getBgColor());
                        g.fillRect(startX, startY, endX-startX, endY-startY);
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(i).getColor());
                        g.fillRect(startX+2, startY+2, endX-startX-4, endY-startY-4);
                    }
                    break;
                case OVAL:
                    if(app.getModelDrawingPanel().shapePoints.get(i).isSelected()){
                        selectedOne = i;
                    }else{
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(i).getBgColor());
                        g.fillOval(startX, startY, endX-startX, endY-startY);
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(i).getColor());
                        g.fillOval(startX+2, startY+2, endX-startX-4, endY-startY-4);
                    }
                    break;
                default:
                    break;
            }
            if(selectedOne != -1){
                startX = app.getModelDrawingPanel().shapePoints.get(selectedOne).getPointStart().x;
                startY = app.getModelDrawingPanel().shapePoints.get(selectedOne).getPointStart().y;
                endX = app.getModelDrawingPanel().shapePoints.get(selectedOne).getPointEnd().x;
                endY = app.getModelDrawingPanel().shapePoints.get(selectedOne).getPointEnd().y;
                switch (app.getModelDrawingPanel().shapePoints.get(selectedOne).getShapeType()) {
                    case LINE:
                        g.setColor(Color.black);
                        g.drawLine(startX, startY+1, endX, endY+1);
                        g.drawLine(startX, startY-1, endX, endY-1);
                        g.drawLine(startX+1, startY, endX+1, endY);
                        g.drawLine(startX-1, startY-1, endX-1, endY-1);
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(selectedOne).getColor());
                        g.drawLine(startX, startY, endX, endY);
                        break;
                    case RECTANGLE:   
                        g.setColor(Color.black);
                        g.fillRect(startX-4, startY-4, endX-startX+8, endY-startY+8);
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(selectedOne).getBgColor());
                        g.fillRect(startX, startY, endX-startX, endY-startY);
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(selectedOne).getColor());
                        g.fillRect(startX+2, startY+2, endX-startX-4, endY-startY-4);
                        break;
                    case OVAL:
                        g.setColor(Color.black);
                        g.fillOval(startX-4, startY-4, endX-startX+8, endY-startY+8);
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(selectedOne).getBgColor());
                        g.fillOval(startX, startY, endX-startX, endY-startY);
                        g.setColor(app.getModelDrawingPanel().shapePoints.get(selectedOne).getColor());
                        g.fillOval(startX+2, startY+2, endX-startX-4, endY-startY-4);
                        break;
                }
            }
        }
    }
}
