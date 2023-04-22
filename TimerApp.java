import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;

/**
 * TimerApp
 */
public class TimerApp extends JFrame implements ActionListener {
    private JTextField timeField;
    private JButton startButton, pauseButton, resetButton;
    private JLabel timeLabel;
    private Timer timer;
    private int remainingTime;

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

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                timeLabel.setText("残り時間： " + remainingTime);
                if(remainingTime == 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "タイマー終了");
                }
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        ;
    }

    public static void main(String[] args) {
        new TimerApp();
    }
    
}