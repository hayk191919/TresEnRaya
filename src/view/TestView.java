package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.pButtons;

public class TestView extends JFrame {
    
    public pButtons[][] pButton = new pButtons[3][3];
    
    public TestView() {
        this.setTitle("Tres En Raya!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    void addComponentsToPane(Container pane) {

        JPanel panel = new JPanel(new GridLayout(3, 3));
        pane.add(panel);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pButton[i][j] = new pButtons(3);
                pButton[i][j].setPreferredSize(new Dimension(180,170));
                pButton[i][j].setOpaque(true);
                panel.add(pButton[i][j]);
            }
        }
    }
    
}
