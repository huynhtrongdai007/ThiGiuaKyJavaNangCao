package view;

import javax.swing.*;
import java.awt.event.*;

public class NewEmployee {
    private JPanel rootPanel;
    private JTextField fullNameTextField;
    private JRadioButton namRadioButton;
    private JRadioButton nuRadioButton;
    private boolean genderer;


    public NewEmployee() {

        namRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               genderer = true;
            }
        });

        nuRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               genderer = false;
            }
        });
    }

    public JPanel getRootPanel(){return rootPanel;}
    public String getFullNam(){return  fullNameTextField.getText();}
    public boolean getGender(){return genderer;}
  //public boolean getGender(){return namRadioButton.isSelected();}

}
