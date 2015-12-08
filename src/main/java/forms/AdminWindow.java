package forms;

import javax.swing.*;

/**
 * Created by Arsefan on 07.12.2015.
 */
public class AdminWindow extends JFrame{
    private JPanel rootPanel;
    private JTabbedPane tabbedPane1;
    private JTable userTable;
    private JTable goodTable;
    private JTable priceTable;
    private JTextField textLogin;
    private JPasswordField passwordField;
    private JButton clearButton;
    private JButton addButton;
    private JTextField textGoodName;
    private JTextField textGoodPrice;
    private JTextField textGoodDesc;
    private JButton clearButton1;
    private JButton addButton1;
    private JSpinner spinner1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JButton button1;
    private JButton button2;

    public AdminWindow(){
        setContentPane(rootPanel);
    }
}
