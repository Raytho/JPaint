package jpaint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ListenerToolbar implements ActionListener{
    Application app;
    public ListenerToolbar(Application app) {
        this.app = app;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton)ae.getSource();
        app.getMainFrame().stateBar.setText("Tool " + button.getText().toLowerCase() + " selected.");
        switch (button.getText().toLowerCase()){
            case "select" :
                app.getModelDrawingPanel().setEnumeration(EnumTools.SELECT);
                break;
            case "fill" :
                app.getModelDrawingPanel().setEnumeration(EnumTools.FILL);
                break;
            case "oval" :
                app.getModelDrawingPanel().setEnumeration(EnumTools.OVAL);
                break;
            case "line" :
                app.getModelDrawingPanel().setEnumeration(EnumTools.LINE);
                break;
            case "rectangle" :
                app.getModelDrawingPanel().setEnumeration(EnumTools.RECTANGLE);
                break;
        }
        for(int i=0; i < app.getModelDrawingPanel().shapePoints.size(); i++){
            app.getModelDrawingPanel().shapePoints.get(i).setSelected(false);
        } 
        app.getMainFrame().drawingPanel.ldp.lastSelected = -1;
        app.getMainFrame().drawingPanel.repaint();
    }
    
}
