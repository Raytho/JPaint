package jpaint;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;


public class ViewToolBar extends JToolBar{
    JButton selectButton, fillButton, ovalButton, lineButton, rectangleButton;
    Application app;
    public ViewToolBar(Application app) {
        super("Toolbar");
        this.app = app;
        this.setLayout(new GridLayout(6,1,4,4));
        this.setPreferredSize(new Dimension(120,100));
        selectButton = new JButton("Select");
        fillButton = new JButton("Fill");
        ovalButton = new JButton("Oval");
        lineButton = new JButton("Line");
        rectangleButton = new JButton("Rectangle");
        
        ListenerToolbar lt = new ListenerToolbar(app);
        selectButton.addActionListener(lt);
        fillButton.addActionListener(lt);
        ovalButton.addActionListener(lt);
        lineButton.addActionListener(lt);
        rectangleButton.addActionListener(lt);
        
        this.add(selectButton);
        this.add(fillButton);
        this.add(ovalButton);
        this.add(lineButton);
        this.add(rectangleButton);
        this.add(new ViewColorChooserPanel());
    }
}
