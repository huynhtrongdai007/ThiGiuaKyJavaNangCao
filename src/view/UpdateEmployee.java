package view;

import javax.swing.*;

public class UpdateEmployee {
    private JPanel rootPanel;
    private JTextField fullNameTextField;
    private JRadioButton namRadioButton;
    private JRadioButton nuRadioButton;
    private JTextField textID;
    private boolean genderer;

    public JPanel getRootPanel(){return rootPanel;}
    public String getID(){return textID.getText();}
    public void SetID(String ID){textID.setText(ID);}
    public String getFullNam(){return  fullNameTextField.getText();}
    public void setFullname(String fullname) {
        fullNameTextField.setText(fullname);
    }
    public String getGender(){return namRadioButton.getText();}
    public void setGenderer(String genderer){namRadioButton.isSelected();}

}
