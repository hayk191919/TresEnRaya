package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.TestModel;
import model.pButtons;
import view.TestView;

public class TestController implements ActionListener {

    private TestView view;
    private TestModel model;
    final ImageIcon iconX = new ImageIcon("images/x.png");
    final ImageIcon iconO = new ImageIcon("images/o.png");

    public TestController(TestModel model, TestView view) {
        this.model = model;
        this.view = view;
        createButtons();
    }

    void createButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                view.pButton[i][j].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {

            pButtons selectButton = (pButtons) e.getSource();

            updateTablero(selectButton, model.getTurno());

            if (model.getTurno() == 0) {
                model.setTurno(1);

            } else {
                model.setTurno(0);
            }

            ganador();

        }

    }

    void updateTablero(pButtons s, int v) {
        if (v == 1) {
            s.setIcon(iconX);
            s.setType(v);
        } else {
            s.setIcon(iconO);
            s.setType(v);
        }
        s.setEnabled(false);
    }

    void restart(pButtons[][] x) {
        check();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                x[i][j].setIcon(null);
                x[i][j].setEnabled(true);
                x[i][j].setType(3);
            }
        }
    }

    void ganador() {
        int contador = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(view.pButton[i][j].getType() + " [" + i + "]" + "[" + j + "]");
//            }
//        }

        for (int i = 0; i < 3; i++) {
            if (view.pButton[0][i].getType() == 1 && view.pButton[1][i].getType() == 1 && view.pButton[2][i].getType() == 1) {
                JOptionPane.showMessageDialog(null, "GANA X");
                restart(view.pButton);
            } else if (view.pButton[0][i].getType() == 0 && view.pButton[1][i].getType() == 0 && view.pButton[2][i].getType() == 0) {
                JOptionPane.showMessageDialog(null, "GANA 0");
                restart(view.pButton);
            } else {
                contador++;
            }

            if (view.pButton[i][0].getType() == 1 && view.pButton[i][1].getType() == 1 && view.pButton[i][2].getType() == 1) {
                JOptionPane.showMessageDialog(null, "GANA X");
                restart(view.pButton);
            } else if (view.pButton[i][0].getType() == 0 && view.pButton[i][1].getType() == 0 && view.pButton[i][2].getType() == 0) {
                JOptionPane.showMessageDialog(null, "GANA 0");
                restart(view.pButton);
            } else {
                contador++;
            }

        }

        if (view.pButton[0][0].getType() == 1 && view.pButton[1][1].getType() == 1 && view.pButton[2][2].getType() == 1) {
            JOptionPane.showMessageDialog(null, "GANA X");
            restart(view.pButton);
        } else if (view.pButton[0][0].getType() == 0 && view.pButton[1][1].getType() == 0 && view.pButton[2][2].getType() == 0) {
            JOptionPane.showMessageDialog(null, "GANA 0");
            restart(view.pButton);
        } else {
            contador++;
        }

        if (view.pButton[0][2].getType() == 1 && view.pButton[1][1].getType() == 1 && view.pButton[2][0].getType() == 1) {
            JOptionPane.showMessageDialog(null, "GANA X");
            restart(view.pButton);
        } else if (view.pButton[0][2].getType() == 0 && view.pButton[1][1].getType() == 0 && view.pButton[2][0].getType() == 0) {
            JOptionPane.showMessageDialog(null, "GANA 0");
            restart(view.pButton);
        } else {
            contador++;
        }

        if (contador == 4) {
            JOptionPane.showMessageDialog(null, "EMPATE");
        }

    }

    void check() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]");
                if (i == 0 && j == 2) {
                    System.out.println("\n");
                    System.out.print("[" + i + "]" + "[" + j + "]");
                }
                
                if (i == 1 && j == 0){
                    System.out.println("\n");
                    System.out.print("[" + i + "]" + "[" + j + "]");
                }
            }
        }
    }

}
