package jpaint;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class ViewStateBar extends JPanel{
    private JTextArea textZone;
    public ViewStateBar(){
        textZone = new JTextArea("No tool selected");
        this.setLayout(new BorderLayout());
        this.add(textZone, BorderLayout.WEST);
        textZone.setFocusable(false);
        this.setBorder(BorderFactory.createLoweredBevelBorder());
    }
    public void setText(String s){
        textZone.setText(s);
    }
}
