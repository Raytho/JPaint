package jpaint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;


public class ViewToolbar extends JToolBar{
    JButton selectButton, fillButton, ovalButton, lineButton, rectangleButton;
    
    public ViewToolbar() {
        super("Toolbar");
        this.setLayout(new GridLayout(6,1,4,4));
        this.setPreferredSize(new Dimension(120,100));
        selectButton = new JButton("Select");
        fillButton = new JButton("Fill");
        ovalButton = new JButton("Oval");
        lineButton = new JButton("Line");
        rectangleButton = new JButton("Rectangle");
        
        this.add(selectButton);
        this.add(fillButton);
        this.add(ovalButton);
        this.add(lineButton);
        this.add(rectangleButton);
        this.add(new ViewColorChooserPanel());
        
    }
}
