package view;


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class BoardPanel extends JPanel {
    
    // declaaration
    
    private JFrame       parentFrame;
    private SpringLayout layout;
    private JPanel       gridPane;
    private double       boardSize;
    
     public BoardPanel(JFrame parentFrame) {
        super();
        layout = new SpringLayout();
        gridPane = new JPanel(new GridLayout(6, 6, 3, 3));
       
    }   
    
}