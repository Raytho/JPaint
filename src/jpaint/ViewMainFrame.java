package jpaint;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewMainFrame extends JFrame{
    Application app;
    ViewStateBar stateBar;
    ViewToolBar toolBar;
    ViewDrawingPanel drawingPanel;
    public ViewMainFrame(Application app) {
        super("JPaint");
        this.app = app;
        this.setPreferredSize(new Dimension(800,600));
        this.setLayout(new BorderLayout());
        
        stateBar = new ViewStateBar();
        toolBar = new ViewToolBar(app);
        drawingPanel = new ViewDrawingPanel(app);
        this.add(stateBar, BorderLayout.SOUTH);
        this.add(toolBar,  BorderLayout.WEST);
        this.add(drawingPanel, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
}
