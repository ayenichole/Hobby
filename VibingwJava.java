//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VibingwJava extends JPanel {
    private double x = 50, y = 50, dx = 3, dy = 2.5;
    private final int size = 60;
    private float hue = 0f;

    private final String[] lyrics = {
            "♪ You can't believe it, you can't conceive it ♪",
            "♪ And you can't touch me, cause I'm untouchable ♪",
            "♪ And I know you hate it, and you can't take it♪",
            "♪ You'll never break me, cause I'm unbreakable ♪"
    };
    private int lyricIndex = 0;
    private double scrollX = 800;

    public VibingwJava() {
        setBackground(Color.BLACK);
        Timer timer = new Timer(16, this::tick);
        timer.start();
    }

    private void tick(ActionEvent e) {
        // bounce physics
        x += dx;
        y += dy;
        if (x <= 0 || x + size >= getWidth()) dx = -dx;
        if (y <= 0 || y + size >= getHeight()) dy = -dy;

        // color cycling
        hue += 0.004f;
        if (hue > 1f) hue = 0f;

        // scrolling lyrics
        scrollX -= 2.5;
        if (scrollX < -300) {
            scrollX = getWidth();
            lyricIndex = (lyricIndex + 1) % lyrics.length;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // glowing square
        Color color = Color.getHSBColor(hue, 0.8f, 1f);
        g2.setColor(color);
        g2.fillRoundRect((int) x, (int) y, size, size, 16, 16);

        // soft glow ring
        g2.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 60));
        g2.fillRoundRect((int) x - 8, (int) y - 8, size + 16, size + 16, 24, 24);

        // scrolling lyric
        g2.setFont(new Font("Monospaced", Font.BOLD, 22));
        g2.setColor(new Color(255, 255, 255, 200));
        g2.drawString(lyrics[lyricIndex], (int) scrollX, getHeight() - 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Unbreakable by Michael Jackson 🎵");
        VibingwJava panel = new VibingwJava();
        frame.add(panel);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}