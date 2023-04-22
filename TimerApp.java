import javax.swing.*;
import javax.xml.stream.events.StartElement;

import java.awt.*;
import java.awt.event.*;

/**
 * TimerApp
 */
public class TimerApp extends JFrame implements ActionListener {
    private JTextField timeField;
    private JButton startButton, pauseButton, resetButton;
    private JLabel timeLabel;

    //コンストラクタ(Pythonで言うと__init__)
    public TimerApp() {
        setTitle("タイマーアプリ");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 1));

        timeField = new JTextField();
        add(timeField);

        startButton = new JButton("START");
        startButton.addActionListener(this);
        add(startButton);

        pauseButton = new JButton("PAUSE");
        pauseButton.addActionListener(this);
        add(pauseButton);

        resetButton = new JButton("RESET");
        resetButton.addActionListener(this);
        add(resetButton);

        timeLabel = new JLabel("残り時間：");
        add(timeLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        ;
    }

    public static void main(String[] args) {
        new TimerApp();
    }
    
}