import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

/**
 * Class UI is responsible for creating the graphical user interface
 * by creating the JFrame and the different panels for the students,
 * the teachers and the admin.
 */
public class UI {

    private static UI ui = null;

    private Administrator administrator;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Course> courses;
    private String[][] refectorySchedule;
    private Member workingMember;
    private MouseHandler mouseHandler;
    private Saviour saver;

    private JFrame frame;
    private final Color studentColour;
    private final Color teacherColour;
    private final Color adminColour;
    private Font barFont;
    private TitledBorder studentCommonBorder;
    private TitledBorder teacherCommonBorder;
    private TitledBorder adminCommonBorder;
    private Font mainFont;
    private JTextField newUsernameField;
    private JPasswordField newPasswordField;
    private JPasswordField repeatPasswordField;
    private JButton changeButton;
    private JButton setButton;
    private JLabel successLabel;
    private JButton addAsStudentButton;
    private JButton addAsTeacherButton;
    private JPanel courseStudents;
    private JLabel newUsername;
    private JLabel newPassword;
    private JLabel repeatPassword;

    //    loginPanel accessories
    private JPanel loginPanel;
    private JComboBox<String> comboBox;
    private JLabel errorLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton enterButton;

    //    studentPanel accessories
    private JPanel studentPanel;
    private JPanel studentMainPanel;
    private JLabel studentMainB;
    private JLabel changeUNAndPW;
    private JLabel purchaseBalance;
    private JLabel reserve;
    private JLabel selectCredits;
    private JLabel studentPanelExit;
    private JPanel UNPSPanel;
    private JPanel balancePanel;
    private JPanel reservationPanel;
    private JPanel creditSelectionPanel;
    private JTextField cardNumberT;
    private JTextField balanceT;
    private JPasswordField passwordF;
    private JButton purchaseBalanceB;
    private JButton reserveButton;
    private JCheckBox[][] checkBoxes;
    private JTextField[][] meals;
    private JTextArea courseDescription;

    //    teacherPanel accessories
    private JPanel teacherPanel;
    private JPanel teacherMainPanel;
    private JPanel teacherUNPSPanel;
    private JPanel teacherAddToCoursesPanel;
    private JLabel teacherMainB;
    private JLabel teacherChangeUNAndPW;
    private JLabel teacherPanelExit;
    private JLabel teacherAddToCoursesB;
    private JList<Subjects> prerequisiteSubjects;
    private JButton teacherAddCourse;
    private JComboBox<Subjects> courseNameC;
    private JTextField capacityF;
    private JComboBox<Days> daysC;
    private JComboBox<Times> timesC;

    //    adminPanel accessories
    private JPanel adminPanel;
    private JPanel adminMainPanel;
    private JPanel adminUNPSPanel;
    private JPanel adminRefectoryPanel;
    private JScrollPane adminSTPanel;
    private JLabel adminMainB;
    private JLabel adminChangeUNAndPW;
    private JLabel adminRefectoryB;
    private JLabel adminSTB;
    private JLabel adminPanelExit;
    private JComboBox<String> creditsC;
    private JTextField[][] mealPrices;

    //    constraints variable is for managing the items of the GridBagLayout
    //    wherever its needed
    private GridBagConstraints constraints = new GridBagConstraints();

    /**
     * Returns a unique instance of this class
     * @param administrator The administrator of the system
     * @param students The students list of the system
     * @param teachers The teachers list of the system
     * @param courses The courses list of the system
     * @param refectorySchedule The refectory meal schedule
     * @param refectoryPrices The refectory meal prices
     */
    public static void getInstance(Administrator administrator, ArrayList<Student> students, ArrayList<Teacher> teachers,
       ArrayList<Course> courses, String[][] refectorySchedule, float[][] refectoryPrices, Saviour saver) {
        if(ui == null)
            ui = new UI(administrator,  students,  teachers,
                    courses,  refectorySchedule, refectoryPrices, saver);
    }

    /**
     * Instantiates this class
     */
    private UI(Administrator administrator, ArrayList<Student> students, ArrayList<Teacher> teachers,
               ArrayList<Course> courses, String[][] refectorySchedule, float[][] refectoryPrices, Saviour saver) {

//        Getting the system members and attributes
        this.administrator = administrator;
        this.students = students;
        this.teachers = teachers;
        this.courses = courses;
        this.refectorySchedule = refectorySchedule;
        this.saver = saver;

        this.mealPrices = new JTextField[7][2];
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                this.mealPrices[i][j] = new JTextField(refectoryPrices[i][j] + "");
            }
        }
        checkBoxes = new JCheckBox[7][2];
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                checkBoxes[i][j] = new JCheckBox();
                checkBoxes[i][j].setOpaque(false);
            }
        }
        meals = new JTextField[7][2];
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                meals[i][j] = new JTextField(refectorySchedule[i][j]);
            }
        }


//        Setting some common attributes in the programme
        studentColour = new Color(30, 90, 20);
        teacherColour = new Color(170, 60, 10);
        adminColour = new Color(30, 50, 150);
        Color courseColour = new Color(120, 120, 50);
        barFont = new Font("", Font.BOLD, 12);
        mainFont = new Font("", Font.PLAIN, 20);
        studentCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(studentColour, 2),
                "", 4, 0, mainFont);
        teacherCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(teacherColour, 2),
                "", 4, 0, mainFont);
        adminCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(adminColour, 2),
                "", 4, 0, mainFont);

        EventHandler eventHandler = new EventHandler();
        mouseHandler = new MouseHandler();

        newUsername = new JLabel("New username");
        newUsername.setPreferredSize(new Dimension(180, 50));
        newUsername.setFont(mainFont);
        newPassword = new JLabel("New Password");
        newPassword.setPreferredSize(new Dimension(180, 50));
        newPassword.setFont(mainFont);
        newPassword.setPreferredSize(new Dimension(180, 50));
        repeatPassword = new JLabel("Repeat Password");
        repeatPassword.setFont(mainFont);
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        successLabel = new JLabel();
        successLabel.setForeground(Color.GREEN);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(40, 25));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(40, 25));
        usernameField.addActionListener(eventHandler);
        passwordField.addActionListener(eventHandler);
        enterButton = new JButton("Enter");
        enterButton.setPreferredSize(new Dimension(200, 40));
        enterButton.setForeground(new Color(0, 0, 100));
        enterButton.setFont(new Font("", Font.PLAIN, 20));
        enterButton.addActionListener(eventHandler);

        newUsernameField = new JTextField();
        newUsernameField.setFont(mainFont);
        newPasswordField = new JPasswordField();
        repeatPasswordField = new JPasswordField();
        changeButton = new JButton("Change");
        changeButton.setFont(mainFont);
        changeButton.addActionListener(eventHandler);

        reserveButton = new JButton("Reserve");
        reserveButton.setFont(mainFont);
        reserveButton.addActionListener(eventHandler);

        cardNumberT = new JTextField();
        cardNumberT.setFont(mainFont);
        cardNumberT.addActionListener(eventHandler);
        balanceT = new JTextField();
        balanceT.setFont(mainFont);
        balanceT.addActionListener(eventHandler);
        passwordF = new JPasswordField();
        passwordF.addActionListener(eventHandler);
        purchaseBalanceB = new JButton("Purchase");
        purchaseBalanceB.setFont(mainFont);
        purchaseBalanceB.addActionListener(eventHandler);

        setButton = new JButton("Set");
        setButton.setFont(mainFont);
        setButton.addActionListener(eventHandler);

        courseStudents = new JPanel();

        teacherAddCourse = new JButton("Add");
        teacherAddCourse.setFont(mainFont);
        teacherAddCourse.addActionListener(eventHandler);

        addAsStudentButton = new JButton("Add As Student");
        addAsStudentButton.setFont(mainFont);
        addAsStudentButton.addActionListener(eventHandler);
        addAsTeacherButton = new JButton("Add As Teacher");
        addAsTeacherButton.setFont(mainFont);
        addAsTeacherButton.addActionListener(eventHandler);

        prerequisiteSubjects = new JList<>(Subjects.values());
        prerequisiteSubjects.setFont(mainFont);
        prerequisiteSubjects.setSelectionForeground(Color.WHITE);
        prerequisiteSubjects.setSelectionBackground(courseColour);
        creditsC = new JComboBox<>(new String[]{"1", "2", "3", "4"});
        creditsC.setFont(mainFont);
        courseNameC = new JComboBox<>(Subjects.values());
        courseNameC.setFont(mainFont);
        capacityF = new JTextField();
        capacityF.setFont(mainFont);
        daysC = new JComboBox<>(Days.values());
        daysC.setFont(mainFont);
        timesC = new JComboBox<>(Times.values());
        timesC.setFont(mainFont);

        courseDescription = new JTextArea();

//        Setting the frame
        frame = new JFrame("University Management System");
        frame.setSize(740, 560);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLoginPanel();
        frame.setContentPane(loginPanel);
        frame.setVisible(true);

    }

    /**
     * Creates the login panel as the starting page
     */
    public void setLoginPanel() {

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

        JPanel creditsBoard = new JPanel();
        creditsBoard.setLayout(new GridLayout(2, 2, 5,5));
        JLabel usernameL = new JLabel("Username");
        usernameL.setForeground(Color.WHITE);
        usernameL.setFont(mainFont);
        JLabel passwordL = new JLabel("Password");
        passwordL.setForeground(Color.WHITE);
        passwordL.setFont(mainFont);
        usernameField.setText("");
        passwordField.setText("");
        creditsBoard.add(usernameL);
        creditsBoard.add(usernameField);
        creditsBoard.add(passwordL);
        creditsBoard.add(passwordField);
        creditsBoard.setOpaque(false);
        JLabel informLabel = new JLabel("Enter ye' username and password");
        informLabel.setPreferredSize(new Dimension(350, 50));
        informLabel.setForeground(Color.WHITE);
        informLabel.setFont(new Font("", Font.PLAIN, 20));
        informLabel.setHorizontalAlignment(0);
        errorLabel.setText("");
        enterButton.setOpaque(false);
        JPanel loginBoard = new JPanel(new BorderLayout(5, 5));
        loginBoard.add(informLabel, BorderLayout.NORTH);
        loginBoard.add(creditsBoard, BorderLayout.CENTER);
        loginBoard.add(errorLabel, BorderLayout.SOUTH);
        loginBoard.setOpaque(false);

        loginPanel = new JPanel(new BorderLayout());
        loginPanel.add(introPanel, BorderLayout.NORTH);
        JPanel secondaryPanel = new ImageJPanel("Project Files\\Pictures\\loading-bg-breeze-rpeast-morespace.jpeg");
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
//        Resetting constraints
        constraints.gridy = 0;
        constraints.gridx = 0;

    }

    /**
     * Creates the student panel and its different sections
     */
    public void setStudentPanel() {

//        Creating the general studentPanel here with its buttons and fields
        studentPanel = new ImageJPanel("Project Files\\Pictures\\istockphoto-610850338-1024x1024 2.jpg");
        studentPanel.setLayout(new BorderLayout(5, 5));
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

        studentMainPanel = new JPanel(new BorderLayout(5, 5));
        studentMainPanel.setOpaque(false);
        JPanel studentMainPanelSecondary = new JPanel(new GridBagLayout());
        studentMainPanelSecondary.setOpaque(false);
        TitledBorder border = new TitledBorder(studentCommonBorder);
        border.setTitle("Credentials");
        border.setTitleFont(mainFont);
        studentMainPanelSecondary.setBorder(border);
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
        Student student = (Student) workingMember;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:
             student.getPassword()) {
            stringBuilder.append(c);
        }
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(userName, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel(student.getUserName()), constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(password, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel(stringBuilder.toString()), constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(average, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel(student.getAverage() + ""), constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;
        studentMainPanelSecondary.add(balance, constraints);
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        studentMainPanelSecondary.add(new JLabel(student.getBalance() + ""), constraints);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        JPanel studentMainPanelTertiary = new JPanel(new GridLayout(3, 1));
        studentMainPanelTertiary.setOpaque(false);
        JPanel currentCredits = new JPanel();
        currentCredits.setLayout(new BoxLayout(currentCredits, BoxLayout.PAGE_AXIS));
        prepareCourseListItems(currentCredits, student.getStudentCourses());
        JPanel pastCredits = new JPanel();
        pastCredits.setLayout(new BoxLayout(pastCredits, BoxLayout.PAGE_AXIS));
        prepareCourseListItems(pastCredits, student.getPastCourses());
        JScrollPane pane1 = new JScrollPane(currentCredits);
        TitledBorder border1 = new TitledBorder(studentCommonBorder);
        border1.setTitle("Current credits");
        pane1.setPreferredSize(new Dimension(350, 250));
        pane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        border1.setTitleFont(mainFont);
        pane1.setBorder(border1);
        JScrollPane pane2 = new JScrollPane(pastCredits);
        pane2.setPreferredSize(new Dimension(350, 250));
        pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        TitledBorder border2 = new TitledBorder(studentCommonBorder);
        border2.setTitle("Past credits");
        border2.setTitleFont(mainFont);
        pane2.setBorder(border2);
        studentMainPanelTertiary.add(pane1);
        studentMainPanelTertiary.add(pane2);
        JTable programme = new JTable(6, 4);
        programme.setEnabled(false);
        programme.setOpaque(false);
        programme.setPreferredSize(new Dimension(300, 200));
        programme.setValueAt("Day", 0, 0);
        programme.setValueAt("Mon", 1, 0);
        programme.setValueAt("Tue", 2, 0);
        programme.setValueAt("Wed", 3, 0);
        programme.setValueAt("Thu", 4, 0);
        programme.setValueAt("Fri", 5, 0);
        programme.setValueAt("8 - 10", 0, 1);
        programme.setValueAt("10 - 12", 0, 2);
        programme.setValueAt("14 - 16", 0, 3);
        for (Course course:
             student.getStudentCourses().keySet()) {
            int day, time;
            switch (course.getDay()) {
                case MON:
                    day = 1;
                    break;
                case TUE:
                    day = 2;
                    break;
                case WED:
                    day = 3;
                    break;
                case THU:
                    day = 4;
                    break;
                default:
                    day = 5;
            }
            switch (course.getTime()) {
                case _8_10:
                    time = 1;
                    break;
                case _14_16:
                    time = 2;
                    break;
                default:
                    time = 3;
            }
            programme.setValueAt(course.getSubject(), day, time);
        }
        studentMainPanelTertiary.add(programme);
        studentMainPanel.add(studentMainPanelSecondary, BorderLayout.WEST);
        JScrollPane scrollPane = new JScrollPane(studentMainPanelTertiary);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        studentMainPanel.add(scrollPane, BorderLayout.CENTER);
        studentMainPanel.add(new JPanel(), BorderLayout.EAST);
        studentMainPanel.add(new JPanel(), BorderLayout.SOUTH);
    }

    /**
     * Creates the student username and password resetting panel
     */
    public void setStudentUNPSPanel() {

        UNPSPanel = new JPanel(new GridBagLayout());
        UNPSPanel.setOpaque(false);
        errorLabel.setText("");
        successLabel.setText("");
        JPanel secondary = new JPanel(new GridLayout(5, 2, 5, 5));
        secondary.setOpaque(false);
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        secondary.add(repeatPassword);
        secondary.add(repeatPasswordField);
        secondary.add(changeButton);
        secondary.add(new JLabel());
        secondary.add(errorLabel);
        secondary.add(successLabel);
        UNPSPanel.add(secondary, constraints);

    }

    /**
     * Creates the student balance management panel
     */
    public void setBalancePanel() {

        balancePanel = new JPanel(new GridBagLayout());
        balancePanel.setOpaque(false);
        JPanel balancePanelSecondary = new JPanel(new GridLayout(5, 1, 5, 5));
        balancePanelSecondary.setOpaque(false);
        JLabel cardNumberL = new JLabel("Card number: ");
        cardNumberL.setPreferredSize(new Dimension(180, 50));
        cardNumberL.setFont(mainFont);
        JLabel balanceL = new JLabel("Balance: ");
        balanceL.setPreferredSize(new Dimension(180, 50));
        balanceL.setFont(mainFont);
        JLabel passwordL = new JLabel("Password: ");
        passwordL.setPreferredSize(new Dimension(180, 50));
        passwordL.setFont(mainFont);
        balanceT.setText("");
        passwordF.setText("");
        cardNumberT.setText("");
        errorLabel.setText("");
        successLabel.setText("");
        balancePanelSecondary.add(cardNumberL);
        balancePanelSecondary.add(cardNumberT);
        balancePanelSecondary.add(balanceL);
        balancePanelSecondary.add(balanceT);
        balancePanelSecondary.add(passwordL);
        balancePanelSecondary.add(passwordF);
        balancePanelSecondary.add(purchaseBalanceB);
        balancePanelSecondary.add(errorLabel);
        balancePanelSecondary.add(successLabel);
        balancePanel.add(balancePanelSecondary, constraints);

    }

    /**
     * Creates the student reservation panel
     */
    public void setStudentReservationPanel() {

        reservationPanel = new JPanel(new GridLayout(9, 5, 20, 20));
        reservationPanel.setOpaque(false);
        errorLabel.setText("");
        successLabel.setText("");
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
        Student student = (Student) workingMember;
        JLabel[][] mealsLabels = new JLabel[7][2];
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                mealsLabels[i][j] = new JLabel(refectorySchedule[i][j]);
                mealsLabels[i][j].setToolTipText(mealPrices[i][j].getText() + " £");
                checkBoxes[i][j].setSelected(student.isReserved(i, j));
            }
        }
        JLabel balanceLabel = new JLabel(student.getBalance() + "", SwingConstants.CENTER);
        balanceLabel.setFont(mainFont);
        reservationPanel.add(new JLabel());
        reservationPanel.add(lunch);
        reservationPanel.add(new JLabel());
        reservationPanel.add(dinner);
        reservationPanel.add(new JLabel());
        for (int i = 0; i < 7; ++i) {
            switch (i) {
                case 0:
                    reservationPanel.add(Mon);
                    break;
                case 1:
                    reservationPanel.add(Tue);
                    break;
                case 2:
                    reservationPanel.add(Wed);
                    break;
                case 3:
                    reservationPanel.add(Thu);
                    break;
                case 4:
                    reservationPanel.add(Fri);
                    break;
                case 5:
                    reservationPanel.add(Sat);
                    break;
                default:
                    reservationPanel.add(Sun);
                    break;
            }
            reservationPanel.add(mealsLabels[i][0]);
            reservationPanel.add(checkBoxes[i][0]);
            reservationPanel.add(mealsLabels[i][1]);
            reservationPanel.add(checkBoxes[i][1]);
        }
        reservationPanel.add(balanceLabel);
        reservationPanel.add(reserveButton);
        reservationPanel.add(errorLabel);
        reservationPanel.add(successLabel);
    }

    /**
     * Creates the student credit selection panel
     */
    public void setCreditSelectionPanel() {

        creditSelectionPanel = new JPanel(new GridLayout(1, 2));
        creditSelectionPanel.setOpaque(false);
        JPanel creditSelectionPanelSecondary = new JPanel(new GridBagLayout());
        creditSelectionPanelSecondary.setOpaque(false);
        courseDescription.setOpaque(false);
        courseDescription.setFont(barFont);
        TitledBorder border = new TitledBorder(studentCommonBorder);
        border.setTitle("Course Description");
        border.setTitleFont(mainFont);
        courseDescription.setBorder(border);
        courseDescription.setEnabled(false);
        courseDescription.setDisabledTextColor(Color.BLACK);
        courseDescription.setPreferredSize(new Dimension(300, 200));
        courseDescription.setText("");
        errorLabel.setText("");
        successLabel.setText("");
        creditSelectionPanelSecondary.add(courseDescription);
        constraints.gridy = 1;
        creditSelectionPanelSecondary.add(errorLabel, constraints);
        constraints.gridy = 2;
        creditSelectionPanelSecondary.add(successLabel, constraints);
        constraints.gridy = 0;
        creditSelectionPanel.add(creditSelectionPanelSecondary);
        JPanel presentCreditsList = new JPanel();
        presentCreditsList.setLayout(new BoxLayout(presentCreditsList, BoxLayout.PAGE_AXIS));
        prepareCourseListItemsWithActions(presentCreditsList, courses);
        TitledBorder border1 = new TitledBorder(studentCommonBorder);
        border1.setTitleFont(mainFont);
        border1.setTitle("Present courses");
        JScrollPane pane = new JScrollPane(presentCreditsList);
        pane.setPreferredSize(new Dimension(300, 550));
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setBorder(border1);
        creditSelectionPanel.add(pane);
    }

    /**
     * Creates the teacher panel and its different sections
     */
    public void setTeacherPanel() {

//        Creating the general and initial panel here
        teacherPanel = new ImageJPanel("Project Files\\Pictures\\istockphoto-610850338-1024x1024 2.jpg");
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

        teacherMainPanel = new JPanel(new BorderLayout(10, 10));
        teacherMainPanel.setOpaque(false);
        JPanel teacherMainPanelSecondary = new JPanel(new GridBagLayout());
        teacherMainPanelSecondary.setOpaque(false);
        teacherMainPanelSecondary.setOpaque(false);
        TitledBorder border = new TitledBorder(teacherCommonBorder);
        border.setTitle("Credentials");
        border.setTitleFont(mainFont);
        teacherMainPanelSecondary.setBorder(border);
        JLabel userName = new JLabel("Username: ");
        userName.setPreferredSize(new Dimension(120, 50));
        userName.setFont(mainFont);
        JLabel username = new JLabel(workingMember.getUserName());
        userName.setFont(mainFont);
        JLabel userPassword = new JLabel("Password: ");
        userPassword.setPreferredSize(new Dimension(120, 50));
        userPassword.setFont(mainFont);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:
             workingMember.getPassword()) {
            stringBuilder.append(c);
        }
        JLabel password = new JLabel(stringBuilder.toString());
        userName.setFont(mainFont);
        teacherMainPanelSecondary.add(userName, constraints);
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.EAST;
        teacherMainPanelSecondary.add(username, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridy = 2;
        teacherMainPanelSecondary.add(userPassword, constraints);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridy = 3;
        teacherMainPanelSecondary.add(password, constraints);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JPanel teacherMainPanelTertiary = new JPanel(new GridLayout(2, 1));
        teacherMainPanelTertiary.setOpaque(false);
        Teacher thisTeacher = (Teacher) workingMember;
        TitledBorder border1 = new TitledBorder(teacherCommonBorder);
        border1.setTitle("Current Credits");
        border1.setTitleFont(mainFont);
        JPanel currentCredits = new JPanel();
        currentCredits.setLayout(new BoxLayout(currentCredits, BoxLayout.PAGE_AXIS));
        ArrayList<Course> teacherCourses = new ArrayList<>();
        int index;
        for (Course crs:
             thisTeacher.getTeacherCourses()) {
            index = courses.indexOf(crs);
            if(index >= 0)
                teacherCourses.add(courses.get(index));
        }
        prepareCourseListItemsWithActions(currentCredits, teacherCourses);
        currentCredits.setFont(mainFont);
        JScrollPane pane1 = new JScrollPane(currentCredits);
        pane1.setPreferredSize(new Dimension(350, 250));
        pane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane1.setBorder(border1);
        TitledBorder border2 = new TitledBorder(teacherCommonBorder);
        courseStudents.setFont(mainFont);
        courseStudents.setLayout(new BoxLayout(courseStudents, BoxLayout.PAGE_AXIS));
        border2.setTitle("Course Students");
        border2.setTitleFont(mainFont);
        JScrollPane pane2 = new JScrollPane(courseStudents);
        pane2.setPreferredSize(new Dimension(350, 250));
        pane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane2.setBorder(border2);

        errorLabel.setText("");
        successLabel.setText("");
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.add(errorLabel);
        infoPanel.add(successLabel);

        teacherMainPanelTertiary.add(pane1);
        teacherMainPanelTertiary.add(pane2);
        teacherMainPanel.add(teacherMainPanelSecondary, BorderLayout.WEST);
        teacherMainPanel.add(teacherMainPanelTertiary, BorderLayout.CENTER);
        teacherMainPanel.add(infoPanel, BorderLayout.SOUTH);

    }

    /**
     * Creates the teacher username and password management panel
     */
    public void setTeacherUNPSPanel() {

        teacherUNPSPanel = new JPanel(new GridBagLayout());
        teacherUNPSPanel.setOpaque(false);
        errorLabel.setText("");
        successLabel.setText("");
        JPanel secondary = new JPanel(new GridLayout(5, 2, 5, 5));
        secondary.setOpaque(false);
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        secondary.add(repeatPassword);
        secondary.add(repeatPasswordField);
        secondary.add(changeButton);
        secondary.add(new JLabel());
        secondary.add(errorLabel);
        secondary.add(successLabel);
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
        errorLabel.setText("");
        successLabel.setText("");
        capacityF.setText("");
        teacherAddToCoursesPanelSecondary.add(courseNameL);
        teacherAddToCoursesPanelSecondary.add(courseNameC);
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
        teacherAddToCoursesPanelSecondary.add(successLabel);
        teacherAddToCoursesPanelSecondary.setPreferredSize(new Dimension(350, 300));
        teacherAddToCoursesPanel.add(teacherAddToCoursesPanelSecondary, constraints);
        JPanel prerequisitesPanel = new JPanel(new BorderLayout());
        prerequisitesPanel.setOpaque(false);
        JLabel prerequisitesLabel = new JLabel("Select the prerequisites:");
        prerequisitesLabel.setFont(barFont);
        prerequisitesPanel.add(prerequisitesLabel, BorderLayout.NORTH);
        prerequisitesPanel.add(prerequisiteSubjects, BorderLayout.CENTER);
        constraints.gridx = 1;
        prerequisiteSubjects.clearSelection();
        teacherAddToCoursesPanel.add(prerequisiteSubjects, constraints);
        constraints.gridx = 0;
    }

    /**
     * Creates the admin panel and its different sections
     */
    public void setAdminPanel() {

//        Creating the initial admin panel here
        adminPanel = new ImageJPanel("Project Files\\Pictures\\white-technology-2K-wallpaper.jpg");
        adminPanel.setLayout(new BorderLayout());
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
        JLabel adminUserName = new JLabel(administrator.getUserName());
        adminUserName.setFont(mainFont);
        JLabel password = new JLabel("Password:");
        password.setFont(mainFont);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:
                workingMember.getPassword()) {
            stringBuilder.append(c);
        }
        JLabel adminPassword = new JLabel(stringBuilder.toString());
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
        newUsernameField.setText("");
        newPasswordField.setText("");
        errorLabel.setText("");
        successLabel.setText("");
        JPanel secondary = new JPanel(new GridLayout(5, 2, 5, 5));
        secondary.setOpaque(false);
        secondary.add(newUsername);
        secondary.add(newUsernameField);
        secondary.add(newPassword);
        secondary.add(newPasswordField);
        secondary.add(repeatPassword);
        secondary.add(repeatPasswordField);
        secondary.add(changeButton);
        secondary.add(new JLabel());
        secondary.add(errorLabel);
        secondary.add(successLabel);
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
        JLabel lunch = new JLabel("Lunch");
        lunch.setFont(mainFont);
        JLabel dinner = new JLabel("Dinner");
        dinner.setFont(mainFont);
        adminRefectoryPanelSecondary.add(new JLabel());
        adminRefectoryPanelSecondary.add(lunch);
        JLabel priceLabel1 = new JLabel("Price");
        priceLabel1.setFont(mainFont);
        adminRefectoryPanelSecondary.add(priceLabel1);
        adminRefectoryPanelSecondary.add(dinner);
        JLabel priceLabel2 = new JLabel("Price");
        priceLabel2.setFont(mainFont);
        adminRefectoryPanelSecondary.add(priceLabel2);
        String day;
        for (int i = 0; i < 7; ++i) {
            switch (i) {
                case 0:
                    day = "Mon";
                    break;
                case 1:
                    day = "Tue";
                    break;
                case 2:
                    day = "Wed";
                    break;
                case 3:
                    day = "Thu";
                    break;
                case 4:
                    day = "Fri";
                    break;
                case 5:
                    day = "Sat";
                    break;
                default:
                    day = "Sun";
                    break;
            }
            adminRefectoryPanelSecondary.add(new JLabel(day));
            adminRefectoryPanelSecondary.add(meals[i][0]);
            adminRefectoryPanelSecondary.add(mealPrices[i][0]);
            adminRefectoryPanelSecondary.add(meals[i][1]);
            adminRefectoryPanelSecondary.add(mealPrices[i][1]);
        }
        adminRefectoryPanelSecondary.add(setButton);
        errorLabel.setText("");
        successLabel.setText("");
        adminRefectoryPanelSecondary.add(errorLabel);
        adminRefectoryPanelSecondary.add(successLabel);
        adminRefectoryPanel.add(adminRefectoryPanelSecondary, BorderLayout.CENTER);

    }

    /**
     * Creates the admin student and teacher panel
     */
    public void setAdminSTPanel() {

        JPanel scrollPanePanel = new ImageJPanel("Project Files\\Pictures\\white-technology-2K-wallpaper.jpg");
        scrollPanePanel.setLayout(new BorderLayout(10, 10));
        scrollPanePanel.setOpaque(false);
        JPanel studentsList = new JPanel();
        studentsList.setLayout(new BoxLayout(studentsList, BoxLayout.PAGE_AXIS));
        prepareStudentListItems(studentsList, students);
        TitledBorder border1 = new TitledBorder(adminCommonBorder);
        border1.setTitle("Students");
        border1.setTitleFont(mainFont);
        JScrollPane pane1 = new JScrollPane(studentsList);
        pane1.setPreferredSize(new Dimension(210, 400 ));
        pane1.setBorder(border1);
        JPanel teachersList = new JPanel();
        teachersList.setLayout(new BoxLayout(teachersList, BoxLayout.PAGE_AXIS));
        prepareTeacherListItems(teachersList);
        TitledBorder border2 = new TitledBorder(adminCommonBorder);
        border2.setTitle("Teachers");
        border2.setTitleFont(mainFont);
        JScrollPane pane2 = new JScrollPane(teachersList);
        pane2.setPreferredSize(new Dimension(210, 400 ));
        pane2.setBorder(border2);
        JPanel coursesList = new JPanel();
        coursesList.setLayout(new BoxLayout(coursesList, BoxLayout.PAGE_AXIS));
        prepareCourseListItems(coursesList, courses);
        TitledBorder border3 = new TitledBorder(adminCommonBorder);
        border3.setTitle("Courses");
        border3.setTitleFont(mainFont);
        JScrollPane pane3 = new JScrollPane(coursesList);
        pane3.setPreferredSize(new Dimension(210, 400 ));
        pane3.setBorder(border3);
        JPanel scrollPanePanelCentre = new JPanel(new FlowLayout());
        scrollPanePanelCentre.setOpaque(false);
        scrollPanePanelCentre.add(pane1);
        scrollPanePanelCentre.add(pane2);
        scrollPanePanelCentre.add(pane3);
        JPanel credentialsPanel = new JPanel(new GridBagLayout());
        credentialsPanel.setOpaque(false);
        JPanel credentialsPanelSecondary = new JPanel(new GridLayout(4, 2));
        credentialsPanelSecondary.setOpaque(false);
        JLabel unLabel = new JLabel("Username:");
        unLabel.setFont(mainFont);
        JLabel psLabel = new JLabel("Password:");
        psLabel.setFont(mainFont);
        newUsernameField.setText("");
        newPasswordField.setText("");
        errorLabel.setText("");
        successLabel.setText("");
        credentialsPanelSecondary.add(unLabel);
        credentialsPanelSecondary.add(newUsernameField);
        credentialsPanelSecondary.add(psLabel);
        credentialsPanelSecondary.add(newPasswordField);
        credentialsPanelSecondary.add(addAsStudentButton);
        credentialsPanelSecondary.add(addAsTeacherButton);
        credentialsPanelSecondary.add(errorLabel);
        credentialsPanelSecondary.add(successLabel);
        credentialsPanel.add(credentialsPanelSecondary, constraints);
        scrollPanePanel.add(scrollPanePanelCentre, BorderLayout.CENTER);
        scrollPanePanel.add(credentialsPanel, BorderLayout.SOUTH);
        adminSTPanel = new JScrollPane();
        JViewport viewport = new JViewport();
        viewport.setView(scrollPanePanel);
        adminSTPanel.setViewport(viewport);
        adminSTPanel.setOpaque(false);
    }

    private void prepareCourseListItems(JPanel mainPanel, HashMap<Course, Float> courseItems) {
        for (Map.Entry<Course, Float> course:
                courseItems.entrySet()) {
            JPanel courseThumbnail = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            courseThumbnail.setMinimumSize(new Dimension(200, 80));
            courseThumbnail.setBorder(studentCommonBorder);
            courseThumbnail.add(new JLabel("Subject: " + course.getKey().getSubject() + ""));
            courseThumbnail.add(new JLabel("Teacher: " + course.getKey().getTeacher().getUserName()));
            courseThumbnail.add(new JLabel("Attendants: " + course.getKey().getAttendants() + ""));
            courseThumbnail.add(new JLabel("Grade: " + course.getValue()));
            mainPanel.add(courseThumbnail);
        }
    }

    private void prepareCourseListItems(JPanel mainPanel, ArrayList<Course> courseItems) {
        for (Course course:
                courseItems) {
            JPanel courseThumbnail = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            courseThumbnail.setMinimumSize(new Dimension(150, 80));
            courseThumbnail.setBorder(studentCommonBorder);
            courseThumbnail.add(new JLabel("Subject: " + course.getSubject() + ""));
            courseThumbnail.add(new JLabel("Teacher: " + course.getTeacher().getUserName()));
            courseThumbnail.add(new JLabel("Attendants: " + course.getAttendants() + ""));
            mainPanel.add(courseThumbnail);
        }
    }

    private void prepareCourseListItemsWithActions(JPanel mainPanel, ArrayList<Course> courseItems) {
        for (Course course:
                courseItems) {
            JPanel courseThumbnail = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
            courseThumbnail.setBorder(studentCommonBorder);
            courseThumbnail.setMinimumSize(new Dimension(300, 50));
            courseThumbnail.add(new JLabel("Subject: " + course.getSubject() + ""));
            courseThumbnail.add(new JLabel("Teacher: " + course.getTeacher().getUserName()));
            courseThumbnail.add(new JLabel("Attendants: " + course.getAttendants() + ""));
            if(workingMember instanceof Teacher) {
                JButton close = new JButton("Close");
                close.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Course removedCourse = null;
                        for (Course crs:
                                courses) {
                            if(crs.equals(course)) {
                                removedCourse = crs;
                            }
                        }
                        if(removedCourse != null) {
                            for (Student student:
                                    removedCourse.getCourseStudents()) {
                                student.addToPastCourses(removedCourse);
                                removedCourse.getTeacher().removeCourse(removedCourse);
                            }
                            courses.remove(removedCourse);
                            setTeacherPanel();
                            setTeacherMainBoard();
                            teacherPanel.add(teacherMainPanel, BorderLayout.CENTER);
                            frame.setContentPane(teacherPanel);
                            frame.revalidate();
                            try {
                                saver.writeCourses(courses);
                                saver.writeStudents(students);
                                saver.writeTeachers(teachers);
                                errorLabel.setText("");
                                successLabel.setText("Successfully closed");
                            } catch (IOException ex) {
                                errorLabel.setText("Failed, try reopening the app");
                                successLabel.setText("");
                            }
                        }
                    }
                });
                courseThumbnail.add(close);
                JButton viewStudents = new JButton("View Students");
                viewStudents.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        courseStudents.setLayout(new BoxLayout(courseStudents, BoxLayout.PAGE_AXIS));
                        prepareStudentListItemsWithActions(courseStudents, course);
                        setTeacherPanel();
                        setTeacherMainBoard();
                        teacherPanel.add(teacherMainPanel, BorderLayout.CENTER);
                        frame.setContentPane(teacherPanel);
                        frame.revalidate();
                    }
                });
                courseThumbnail.add(viewStudents);
            }
            else if(workingMember instanceof Student) {
                JButton viewDetails = new JButton("View Details");
                viewDetails.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        courseDescription.setText(course.getDescription());
                    }
                });
                courseThumbnail.add(viewDetails);
                JButton addCourse = new JButton("Enroll");
                addCourse.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Student student = (Student) workingMember;
                        if(student.getAverage() < 17 && student.getCurrentCredits() + course.getCredits() > 20
                                || student.getAverage() >= 17 && student.getCurrentCredits() + course.getCredits() > 24) {
                            errorLabel.setText("Credits number exceeds");
                            successLabel.setText("");
                            return;
                        }
                        if(course.getCapacity() - course.getAttendants() == 0) {
                            errorLabel.setText("No room for new students");
                            successLabel.setText("");
                            return;
                        }
                        if(isPreviouslyTaken(course, student)) {
                            errorLabel.setText("You have previously taken this course");
                            successLabel.setText("");
                            return;
                        }
                        if(!isPrerequisitesTaken(course, student)) {
                            errorLabel.setText("Prerequisites needed");
                            successLabel.setText("");
                            return;
                        }
                        if(isTimeFilled(student, course)) {
                            errorLabel.setText("Time is filled");
                            successLabel.setText("");
                            return;
                        }
                        student.addToCourses(course);
                        course.addStudent(student);
                        setStudentPanel();
                        setCreditSelectionPanel();
                        studentPanel.add(creditSelectionPanel, BorderLayout.CENTER);
                        frame.setContentPane(studentPanel);
                        frame.revalidate();
                        try {
                            saver.writeStudents(students);
                            saver.writeCourses(courses);
                            saver.writeTeachers(teachers);
                        } catch (IOException ex) {
                            errorLabel.setText("Failed, try reopening the app");
                            successLabel.setText("");
                            return;
                        }
                        errorLabel.setText("");
                        successLabel.setText("Successfully added to ye' courses");
                    }
                });
                courseThumbnail.add(addCourse);
            }
            mainPanel.add(courseThumbnail);
        }
    }

    private void prepareStudentListItems(JPanel mainPanel, ArrayList<Student> studentItems) {
        for (Student student:
                studentItems) {
            JPanel courseThumbnail = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            courseThumbnail.setBorder(studentCommonBorder);
            courseThumbnail.setMaximumSize(new Dimension(200, 50));
            courseThumbnail.add(new JLabel("Username: " + student.getUserName() + ""));
            courseThumbnail.add(new JLabel("Average: " + student.getAverage() + ""));
            mainPanel.add(courseThumbnail);
        }
    }

    private void prepareStudentListItemsWithActions(JPanel mainPanel, Course selectedCourse) {
        mainPanel.removeAll();
        for (Student student:
                selectedCourse.getCourseStudents()) {
            Student std = null;
            for (Student stu:
                 students) {
                if(stu.equals(student))
                    std = stu;
            }
            JPanel courseThumbnail = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
            courseThumbnail.setMinimumSize(new Dimension(300, 50));
            courseThumbnail.setBorder(studentCommonBorder);
            courseThumbnail.add(new JLabel("Username: " + student.getUserName() + ""));
            courseThumbnail.add(new JLabel("Average: " + student.getAverage() + ""));
            if(std != null)
                for (Course crs:
                     courses) {
                    if(crs.equals(selectedCourse))
                        courseThumbnail.add(new JLabel("Grade: " + std.getStudentCourses().get(crs) + ""));
                }
            courseThumbnail.add(new JLabel("Grade this student: "));
            JTextField grade = new JTextField();
            grade.setPreferredSize(new Dimension(30, 30));
            grade.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        float mark = Float.parseFloat(grade.getText());
                        if(mark < 0 || mark > 20)
                            throw new NumberFormatException();
                        Student std1 = null;
                        for (Student stu:
                                students) {
                            if(stu.equals(student))
                                std1 = stu;
                        }
                        if(std1 != null)
                            for (Course crs:
                                    courses) {
                                if(crs.equals(selectedCourse))
                                    std1.getStudentCourses().put(crs, mark);
                            }
                        saver.writeStudents(students);
                        saver.writeTeachers(teachers);
                        saver.writeCourses(courses);
                        successLabel.setText("Successfully done");
                        errorLabel.setText("");
                    } catch (NumberFormatException ex) {
                        errorLabel.setText("Wrong grade entered");
                        successLabel.setText("");
                    } catch (IOException ex) {
                        errorLabel.setText("Failed, try reopening the app");
                    }
                }
            });
            courseThumbnail.add(grade);
            mainPanel.add(courseThumbnail);
        }
    }

    private void prepareTeacherListItems(JPanel mainPanel) {
        for (Teacher teacher:
                teachers) {
            JPanel courseThumbnail = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            courseThumbnail.setMaximumSize(new Dimension(200, 50));
            courseThumbnail.setBorder(teacherCommonBorder);
            courseThumbnail.add(new JLabel(teacher.getUserName() + ""));
            mainPanel.add(courseThumbnail);
        }
    }

    private boolean isTimeFilled(Student student, Course course) {
        for (Course studentCourse:
                student.getStudentCourses().keySet())
            if(studentCourse.getDay() == course.getDay()
                    && studentCourse.getTime() == course.getTime())
                return true;
        return false;
    }

    private boolean isPrerequisitesTaken(Course selectedCourse, Student student) {
        boolean isPassed;
        boolean qualified = true;
        HashSet<Subjects> takenSubjects = new HashSet<>();
        for (Course course:
                student.getPastCourses().keySet()) {
            takenSubjects.add(course.getSubject());
        }
        for (Course course:
                student.getStudentCourses().keySet()) {
            takenSubjects.add(course.getSubject());
        }
        if(selectedCourse.getPrerequisites() != null && selectedCourse.getPrerequisites().size() != 0)
            for (Subjects subject:
                    selectedCourse.getPrerequisites()) {
                isPassed = false;
                for (Subjects pastSubject:
                        takenSubjects)
                    if(subject.equals(pastSubject)) {
                        isPassed = true;
                        break;
                    }
                qualified &= isPassed;
            }
        return qualified;
    }

    private boolean isPreviouslyTaken(Course selectedCourse, Student student) {
        for (Course studentPastCourse:
                student.getPastCourses().keySet()) {
            if(selectedCourse.getSubject() == studentPastCourse.getSubject()) {
                return true;
            }
        }
        for (Course studentCourse:
                student.getStudentCourses().keySet()) {
            if(selectedCourse.getSubject() == studentCourse.getSubject()) {
                return true;
            }
        }
        return false;
    }

    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(usernameField) || e.getSource().equals(passwordField)
                    || e.getSource().equals(enterButton)) {
                int entranceMode = comboBox.getSelectedIndex();
                switch (entranceMode) {
                    case 0:
                        workingMember = administrator;
                        if (workingMember.getUserName().equals(usernameField.getText())
                                && isPasswordCorrect(workingMember.getPassword(), passwordField.getPassword())) {
                            errorLabel.setText("");
                            ui.setAdminPanel();
                            ui.setAdminMainBoard();
                            adminPanel.add(adminMainPanel, BorderLayout.CENTER);
                            frame.setContentPane(adminPanel);
                        } else errorLabel.setText("Invalid username or password");
                        break;
                    case 1:
                        Teacher member = new Teacher(usernameField.getText(), new char[0]);
                        for (Teacher teacher :
                                teachers) {
                            if (teacher.equals(member)) {
                                workingMember = teacher;
                                break;
                            }
                        }
                        if (workingMember != null && workingMember instanceof Teacher && isPasswordCorrect(workingMember.getPassword(), passwordField.getPassword())) {
                            errorLabel.setText("");
                            ui.setTeacherPanel();
                            ui.setTeacherMainBoard();
                            teacherPanel.add(teacherMainPanel, BorderLayout.CENTER);
                            frame.setContentPane(teacherPanel);
                        } else errorLabel.setText("Invalid username or password");
                        break;
                    case 2:
                        Student current = new Student(usernameField.getText(), new char[0]);
                        for (Student student :
                                students) {
                            if (student.equals(current)) {
                                workingMember = student;
                                break;
                            }
                        }
                        if (workingMember != null && workingMember instanceof Student && isPasswordCorrect(workingMember.getPassword(), passwordField.getPassword())) {
                            errorLabel.setText("");
                            ui.setStudentPanel();
                            ui.setStudentMainBoard();
                            studentPanel.add(studentMainPanel, BorderLayout.CENTER);
                            frame.setContentPane(studentPanel);
                        } else errorLabel.setText("Invalid username or password");
                }
            }
            else if(e.getSource().equals(changeButton)) {
                String newUsername = newUsernameField.getText();
                char[] newPassword = newPasswordField.getPassword();
                if(!newUsername.equals("")) {
                    if (workingMember instanceof Student)
                        for (Student student :
                                students)
                            if (student.getUserName().equals(newUsername) && student != workingMember) {
                                errorLabel.setText("Username already in use");
                                frame.revalidate();
                            }
                    else if (workingMember instanceof Teacher)
                        for (Teacher teacher :
                                teachers)
                            if (teacher.getUserName().equals(newUsername) && teacher != workingMember) {
                                errorLabel.setText("Username already in use");
                                frame.revalidate();
                            }
                }
                if(newPassword.length < 8) {
                    errorLabel.setText("Password not long enough");
                    successLabel.setText("");
                }
                else if(!isPasswordCorrect(newPassword, repeatPasswordField.getPassword())) {
                    errorLabel.setText("Password entries do not match");
                    successLabel.setText("");
                }
                else if(isPasswordCorrect(workingMember.getPassword(), newPassword)) {
                    errorLabel.setText("New password matches the previous one");
                    successLabel.setText("");
                }
                else {
                    if(!newUsername.equals(""))
                        workingMember.setUserName(newUsername);
                    workingMember.setPassword(newPassword);
                    try {
                        if(workingMember instanceof Student)
                            saver.writeStudents(students);
                        else if(workingMember instanceof Teacher)
                            saver.writeTeachers(teachers);
                        else saver.writeAdmin(administrator);
                    } catch (IOException ex) {
                        errorLabel.setText("Failed, try reopening the app");
                        successLabel.setText("");
                    }
                    errorLabel.setText("");
                    successLabel.setText("Successfully set");
                }
                newUsernameField.setText("");
                newPasswordField.setText("");
                repeatPasswordField.setText("");

            }
            else if(e.getSource().equals(setButton)) {

                String[][] refectorySchedule1 = new String[7][2];
                float[][] refectoryPrices1 = new float[7][2];

                try {
                    for (int i = 0; i < 7; ++i)
                        for (int j = 0; j < 2; ++j) {
                            refectorySchedule1[i][j] = meals[i][j].getText();
                            refectoryPrices1[i][j] = Float.parseFloat(mealPrices[i][j].getText());
                            if(refectoryPrices1[i][j] <= 0)
                                throw new NumberFormatException();
                        }
                } catch(NumberFormatException ex) {
                    errorLabel.setText("Wrong or empty entry");
                    successLabel.setText("");
                    frame.revalidate();
                    return;
                }
                refectorySchedule = refectorySchedule1;
                for (Student student:
                        students) {
                    student.clearScheduledMeals();
                }
                try {
                    saver.writeRefectorySchedule(refectorySchedule);
                    saver.writeRefectoryPrices(refectoryPrices1);
                    saver.writeStudents(students);
                } catch (IOException ex) {
                    errorLabel.setText("Failed, try reopening the app");
                    successLabel.setText("");
                    return;
                }
                errorLabel.setText("");
                successLabel.setText("Successfully Set");
            }
            else if(e.getSource().equals(addAsStudentButton) || e.getSource().equals(addAsTeacherButton)) {
                if (newUsernameField.getText().length() == 0 || newPasswordField.getPassword().length < 8) {
                    errorLabel.setText("Insufficient fields");
                    successLabel.setText("");
                    frame.revalidate();
                    return;
                }
                else {
                    String newUN = newUsernameField.getText();
                    char[] newPS = newPasswordField.getPassword();
                    if(e.getSource().equals(addAsStudentButton) && doesStudentExist(newUN)
                            || e.getSource().equals(addAsTeacherButton) && doesTeacherExist(newUN)) {
                        errorLabel.setText("Username already in use");
                        successLabel.setText("");
                        frame.revalidate();
                        return;
                    }
                    else {
                        if(e.getSource().equals(addAsStudentButton)) {
                            students.add(new Student(newUN, newPS));
                            try {
                                saver.writeStudents(students);
                            } catch (IOException ex) {
                                errorLabel.setText("Failed, try reopening the app");
                                successLabel.setText("");
                                return;
                            }
                        }
                        else {
                            teachers.add(new Teacher(newUN, newPS));
                            try {
                                saver.writeTeachers(teachers);
                            } catch (IOException ex) {
                                errorLabel.setText("Failed, try reopening the app");
                                successLabel.setText("");
                                return;
                            }
                        }
                        errorLabel.setText("");
                        successLabel.setText("Successfully added");
                    }
                }
            }
            else if(e.getSource().equals(teacherAddCourse)) {
                if(capacityF.getText().length() == 0) {
                    successLabel.setText("");
                    errorLabel.setText("Capacity not set");
                    return;
                }
                Teacher teacher = (Teacher) workingMember;
                for (Course current:
                        teacher.getTeacherCourses()) {
                    if(current.getDay() == daysC.getItemAt(daysC.getSelectedIndex())
                            && current.getTime() == timesC.getItemAt(timesC.getSelectedIndex())) {
                        successLabel.setText("");
                        errorLabel.setText("This time is filled");
                        return;
                    }
                }
                try {
                    Course newCourse = new Course();
                    newCourse.setCredits(creditsC.getSelectedIndex() + 1);
                    newCourse.setCapacity(Integer.parseInt(capacityF.getText()));
                    newCourse.setDay(daysC.getItemAt(daysC.getSelectedIndex()));
                    newCourse.setTime(timesC.getItemAt(timesC.getSelectedIndex()));
                    newCourse.setSubject(courseNameC.getItemAt(courseNameC.getSelectedIndex()));
                    newCourse.setPrerequisites(new ArrayList<>(prerequisiteSubjects.getSelectedValuesList()));
                    newCourse.setTeacher(teacher);
                    newCourse.setDescription();
                    courses.add(newCourse);
                    teacher.addToCourses(newCourse);
                    saver.writeTeachers(teachers);
                    saver.writeCourses(courses);
                    errorLabel.setText("");
                    successLabel.setText("Successfully Added");
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Wrong data form");
                    successLabel.setText("");
                } catch (IOException ex) {
                    errorLabel.setText("Failed, try reopening the app");
                    successLabel.setText("");
                }
            }
            else if(e.getSource().equals(purchaseBalanceB)) {
                if(cardNumberT.getText().length() != 16) {
                    errorLabel.setText("Invalid card number");
                    successLabel.setText("");
                    return;
                }
                for (char c:
                        cardNumberT.getText().toCharArray()) {
                    if(c < '0' || c > '9') {
                        errorLabel.setText("Wrong card number");
                        successLabel.setText("");
                        return;
                    }
                }
                try {
                    float balance = Float.parseFloat(balanceT.getText());
                    if (balance <= 0 || balance > 100) {
                        errorLabel.setText("Invalid balance");
                        successLabel.setText("");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Invalid balance");
                    successLabel.setText("");
                    return;
                }
                if(passwordF.getPassword().length != 4) {
                    errorLabel.setText("Wrong password");
                    successLabel.setText("");
                    return;
                }
                Student student = (Student) workingMember;
                student.setBalance(student.getBalance() + Float.parseFloat(balanceT.getText()));
                try {
                    saver.writeStudents(students);
                } catch (IOException ex) {
                    errorLabel.setText("Failed, try reopening the app");
                    successLabel.setText("");
                    return;
                }
                errorLabel.setText("");
                successLabel.setText("Successfully processed");
            }
            else if(e.getSource().equals(reserveButton)) {
                Student student = (Student) workingMember;
                for (int i = 0; i < 7; ++i) {
                    for (int j = 0; j < 2; ++j) {
                        if(checkBoxes[i][j].isSelected()) {
                            if(student.getScheduledMeals()[i][j]) {
                                errorLabel.setText("Meal already reserved");
                                successLabel.setText("");
                            } else if(Float.parseFloat(mealPrices[i][j].getText()) > student.getBalance()) {
                                errorLabel.setText("Not enough balance");
                                successLabel.setText("");
                                return;
                            } else {
                                student.addToReserved(i, j, Float.parseFloat(mealPrices[i][j].getText()));
                                errorLabel.setText("");
                                successLabel.setText("Successfully Processed");
                            }
                        } else student.removeReserved(i, j, Float.parseFloat(mealPrices[i][j].getText()));
                    }
                }
                try {
                    saver.writeStudents(students);
                } catch (IOException ex) {
                    errorLabel.setText("Failed, try reopening the app");
                    successLabel.setText("");
                    return;
                }
            }

            frame.revalidate();
        }

        private boolean doesStudentExist(String username) {
            for (Student student:
                    students) {
                if(student.getUserName().equals(username))
                    return true;
            }
            return false;
        }

        private boolean doesTeacherExist(String username) {
            for (Teacher teacher:
                    teachers) {
                if(teacher.getUserName().equals(username))
                    return true;
            }
            return false;
        }

        private boolean isPasswordCorrect(char[] password, char[] input) {
            if(input.length != password.length)
                return false;
            return Arrays.equals(password, input);
        }

    }

    private class MouseHandler extends MouseAdapter {

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

            }
            else if(interactedLabel.equals(changeUNAndPW)) {
                studentPanel.removeAll();
                setStudentPanel();
                setStudentUNPSPanel();
                studentPanel.add(UNPSPanel, BorderLayout.CENTER);
                studentPanel.revalidate();
                frame.setContentPane(studentPanel);

            }
            else if(interactedLabel.equals(purchaseBalance)) {
                studentPanel.removeAll();
                setStudentPanel();
                setBalancePanel();
                studentPanel.add(balancePanel, BorderLayout.CENTER);
                studentPanel.revalidate();
                frame.setContentPane(studentPanel);

            }
            else if(interactedLabel.equals(reserve)) {
                studentPanel.removeAll();
                setStudentPanel();
                try {
                    setStudentReservationPanel();
                    studentPanel.add(reservationPanel, BorderLayout.CENTER);
                } catch (IndexOutOfBoundsException ex) {
                    JLabel label = new JLabel("No refectory Schedule available at this moment, try again later...");
                    label.setFont(mainFont);
                    label.setForeground(studentColour);
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    studentPanel.add(label, BorderLayout.CENTER);
                }
                studentPanel.revalidate();
                frame.setContentPane(studentPanel);

            }
            else if(interactedLabel.equals(selectCredits)) {
                studentPanel.removeAll();
                setStudentPanel();
                setCreditSelectionPanel();
                studentPanel.add(creditSelectionPanel, BorderLayout.CENTER);
                studentPanel.repaint();
                frame.setContentPane(studentPanel);

            }
            else if(interactedLabel.equals(teacherMainB)) {
                teacherPanel.removeAll();
                setTeacherPanel();
                setTeacherMainBoard();
                teacherPanel.add(teacherMainPanel, BorderLayout.CENTER);
                teacherPanel.repaint();
                frame.setContentPane(teacherPanel);

            }
            else if(interactedLabel.equals(teacherChangeUNAndPW)) {
                teacherPanel.removeAll();
                setTeacherPanel();
                setTeacherUNPSPanel();
                teacherPanel.add(teacherUNPSPanel, BorderLayout.CENTER);
                teacherPanel.repaint();
                frame.setContentPane(teacherPanel);

            }
            else if(interactedLabel.equals(teacherAddToCoursesB)) {
                teacherPanel.removeAll();
                setTeacherPanel();
                setCourseCreationPanel();
                teacherPanel.add(teacherAddToCoursesPanel, BorderLayout.CENTER);
                teacherPanel.repaint();
                frame.setContentPane(teacherPanel);

            }
            else if(interactedLabel.equals(adminMainB)) {
                adminPanel.removeAll();
                setAdminPanel();
                setAdminMainBoard();
                adminPanel.add(adminMainPanel, BorderLayout.CENTER);
                adminPanel.repaint();
                frame.setContentPane(adminPanel);

            }
            else if(interactedLabel.equals(adminChangeUNAndPW)) {
                adminPanel.removeAll();
                setAdminPanel();
                setAdminUNPSPanel();
                adminPanel.add(adminUNPSPanel, BorderLayout.CENTER);
                adminPanel.repaint();
                frame.setContentPane(adminPanel);

            }
            else if(interactedLabel.equals(adminRefectoryB)) {
                adminPanel.removeAll();
                setAdminPanel();
                setAdminRefectoryPanel();
                adminPanel.add(adminRefectoryPanel, BorderLayout.CENTER);
                adminPanel.repaint();
                frame.setContentPane(adminPanel);

            }
            else if(interactedLabel.equals(adminSTB)) {
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