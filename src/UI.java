import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Class UI is responsible for creating the graphical user interface
 * by creating the JFrame and the different panels for the students,
 * the teachers and the admin.
 */
public class UI {

    JFrame frame;
    Color studentColour;
    Color teacherColour;
    Color adminColour;
    Font barFont;
    TitledBorder studentCommonBorder;
    TitledBorder teacherCommonBorder;
    TitledBorder adminCommonBorder;
    Font mainFont;

//    loginPanel accessories
    JPanel loginPanel;
    JComboBox<String> comboBox;
    JPanel loginBoard;
    JPanel creditsBoard;
    JLabel informLabel, errorLabel;
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
    JLabel teacherMainB;
    JLabel teacherChangeUNAndPW;
    JLabel teacherPanelExit;
    JLabel teacherAddToCoursesB;

    //    adminPanel accessories
    JPanel adminPanel;
    JPanel adminMainPanel;
    JPanel adminUNPSPanel;
    JPanel adminRefectoryPanel;
    JPanel adminSTPanel;
    JLabel adminMainB;
    JLabel adminChangeUNAndPW;
    JLabel adminRefectoryB;
    JLabel adminSTB;
    JLabel adminPanelExit;

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
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLoginPanel();
        frame.setContentPane(loginPanel);
        frame.setVisible(true);

//        Setting some common attributes in the programme
        studentColour = new Color(30, 90, 20);
        teacherColour = new Color(170, 60, 10);
        adminColour = new Color(30, 50, 150);
        barFont = new Font("", Font.BOLD, 12);
        studentCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(studentColour, 3),
                "Credentials", 4, 0, barFont);
        teacherCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(teacherColour, 3),
                "Credentials", 4, 0, barFont);
        adminCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(adminColour, 3),
                "Credentials", 4, 0, barFont);
        mainFont = new Font("", Font.PLAIN, 20);

    }

    /**
     * Creates the login panel as the starting page
     */
    public void setLoginPanel() {

//        Creating the action Listener
        EventHandler eventHandler = new EventHandler();

        JLabel entranceMode = new JLabel("Enter as");
        entranceMode.setForeground(Color.WHITE);
        entranceMode.setFont(barFont);
        entranceMode.setPreferredSize(new Dimension(90, 40));
        String[] comboItems = {"Admin", "Teacher", "Student"};
        comboBox = new JComboBox<>(comboItems);
        comboBox.setPreferredSize(new Dimension(120, 30));
        comboBox.setFont(barFont);
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
        JPanel secondaryPanel = new ImageJPanel("Project Files\\loading-bg-breeze-rpeast-morespace.jpeg");
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

        constraints.gridy = 0;
        constraints.gridx = 0;

    }

    /**
     * Creates the student panel and its different sections
     */
    public void setStudentPanel() {

//        Creating the mouse listener
        MouseHandler mouseHandler = new MouseHandler();

//        Creating the general studentPanel here with its buttons and fields
        studentPanel = new ImageJPanel("Project Files\\istockphoto-610850338-1024x1024 2.jpg");
        studentPanel.setLayout(new BorderLayout(30, 30));
        studentMainB = new JLabel("Main Panel");
        studentMainB.setPreferredSize(new Dimension(90, 40));
        studentMainB.setHorizontalAlignment(0);
        studentMainB.setFont(barFont);
        studentMainB.setForeground(Color.WHITE);
        studentMainB.addMouseListener(mouseHandler);
        changeUNAndPW = new JLabel("Change username or password");
        changeUNAndPW.setPreferredSize(new Dimension(200, 40));
        changeUNAndPW.setHorizontalAlignment(0);
        changeUNAndPW.setFont(barFont);
        changeUNAndPW.setForeground(Color.WHITE);
        changeUNAndPW.addMouseListener(mouseHandler);
        purchaseBalance = new JLabel("Purchase balance");
        purchaseBalance.setPreferredSize(new Dimension(130, 40));
        purchaseBalance.setHorizontalAlignment(0);
        purchaseBalance.setFont(barFont);
        purchaseBalance.setForeground(Color.WHITE);
        purchaseBalance.addMouseListener(mouseHandler);
        reserve = new JLabel("Reserve food");
        reserve.setPreferredSize(new Dimension(90, 40));
        reserve.setHorizontalAlignment(0);
        reserve.setFont(barFont);
        reserve.setForeground(Color.WHITE);
        reserve.addMouseListener(mouseHandler);
        selectCredits = new JLabel("Select new credits");
        selectCredits.setPreferredSize(new Dimension(140, 40));
        selectCredits.setHorizontalAlignment(0);
        selectCredits.setFont(barFont);
        selectCredits.setForeground(Color.WHITE);
        selectCredits.addMouseListener(mouseHandler);
        studentPanelExit = new JLabel("Exit");
        studentPanelExit.setPreferredSize(new Dimension(50, 40));
        studentPanelExit.setHorizontalAlignment(0);
        studentPanelExit.setFont(barFont);
        studentPanelExit.setForeground(Color.WHITE);
        studentPanelExit.addMouseListener(mouseHandler);
        JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 15));
        upperPanel.setBackground(studentColour);
        upperPanel.add(studentPanelExit);
        upperPanel.add(studentMainB);
        upperPanel.add(changeUNAndPW);
        upperPanel.add(purchaseBalance);
        upperPanel.add(reserve);
        upperPanel.add(selectCredits);
        studentPanel.add(upperPanel, BorderLayout.NORTH);
    }

    /**
     * Creates the student main panel
     */
    public void setStudentMainBoard() {

        studentMainPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        studentMainPanel.setOpaque(false);
        JPanel studentMainPanelSecondary = new JPanel(new GridBagLayout());
        studentMainPanelSecondary.setOpaque(false);
        studentMainPanelSecondary.setBorder(studentCommonBorder);
        JLabel userName = new JLabel("Username: ");
        userName.setPreferredSize(new Dimension(180, 50));
        userName.setFont(mainFont);
        JLabel password = new JLabel("Password: ");
        password.setPreferredSize(new Dimension(180, 50));
        password.setFont(mainFont);
        JLabel average = new JLabel("Average: ");
        average.setPreferredSize(new Dimension(180, 50));
        average.setFont(mainFont);
        JLabel balance = new JLabel("Balance: ");
        balance.setPreferredSize(new Dimension(180, 50));
        balance.setFont(mainFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(userName, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel("Username"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(password, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel("Password"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(average, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel("Average"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(balance, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel("Balance"), constraints);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        JList<Object> currentCredits = new JList<>();
        currentCredits.setOpaque(false);
        TitledBorder border = new TitledBorder(studentCommonBorder);
        border.setTitle("Current credits");
        border.setTitleFont(mainFont);
        currentCredits.setBorder(border);
        studentMainPanel.add(studentMainPanelSecondary);
        studentMainPanel.add(currentCredits);

    }

    /**
     * Creates the student username and password resetting panel
     */
    public void setStudentUNPSPanel() {

        UNPSPanel = new JPanel(new GridBagLayout());
        UNPSPanel.setOpaque(false);
        JPanel secondary = new JPanel(new GridLayout(5, 2, 5, 5));
        secondary.setOpaque(false);
        JLabel newUsername = new JLabel("New username");
        newUsername.setPreferredSize(new Dimension(180, 50));
        newUsername.setFont(mainFont);
        JLabel newPassword = new JLabel("New Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        newPassword.setFont(mainFont);
        JLabel repeatPassword = new JLabel("Repeat Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        repeatPassword.setFont(mainFont);
        JTextField newUsernameField = new JTextField();
        newUsernameField.setFont(mainFont);
        JPasswordField newPasswordField = new JPasswordField();
        newPasswordField.setFont(mainFont);
        JPasswordField repeatPasswordField = new JPasswordField();
        newPasswordField.setFont(mainFont);
        JLabel notice = new JLabel("");
        JButton changeButton = new JButton("Change");
        changeButton.setFont(mainFont);
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        secondary.add(repeatPassword);
        secondary.add(repeatPasswordField);
        secondary.add(changeButton);
        secondary.add(new JLabel());
        secondary.add(notice);
        UNPSPanel.add(secondary, constraints);

    }

    /**
     * Creates the student balance management panel
     */
    public void setBalancePanel() {

        balancePanel = new JPanel(new GridBagLayout());
        balancePanel.setOpaque(false);
        JPanel balancePanelSecondary = new JPanel(new GridLayout(5, 1));
        balancePanelSecondary.setOpaque(false);
        JLabel cardNumberL = new JLabel("Card number: ");
        cardNumberL.setPreferredSize(new Dimension(180, 50));
        cardNumberL.setFont(mainFont);
        JTextField cardNumberT = new JTextField();
        JLabel balanceL = new JLabel("Balance: ");
        balanceL.setPreferredSize(new Dimension(180, 50));
        balanceL.setFont(mainFont);
        JTextField balanceT = new JTextField();
        JLabel passwordL = new JLabel("Password: ");
        passwordL.setPreferredSize(new Dimension(180, 50));
        passwordL.setFont(mainFont);
        JPasswordField passwordF = new JPasswordField();
        JLabel noticeBalance = new JLabel("");
        JButton purchaseBalanceB = new JButton("Purchase");
        purchaseBalanceB.setFont(mainFont);
        balancePanelSecondary.add(cardNumberL);
        balancePanelSecondary.add(cardNumberT);
        balancePanelSecondary.add(balanceL);
        balancePanelSecondary.add(balanceT);
        balancePanelSecondary.add(passwordL);
        balancePanelSecondary.add(passwordF);
        balancePanelSecondary.add(purchaseBalanceB);
        balancePanelSecondary.add(noticeBalance);
        balancePanel.add(balancePanelSecondary, constraints);

    }

    /**
     * Creates the student reservation panel
     */
    public void setStudentReservationPanel() {

        reservationPanel = new JPanel(new GridLayout(9, 5, 20, 20));
        reservationPanel.setOpaque(false);
        JLabel Mon = new JLabel("Mon", SwingConstants.CENTER);
        Mon.setFont(mainFont);
        JLabel Tue = new JLabel("Tue", SwingConstants.CENTER);
        Tue.setFont(mainFont);
        JLabel Wed = new JLabel("Wed", SwingConstants.CENTER);
        Wed.setFont(mainFont);
        JLabel Thu = new JLabel("Thu", SwingConstants.CENTER);
        Thu.setFont(mainFont);
        JLabel Fri = new JLabel("Fri", SwingConstants.CENTER);
        Fri.setFont(mainFont);
        JLabel Sat = new JLabel("Sat", SwingConstants.CENTER);
        Sat.setFont(mainFont);
        JLabel Sun = new JLabel("Sun", SwingConstants.CENTER);
        Sun.setFont(mainFont);
        JLabel dinner = new JLabel("Dinner");
        dinner.setFont(mainFont);
        JLabel lunch = new JLabel("Lunch");
        lunch.setFont(mainFont);
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
        balanceLabel.setFont(mainFont);
        JButton reserveButton = new JButton("Reserve");
        reserveButton.setFont(mainFont);
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

    }

    /**
     * Creates the student credit selection panel
     */
    public void setCreditSelectionPanel() {

        creditSelectionPanel = new JPanel(new GridLayout(1, 2));
        creditSelectionPanel.setOpaque(false);
        JPanel creditSelectionPanelSecondary = new JPanel(new GridBagLayout());
        creditSelectionPanelSecondary.setOpaque(false);
        JButton addCreditButton = new JButton("Add This Course");
        addCreditButton.setFont(mainFont);
        JTextArea courseDescription = new JTextArea("Description");
        courseDescription.setOpaque(false);
        courseDescription.setFont(new Font("", courseDescription.getFont().getStyle(), 20));
        TitledBorder border = new TitledBorder(studentCommonBorder);
        border.setTitle("Course Description");
        border.setTitleFont(mainFont);
        courseDescription.setBorder(border);
        courseDescription.setEnabled(false);
        courseDescription.setDisabledTextColor(Color.BLACK);
        courseDescription.setPreferredSize(new Dimension(300, 200));
        creditSelectionPanelSecondary.add(courseDescription);
        constraints.gridy = 1;
        creditSelectionPanelSecondary.add(addCreditButton, constraints);
        constraints.gridy = 0;
        creditSelectionPanel.add(creditSelectionPanelSecondary);
        JList<Object> presentCreditsList = new JList<>();
        presentCreditsList.setOpaque(false);
        TitledBorder border1 = new TitledBorder(studentCommonBorder);
        border1.setTitleFont(mainFont);
        border1.setTitle("Courses");
        presentCreditsList.setBorder(border1);
        creditSelectionPanel.add(presentCreditsList);

    }

    /**
     * Creates the teacher panel and its different sections
     */
    public void setTeacherPanel() {

//        Creating the mouse listener
        MouseHandler mouseHandler = new MouseHandler();

//        Creating the general and initial panel here
        teacherPanel = new ImageJPanel("Project Files\\istockphoto-610850338-1024x1024 2.jpg");
        teacherPanel.setLayout(new BorderLayout());
        teacherMainB = new JLabel("Main panel");
        teacherMainB.setFont(barFont);
        teacherMainB.setHorizontalAlignment(0);
        teacherMainB.setPreferredSize(new Dimension(80, 40));
        teacherMainB.setForeground(Color.WHITE);
        teacherMainB.addMouseListener(mouseHandler);
        teacherChangeUNAndPW = new JLabel("Change username or password");
        teacherChangeUNAndPW.setFont(barFont);
        teacherChangeUNAndPW.setHorizontalAlignment(0);
        teacherChangeUNAndPW.setPreferredSize(new Dimension(200, 40));
        teacherChangeUNAndPW.setForeground(Color.WHITE);
        teacherChangeUNAndPW.addMouseListener(mouseHandler);
        teacherAddToCoursesB = new JLabel("Add to Courses");
        teacherAddToCoursesB.setFont(barFont);
        teacherAddToCoursesB.setHorizontalAlignment(0);
        teacherAddToCoursesB.setPreferredSize(new Dimension(110, 40));
        teacherAddToCoursesB.setForeground(Color.WHITE);
        teacherAddToCoursesB.addMouseListener(mouseHandler);
        teacherPanelExit = new JLabel("Exit");
        teacherPanelExit.setFont(barFont);
        teacherPanelExit.setPreferredSize(new Dimension(40, 40));
        teacherPanelExit.setHorizontalAlignment(0);
        teacherPanelExit.setForeground(Color.WHITE);
        teacherPanelExit.addMouseListener(mouseHandler);
        JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        upperPanel.add(teacherPanelExit);
        upperPanel.add(teacherMainB);
        upperPanel.add(teacherChangeUNAndPW);
        upperPanel.add(teacherAddToCoursesB);
        upperPanel.setBackground(teacherColour);
        teacherPanel.add(upperPanel, BorderLayout.NORTH);
    }

    /**
     * Creates the teacher main panel
     */
    public void setTeacherMainBoard() {

        teacherMainPanel = new JPanel(new BorderLayout(10, 30));
        teacherMainPanel.setOpaque(false);
        JPanel teacherMainPanelSecondary = new JPanel(new GridBagLayout());
        teacherMainPanelSecondary.setOpaque(false);
        teacherMainPanelSecondary.setOpaque(false);
        teacherMainPanelSecondary.setBorder(teacherCommonBorder);
        JLabel userName = new JLabel("Username: ");
        userName.setPreferredSize(new Dimension(120, 50));
        userName.setFont(mainFont);
        JLabel password = new JLabel("Password: ");
        password.setPreferredSize(new Dimension(120, 50));
        password.setFont(mainFont);
        teacherMainPanelSecondary.add(userName, constraints);
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.EAST;
        teacherMainPanelSecondary.add(new JLabel("Username"), constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridy = 2;
        teacherMainPanelSecondary.add(password, constraints);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridy = 3;
        teacherMainPanelSecondary.add(new JLabel("Password"), constraints);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JPanel teacherMainPanelTertiary = new JPanel(new GridBagLayout());
        teacherMainPanelTertiary.setOpaque(false);
        JList<Object> currentCredits = new JList<>();
        JList<Object> courseStudents = new JList<>();
        TitledBorder border1 = new TitledBorder(teacherCommonBorder);
        border1.setTitle("Current Credits");
        border1.setTitleFont(mainFont);
        currentCredits.setBorder(border1);
        currentCredits.setPreferredSize(new Dimension(250, 350));
        currentCredits.setOpaque(false);
        TitledBorder border2 = new TitledBorder(teacherCommonBorder);
        border2.setTitle("Course Students");
        border2.setTitleFont(mainFont);
        courseStudents.setBorder(border2);
        courseStudents.setPreferredSize(new Dimension(250, 350));
        courseStudents.setOpaque(false);
        JButton removeThisCourseB = new JButton("Remove this course");
        removeThisCourseB.setPreferredSize(new Dimension(160, 40));
        JTextField gradeF = new JTextField();
        gradeF.setPreferredSize(new Dimension(60, 30));
        JButton gradeThisStB = new JButton("Grade this student");
        gradeThisStB.setPreferredSize(new Dimension(160, 40));
        constraints.gridx = 0;
        constraints.gridy = 0;
        teacherMainPanelTertiary.add(currentCredits, constraints);
        constraints.gridx = 1;
        teacherMainPanelTertiary.add(courseStudents, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        teacherMainPanelTertiary.add(new JLabel(), constraints);
        constraints.gridx = 1;
        teacherMainPanelTertiary.add(gradeF, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        teacherMainPanelTertiary.add(removeThisCourseB, constraints);
        constraints.gridx = 1;
        teacherMainPanelTertiary.add(gradeThisStB, constraints);
        constraints.gridx = 0;
        constraints.gridy = 0;
        teacherMainPanel.add(teacherMainPanelSecondary, BorderLayout.WEST);
        teacherMainPanel.add(teacherMainPanelTertiary, BorderLayout.EAST);

    }

    /**
     * Creates the teacher username and password management panel
     */
    public void setTeacherUNPSPanel() {

        teacherUNPSPanel = new JPanel(new GridBagLayout());
        teacherUNPSPanel.setOpaque(false);
        JPanel secondary = new JPanel(new GridLayout(5, 2, 5, 5));
        secondary.setOpaque(false);
        JLabel newUsername = new JLabel("New username");
        newUsername.setPreferredSize(new Dimension(180, 50));
        newUsername.setFont(mainFont);
        JLabel newPassword = new JLabel("New Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        newPassword.setFont(mainFont);
        JLabel repeatPassword = new JLabel("Repeat Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        repeatPassword.setFont(mainFont);
        JTextField newUsernameField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        JPasswordField repeatPasswordField = new JPasswordField();
        JLabel notice = new JLabel("");
        JButton changeButton = new JButton("Change");
        changeButton.setFont(mainFont);
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        secondary.add(repeatPassword);
        secondary.add(repeatPasswordField);
        secondary.add(changeButton);
        secondary.add(new JLabel());
        secondary.add(notice);
        teacherUNPSPanel.add(secondary, constraints);

    }

    /**
     * Creates the teacher course building panel
     */
    public void setCourseCreationPanel() {

        teacherAddToCoursesPanel = new JPanel(new GridBagLayout());
        teacherAddToCoursesPanel.setOpaque(false);
        JPanel teacherAddToCoursesPanelSecondary = new JPanel(new GridLayout(7, 2, 5, 5));
        teacherAddToCoursesPanelSecondary.setOpaque(false);
        JLabel courseNameL = new JLabel("Course name:");
        courseNameL.setPreferredSize(new Dimension(180, 50));
        courseNameL.setFont(mainFont);
        JLabel dayL = new JLabel("Date:");
        dayL.setPreferredSize(new Dimension(180, 50));
        dayL.setFont(mainFont);
        JLabel timeL = new JLabel("Time:");
        timeL.setPreferredSize(new Dimension(180, 50));
        timeL.setFont(mainFont);
        JLabel creditsL = new JLabel("Credits:");
        creditsL.setPreferredSize(new Dimension(180, 50));
        creditsL.setFont(mainFont);
        JLabel capacityL = new JLabel("Capacity:");
        capacityL.setPreferredSize(new Dimension(180, 50));
        capacityL.setFont(mainFont);
        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        JTextField courseNameF = new JTextField();
        courseNameF.setFont(mainFont);
        JTextField capacityF = new JTextField();
        capacityF.setFont(mainFont);
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        String[] times = {"8 - 10", "10 - 12", "14 - 16"};
        String[] credits = {"1", "2", "3", "4"};
        JComboBox<String> daysC = new JComboBox<>(days);
        daysC.setFont(mainFont);
        JComboBox<String> timesC = new JComboBox<>(times);
        timesC.setFont(mainFont);
        JComboBox<String> creditsC = new JComboBox<>(credits);
        creditsC.setFont(mainFont);
        JButton teacherAddCourse = new JButton("Add");
        teacherAddCourse.setFont(mainFont);
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
        teacherAddToCoursesPanelSecondary.add(new JLabel());
        teacherAddToCoursesPanelSecondary.add(errorLabel);
        teacherAddToCoursesPanel.add(teacherAddToCoursesPanelSecondary, constraints);
    }

    /**
     * Creates the admin panel and its different sections
     */
    public void setAdminPanel() {

//        Creating the mouse listener
        MouseHandler mouseHandler = new MouseHandler();

//        Creating the initial admin panel here
        adminPanel = new ImageJPanel("Project Files\\white-technology-2K-wallpaper.jpg");
        adminPanel.setLayout(new BorderLayout(10, 10));
        adminMainB = new JLabel("Main panel");
        adminMainB.setFont(barFont);
        adminMainB.setHorizontalAlignment(0);
        adminMainB.setPreferredSize(new Dimension(70, 40));
        adminMainB.setForeground(Color.WHITE);
        adminMainB.addMouseListener(mouseHandler);
        adminChangeUNAndPW = new JLabel("Change username or password");
        adminChangeUNAndPW.setFont(barFont);
        adminChangeUNAndPW.setHorizontalAlignment(0);
        adminChangeUNAndPW.setPreferredSize(new Dimension(200, 40));
        adminChangeUNAndPW.setForeground(Color.WHITE);
        adminChangeUNAndPW.addMouseListener(mouseHandler);
        adminRefectoryB = new JLabel("Manage refectory");
        adminRefectoryB.setFont(barFont);
        adminRefectoryB.setHorizontalAlignment(0);
        adminRefectoryB.setPreferredSize(new Dimension(130, 40));
        adminRefectoryB.setForeground(Color.WHITE);
        adminRefectoryB.addMouseListener(mouseHandler);
        adminSTB = new JLabel("Manage students and teachers");
        adminSTB.setFont(barFont);
        adminSTB.setHorizontalAlignment(0);
        adminSTB.setPreferredSize(new Dimension(200, 40));
        adminSTB.setForeground(Color.WHITE);
        adminSTB.addMouseListener(mouseHandler);
        adminPanelExit = new JLabel("Exit");
        adminPanelExit.setFont(barFont);
        adminPanelExit.setHorizontalAlignment(0);
        adminPanelExit.setPreferredSize(new Dimension(40, 40));
        adminPanelExit.setForeground(Color.WHITE);
        adminPanelExit.setPreferredSize(new Dimension(60, 40));
        adminPanelExit.addMouseListener(mouseHandler);
        JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        upperPanel.setBackground(adminColour);
        upperPanel.add(adminPanelExit);
        upperPanel.add(adminMainB);
        upperPanel.add(adminChangeUNAndPW);
        upperPanel.add(adminRefectoryB);
        upperPanel.add(adminSTB);
        adminPanel.add(upperPanel, BorderLayout.NORTH);
    }

    /**
     * Creates the admin main panel
     */
    public void setAdminMainBoard() {

        adminMainPanel = new JPanel(new GridBagLayout());
        adminMainPanel.setOpaque(false);
        JPanel adminMainPanelSecondary = new JPanel(new GridLayout(2, 2, 10, 10));
        adminMainPanelSecondary.setOpaque(false);
        JLabel userName = new JLabel("Username:");
        userName.setFont(mainFont);
        JLabel adminUserName = new JLabel("Username");
        adminUserName.setFont(mainFont);
        JLabel password = new JLabel("Password:");
        password.setFont(mainFont);
        JLabel adminPassword = new JLabel("Password");
        adminPassword.setFont(mainFont);
        adminMainPanelSecondary.add(userName);
        adminMainPanelSecondary.add(adminUserName);
        adminMainPanelSecondary.add(password);
        adminMainPanelSecondary.add(adminPassword);
        adminMainPanel.add(adminMainPanelSecondary);

    }

    /**
     * Creates the admin username and password management panel
     */
    public void setAdminUNPSPanel() {

        adminUNPSPanel = new JPanel(new GridBagLayout());
        adminUNPSPanel.setOpaque(false);
        JPanel secondary = new JPanel(new GridLayout(5, 2, 5, 5));
        secondary.setOpaque(false);
        JLabel newUsername = new JLabel("New username");
        newUsername.setPreferredSize(new Dimension(180, 50));
        newUsername.setFont(mainFont);
        JLabel newPassword = new JLabel("New Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        newPassword.setFont(mainFont);
        JLabel repeatPassword = new JLabel("Repeat Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        repeatPassword.setFont(mainFont);
        JTextField newUsernameField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        JPasswordField repeatPasswordField = new JPasswordField();
        JLabel notice = new JLabel("");
        JButton changeButton = new JButton("Change");
        changeButton.setFont(mainFont);
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        secondary.add(repeatPassword);
        secondary.add(repeatPasswordField);
        secondary.add(changeButton);
        secondary.add(new JLabel());
        secondary.add(notice);
        adminUNPSPanel.add(secondary, constraints);

    }

    /**
     * Creates the admin refectory management panel
     */
    public void setAdminRefectoryPanel() {

        adminRefectoryPanel = new JPanel(new BorderLayout());
        JPanel adminRefectoryPanelSecondary = new JPanel(new GridLayout(9, 5, 20, 20));
        adminRefectoryPanel.setOpaque(false);
        adminRefectoryPanelSecondary.setOpaque(false);
        JLabel Mon = new JLabel("Mon", SwingConstants.CENTER);
        Mon.setFont(mainFont);
        JLabel Tue = new JLabel("Tue", SwingConstants.CENTER);
        Tue.setFont(mainFont);
        JLabel Wed = new JLabel("Wed", SwingConstants.CENTER);
        Wed.setFont(mainFont);
        JLabel Thu = new JLabel("Thu", SwingConstants.CENTER);
        Thu.setFont(mainFont);
        JLabel Fri = new JLabel("Fri", SwingConstants.CENTER);
        Fri.setFont(mainFont);
        JLabel Sat = new JLabel("Sat", SwingConstants.CENTER);
        Sat.setFont(mainFont);
        JLabel Sun = new JLabel("Sun", SwingConstants.CENTER);
        Sun.setFont(mainFont);
        JLabel dinner = new JLabel("Dinner");
        dinner.setFont(mainFont);
        JLabel lunch = new JLabel("Lunch");
        lunch.setFont(mainFont);
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
        setButton.setFont(mainFont);
        adminRefectoryPanelSecondary.add(new JLabel(""));
        adminRefectoryPanelSecondary.add(lunch);
        JLabel priceLabel1 = new JLabel("Price");
        priceLabel1.setFont(mainFont);
        adminRefectoryPanelSecondary.add(priceLabel1);
        adminRefectoryPanelSecondary.add(dinner);
        JLabel priceLabel2 = new JLabel("Price");
        priceLabel2.setFont(mainFont);
        adminRefectoryPanelSecondary.add(priceLabel2);
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

    }

    /**
     * Creates the admin student and teacher panel
     */
    public void setAdminSTPanel() {

        adminSTPanel = new JPanel(new GridLayout(1, 3, 30, 30));
        adminSTPanel.setOpaque(false);
        JPanel studentsPanel = new JPanel(new BorderLayout());
        studentsPanel.setOpaque(false);
        JList<Object> studentsList = new JList<>();
        studentsList.setOpaque(false);
        TitledBorder border1 = new TitledBorder(adminCommonBorder);
        border1.setTitle("Students");
        border1.setTitleFont(mainFont);
        studentsList.setBorder(border1);
        JPanel addRemovePanel = new JPanel(new FlowLayout());
        addRemovePanel.setOpaque(false);
        JButton addStudentB = new JButton("Add");
        JButton removeStudentB = new JButton("Remove");
        addRemovePanel.add(addStudentB);
        addRemovePanel.add(removeStudentB);
        studentsPanel.add(studentsList, BorderLayout.CENTER);
        studentsPanel.add(addRemovePanel, BorderLayout.SOUTH);
        JPanel teachersPanel = new JPanel(new BorderLayout());
        teachersPanel.setOpaque(false);
        JList<Object> teachersList = new JList<>();
        teachersList.setOpaque(false);
        TitledBorder border2 = new TitledBorder(adminCommonBorder);
        border2.setTitleFont(mainFont);
        border2.setTitle("Teachers");
        teachersList.setBorder(border2);
        JPanel addRemovePanel2 = new JPanel(new FlowLayout());
        addRemovePanel2.setOpaque(false);
        JButton addTeacherB = new JButton("Add");
        JButton removeTeacherB = new JButton("Remove");
        addRemovePanel2.add(addTeacherB);
        addRemovePanel2.add(removeTeacherB);
        teachersPanel.add(teachersList, BorderLayout.CENTER);
        teachersPanel.add(addRemovePanel2, BorderLayout.SOUTH);
        JPanel coursesPanel = new JPanel(new BorderLayout());
        coursesPanel.setOpaque(false);
        JList<Object> coursesList = new JList<>();
        coursesList.setOpaque(false);
        TitledBorder border3 = new TitledBorder(adminCommonBorder);
        border3.setTitle("Courses");
        border3.setTitleFont(mainFont);
        coursesList.setBorder(border3);
        JPanel addRemovePanel3 = new JPanel(new FlowLayout());
        addRemovePanel3.setOpaque(false);
        JButton addCourseB = new JButton("Add");
        JButton removeCourseB = new JButton("Remove");
        addRemovePanel3.add(addCourseB);
        addRemovePanel3.add(removeCourseB);
        coursesPanel.add(coursesList, BorderLayout.CENTER);
        coursesPanel.add(addRemovePanel3, BorderLayout.SOUTH);
        adminSTPanel.add(studentsPanel);
        adminSTPanel.add(teachersPanel);
        adminSTPanel.add(coursesPanel);

    }

    public class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(usernameField) || e.getSource().equals(passwordField)
                || e.getSource().equals(enterButton)) {
                int entranceMode = comboBox.getSelectedIndex();
                switch(entranceMode) {
                    case 0:
                        setAdminPanel();
                        setAdminMainBoard();
                        adminPanel.add(adminMainPanel, BorderLayout.CENTER);
                        frame.setContentPane(adminPanel);
                        break;
                    case 1:
                        setTeacherPanel();
                        setTeacherMainBoard();
                        teacherPanel.add(teacherMainPanel, BorderLayout.CENTER);
                        frame.setContentPane(teacherPanel);
                        break;
                    case 2:
                        setStudentPanel();
                        setStudentMainBoard();
                        studentPanel.add(studentMainPanel, BorderLayout.CENTER);
                        frame.setContentPane(studentPanel);
                }
            }
            else if (e.getSource().equals(studentPanelExit) ||
            e.getSource().equals(teacherPanelExit) || e.getSource().equals(adminPanelExit)) {
                setLoginPanel();
                frame.setContentPane(loginPanel);
            }

            frame.revalidate();
        }
    }

    public class MouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel interactedLabel = (JLabel) e.getSource();

            if(interactedLabel.equals(studentPanelExit) || interactedLabel.equals(teacherPanelExit)
                || interactedLabel.equals(adminPanelExit)) {
                setLoginPanel();
                frame.setContentPane(loginPanel);
            }
            else if(interactedLabel.equals(studentMainB)) {
                studentPanel.removeAll();
                setStudentPanel();
                setStudentMainBoard();
                studentPanel.add(studentMainPanel, BorderLayout.CENTER);
                studentPanel.revalidate();
                frame.setContentPane(studentPanel);

            } else if(interactedLabel.equals(changeUNAndPW)) {
                studentPanel.removeAll();
                setStudentPanel();
                setStudentUNPSPanel();
                studentPanel.add(UNPSPanel, BorderLayout.CENTER);
                studentPanel.revalidate();
                frame.setContentPane(studentPanel);

            } else if(interactedLabel.equals(purchaseBalance)) {
                studentPanel.removeAll();
                setStudentPanel();
                setBalancePanel();
                studentPanel.add(balancePanel, BorderLayout.CENTER);
                studentPanel.revalidate();
                frame.setContentPane(studentPanel);

            } else if(interactedLabel.equals(reserve)) {
                studentPanel.removeAll();
                setStudentPanel();
                setStudentReservationPanel();
                studentPanel.add(reservationPanel, BorderLayout.CENTER);
                studentPanel.revalidate();
                frame.setContentPane(studentPanel);

            } else if(interactedLabel.equals(selectCredits)) {
                studentPanel.removeAll();
                setStudentPanel();
                setCreditSelectionPanel();
                studentPanel.add(creditSelectionPanel, BorderLayout.CENTER);
                studentPanel.repaint();
                frame.setContentPane(studentPanel);

            } else if(interactedLabel.equals(teacherMainB)) {
                teacherPanel.removeAll();
                setTeacherPanel();
                setTeacherMainBoard();
                teacherPanel.add(teacherMainPanel, BorderLayout.CENTER);
                teacherPanel.repaint();
                frame.setContentPane(teacherPanel);

            } else if(interactedLabel.equals(teacherChangeUNAndPW)) {
                teacherPanel.removeAll();
                setTeacherPanel();
                setTeacherUNPSPanel();
                teacherPanel.add(teacherUNPSPanel, BorderLayout.CENTER);
                teacherPanel.repaint();
                frame.setContentPane(teacherPanel);

            } else if(interactedLabel.equals(teacherAddToCoursesB)) {
                teacherPanel.removeAll();
                setTeacherPanel();
                setCourseCreationPanel();
                teacherPanel.add(teacherAddToCoursesPanel, BorderLayout.CENTER);
                teacherPanel.repaint();
                frame.setContentPane(teacherPanel);

            } else if(interactedLabel.equals(adminMainB)) {
                adminPanel.removeAll();
                setAdminPanel();
                setAdminMainBoard();
                adminPanel.add(adminMainPanel, BorderLayout.CENTER);
                adminPanel.repaint();
                frame.setContentPane(adminPanel);

            } else if(interactedLabel.equals(adminChangeUNAndPW)) {
                adminPanel.removeAll();
                setAdminPanel();
                setAdminUNPSPanel();
                adminPanel.add(adminUNPSPanel, BorderLayout.CENTER);
                adminPanel.repaint();
                frame.setContentPane(adminPanel);

            } else if(interactedLabel.equals(adminRefectoryB)) {
                adminPanel.removeAll();
                setAdminPanel();
                setAdminRefectoryPanel();
                adminPanel.add(adminRefectoryPanel, BorderLayout.CENTER);
                adminPanel.repaint();
                frame.setContentPane(adminPanel);

            } else if(interactedLabel.equals(adminSTB)) {
                adminPanel.removeAll();
                setAdminPanel();
                setAdminSTPanel();
                adminPanel.add(adminSTPanel, BorderLayout.CENTER);
                adminPanel.repaint();
                frame.setContentPane(adminPanel);

            }

            frame.revalidate();
        }
    }
}
