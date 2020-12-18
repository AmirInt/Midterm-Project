import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

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
    private Color studentColour;
    private Color teacherColour;
    private Color adminColour;
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
    private JList<Course> currentCredits;
    private JList<Student> courseStudents;
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
    private JButton addCreditButton;
    private JTextArea courseDescription;
    private JList<Course> presentCreditsList;

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
                this.mealPrices[i][j].setOpaque(false);
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
                meals[i][j].setOpaque(false);
            }
        }


//        Setting some common attributes in the programme
        studentColour = new Color(30, 90, 20);
        teacherColour = new Color(170, 60, 10);
        adminColour = new Color(30, 50, 150);
        barFont = new Font("", Font.BOLD, 12);
        mainFont = new Font("", Font.PLAIN, 20);
        studentCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(studentColour, 2),
                "Credentials", 4, 0, mainFont);
        teacherCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(teacherColour, 2),
                "Credentials", 4, 0, mainFont);
        adminCommonBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(adminColour, 2),
                "Credentials", 4, 0, mainFont);

        EventHandler eventHandler = new EventHandler();
        mouseHandler = new MouseHandler();
        ListSelectionHandler listSelectionHandler = new ListSelectionHandler();

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

        addCreditButton = new JButton("Add This Course");
        addCreditButton.setFont(mainFont);
        addCreditButton.addActionListener(eventHandler);

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

        teacherAddCourse = new JButton("Add");
        teacherAddCourse.setFont(mainFont);
        teacherAddCourse.addActionListener(eventHandler);

        addAsStudentButton = new JButton("Add As Student");
        addAsStudentButton.setFont(mainFont);
        addAsStudentButton.addActionListener(eventHandler);
        addAsTeacherButton = new JButton("Add As Teacher");
        addAsTeacherButton.setFont(mainFont);
        addAsTeacherButton.addActionListener(eventHandler);

        currentCredits = new JList<>();
        TitledBorder border1 = new TitledBorder(teacherCommonBorder);
        border1.setTitle("Current Credits");
        border1.setTitleFont(mainFont);
        currentCredits.setBorder(border1);
        currentCredits.setPreferredSize(new Dimension(250, 350));
        currentCredits.setOpaque(false);
        currentCredits.setFont(mainFont);
        currentCredits.setSelectionBackground(new Color(120, 120, 50));
        currentCredits.setSelectionForeground(Color.WHITE);
        currentCredits.addListSelectionListener(listSelectionHandler);
        courseStudents = new JList<>();
        TitledBorder border2 = new TitledBorder(teacherCommonBorder);
        courseStudents.setFont(mainFont);
        border2.setTitle("Course Students");
        border2.setTitleFont(mainFont);
        courseStudents.setBorder(border2);
        courseStudents.setPreferredSize(new Dimension(250, 350));
        courseStudents.setOpaque(false);
        courseStudents.setSelectionBackground(studentColour);
        courseStudents.setSelectionForeground(Color.WHITE);
        prerequisiteSubjects = new JList<>(Subjects.values());
        prerequisiteSubjects.setFont(mainFont);
        prerequisiteSubjects.setSelectionForeground(Color.WHITE);
        prerequisiteSubjects.setSelectionBackground(new Color(120, 120, 50));
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
        presentCreditsList = new JList<>(courses.toArray(new Course[0]));
        presentCreditsList.addListSelectionListener(listSelectionHandler);

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
        studentPanel.setLayout(new BorderLayout());
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
        JPanel studentMainPanelTertiary = new JPanel(new GridLayout(2, 1));
        studentMainPanelTertiary.setOpaque(false);
        JList<Course> currentCredits = new JList<>(student.getStudentCourses().keySet().toArray(new Course[0]));
        currentCredits.setOpaque(false);
        TitledBorder border = new TitledBorder(studentCommonBorder);
        border.setTitle("Current credits");
        border.setTitleFont(mainFont);
        currentCredits.setBorder(border);
        currentCredits.setFont(mainFont);
        currentCredits.setSelectionBackground(studentColour);
        currentCredits.setSelectionForeground(Color.WHITE);
        JList<Course> pastCredits = new JList<>(student.getPastCourses().keySet().toArray(new Course[0]));
        pastCredits.setOpaque(false);
        TitledBorder border1 = new TitledBorder(studentCommonBorder);
        border1.setTitle("Past credits");
        border1.setTitleFont(mainFont);
        pastCredits.setBorder(border1);
        pastCredits.setSelectionForeground(Color.WHITE);
        pastCredits.setSelectionBackground(studentColour);
        studentMainPanelTertiary.add(currentCredits);
        studentMainPanelTertiary.add(pastCredits);
        studentMainPanel.add(studentMainPanelSecondary);
        studentMainPanel.add(studentMainPanelTertiary);
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
        creditSelectionPanelSecondary.add(addCreditButton, constraints);
        constraints.gridy = 2;
        creditSelectionPanelSecondary.add(errorLabel, constraints);
        constraints.gridy = 3;
        creditSelectionPanelSecondary.add(successLabel, constraints);
        constraints.gridy = 0;
        creditSelectionPanel.add(creditSelectionPanelSecondary);
        presentCreditsList.setListData(courses.toArray(new Course[0]));
        presentCreditsList.setOpaque(false);
        presentCreditsList.setFont(mainFont);
        presentCreditsList.setSelectionBackground(studentColour);
        presentCreditsList.setSelectionForeground(Color.WHITE);
        presentCreditsList.clearSelection();
        TitledBorder border1 = new TitledBorder(studentCommonBorder);
        border1.setTitleFont(mainFont);
        border1.setTitle("Present courses");
        presentCreditsList.setBorder(border1);
        creditSelectionPanel.add(presentCreditsList);
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
        teacherMainPanelSecondary.setBorder(teacherCommonBorder);
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
        JPanel teacherMainPanelTertiary = new JPanel(new GridBagLayout());
        teacherMainPanelTertiary.setOpaque(false);
        JButton removeThisCourseB = new JButton("Remove this course");
        removeThisCourseB.setPreferredSize(new Dimension(160, 40));
        JTextField gradeF = new JTextField();
        gradeF.setPreferredSize(new Dimension(60, 30));
        JButton gradeThisStB = new JButton("Grade this student");
        gradeThisStB.setPreferredSize(new Dimension(160, 40));
        Teacher thisTeacher = (Teacher) workingMember;
        courseStudents.clearSelection();
        courseStudents.setListData(new Student[0]);
        currentCredits.setListData(thisTeacher.getTeacherCourses().toArray(new Course[0]));
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
        JList<Student> studentsList = new JList<>(students.toArray(new Student[0]));
        studentsList.setFont(mainFont);
        studentsList.setSelectionForeground(Color.WHITE);
        studentsList.setSelectionBackground(studentColour);
        studentsList.setOpaque(false);
        TitledBorder border1 = new TitledBorder(adminCommonBorder);
        border1.setTitle("Students");
        border1.setTitleFont(mainFont);
        studentsList.setBorder(border1);
        studentsList.setPreferredSize(new Dimension(200, 400));
        JList<Teacher> teachersList = new JList<>(teachers.toArray(new Teacher[0]));
        teachersList.setFont(mainFont);
        teachersList.setSelectionForeground(Color.WHITE);
        teachersList.setSelectionBackground(teacherColour);
        teachersList.setOpaque(false);
        TitledBorder border2 = new TitledBorder(adminCommonBorder);
        border2.setTitleFont(mainFont);
        border2.setTitle("Teachers");
        teachersList.setBorder(border2);
        teachersList.setPreferredSize(new Dimension(200, 400));
        JList<Course> coursesList = new JList<>(courses.toArray(new Course[0]));
        coursesList.setFont(mainFont);
        coursesList.setSelectionForeground(Color.WHITE);
        coursesList.setSelectionBackground(new Color(120, 120, 50));
        coursesList.setOpaque(false);
        TitledBorder border3 = new TitledBorder(adminCommonBorder);
        border3.setTitle("Courses");
        border3.setTitleFont(mainFont);
        coursesList.setBorder(border3);
        coursesList.setPreferredSize(new Dimension(200, 400));
        JPanel scrollPanePanelCentre = new JPanel(new FlowLayout());
        scrollPanePanelCentre.setOpaque(false);
        scrollPanePanelCentre.add(studentsList);
        scrollPanePanelCentre.add(teachersList);
        scrollPanePanelCentre.add(coursesList);
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
        adminSTPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        adminSTPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        adminSTPanel.setOpaque(false);

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
                        if (workingMember != null && isPasswordCorrect(workingMember.getPassword(), passwordField.getPassword())) {
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
                        if (workingMember != null && isPasswordCorrect(workingMember.getPassword(), passwordField.getPassword())) {
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
                newUsernameField.setText("");
                newPasswordField.setText("");
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
            else if(e.getSource().equals(addCreditButton)) {
                Student student = (Student) workingMember;
                Course selectedCourse = presentCreditsList.getSelectedValue();
                if(student.getAverage() < 17 && student.getCurrentCredits() + selectedCourse.getCredits() > 20
                        || student.getAverage() >= 17 && student.getCurrentCredits() + selectedCourse.getCredits() > 24) {
                    errorLabel.setText("Credits number exceeds");
                    successLabel.setText("");
                    return;
                }
                if(selectedCourse.getCapacity() - selectedCourse.getAttendants() == 0) {
                    errorLabel.setText("No room for new students");
                    successLabel.setText("");
                    return;
                }
                if(isPreviouslyTaken(selectedCourse, student)) {
                    errorLabel.setText("You have previously taken this course");
                    successLabel.setText("");
                    return;
                }
                if(!isPrerequisitesTaken(selectedCourse, student)) {
                    errorLabel.setText("Prerequisites needed");
                    successLabel.setText("");
                    return;
                }
                if(isTimeFilled(student, selectedCourse)) {
                    errorLabel.setText("Time is filled");
                    successLabel.setText("");
                    return;
                }
                student.addToCourses(selectedCourse);
                selectedCourse.addStudent(student);
                try {
                    saver.writeStudents(students);
                    saver.writeCourses(courses);
                } catch (IOException ex) {
                    errorLabel.setText("Failed, try reopening the app");
                    successLabel.setText("");
                    return;
                }
                errorLabel.setText("");
                successLabel.setText("Successfully added to ye' courses");
            }

            frame.revalidate();
        }

        private boolean isTimeFilled(Student student, Course course) {
            for (Course studentCourse:
                 student.getStudentCourses().keySet())
                if(studentCourse.getDay() == course.getDay()
                    || studentCourse.getTime() == course.getTime())
                    return true;
            return false;
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
            for (Course studentCourse:
                    student.getPastCourses().keySet()) {
                if(selectedCourse.getSubject().equals(studentCourse.getSubject())) {
                    return true;
                }
            }
            for (Course studentPastCourse:
                    student.getPastCourses().keySet()) {
                if(selectedCourse.getSubject().equals(studentPastCourse.getSubject())) {
                    return true;
                }
            }
            return false;
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

    private class ListSelectionHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getSource().equals(currentCredits)) {
                Course selectedCourse = currentCredits.getSelectedValue();
                if(selectedCourse != null)
                    courseStudents.setListData(selectedCourse.getCourseStudents().keySet().toArray(new Student[0]));
                courseStudents.repaint();
            }
            else if(e.getSource().equals(presentCreditsList)) {
                Course selectedCourse = presentCreditsList.getSelectedValue();
                if(selectedCourse != null) {
                    selectedCourse.setDescription();
                    courseDescription.setText(selectedCourse.getDescription());
                }
                courseDescription.repaint();
            }
            frame.revalidate();
        }
    }
}