package ImageSuffelPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GUI extends JFrame {

    private JLabel labelImage;
    private JLabel labelText;
    private JPanel upperPanel;
    private JPanel lowerPanel;

    private ArrayList<String> images;


    GUI(int w, int h) {

        validateImageArray();
        labelImage = new JLabel(new ImageIcon("./asset/images/ninja.png"));
        upperPanel = new JPanel();
        lowerPanel = new JPanel();

        labelText = new JLabel("Click Button to See Magic");

        labelImage.setBounds(0, 0, 400, 400);
        labelText.setBounds(50, 0, 600, 400);

        upperPanel.setBounds(0,0, 600, 500);
        lowerPanel.setBounds(0,500, 600, 300);


        upperPanel.setBackground(new Color(0xB5D52F3A, true));
        lowerPanel.setBackground(new Color(0x00BE73));


        upperPanel.add(labelImage);



        JButton b = new JButton("clickMe");
        b.setBounds(200, 20, 150,20);

        lowerPanel.add(b);
        lowerPanel.add(labelText);


        upperPanel.setLayout(null);
        lowerPanel.setLayout(null);

//
        addMouseEffect(upperPanel);
        addMouseWheelEffect(upperPanel);
        addMouseEffect2(lowerPanel);
        setChangebackAction(b);
        setShufflePickAction(b);

        add(upperPanel);
        add(lowerPanel);


        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    private void addMouseEffect(JComponent component) {
        component.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                var w = labelImage.getWidth();
                var h = labelImage.getHeight();
                labelImage.setBounds(e.getX(), e.getY(), w, h);
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }


    private void addMouseEffect2(JComponent component) {
        component.addMouseListener(new MouseListener() {
            boolean tobreak = false;

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e){

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered  (MouseEvent e)
            {
                    labelText.setFont(new Font("ComicSans", Font.BOLD, 40));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelText.setFont(new Font("arial", Font.BOLD, 20));

            }
        });
    }
    private void addMouseWheelEffect(JComponent component) {
        component.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(e.getUnitsToScroll());
                if (e.getWheelRotation() < 0) {
                    component.setBackground(component.getBackground().brighter());

                } else {
                    component.setBackground(component.getBackground().darker());

                }
                repaint();



            }
        });
    }


    private void setChangebackAction(JButton b) {
        var eventListener = new ChangeBackButtonListener(upperPanel);
        b.addActionListener(eventListener);
    }

    private void setShufflePickAction(JButton b) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                labelImage.setIcon(new ImageIcon(chooseRandomFromArray()));
            }
        });
    }


    private void validateImageArray() {
        images = new ArrayList<>();
        String basePath = "./asset/images/";

        images.add(basePath + "cat.png");
        images.add(basePath + "zombie.png");
        images.add(basePath + "santa.png");
        images.add(basePath + "ninja.png");
        images.add(basePath + "girl.png");
        images.add(basePath + "knight.png");
        images.add(basePath + "cowboy.png");


    }

    private String chooseRandomFromArray(){
        Random rand = new Random();
        var randomPath = images.get(rand.nextInt(images.size()));

        return randomPath;
    }

}
