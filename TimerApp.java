import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

        setLayout(new GridLayout(5, 1));

        timeField = new JTextField();
        timeField.setHorizontalAlignment(JTextField.CENTER);
        timeField.setFont(new Font("Arial", Font.PLAIN, 40));
        add(timeField);

        startButton = new JButton("START");
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.addActionListener(this);
        add(startButton);

        pauseButton = new JButton("PAUSE");
        pauseButton.setFont(new Font("Arial", Font.PLAIN, 20));
        pauseButton.addActionListener(this);
        add(pauseButton);

        resetButton = new JButton("RESET");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
        resetButton.addActionListener(this);
        add(resetButton);

        timeLabel = new JLabel("残り時間： 0秒");
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        add(timeLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                timeLabel.setText("残り時間： " + remainingTime + "秒");
                if(remainingTime == 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "タイマー終了");
                }
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton) {
            remainingTime = Integer.parseInt(timeField.getText());
            timer.start();
        } else if(e.getSource() == pauseButton) {
            timer.stop();
        } else if(e.getSource() == resetButton) {
            timer.stop();
            remainingTime = 0;
            timeLabel.setText("残り時間： 0秒");
        }
    }

    public static void main(String[] args) {
        new TimerApp();
    }
    
}