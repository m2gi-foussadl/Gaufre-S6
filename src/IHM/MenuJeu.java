package IHM;

import javax.swing.*;
import java.awt.*;

public class MenuJeu extends JPanel {

    public MenuJeu() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 500));

        JButton button1 = new JButton("boutton1");
        add(button1);

        JButton button2 = new JButton("boutton2");
        add(button2);
    }
}
