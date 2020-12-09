import javax.swing.*;
import java.awt.*;

/**
 * Class UI is responsible for creating the graphical user interface
 * by creating the JFrame and the different panels for the students,
 * the teachers and the admin.
 */
public class UI extends JFrame {

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
    JButton studentMainB;
    JButton changeUNAndPW;
    JButton purchaseBalance;
    JButton reserve;
    JButton selectCredits;
    JButton studentPanelExit;
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
        setSize(740, 560);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add (setLoginPanel());
        setVisible(true);
    }

    /**
     * Creates the login panel as the starting page
     * @return the login panel it has built for further processes
     */
    public JPanel setLoginPanel() {

        JLabel entranceMode = new JLabel("Enter as: ");
        String[] comboItems = {"Admin", "Teacher", "Student"};
        comboBox = new JComboBox<>(comboItems);
        JPanel introPanel = new JPanel(new GridBagLayout());
        introPanel.add(entranceMode);
        introPanel.add(comboBox);

        creditsBoard = new JPanel();
        creditsBoard.setLayout(new GridLayout(2, 2, 5,5));
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(100, 25));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(100, 25));
        uNameLabel = new JLabel("Username:");
        uNameLabel.setPreferredSize(new Dimension(40, 25));
        passLabel = new JLabel("Password:");
        passLabel.setPreferredSize(new Dimension(40, 25));
        creditsBoard.add(uNameLabel);
        creditsBoard.add(usernameField);
        creditsBoard.add(passLabel);
        creditsBoard.add(passwordField);
        informLabel = new JLabel("Enter ye' username and password");
        errorLabel = new JLabel("");
        enterButton = new JButton("Enter");
        loginBoard = new JPanel(new BorderLayout(5, 5));
        loginBoard.add(informLabel, BorderLayout.NORTH);
        loginBoard.add(creditsBoard, BorderLayout.CENTER);
        loginBoard.add(errorLabel, BorderLayout.SOUTH);

        loginPanel = new JPanel(new BorderLayout());
        loginPanel.add(introPanel, BorderLayout.NORTH);
        JPanel secondaryPanel = new JPanel(new GridBagLayout());
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        secondaryPanel.add(loginBoard, constraints);
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        secondaryPanel.add(enterButton, constraints);
        loginPanel.add(secondaryPanel, BorderLayout.CENTER);
        return loginPanel;
    }

    /**
     * Creates the student panel and its different sections
     * @return the panel it has built for further processes
     */
    public JPanel setStudentPanel() {

//        Creating the general studentPanel here with its buttons and fields
        studentPanel = new JPanel(new BorderLayout(30, 30));
        studentMainB = new JButton("Main Panel");
        changeUNAndPW = new JButton("Change username or password");
        purchaseBalance = new JButton("Purchase balance");
        reserve = new JButton("Reserve food");
        selectCredits = new JButton("Select new credits");
        studentPanelExit = new JButton("Exit");
        JPanel exitPanel = new JPanel(new GridBagLayout());
        exitPanel.add(studentPanelExit, constraints);
        JPanel studentOptionsPanel = new JPanel(new GridLayout(20, 1));
        studentOptionsPanel.add(studentMainB);
        studentOptionsPanel.add(changeUNAndPW);
        studentOptionsPanel.add(purchaseBalance);
        studentOptionsPanel.add(reserve);
        studentOptionsPanel.add(selectCredits);
        studentPanel.add(studentOptionsPanel, BorderLayout.WEST);
        studentPanel.add(exitPanel, BorderLayout.NORTH);

//        Creating the main panel here
        studentMainPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JPanel studentMainPanelSecondary = new JPanel(new GridLayout(20, 2, 5, 5));
        studentMainPanelSecondary.setBorder(BorderFactory.createTitledBorder("Credentials:"));
        JLabel userName = new JLabel("Username: ");
        JLabel password = new JLabel("Password: ");
        JLabel average = new JLabel("Average: ");
        JLabel balance = new JLabel("Balance: ");
        studentMainPanelSecondary.add(userName);
        studentMainPanelSecondary.add(new JLabel("Username"));
        studentMainPanelSecondary.add(password);
        studentMainPanelSecondary.add(new JLabel("Password"));
        studentMainPanelSecondary.add(average);
        studentMainPanelSecondary.add(new JLabel("Average"));
        studentMainPanelSecondary.add(balance);
        studentMainPanelSecondary.add(new JLabel("Balance"));
;
        JList<Object> currentCredits = new JList<>();
        currentCredits.setPreferredSize(new Dimension(200, currentCredits.getHeight()));
        currentCredits.setBorder(BorderFactory.createTitledBorder("Current credits:"));
        studentMainPanel.add(studentMainPanelSecondary, BorderLayout.WEST);
        studentMainPanel.add(currentCredits, BorderLayout.EAST);

//        Creating the panel in charge of resetting password and username
        UNPSPanel = new JPanel(new GridBagLayout());
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
        UNPSPanel.add(secondary, constraints);

//        Creating the panel for managing balance
        balancePanel = new JPanel(new GridBagLayout());
        JPanel balancePanelSecondary = new JPanel(new GridLayout(5, 1));
        JLabel cardNumberL = new JLabel("Card number: ");
        JTextField cardNumberT = new JTextField();
        JLabel balanceL = new JLabel("Balance: ");
        JTextField balanceT = new JTextField();
        JLabel passwordL = new JLabel("Password: ");
        JPasswordField passwordF = new JPasswordField();
        JLabel noticeBalance = new JLabel("");
        JButton purchaseBalanceB = new JButton("Purchase");
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
        reservationPanel = new JPanel(new BorderLayout());
        JPanel reservationPanelSecondary = new JPanel(new GridLayout(9, 5, 20, 20));
        JLabel Mon = new JLabel("Mon");
        JLabel Tue = new JLabel("Tue");
        JLabel Wed = new JLabel("Wed");
        JLabel Thu = new JLabel("Thu");
        JLabel Fri = new JLabel("Fri");
        JLabel Sat = new JLabel("Sat");
        JLabel Sun = new JLabel("Sun");
        JLabel dinner = new JLabel("Dinner");
        JLabel lunch = new JLabel("Lunch");
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
        JCheckBox TueLunchCh = new JCheckBox();
        JCheckBox WedLunchCh = new JCheckBox();
        JCheckBox ThuLunchCh = new JCheckBox();
        JCheckBox FriLunchCh = new JCheckBox();
        JCheckBox SatLunchCh = new JCheckBox();
        JCheckBox SunLunchCh = new JCheckBox();
        JCheckBox MonDinnerCh = new JCheckBox();
        JCheckBox TueDinnerCh = new JCheckBox();
        JCheckBox WedDinnerCh = new JCheckBox();
        JCheckBox ThuDinnerCh = new JCheckBox();
        JCheckBox FriDinnerCh = new JCheckBox();
        JCheckBox SatDinnerCh = new JCheckBox();
        JCheckBox SunDinnerCh = new JCheckBox();
        JLabel balanceLabel = new JLabel("Balance");
        JButton reserveButton = new JButton("Reserve");
        reservationPanelSecondary.add(new JLabel(""));
        reservationPanelSecondary.add(lunch);
        reservationPanelSecondary.add(new JLabel(""));
        reservationPanelSecondary.add(dinner);
        reservationPanelSecondary.add(new JLabel(""));
        reservationPanelSecondary.add(Mon);
        reservationPanelSecondary.add(MonLunch);
        reservationPanelSecondary.add(MonLunchCh);
        reservationPanelSecondary.add(MonDinner);
        reservationPanelSecondary.add(MonDinnerCh);
        reservationPanelSecondary.add(Tue);
        reservationPanelSecondary.add(TueLunch);
        reservationPanelSecondary.add(TueLunchCh);
        reservationPanelSecondary.add(TueDinner);
        reservationPanelSecondary.add(TueDinnerCh);
        reservationPanelSecondary.add(Wed);
        reservationPanelSecondary.add(WedLunch);
        reservationPanelSecondary.add(WedLunchCh);
        reservationPanelSecondary.add(WedDinner);
        reservationPanelSecondary.add(WedDinnerCh);
        reservationPanelSecondary.add(Thu);
        reservationPanelSecondary.add(ThuLunch);
        reservationPanelSecondary.add(ThuLunchCh);
        reservationPanelSecondary.add(ThuDinner);
        reservationPanelSecondary.add(ThuDinnerCh);
        reservationPanelSecondary.add(Fri);
        reservationPanelSecondary.add(FriLunch);
        reservationPanelSecondary.add(FriLunchCh);
        reservationPanelSecondary.add(FriDinner);
        reservationPanelSecondary.add(FriDinnerCh);
        reservationPanelSecondary.add(Sat);
        reservationPanelSecondary.add(SatLunch);
        reservationPanelSecondary.add(SatLunchCh);
        reservationPanelSecondary.add(SatDinner);
        reservationPanelSecondary.add(SatDinnerCh);
        reservationPanelSecondary.add(Sun);
        reservationPanelSecondary.add(SunLunch);
        reservationPanelSecondary.add(SunLunchCh);
        reservationPanelSecondary.add(SunDinner);
        reservationPanelSecondary.add(SunDinnerCh);
        reservationPanelSecondary.add(balanceLabel);
        reservationPanelSecondary.add(reserveButton);
        reservationPanel.add(reservationPanelSecondary, BorderLayout.CENTER);

//        Creating panel responsible for credit selection
        creditSelectionPanel = new JPanel(new GridBagLayout());
        JButton addCreditButton = new JButton("Add This Course");
        JTextArea courseDescription = new JTextArea("Description");
        courseDescription.setEnabled(false);
        courseDescription.setDisabledTextColor(Color.BLACK);
        courseDescription.setBorder(BorderFactory.createTitledBorder("Course description"));
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.ipadx = 100;
        constraints.ipady = 100;
        constraints.anchor = GridBagConstraints.SOUTH;
        creditSelectionPanel.add(courseDescription, constraints);
        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.ipady = 400;
        constraints.ipadx = 200;
        constraints.anchor = GridBagConstraints.CENTER;
        JList<Object> presentCreditsList = new JList<>();
        presentCreditsList.setBorder(BorderFactory.createTitledBorder("AvailableCourses"));
        creditSelectionPanel.add(presentCreditsList, constraints);
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.ipady = 10;
        constraints.ipadx = 40;
        constraints.anchor = GridBagConstraints.CENTER;
        creditSelectionPanel.add(addCreditButton, constraints);

//        Setting the initial panel as the first page
        studentPanel.add(creditSelectionPanel, BorderLayout.CENTER);

        return studentPanel;
    }

    /**
     * Creates the teacher panel and its different sections
     * @return the panel it has built for further processes
     */
    public JPanel setTeacherPanel() {

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
}
