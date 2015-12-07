package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Arsefan on 06.12.2015.
 */
public class MainWindows extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    // ��������� �������� ����
    private JTextArea jta = new JTextArea(
            "Scroll bar will appear, when much text");
    private JTextArea textAreaLogin = new JTextArea("Use login");
    private JPasswordField passwordField = new JPasswordField("User password");

    public MainWindows() {
//        Container container = getContentPane();
//        container.setLayout(new BorderLayout());
//        container.add(new Label("Administrator"));
//        JTextArea textAreaLogin = new JTextArea("login");
//        container.add(textAreaLogin);
//
//        JTextArea textArea1Pass = new JTextArea("Pass");
//        container.add(textArea1Pass);
//
//        JButton buttonOK = new JButton("add user");
//        setPreferredSize(new Dimension(200, 200));

        Container c = getContentPane(); // ���������� ������� ����
        c.setLayout(new BorderLayout()); // �������� �����������

        // ����� ������
        c.add(new JLabel("my first label :)"), BorderLayout.NORTH);
        // ��� ������ � �������������� ������
        JPanel jp = new JPanel();
        JButton jbt = new JButton("Add User");
        jbt.addActionListener(this); // ��������� ���������� �������
        c.add(textAreaLogin, BorderLayout.NORTH);
        c.add(passwordField, BorderLayout.CENTER);
//        jp.add(textAreaLogin);
//        jp.add(passwordField);
        jp.add(jbt);
        jbt = new JButton("Clear field");
        jbt.addActionListener(this); // ��������� ���������� �������

        jp.add(jbt);
        // ��������� ������ ����
        c.add(jp, BorderLayout.SOUTH);
        // �������� �����. ���� � ������� ���������
        // � ������� ��������� � ����� ����,
        // BorderLayout.CENTER �������� �� ���������
//        c.add(new JScrollPane(jta));
        jta.setLineWrap(true); // �������������� ������� �����
        // ����������� ���������
        jta.setToolTipText("this is simple text editor");

        setSize(new Dimension(500, 500));
    }
    // ���������� �������, ����� ���������� ActionListener
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals("Add User"))
            jta.append(" Add text\\n");

        if (arg0.getActionCommand().equals("Clear field"))
            jta.setText("");

        // ���� ������ �� ������� ��������� ����� ����������
        // �� ��������, �������� ��� JButton jbOK= new JBUtton("Ok");
        // �� ��������� ����� �����
        //    if(arg0.getSource().equals(jbOK))
    }

    // ������ �������� ����������
}
