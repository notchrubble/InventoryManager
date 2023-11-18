package main2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import classes.Categories;
import classes.ProductPage;
import classes.Search;

public class main extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Container container = getContentPane();
    private JLabel userLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JLabel invalidLogin = new JLabel("");
    private JPanel sideBar = new JPanel();
    private JButton moveButton = new JButton(">");
    private boolean isSideBarOpen = false;
    private JTextField menuText = new JTextField("Menu");

    main() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        invalidLogin.setBounds(50, 250, 200, 30);
        moveButton.setBounds(0, 0, 50, 50);
        menuText.setBounds(50, 0, 50, 50);
        menuText.setEditable(false); // make menuText uneditable
        sideBar.setBounds(0, 0, 250, 600); // increase width of sideBar
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
        container.add(resetButton);
        container.add(invalidLogin);
        container.add(sideBar);
        container.add(moveButton);
        sideBar.setVisible(false);
        sideBar.setLayout(null);
        sideBar.setBackground(Color.LIGHT_GRAY);
        JButton button1 = new JButton("Product Page");
        JButton button2 = new JButton("Categories Page");
        JButton button3 = new JButton("Search Page");
        button1.setBounds(25, 100, 150, 30);
        button2.setBounds(25, 150, 150, 30);
        button3.setBounds(25, 200, 150, 30);
        sideBar.add(button1);
        sideBar.add(button2);
        sideBar.add(button3);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductPage productPage = new ProductPage();
                productPage.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categories CategoriesPage = new Categories();
                CategoriesPage.setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Search SearchPage = new Search();
                    SearchPage.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
            
        sideBar.setVisible(false);
        moveButton.setVisible(false);
        // Set the z-order of the moveButton to be higher than the sideBar
        container.setComponentZOrder(moveButton, 0);

        // Add KeyListeners to userTextField and passwordField
        userTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }
        });
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSideBarOpen) {
                    sideBar.setVisible(false);
                    moveButton.setText(">");
                    isSideBarOpen = false;
                } else {
                    sideBar.setVisible(true);
                    moveButton.setText("<");
                    isSideBarOpen = true;
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String passwordText = passwordField.getText();
            if (userText.equalsIgnoreCase("username") && passwordText.equalsIgnoreCase("password")) {
                invalidLogin.setText("");
                JOptionPane.showMessageDialog(this, "Login Successful");
                this.dispose(); // close login form
                JFrame mainPage = new JFrame();
                mainPage.setTitle("Main page");
                mainPage.setVisible(true);
                mainPage.setBounds(0, 0, 500, 600);
                mainPage.setLocationRelativeTo(null); // center the main page
                mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainPage.setResizable(true); // set resizable to true
                Container mainContainer = mainPage.getContentPane();
                mainContainer.setLayout(null);
                mainContainer.add(sideBar);
                mainContainer.add(moveButton);
                mainContainer.add(menuText);
                sideBar.setVisible(false);
                moveButton.setVisible(true);
                menuText.setVisible(true); // make menuText visible
                // Set the z-order of the moveButton to be higher than the sideBar
                mainContainer.setComponentZOrder(moveButton, 0);
                
                // Add a title to the main page with a grey background
                JLabel titleLabel = new JLabel("Welcome to the Inventory Manager");
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                titleLabel.setOpaque(true);
                titleLabel.setBackground(Color.GRAY);
                mainContainer.add(titleLabel);

                mainPage.addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        titleLabel.setBounds(0, 0, mainPage.getWidth(), 50);
                        sideBar.setBounds(0, 50, 200, mainPage.getHeight() - 50);
                        menuText.setBounds(50, 0, 50, 50); // set location of menuText
                    }
                });
            } else {
                invalidLogin.setText("Invalid username or password");
            }
        } else if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] a) {
        main frame = new main();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(0, 0, 370, 600);
        frame.setLocationRelativeTo(null); // center the login form
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}