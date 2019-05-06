package DragonManager.FrontEnd;

import DragonManager.FileManagers.DragonManager;
import DragonManager.Models.Dragon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

    public static GUI instance;

    private JFrame frame;

    private JPanel contentPanel;

    private JButton getDragonsButton;

    private GUI(int w, int h) {
        frame = new JFrame();
        contentPanel = new JPanel();
        getDragonsButton = new JButton();
//        frame.setResizable(false);
        setMenubar();
        button();
        createContentPanel();


        frame.setName("my app");
        frame.setSize(w, h);
        frame.setVisible(true);


//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

    }

    private void setMenubar() {

        JMenuBar menuBar = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("View");
        JMenu m3 = new JMenu("Edit");
        JMenu m4 = new JMenu("Navigate");
        JMenu m5 = new JMenu("Help");

        JMenuItem i1 = new JMenuItem("new project");
        JMenuItem i2 = new JMenuItem("open");
        JMenuItem i3 = new JMenuItem("save");
        JMenuItem i4 = new JMenuItem("Setting");

        menuBar.add(m1);
        menuBar.add(m2);
        menuBar.add(m3);
        m5.add(m4);
        menuBar.add(m4);
        menuBar.add(m5);

        m1.add(i1);
        m1.add(i2);
        m1.add(i3);
        m2.add(i4);
//        menuBar.setBounds(0,0, 400, 25);

        frame.add(menuBar, BorderLayout.NORTH);
    }

    private void createContentPanel() {
        var layout = new BoxLayout(contentPanel, BoxLayout.Y_AXIS);
        contentPanel.setLayout(layout);
        contentPanel.setAutoscrolls(true);
        frame.add(contentPanel, BorderLayout.CENTER);

    }
    public void addDragons(ArrayList<Dragon> dragons) throws Exception {
        int i = 0;
        int margin = 50;
        for(Dragon dragon : dragons) {
            i += margin;

            contentPanel.add(new DragonView(dragon).getPanel(0, i));

        }

        contentPanel.updateUI();
    }
    private void button() {

        getDragonsButton.setBounds(0, 25, 300, 25);
        getDragonsButton.setText("Show my Dragons");
        frame.add(getDragonsButton, BorderLayout.SOUTH);
        getDragonsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    addDragons(DragonManager.LoadDragons());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static GUI GetOrCreate() {
        if (instance == null) {
            instance = new GUI(600, 700);
            return instance;
        } else {
            return instance;
        }
    }
}
