package jpaint;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewMainFrame extends JFrame{
    Application app;
    public ViewMainFrame(Application app) {
        super("JPaint");
        this.app = app;
        this.setPreferredSize(new Dimension(800,600));
        this.setLayout(new BorderLayout());
        
        this.add(new ViewStateBar(), BorderLayout.SOUTH);
        this.add(new ViewToolbar(), BorderLayout.WEST);
        this.add(new JPanel(), BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
}
