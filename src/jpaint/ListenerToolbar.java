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
        app.mainFrame.stateBar.setText("Tool " + button.getText().toLowerCase() + " selected.");
    }
    
}
