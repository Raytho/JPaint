package jpaint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;


public class ButtonColorChooser extends JButton implements ActionListener{
    private final boolean isBackground;
    private Color color;
    public ButtonColorChooser(boolean isBackground){
        this.isBackground = isBackground;
        if(isBackground)
            this.color = Color.white;
        else
            this.color = Color.black;
        
        this.setBackground(this.color);
        this.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Color initialBackground = this.getBackground();
        Color background;
        if(isBackground)
            background = JColorChooser.showDialog(null, "Change background color",initialBackground);
        else
            background = JColorChooser.showDialog(null, "Change frontground color", initialBackground);
        
        
        if (background != null) {
          this.setColor(background);
        }
    }
    
    public boolean isBackground(){
        return this.isBackground;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color color){
        this.color = color;
        this.setBackground(color);
    }
    
}
