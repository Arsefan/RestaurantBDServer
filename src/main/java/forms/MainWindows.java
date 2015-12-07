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

    // некоторые элементы окна
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

        Container c = getContentPane(); // клиентская область окна
        c.setLayout(new BorderLayout()); // выбираем компоновщик

        // метку наверх
        c.add(new JLabel("my first label :)"), BorderLayout.NORTH);
        // две кнопки в дополнительную панель
        JPanel jp = new JPanel();
        JButton jbt = new JButton("Add User");
        jbt.addActionListener(this); // назначаем обработчик события
        c.add(textAreaLogin, BorderLayout.NORTH);
        c.add(passwordField, BorderLayout.CENTER);
//        jp.add(textAreaLogin);
//        jp.add(passwordField);
        jp.add(jbt);
        jbt = new JButton("Clear field");
        jbt.addActionListener(this); // назначаем обработчик события

        jp.add(jbt);
        // добавляем панель вниз
        c.add(jp, BorderLayout.SOUTH);
        // помещаем текст. поле в область прокрутки
        // а область прокрутки в центр окна,
        // BorderLayout.CENTER значение по умолчанию
//        c.add(new JScrollPane(jta));
        jta.setLineWrap(true); // автоматический перенос строк
        // всплывающая подсказка
        jta.setToolTipText("this is simple text editor");

        setSize(new Dimension(500, 500));
    }
    // обработчик события, метод интерфейса ActionListener
    public void actionPerformed(ActionEvent arg0) {
        if (arg0.getActionCommand().equals("Add User"))
            jta.append(" Add text\\n");

        if (arg0.getActionCommand().equals("Clear field"))
            jta.setText("");

        // если ссылки на объекты сохранены можно сравнивать
        // по объектам, например для JButton jbOK= new JBUtton("Ok");
        // то сравнение будет таким
        //    if(arg0.getSource().equals(jbOK))
    }

    // запуск оконного приложения
}
