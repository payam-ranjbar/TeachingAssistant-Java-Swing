import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFavoriteListener implements ActionListener {

    JButton b;

    MyFavoriteListener(JButton b) {
        this.b = b;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        b.setText("i was clicked");
    }
}
