import javax.swing.*;
import java.util.Scanner;

public class NewGUI {

    private JFrame frame;

    NewGUI (){
        frame = new JFrame("eseme barname");
        frame.setSize(500, 200);

        JButton button = new JButton("click me");
        button.setBounds(200, 50, 46, 14);

        JLabel label = new JLabel("dld");

        button.addActionListener(new MyFavoriteListener(button));
        frame.setVisible(true);

        frame.setLayout(null);
        frame.add(button);



    }


    public static void main(String[] args) {
        NewGUI gui = new NewGUI();

    }
}
