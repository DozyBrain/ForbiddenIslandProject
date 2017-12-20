package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import util.Utils.Pion;

 
public class ViewAdventurer {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton moveBtn  ;
    private final JButton dryBtn;
    private final JButton otherActionBtn;
    private final JButton endTurnBtn;
    private JTextField position;
 
    public ViewAdventurer(String playerName, String adventurerName, Color color){

        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setTitle(playerName);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(color, 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(color);
        panelAventurier.add(new JLabel(adventurerName,SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, color));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.moveBtn = new JButton("Bouger") ;
        this.dryBtn = new JButton( "Assecher");
        this.otherActionBtn = new JButton("AutreAction") ;
        this.endTurnBtn = new JButton("Terminer Tour") ;
        
        this.panelBoutons.add(moveBtn);
        this.panelBoutons.add(dryBtn);
        this.panelBoutons.add(otherActionBtn);
        this.panelBoutons.add(endTurnBtn);

        this.window.setVisible(true);
    } 
    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
     public JButton getOthersActionBtn() {
        return otherActionBtn;
    }
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getMoveBtn() {
        return moveBtn;
    }
    
    public JButton getDryBtn() {
        return dryBtn;
    }

    public JButton getEndTurnBtn() {
        return endTurnBtn;
    }
 
     public static void main(String [] args) {
        // Instanciation de la fenêtre 
        ViewAdventurer viewAdventurer = new ViewAdventurer("Manon", "Explorateur",Pion.ROUGE.getCouleur() );
    }
}