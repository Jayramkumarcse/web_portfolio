import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class PortfolioGUI extends JFrame {
    
    private JTabbedPane tabbedPane;
    private JPanel homePanel, aboutPanel, skillsPanel, experiencePanel, projectsPanel, educationPanel, contactPanel;
    
    public PortfolioGUI() {
        setTitle("Jayram Kumar - Portfolio");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        
        initComponents();
        setupLayout();
    }
    
    private void initComponents() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Initialize panels
        homePanel = createHomePanel();
        aboutPanel = createAboutPanel();
        skillsPanel = createSkillsPanel();
        experiencePanel = createExperiencePanel();
        projectsPanel = createProjectsPanel();
        educationPanel = createEducationPanel();
        contactPanel = createContactPanel();
        
        // Add panels to tabbed pane
        tabbedPane.addTab("Home", homePanel);
        tabbedPane.addTab("About", aboutPanel);
        tabbedPane.addTab("Skills", skillsPanel);
        tabbedPane.addTab("Experience", experiencePanel);
        tabbedPane.addTab("Projects", projectsPanel);
        tabbedPane.addTab("Education", educationPanel);
        tabbedPane.addTab("Contact", contactPanel);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        
        // Add menu bar
        JMenuBar menuBar = createMenuBar();
        setJMenuBar(menuBar);
    }
    
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem aboutItem = new JMenuItem("About Application");
        
        exitItem.addActionListener(e -> System.exit(0));
        aboutItem.addActionListener(e -> showAboutDialog());
        
        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        return menuBar;
    }
    
    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 249, 250));
        
        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(52, 73, 94));
        
        JLabel titleLabel = new JLabel("Jayram Kumar");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        
        // Main content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(new Color(248, 249, 250));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        
        // Profile image placeholder
        JPanel imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(200, 200));
        imagePanel.setBackground(new Color(52, 152, 219));
        imagePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        
        JLabel imageLabel = new JLabel("Profile Photo");
        imageLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        imageLabel.setForeground(Color.WHITE);
        imagePanel.add(imageLabel);
        
        contentPanel.add(imagePanel, gbc);
        
        // Welcome text
        gbc.gridy = 1;
        JLabel welcomeLabel = new JLabel("Welcome to My Portfolio!");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(52, 73, 94));
        contentPanel.add(welcomeLabel, gbc);
        
        gbc.gridy = 2;
        JTextArea descriptionArea = new JTextArea(
            "Hi, I'm Jayram Kumar, a recent graduate with a Bachelor of Technology in Computer Science and Engineering. " +
            "I am enthusiastic about utilizing my skills in computer science and engineering to contribute to the success " +
            "of an organization and advance my career in the tech industry.\n\n" +
            "Currently working as a dedicated trainer at National Institute of Electronics and Information Technology (NIELIT), Buxar, " +
            "I specialize in designing and delivering impactful training programs that drive personal and professional growth."
        );
        descriptionArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        descriptionArea.setBackground(new Color(248, 249, 250));
        descriptionArea.setBorder(BorderFactory.createEmptyBorder());
        descriptionArea.setPreferredSize(new Dimension(600, 150));
        contentPanel.add(descriptionArea, gbc);
        
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createAboutPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        
        // Personal Details Section
        JPanel personalPanel = createSectionPanel("Personal Details");
        personalPanel.setLayout(new GridLayout(0, 2, 10, 5));
        
        addDetailRow(personalPanel, "Date of Birth:", "03/09/2002");
        addDetailRow(personalPanel, "Gender:", "Male");
        addDetailRow(personalPanel, "Father's Name:", "Krishna Manjhi");
        addDetailRow(personalPanel, "Father's Occupation:", "Labour Farmer");
        addDetailRow(personalPanel, "Mother's Name:", "Sona Devi");
        addDetailRow(personalPanel, "Location:", "Nawada, Bihar");
        addDetailRow(personalPanel, "Address:", "Village Karman, Post Kuhila, PS Akbarpur, District Nawada, Bihar – 805126");
        
        // Contact Information
        JPanel contactPanel = createSectionPanel("Contact Information");
        contactPanel.setLayout(new GridLayout(0, 2, 10, 5));
        
        addDetailRow(contactPanel, "Phone:", "+91 7261864172");
        addDetailRow(contactPanel, "Email:", "er.jaykumar01@gmail.com");
        addDetailRow(contactPanel, "LinkedIn:", "Connect on LinkedIn");
        
        // About Me
        JPanel aboutMePanel = createSectionPanel("About Me");
        JTextArea aboutText = new JTextArea(
            "I am a recent graduate with a Bachelor of Technology in Computer Science and Engineering from " +
            "Sityog Institute of Technology, Aurangabad, Bihar. With a CGPA of 7.35, I have demonstrated strong " +
            "academic performance and a passion for technology.\n\n" +
            "Currently working as a dedicated trainer at National Institute of Electronics and Information Technology (NIELIT), " +
            "Buxar, I specialize in designing and delivering impactful training programs that drive personal and professional growth. " +
            "With over six months of experience, I have a proven track record of empowering individuals and teams to achieve their full potential.\n\n" +
            "My expertise spans across various domains, including Ms Visio (Flowchart), Ms Word, Ms Excel, Google Workspace, " +
            "and other leadership development, communication skills, project management. I employ a learner-centric approach, " +
            "combining interactive methodologies and practical insights to ensure engaging and effective training sessions."
        );
        aboutText.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setEditable(false);
        aboutText.setBackground(Color.WHITE);
        aboutText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        contentPanel.add(personalPanel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(contactPanel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(aboutMePanel);
        contentPanel.add(aboutText);
        
        scrollPane.setViewportView(contentPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createSkillsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 249, 250));
        
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 2, 20, 20));
        contentPanel.setBackground(new Color(248, 249, 250));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Technical Skills
        contentPanel.add(createSkillCard("HTML5", "Semantic markup and modern web standards", new Color(52, 152, 219)));
        contentPanel.add(createSkillCard("CSS", "Responsive design and modern styling", new Color(155, 89, 182)));
        contentPanel.add(createSkillCard("JavaScript", "Dynamic web applications and interactivity", new Color(241, 196, 15)));
        contentPanel.add(createSkillCard("Java Programming", "Object-oriented programming and development", new Color(231, 76, 60)));
        contentPanel.add(createSkillCard("Data Science & ML", "Machine learning and data analysis", new Color(46, 204, 113)));
        contentPanel.add(createSkillCard("Internet of Things", "IoT systems and connected devices", new Color(230, 126, 34)));
        
        scrollPane.setViewportView(contentPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createSkillCard(String skillName, String description, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel nameLabel = new JLabel(skillName);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        nameLabel.setForeground(color);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JTextArea descArea = new JTextArea(description);
        descArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setEditable(false);
        descArea.setBackground(Color.WHITE);
        descArea.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        card.add(nameLabel, BorderLayout.NORTH);
        card.add(descArea, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel createExperiencePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Level 02 Experience
        JPanel exp1Panel = createExperienceCard(
            "Trainer - Level 02",
            "National Institute of Electronics and Information Technology (NIELIT), Buxar",
            "March – Sept, 2025",
            "Continuing to deliver high-quality training programs and empowering individuals with technical skills and knowledge."
        );
        
        // Level 01 Experience
        JPanel exp2Panel = createExperienceCard(
            "Trainer - Level 01",
            "National Institute of Electronics and Information Technology (NIELIT), Buxar",
            "Aug - Feb, 2024",
            "Specialized in designing and delivering impactful training programs across various domains including Ms Visio (Flowchart), " +
            "Ms Word, Ms Excel, Google Workspace, and leadership development. Employed learner-centric approaches with interactive " +
            "methodologies to ensure engaging and effective training sessions."
        );
        
        // Internships
        JPanel internshipPanel = createSectionPanel("Internships");
        internshipPanel.setLayout(new BoxLayout(internshipPanel, BoxLayout.Y_AXIS));
        
        JPanel intern1 = createInternshipCard(
            "Advanced AutoCAD",
            "Tool Room Ranchi",
            "Feb 2023 – Mar 2023",
            "Worked on 2D and 3D design drafting of mechanical parts and structures."
        );
        
        JPanel intern2 = createInternshipCard(
            "CNC Turning",
            "Patna Tool Enterprises",
            "Apr 2022 – May 2022",
            "Operated CNC turning tools, read blueprints, and ensured machining precision."
        );
        
        internshipPanel.add(intern1);
        internshipPanel.add(Box.createVerticalStrut(10));
        internshipPanel.add(intern2);
        
        contentPanel.add(exp1Panel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(exp2Panel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(internshipPanel);
        
        scrollPane.setViewportView(contentPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createExperienceCard(String title, String company, String period, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(new Color(248, 249, 250));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setOpaque(false);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(52, 73, 94));
        
        JLabel periodLabel = new JLabel(period);
        periodLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        periodLabel.setForeground(new Color(52, 152, 219));
        
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(periodLabel, BorderLayout.EAST);
        
        JLabel companyLabel = new JLabel(company);
        companyLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        companyLabel.setForeground(new Color(52, 73, 94));
        
        JTextArea descArea = new JTextArea(description);
        descArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setEditable(false);
        descArea.setBackground(new Color(248, 249, 250));
        descArea.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        card.add(headerPanel, BorderLayout.NORTH);
        card.add(companyLabel, BorderLayout.CENTER);
        card.add(descArea, BorderLayout.SOUTH);
        
        return card;
    }
    
    private JPanel createInternshipCard(String title, String company, String period, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(155, 89, 182), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setOpaque(false);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        titleLabel.setForeground(new Color(155, 89, 182));
        
        JLabel periodLabel = new JLabel(period);
        periodLabel.setFont(new Font("Segoe UI", Font.ITALIC, 10));
        periodLabel.setForeground(new Color(155, 89, 182));
        
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(periodLabel, BorderLayout.EAST);
        
        JLabel companyLabel = new JLabel(company);
        companyLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        companyLabel.setForeground(new Color(52, 73, 94));
        
        JTextArea descArea = new JTextArea(description);
        descArea.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setEditable(false);
        descArea.setBackground(Color.WHITE);
        descArea.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        
        card.add(headerPanel, BorderLayout.NORTH);
        card.add(companyLabel, BorderLayout.CENTER);
        card.add(descArea, BorderLayout.SOUTH);
        
        return card;
    }
    
    private JPanel createProjectsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 249, 250));
        
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1, 20, 20));
        contentPanel.setBackground(new Color(248, 249, 250));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Smart Skills Tutorials
        JPanel project1 = createProjectCard(
            "Smart Skills Tutorials",
            "Designed a low-cost electric vehicle prototype for short-distance commuting, demonstrating practical application of engineering principles.",
            new String[]{"Engineering", "Prototype", "Innovation"},
            new Color(52, 152, 219)
        );
        
        // Sityog Food Zone
        JPanel project2 = createProjectCard(
            "Sityog Food Zone – Online Food Ordering System",
            "Developed a basic solar heating system using copper tubes and reflectors, showcasing sustainable energy solutions.",
            new String[]{"Solar Energy", "Sustainability", "System Design"},
            new Color(46, 204, 113)
        );
        
        contentPanel.add(project1);
        contentPanel.add(project2);
        
        scrollPane.setViewportView(contentPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createProjectCard(String title, String description, String[] tags, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(color);
        
        JTextArea descArea = new JTextArea(description);
        descArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setEditable(false);
        descArea.setBackground(Color.WHITE);
        descArea.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        
        // Tags panel
        JPanel tagsPanel = new JPanel();
        tagsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        tagsPanel.setOpaque(false);
        
        for (String tag : tags) {
            JLabel tagLabel = new JLabel(tag);
            tagLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
            tagLabel.setForeground(Color.WHITE);
            tagLabel.setBackground(color);
            tagLabel.setOpaque(true);
            tagLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            tagsPanel.add(tagLabel);
        }
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(descArea, BorderLayout.CENTER);
        card.add(tagsPanel, BorderLayout.SOUTH);
        
        return card;
    }
    
    private JPanel createEducationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(0, 1, 20, 20));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // B.Tech
        JPanel btechPanel = createEducationCard(
            "Bachelor of Technology in Computer Science & Engineering",
            "Sityog Institute of Technology, Aurangabad, Bihar",
            "Bihar Engineering University, Patna",
            "2020 – 2024",
            "CGPA: 7.35",
            new Color(52, 152, 219)
        );
        
        // Higher Secondary
        JPanel hscPanel = createEducationCard(
            "Higher Secondary (XII)",
            "Kanhai Lal Sahu College, Nawada",
            "BSEB",
            "2018 – 2020",
            "Percentage: 81.20%",
            new Color(155, 89, 182)
        );
        
        // Secondary
        JPanel sscPanel = createEducationCard(
            "Secondary (X)",
            "Utkramit Middle School, Kuhila, Akbarpur",
            "BSEB",
            "2017 - 2018",
            "Percentage: 68.68%",
            new Color(46, 204, 113)
        );
        
        contentPanel.add(btechPanel);
        contentPanel.add(hscPanel);
        contentPanel.add(sscPanel);
        
        scrollPane.setViewportView(contentPanel);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createEducationCard(String degree, String institution, String board, String period, String grade, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(new Color(248, 249, 250));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 3),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel degreeLabel = new JLabel(degree);
        degreeLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        degreeLabel.setForeground(color);
        
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(0, 1, 5, 5));
        detailsPanel.setOpaque(false);
        
        JLabel institutionLabel = new JLabel(institution);
        institutionLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        institutionLabel.setForeground(new Color(52, 73, 94));
        
        JLabel boardLabel = new JLabel(board);
        boardLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        boardLabel.setForeground(new Color(52, 73, 94));
        
        JLabel periodLabel = new JLabel(period);
        periodLabel.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        periodLabel.setForeground(new Color(52, 73, 94));
        
        JLabel gradeLabel = new JLabel(grade);
        gradeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gradeLabel.setForeground(color);
        
        detailsPanel.add(institutionLabel);
        detailsPanel.add(boardLabel);
        detailsPanel.add(periodLabel);
        detailsPanel.add(gradeLabel);
        
        card.add(degreeLabel, BorderLayout.NORTH);
        card.add(detailsPanel, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel createContactPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(248, 249, 250));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2, 20, 20));
        contentPanel.setBackground(new Color(248, 249, 250));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Phone
        JPanel phonePanel = createContactCard(
            "Phone",
            "+91 7261864172",
            "fas fa-phone",
            new Color(52, 152, 219)
        );
        
        // Email
        JPanel emailPanel = createContactCard(
            "Email",
            "er.jaykumar01@gmail.com",
            "fas fa-envelope",
            new Color(231, 76, 60)
        );
        
        // Location
        JPanel locationPanel = createContactCard(
            "Location",
            "Nawada, Bihar, India",
            "fas fa-map-marker-alt",
            new Color(46, 204, 113)
        );
        
        // LinkedIn
        JPanel linkedinPanel = createContactCard(
            "LinkedIn",
            "Connect with me on LinkedIn",
            "fab fa-linkedin",
            new Color(52, 73, 94)
        );
        
        contentPanel.add(phonePanel);
        contentPanel.add(emailPanel);
        contentPanel.add(locationPanel);
        contentPanel.add(linkedinPanel);
        
        panel.add(contentPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createContactCard(String title, String value, String iconClass, Color color) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(color);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        valueLabel.setForeground(new Color(52, 73, 94));
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Icon placeholder
        JPanel iconPanel = new JPanel();
        iconPanel.setPreferredSize(new Dimension(50, 50));
        iconPanel.setBackground(color);
        iconPanel.setLayout(new GridBagLayout());
        
        JLabel iconLabel = new JLabel("📞");
        iconLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        iconPanel.add(iconLabel);
        
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(iconPanel, BorderLayout.CENTER);
        card.add(valueLabel, BorderLayout.SOUTH);
        
        return card;
    }
    
    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(52, 152, 219), 2),
                title,
                0, 0,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(52, 152, 219)
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        return panel;
    }
    
    private void addDetailRow(JPanel panel, String label, String value) {
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Segoe UI", Font.BOLD, 12));
        labelComponent.setForeground(new Color(52, 73, 94));
        
        JLabel valueComponent = new JLabel(value);
        valueComponent.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        valueComponent.setForeground(new Color(52, 73, 94));
        
        panel.add(labelComponent);
        panel.add(valueComponent);
    }
    
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(
            this,
            "Jayram Kumar Portfolio Application\n\n" +
            "Version: 1.0\n" +
            "Created with Java Swing\n\n" +
            "This application displays the professional portfolio of Jayram Kumar, " +
            "a Computer Science & Engineering graduate with expertise in web technologies " +
            "and training programs.\n\n" +
            "© 2024 Jayram Kumar. All rights reserved.",
            "About Application",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public static void main(String[] args) {
        // Set system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        // Create and display the application
        SwingUtilities.invokeLater(() -> {
            PortfolioGUI portfolio = new PortfolioGUI();
            portfolio.setVisible(true);
        });
    }
}
