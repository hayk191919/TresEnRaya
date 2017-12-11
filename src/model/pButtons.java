package model;

import javax.swing.JButton;

public class pButtons extends JButton {
    private int type;

    public pButtons(int type) {
        this.type = type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
    
}
