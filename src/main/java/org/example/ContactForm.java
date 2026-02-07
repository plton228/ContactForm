package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JTextField name_field;
    private JTextField email_field;
    private JRadioButton female, male;
    private Checkbox checkbox;

    ContactForm(){
        super("Контактна форма");
        super.setBounds(200, 200, 350, 200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5,2,2,3));

        JLabel name = new JLabel("Enter your name:");
        name_field = new JTextField("", 1);

        JLabel email = new JLabel("Enter your email:");
        email_field = new JTextField("", 1);

        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        male = new JRadioButton("male");
        female = new JRadioButton("female");

        male.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(male);
        container.add(female);

        checkbox = new Checkbox("Accept", false);
        container.add(checkbox);

        JButton btn = new JButton("yes");
        container.add(btn);
        btn.addActionListener(new ButtonEventManager());
    }
    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String email = email_field.getText();

            String isMale = "male";
            if(!male.isSelected())
                isMale = "female";

            boolean isCheck = checkbox.getState();

            JOptionPane.showMessageDialog(null,
                    "name: " + name + "\nEmail: " + email + "\nGender: " + isMale + "\nAccept: " + isCheck,
                    "Дані форми",
                    JOptionPane.PLAIN_MESSAGE);

        }
    }
}
