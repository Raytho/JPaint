package jpaint;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class ViewColorChooserPanel extends JPanel{
    ButtonColorChooser backgroundButton, frontgroundButton;
    public ViewColorChooserPanel() {
        this.setLayout(new GridLayout(1,2,4,4));
        this.setOpaque(false);
        backgroundButton = new ButtonColorChooser(true);
        frontgroundButton = new ButtonColorChooser(false);
        this.add(backgroundButton);
        this.add(frontgroundButton);
    }
    
}
