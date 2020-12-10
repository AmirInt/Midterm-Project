import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

/**
 * Class UI is responsible for creating the graphical user interface
 * by creating the JFrame and the different panels for the students,
 * the teachers and the admin.
 */
public class UI {

    JFrame frame;

//    loginPanel accessories
    JPanel loginPanel;
    JComboBox<String> comboBox;
    JPanel loginBoard;
    JPanel creditsBoard;
    JLabel informLabel, uNameLabel, passLabel, errorLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton enterButton;

    //    studentPanel accessories
    JPanel studentPanel;
    JPanel studentMainPanel;
    JLabel studentMainB;
    JLabel changeUNAndPW;
    JLabel purchaseBalance;
    JLabel reserve;
    JLabel selectCredits;
    JLabel studentPanelExit;
    JPanel UNPSPanel;
    JPanel balancePanel;
    JPanel reservationPanel;
    JPanel creditSelectionPanel;

    //    teacherPanel accessories
    JPanel teacherPanel;
    JPanel teacherMainPanel;
    JPanel teacherUNPSPanel;
    JPanel teacherAddToCoursesPanel;
    JButton teacherMainB;
    JButton teacherChangeUNAndPW;
    JButton teacherPanelExit;
    JButton teacherAddToCoursesB;

    //    adminPanel accessories
    JPanel adminPanel;
    JPanel adminMainPanel;
    JPanel adminUNPSPanel;
    JPanel adminRefectoryPanel;
    JPanel adminSTPanel;
    JButton adminMainB;
    JButton adminChangeUNAndPW;
    JButton adminRefectoryB;
    JButton adminSTB;
    JButton adminPanelExit;

//    constraints variable is for managing the items of the GridBagLayout
//    wherever its needed
    GridBagConstraints constraints = new GridBagConstraints();

    /**
     * Instantiates this class
     */
    public UI() {

//        Setting the frame
        frame = new JFrame("University Management System");
        frame.setSize(740, 560);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(setTeacherPanel());
        frame.setVisible(true);
    }

    /**
     * Creates the login panel as the starting page
     * @return the login panel it has built for further processes
     */
    public JPanel setLoginPanel() {

        EventHandler eventHandler = new EventHandler();

        JLabel entranceMode = new JLabel("Enter as");
        entranceMode.setForeground(new Color(225, 225, 225));
        entranceMode.setFont(new Font("", Font.PLAIN, 15));
        entranceMode.setPreferredSize(new Dimension(90, 40));
        String[] comboItems = {"Admin", "Teacher", "Student"};
        comboBox = new JComboBox<>(comboItems);
        comboBox.setPreferredSize(new Dimension(120, 30));
        comboBox.setFont(new Font("", Font.PLAIN, 15));
        JPanel introPanel = new JPanel(new GridBagLayout());
        introPanel.add(entranceMode);
        introPanel.add(comboBox);
        introPanel.setBackground(new Color(30, 50, 150));

        creditsBoard = new JPanel();
        creditsBoard.setLayout(new GridLayout(2, 1, 5,5));
        usernameField = new JTextField("Username");
        usernameField.addActionListener(eventHandler);
        usernameField.setPreferredSize(new Dimension(80, 25));
        passwordField = new JPasswordField("Password");
        passwordField.addActionListener(eventHandler);
        passwordField.setPreferredSize(new Dimension(80, 25));
        creditsBoard.add(usernameField);
        creditsBoard.add(passwordField);
        creditsBoard.setOpaque(false);
        informLabel = new JLabel("Enter ye' username and password");
        informLabel.setPreferredSize(new Dimension(350, 50));
        informLabel.setForeground(Color.WHITE);
        informLabel.setFont(new Font("", Font.PLAIN, 20));
        informLabel.setHorizontalAlignment(0);
        errorLabel = new JLabel("");
        enterButton = new JButton("Enter");
        enterButton.setPreferredSize(new Dimension(200, 40));
        enterButton.setForeground(new Color(0, 0, 100));
        enterButton.setFont(new Font("", Font.PLAIN, 20));
        enterButton.addActionListener(eventHandler);
        enterButton.setOpaque(false);
        loginBoard = new JPanel(new BorderLayout(5, 5));
        loginBoard.add(informLabel, BorderLayout.NORTH);
        loginBoard.add(creditsBoard, BorderLayout.CENTER);
        loginBoard.add(errorLabel, BorderLayout.SOUTH);
        loginBoard.setOpaque(false);

        loginPanel = new JPanel(new BorderLayout());
        loginPanel.add(introPanel, BorderLayout.NORTH);
        JPanel secondaryPanel = new ImageJPanel("F:\\loading-bg-breeze-rpeast-morespace.jpeg");
        secondaryPanel.setLayout(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        secondaryPanel.add(loginBoard, constraints);
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        secondaryPanel.add(enterButton, constraints);
        constraints.gridy = 0;
        loginPanel.add(secondaryPanel, BorderLayout.CENTER);
        return loginPanel;
    }

    /**
     * Creates the student panel and its different sections
     * @return the panel it has built for further processes
     */
    public JPanel setStudentPanel() {

        Color colour = new Color(30, 90, 20);
//        Creating the general studentPanel here with its buttons and fields
        studentPanel = new ImageJPanel("C:\\Users\\l0000\\Downloads\\istockphoto-610850338-1024x1024 2.jpg");
        studentPanel.setLayout(new BorderLayout(30, 30));
        studentMainB = new JLabel("Main Panel");
        studentMainB.setPreferredSize(new Dimension(80, 40));
        studentMainB.setHorizontalAlignment(0);
        studentMainB.setFont(new Font("", Font.PLAIN, 10));
        studentMainB.setForeground(Color.WHITE);
        changeUNAndPW = new JLabel("Change username or password");
        changeUNAndPW.setPreferredSize(new Dimension(160, 40));
        changeUNAndPW.setHorizontalAlignment(0);
        changeUNAndPW.setFont(new Font("", Font.PLAIN, 10));
        changeUNAndPW.setForeground(Color.WHITE);
        purchaseBalance = new JLabel("Purchase balance");
        purchaseBalance.setPreferredSize(new Dimension(100, 40));
        purchaseBalance.setHorizontalAlignment(0);
        purchaseBalance.setFont(new Font("", Font.PLAIN, 10));
        purchaseBalance.setForeground(Color.WHITE);
        reserve = new JLabel("Reserve food");
        reserve.setPreferredSize(new Dimension(80, 40));
        reserve.setHorizontalAlignment(0);
        reserve.setFont(new Font("", Font.PLAIN, 10));
        reserve.setForeground(Color.WHITE);
        selectCredits = new JLabel("Select new credits");
        selectCredits.setPreferredSize(new Dimension(1000, 40));
        selectCredits.setHorizontalAlignment(0);
        selectCredits.setFont(new Font("", Font.PLAIN, 10));
        selectCredits.setForeground(Color.WHITE);
        studentPanelExit = new JLabel("Exit");
        studentPanelExit.setPreferredSize(new Dimension(60, 40));
        studentPanelExit.setHorizontalAlignment(0);
        studentPanelExit.setFont(new Font("", Font.PLAIN, 10));
        studentPanelExit.setForeground(Color.WHITE);
        JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 15));
        upperPanel.setBackground(colour);
        upperPanel.add(studentPanelExit);
        upperPanel.add(studentMainB);
        upperPanel.add(changeUNAndPW);
        upperPanel.add(purchaseBalance);
        upperPanel.add(reserve);
        upperPanel.add(selectCredits);
        studentPanel.add(upperPanel, BorderLayout.NORTH);

//        Creating the main panel here
        studentMainPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        studentMainPanel.setOpaque(false);
        JPanel studentMainPanelSecondary = new JPanel(new GridBagLayout());
        studentMainPanelSecondary.setOpaque(false);
        studentMainPanelSecondary.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colour, 3),
                "Credentials", 4, 0, new Font("", Font.PLAIN, 15)));
        JLabel userName = new JLabel("Username: ");
        userName.setPreferredSize(new Dimension(180, 50));
        userName.setFont(new Font("", Font.PLAIN, 20));
        JLabel password = new JLabel("Password: ");
        password.setPreferredSize(new Dimension(180, 50));
        password.setFont(new Font("", Font.PLAIN, 20));
        JLabel average = new JLabel("Average: ");
        average.setPreferredSize(new Dimension(180, 50));
        average.setFont(new Font("", Font.PLAIN, 20));
        JLabel balance = new JLabel("Balance: ");
        balance.setPreferredSize(new Dimension(180, 50));
        balance.setFont(new Font("", Font.PLAIN, 20));
        studentMainPanelSecondary.add(userName, constraints);
        constraints.gridx = 1;
        studentMainPanelSecondary.add(new JLabel("Username"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        studentMainPanelSecondary.add(password, constraints);
        constraints.gridx = 1;
        studentMainPanelSecondary.add(new JLabel("Password"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        studentMainPanelSecondary.add(average, constraints);
        constraints.gridx = 1;
        studentMainPanelSecondary.add(new JLabel("Average"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        studentMainPanelSecondary.add(balance, constraints);
        constraints.gridx = 1;
        studentMainPanelSecondary.add(new JLabel("Balance"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 0;
        JList<Object> currentCredits = new JList<>();
        currentCredits.setOpaque(false);
        currentCredits.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colour, 3),
                "Current Credits", 4, 0, new Font("", Font.PLAIN, 15)));
        studentMainPanel.add(studentMainPanelSecondary);
        studentMainPanel.add(currentCredits);

//        Creating the panel in charge of resetting password and username
        UNPSPanel = new JPanel(new GridBagLayout());
        UNPSPanel.setOpaque(false);
        JPanel secondary = new JPanel(new GridLayout(4, 2, 5, 5));
        secondary.setOpaque(false);
        JLabel newUsername = new JLabel("New username");
        newUsername.setPreferredSize(new Dimension(180, 50));
        newUsername.setFont(new Font("", Font.PLAIN, 20));
        JLabel newPassword = new JLabel("New Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        newPassword.setFont(new Font("", Font.PLAIN, 20));
        JTextField newUsernameField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        JLabel notice = new JLabel("");
        JButton changeButton = new JButton("Change");
        changeButton.setFont(new Font("", Font.PLAIN, 20));
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        secondary.add(notice, constraints);
        constraints.gridy = 3;
        secondary.add(changeButton, constraints);
        constraints.gridx = 0;
        constraints.gridwidth = 0;
        constraints.gridwidth = 1;
        UNPSPanel.add(secondary, constraints);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 0;
        constraints.gridheight = 0;

//        Creating the panel for managing balance
        balancePanel = new JPanel(new GridBagLayout());
        balancePanel.setOpaque(false);
        JPanel balancePanelSecondary = new JPanel(new GridLayout(5, 1));
        balancePanelSecondary.setOpaque(false);
        JLabel cardNumberL = new JLabel("Card number: ");
        cardNumberL.setPreferredSize(new Dimension(180, 50));
        cardNumberL.setFont(new Font("", Font.PLAIN, 20));
        JTextField cardNumberT = new JTextField();
        JLabel balanceL = new JLabel("Balance: ");
        balanceL.setPreferredSize(new Dimension(180, 50));
        balanceL.setFont(new Font("", Font.PLAIN, 20));
        JTextField balanceT = new JTextField();
        JLabel passwordL = new JLabel("Password: ");
        passwordL.setPreferredSize(new Dimension(180, 50));
        passwordL.setFont(new Font("", Font.PLAIN, 20));
        JPasswordField passwordF = new JPasswordField();
        JLabel noticeBalance = new JLabel("");
        JButton purchaseBalanceB = new JButton("Purchase");
        purchaseBalanceB.setFont(new Font("", Font.PLAIN, 20));
        balancePanelSecondary.add(cardNumberL);
        balancePanelSecondary.add(cardNumberT);
        balancePanelSecondary.add(balanceL);
        balancePanelSecondary.add(balanceT);
        balancePanelSecondary.add(passwordL);
        balancePanelSecondary.add(passwordF);
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        balancePanelSecondary.add(purchaseBalanceB);
        constraints.gridy = 4;
        balancePanelSecondary.add(noticeBalance);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        balancePanel.add(balancePanelSecondary, constraints);

//        Creating the panel for reserving refectory food
        reservationPanel = new JPanel(new GridLayout(9, 5, 20, 20));
        reservationPanel.setOpaque(false);
        JLabel Mon = new JLabel("Mon", SwingConstants.CENTER);
        Mon.setFont(new Font("", Font.PLAIN, 20));
        JLabel Tue = new JLabel("Tue", SwingConstants.CENTER);
        Tue.setFont(new Font("", Font.PLAIN, 20));
        JLabel Wed = new JLabel("Wed", SwingConstants.CENTER);
        Wed.setFont(new Font("", Font.PLAIN, 20));
        JLabel Thu = new JLabel("Thu", SwingConstants.CENTER);
        Thu.setFont(new Font("", Font.PLAIN, 20));
        JLabel Fri = new JLabel("Fri", SwingConstants.CENTER);
        Fri.setFont(new Font("", Font.PLAIN, 20));
        JLabel Sat = new JLabel("Sat", SwingConstants.CENTER);
        Sat.setFont(new Font("", Font.PLAIN, 20));
        JLabel Sun = new JLabel("Sun", SwingConstants.CENTER);
        Sun.setFont(new Font("", Font.PLAIN, 20));
        JLabel dinner = new JLabel("Dinner");
        dinner.setFont(new Font("", Font.PLAIN, 20));
        JLabel lunch = new JLabel("Lunch");
        lunch.setFont(new Font("", Font.PLAIN, 20));
        JLabel MonLunch = new JLabel();
        JLabel TueLunch = new JLabel();
        JLabel WedLunch = new JLabel();
        JLabel ThuLunch = new JLabel();
        JLabel FriLunch = new JLabel();
        JLabel SatLunch = new JLabel();
        JLabel SunLunch = new JLabel();
        JLabel MonDinner = new JLabel();
        JLabel TueDinner = new JLabel();
        JLabel WedDinner = new JLabel();
        JLabel ThuDinner = new JLabel();
        JLabel FriDinner = new JLabel();
        JLabel SatDinner = new JLabel();
        JLabel SunDinner = new JLabel();
        JCheckBox MonLunchCh = new JCheckBox();
        MonLunchCh.setOpaque(false);
        JCheckBox TueLunchCh = new JCheckBox();
        TueLunchCh.setOpaque(false);
        JCheckBox WedLunchCh = new JCheckBox();
        WedLunchCh.setOpaque(false);
        JCheckBox ThuLunchCh = new JCheckBox();
        ThuLunchCh.setOpaque(false);
        JCheckBox FriLunchCh = new JCheckBox();
        FriLunchCh.setOpaque(false);
        JCheckBox SatLunchCh = new JCheckBox();
        SatLunchCh.setOpaque(false);
        JCheckBox SunLunchCh = new JCheckBox();
        SunLunchCh.setOpaque(false);
        JCheckBox MonDinnerCh = new JCheckBox();
        MonDinnerCh.setOpaque(false);
        JCheckBox TueDinnerCh = new JCheckBox();
        TueDinnerCh.setOpaque(false);
        JCheckBox WedDinnerCh = new JCheckBox();
        WedDinnerCh.setOpaque(false);
        JCheckBox ThuDinnerCh = new JCheckBox();
        ThuDinnerCh.setOpaque(false);
        JCheckBox FriDinnerCh = new JCheckBox();
        FriDinnerCh.setOpaque(false);
        JCheckBox SatDinnerCh = new JCheckBox();
        SatDinnerCh.setOpaque(false);
        JCheckBox SunDinnerCh = new JCheckBox();
        SunDinnerCh.setOpaque(false);
        JLabel balanceLabel = new JLabel("Balance", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("", Font.PLAIN, 20));
        JButton reserveButton = new JButton("Reserve");
        reserveButton.setFont(new Font("", Font.PLAIN, 20));
        reservationPanel.add(new JLabel(""));
        reservationPanel.add(lunch);
        reservationPanel.add(new JLabel(""));
        reservationPanel.add(dinner);
        reservationPanel.add(new JLabel(""));
        reservationPanel.add(Mon);
        reservationPanel.add(MonLunch);
        reservationPanel.add(MonLunchCh);
        reservationPanel.add(MonDinner);
        reservationPanel.add(MonDinnerCh);
        reservationPanel.add(Tue);
        reservationPanel.add(TueLunch);
        reservationPanel.add(TueLunchCh);
        reservationPanel.add(TueDinner);
        reservationPanel.add(TueDinnerCh);
        reservationPanel.add(Wed);
        reservationPanel.add(WedLunch);
        reservationPanel.add(WedLunchCh);
        reservationPanel.add(WedDinner);
        reservationPanel.add(WedDinnerCh);
        reservationPanel.add(Thu);
        reservationPanel.add(ThuLunch);
        reservationPanel.add(ThuLunchCh);
        reservationPanel.add(ThuDinner);
        reservationPanel.add(ThuDinnerCh);
        reservationPanel.add(Fri);
        reservationPanel.add(FriLunch);
        reservationPanel.add(FriLunchCh);
        reservationPanel.add(FriDinner);
        reservationPanel.add(FriDinnerCh);
        reservationPanel.add(Sat);
        reservationPanel.add(SatLunch);
        reservationPanel.add(SatLunchCh);
        reservationPanel.add(SatDinner);
        reservationPanel.add(SatDinnerCh);
        reservationPanel.add(Sun);
        reservationPanel.add(SunLunch);
        reservationPanel.add(SunLunchCh);
        reservationPanel.add(SunDinner);
        reservationPanel.add(SunDinnerCh);
        reservationPanel.add(balanceLabel);
        reservationPanel.add(reserveButton);

//        Creating panel responsible for credit selection
        creditSelectionPanel = new JPanel(new GridLayout(1, 2));
        creditSelectionPanel.setOpaque(false);
        JPanel creditSelectionPanelSecondary = new JPanel(new GridBagLayout());
        creditSelectionPanelSecondary.setOpaque(false);
        JButton addCreditButton = new JButton("Add This Course");
        addCreditButton.setFont(new Font("", Font.PLAIN, 20));
        JTextArea courseDescription = new JTextArea("Description");
        courseDescription.setOpaque(false);
        courseDescription.setFont(new Font("", courseDescription.getFont().getStyle(), 20));
        courseDescription.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colour, 3),
                "Course Description", 4, 0, new Font("", Font.PLAIN, 15)));
        courseDescription.setEnabled(false);
        courseDescription.setDisabledTextColor(colour);
        courseDescription.setPreferredSize(new Dimension(300, 200));
        creditSelectionPanelSecondary.add(courseDescription);
        constraints.gridy = 1;
        creditSelectionPanelSecondary.add(addCreditButton, constraints);
        constraints.gridy = 0;
        creditSelectionPanel.add(creditSelectionPanelSecondary);
        JList<Object> presentCreditsList = new JList<>();
        presentCreditsList.setOpaque(false);
        presentCreditsList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(colour, 3),
                "Available Courses", 4, 0, new Font("", Font.PLAIN, 15)));
        creditSelectionPanel.add(presentCreditsList);

//        Setting the initial panel as the first page
        studentPanel.add(creditSelectionPanel);

        return studentPanel;
    }

    /**
     * Creates the teacher panel and its different sections
     * @return the panel it has built for further processes
     */
    public JPanel setTeacherPanel() {

        Color colour = new Color(250, 160, 40);

//        Creating the general and initial panel here
        teacherPanel = new JPanel(new BorderLayout(30, 30));
        teacherMainB = new JButton("Main panel");
        teacherChangeUNAndPW = new JButton("Change username or password");
        teacherAddToCoursesB = new JButton("Add to Courses");
        teacherPanelExit = new JButton("Exit");
        JPanel exitPanel = new JPanel(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipadx = teacherPanelExit.getX();
        constraints.gridy = teacherPanelExit.getY();
        exitPanel.add(teacherPanelExit, constraints);
        JPanel teacherOptionsPanel = new JPanel(new GridLayout(20, 1));
        teacherOptionsPanel.add(teacherMainB);
        teacherOptionsPanel.add(teacherChangeUNAndPW);
        teacherOptionsPanel.add(teacherAddToCoursesB);
        teacherPanel.add(teacherOptionsPanel, BorderLayout.WEST);
        teacherPanel.add(exitPanel, BorderLayout.NORTH);

//        Creating the main panel
        teacherMainPanel = new JPanel(new BorderLayout(30, 30));
        JPanel teacherMainPanelSecondary = new JPanel(new GridLayout(10, 2, 10, 10));
        teacherMainPanelSecondary.setBorder(BorderFactory.createTitledBorder("Credentials"));
        JLabel userName = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        teacherMainPanelSecondary.add(userName);
        teacherMainPanelSecondary.add(new JLabel("Username"));
        teacherMainPanelSecondary.add(password);
        teacherMainPanelSecondary.add(new JLabel("Password"));
        teacherMainPanelSecondary.setPreferredSize(new Dimension(100, teacherMainPanelSecondary.getPreferredSize().height));

        JPanel teacherMainPanelTertiary = new JPanel(new GridBagLayout());
        JList<Object> currentCredits = new JList<>();
        JList<Object> courseStudents = new JList<>();
        currentCredits.setBorder(BorderFactory.createTitledBorder("Current courses"));
        courseStudents.setBorder(BorderFactory.createTitledBorder("This course students"));
        JButton removeThisCourseB = new JButton("Remove this course");
        JTextField gradeF = new JTextField();
        JButton gradeThisStB = new JButton("Grade this student");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipady = 300;
        constraints.ipadx = 150;
        teacherMainPanelTertiary.add(currentCredits, constraints);
        constraints.gridx = 1;
        teacherMainPanelTertiary.add(courseStudents, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.ipady = 10;
        constraints.ipadx = 50;
        constraints.anchor = GridBagConstraints.CENTER;
        teacherMainPanelTertiary.add(new JLabel(), constraints);
        constraints.gridx = 1;
        constraints.ipady = 10;
        constraints.ipadx = 50;
        teacherMainPanelTertiary.add(gradeF, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.ipady = 10;
        constraints.ipadx = 50;
        teacherMainPanelTertiary.add(removeThisCourseB, constraints);
        constraints.gridx = 1;
        constraints.ipady = 10;
        constraints.ipadx = 50;
        teacherMainPanelTertiary.add(gradeThisStB, constraints);
        teacherMainPanel.add(teacherMainPanelSecondary, BorderLayout.WEST);
        teacherMainPanel.add(teacherMainPanelTertiary, BorderLayout.CENTER);

//        Creating the panel for changing password and username
        teacherUNPSPanel = new JPanel(new GridBagLayout());
        JPanel secondary = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel newUsername = new JLabel("New username");
        JLabel newPassword = new JLabel("New Password");
        JTextField newUsernameField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        JLabel notice = new JLabel("");
        JButton changeButton = new JButton("Change");
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        secondary.add(notice, constraints);
        constraints.gridy = 3;
        secondary.add(changeButton, constraints);
        constraints.gridx = 0;
        constraints.gridwidth = 0;
        constraints.gridwidth = 1;
        teacherUNPSPanel.add(secondary, constraints);

//        Creating the panel special for defining new courses
        teacherAddToCoursesPanel = new JPanel(new GridBagLayout());
        JPanel teacherAddToCoursesPanelSecondary = new JPanel(new GridLayout(6, 2, 5, 5));
        JLabel courseNameL = new JLabel("Course name:");
        JLabel dayL = new JLabel("Date:");
        JLabel timeL = new JLabel("Time:");
        JLabel creditsL = new JLabel("Credits:");
        JLabel capacityL = new JLabel("Capacity:");
        JTextField courseNameF = new JTextField();
        JTextField capacityF = new JTextField();
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        String[] times = {"8 - 10", "10 - 12", "14 - 16"};
        String[] credits = {"1", "2", "3", "4"};
        JComboBox<String> daysC = new JComboBox<>(days);
        JComboBox<String> timesC = new JComboBox<>(times);
        JComboBox<String> creditsC = new JComboBox<>(credits);
        JButton teacherAddCourse = new JButton("Add");
        teacherAddToCoursesPanelSecondary.add(courseNameL);
        teacherAddToCoursesPanelSecondary.add(courseNameF);
        teacherAddToCoursesPanelSecondary.add(capacityL);
        teacherAddToCoursesPanelSecondary.add(capacityF);
        teacherAddToCoursesPanelSecondary.add(dayL);
        teacherAddToCoursesPanelSecondary.add(daysC);
        teacherAddToCoursesPanelSecondary.add(timeL);
        teacherAddToCoursesPanelSecondary.add(timesC);
        teacherAddToCoursesPanelSecondary.add(creditsL);
        teacherAddToCoursesPanelSecondary.add(creditsC);
        teacherAddToCoursesPanelSecondary.add(teacherAddCourse);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        teacherAddToCoursesPanel.add(teacherAddToCoursesPanelSecondary, constraints);

//        Setting the main panel as the first page
        teacherPanel.add(teacherMainPanel, BorderLayout.CENTER);

        return teacherPanel;
    }

    /**
     * Creates the admin panel and its different sections
     * @return the panel it has built for further processes
     */
    public JPanel setAdminPanel() {

//        Creating the initial admin panel here
        adminPanel = new JPanel(new BorderLayout(30, 30));
        adminMainB = new JButton("Main panel");
        adminChangeUNAndPW = new JButton("Change username or password");
        adminRefectoryB = new JButton("Manage refectory");
        adminSTB = new JButton("Manage students and teachers");
        adminPanelExit = new JButton("Exit");
        JPanel adminOptionsPanel = new JPanel(new GridLayout(20, 1));
        adminOptionsPanel.add(adminMainB);
        adminOptionsPanel.add(adminChangeUNAndPW);
        adminOptionsPanel.add(adminRefectoryB);
        adminOptionsPanel.add(adminSTB);
        adminPanel.add(adminOptionsPanel, BorderLayout.WEST);
        adminPanel.add(adminPanelExit, BorderLayout.NORTH);

//        Creating the main panel here
        adminMainPanel = new JPanel(new GridBagLayout());
        JPanel adminMainPanelSecondary = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel userName = new JLabel("Username:");
        JLabel password = new JLabel("Password:");
        JLabel adminUserName = new JLabel("Username");
        JLabel adminPassword = new JLabel("Password");
        adminMainPanelSecondary.add(userName);
        adminMainPanelSecondary.add(password);
        adminMainPanelSecondary.add(adminUserName);
        adminMainPanelSecondary.add(adminPassword);
        adminMainPanel.add(adminMainPanelSecondary, constraints);

//        Creating the panel for renewing password and username
        adminUNPSPanel = new JPanel(new GridBagLayout());
        JPanel secondary = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel newUsername = new JLabel("New username");
        JLabel newPassword = new JLabel("New Password");
        JTextField newUsernameField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        JLabel notice = new JLabel("");
        JButton changeButton = new JButton("Change");
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        secondary.add(notice, constraints);
        constraints.gridy = 3;
        secondary.add(changeButton, constraints);
        constraints.gridx = 0;
        constraints.gridwidth = 0;
        constraints.gridwidth = 1;
        adminUNPSPanel.add(secondary, constraints);

//        Creating the panel for scheduling the refectory
        adminRefectoryPanel = new JPanel(new BorderLayout());
        JPanel adminRefectoryPanelSecondary = new JPanel(new GridLayout(9, 5, 20, 20));
        JLabel Mon = new JLabel("Mon");
        JLabel Tue = new JLabel("Tue");
        JLabel Wed = new JLabel("Wed");
        JLabel Thu = new JLabel("Thu");
        JLabel Fri = new JLabel("Fri");
        JLabel Sat = new JLabel("Sat");
        JLabel Sun = new JLabel("Sun");
        JLabel dinner = new JLabel("Dinner");
        JLabel lunch = new JLabel("Lunch");
        JTextField MonLunch = new JTextField();
        JTextField TueLunch = new JTextField();
        JTextField WedLunch = new JTextField();
        JTextField ThuLunch = new JTextField();
        JTextField FriLunch = new JTextField();
        JTextField SatLunch = new JTextField();
        JTextField SunLunch = new JTextField();
        JTextField MonDinner = new JTextField();
        JTextField TueDinner = new JTextField();
        JTextField WedDinner = new JTextField();
        JTextField ThuDinner = new JTextField();
        JTextField FriDinner = new JTextField();
        JTextField SatDinner = new JTextField();
        JTextField SunDinner = new JTextField();
        JTextField MonLunchP = new JTextField();
        JTextField TueLunchP = new JTextField();
        JTextField WedLunchP = new JTextField();
        JTextField ThuLunchP = new JTextField();
        JTextField FriLunchP = new JTextField();
        JTextField SatLunchP = new JTextField();
        JTextField SunLunchP = new JTextField();
        JTextField MonDinnerP = new JTextField();
        JTextField TueDinnerP = new JTextField();
        JTextField WedDinnerP = new JTextField();
        JTextField ThuDinnerP = new JTextField();
        JTextField FriDinnerP = new JTextField();
        JTextField SatDinnerP = new JTextField();
        JTextField SunDinnerP = new JTextField();
        JButton setButton = new JButton("Set");
        adminRefectoryPanelSecondary.add(new JLabel(""));
        adminRefectoryPanelSecondary.add(lunch);
        adminRefectoryPanelSecondary.add(new JLabel("Price"));
        adminRefectoryPanelSecondary.add(dinner);
        adminRefectoryPanelSecondary.add(new JLabel("Price"));
        adminRefectoryPanelSecondary.add(Mon);
        adminRefectoryPanelSecondary.add(MonLunch);
        adminRefectoryPanelSecondary.add(MonLunchP);
        adminRefectoryPanelSecondary.add(MonDinner);
        adminRefectoryPanelSecondary.add(MonDinnerP);
        adminRefectoryPanelSecondary.add(Tue);
        adminRefectoryPanelSecondary.add(TueLunch);
        adminRefectoryPanelSecondary.add(TueLunchP);
        adminRefectoryPanelSecondary.add(TueDinner);
        adminRefectoryPanelSecondary.add(TueDinnerP);
        adminRefectoryPanelSecondary.add(Wed);
        adminRefectoryPanelSecondary.add(WedLunch);
        adminRefectoryPanelSecondary.add(WedLunchP);
        adminRefectoryPanelSecondary.add(WedDinner);
        adminRefectoryPanelSecondary.add(WedDinnerP);
        adminRefectoryPanelSecondary.add(Thu);
        adminRefectoryPanelSecondary.add(ThuLunch);
        adminRefectoryPanelSecondary.add(ThuLunchP);
        adminRefectoryPanelSecondary.add(ThuDinner);
        adminRefectoryPanelSecondary.add(ThuDinnerP);
        adminRefectoryPanelSecondary.add(Fri);
        adminRefectoryPanelSecondary.add(FriLunch);
        adminRefectoryPanelSecondary.add(FriLunchP);
        adminRefectoryPanelSecondary.add(FriDinner);
        adminRefectoryPanelSecondary.add(FriDinnerP);
        adminRefectoryPanelSecondary.add(Sat);
        adminRefectoryPanelSecondary.add(SatLunch);
        adminRefectoryPanelSecondary.add(SatLunchP);
        adminRefectoryPanelSecondary.add(SatDinner);
        adminRefectoryPanelSecondary.add(SatDinnerP);
        adminRefectoryPanelSecondary.add(Sun);
        adminRefectoryPanelSecondary.add(SunLunch);
        adminRefectoryPanelSecondary.add(SunLunchP);
        adminRefectoryPanelSecondary.add(SunDinner);
        adminRefectoryPanelSecondary.add(SunDinnerP);
        adminRefectoryPanelSecondary.add(setButton);
        adminRefectoryPanel.add(adminRefectoryPanelSecondary, BorderLayout.CENTER);

//        Creating panel for managing students and teachers and their courses
        adminSTPanel = new JPanel(new GridLayout(1, 3, 30, 30));
        JPanel studentsPanel = new JPanel(new BorderLayout());
        JLabel students = new JLabel("Students:");
        JList<Object> studentsList = new JList<>();
        JPanel addRemovePanel = new JPanel(new FlowLayout());
        JButton addStudentB = new JButton("Add");
        JButton removeStudentB = new JButton("Remove");
        addRemovePanel.add(addStudentB);
        addRemovePanel.add(removeStudentB);
        studentsPanel.add(students, BorderLayout.NORTH);
        studentsPanel.add(studentsList, BorderLayout.CENTER);
        studentsPanel.add(addRemovePanel, BorderLayout.SOUTH);
        JPanel teachersPanel = new JPanel(new BorderLayout());
        JLabel teachers = new JLabel("Teachers:");
        JList<Object> teachersList = new JList<>();
        JPanel addRemovePanel2 = new JPanel(new FlowLayout());
        JButton addTeacherB = new JButton("Add");
        JButton removeTeacherB = new JButton("Remove");
        addRemovePanel2.add(addTeacherB);
        addRemovePanel2.add(removeTeacherB);
        teachersPanel.add(teachers, BorderLayout.NORTH);
        teachersPanel.add(teachersList, BorderLayout.CENTER);
        teachersPanel.add(addRemovePanel2, BorderLayout.SOUTH);
        JPanel coursesPanel = new JPanel(new BorderLayout());
        JLabel courses = new JLabel("Courses:");
        JList<Object> coursesList = new JList<>();
        JPanel addRemovePanel3 = new JPanel(new FlowLayout());
        JButton addCourseB = new JButton("Add");
        JButton removeCourseB = new JButton("Remove");
        addRemovePanel3.add(addCourseB);
        addRemovePanel3.add(removeCourseB);
        coursesPanel.add(courses, BorderLayout.NORTH);
        coursesPanel.add(coursesList, BorderLayout.CENTER);
        coursesPanel.add(addRemovePanel3, BorderLayout.SOUTH);
        adminSTPanel.add(studentsPanel);
        adminSTPanel.add(teachersPanel);
        adminSTPanel.add(coursesPanel);

//        Setting the main panel as the first page of the initial panel
        adminPanel.add(adminMainPanel, BorderLayout.CENTER);

        return adminPanel;
    }

    public class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(usernameField) || e.getSource().equals(passwordField)
                || e.getSource().equals(enterButton)) {
                int entranceMode = comboBox.getSelectedIndex();
                switch(entranceMode) {
                    case 0:
                        frame.setContentPane(setAdminPanel());
                        break;
                    case 1:
                        frame.setContentPane(setTeacherPanel());
                        break;
                    case 2:
                        frame.setContentPane(setStudentPanel());
                }
            }
        }
    }
}
