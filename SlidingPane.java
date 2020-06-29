import java.awt.Color; import java.awt.Container; 
import java.awt.Dimension; 
import java.awt.EventQueue; 
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; import java.text.NumberFormat; 
import javax.swing.JButton; import javax.swing.JFrame; 
import javax.swing.JLabel; import javax.swing.JPanel; 
import javax.swing.Timer; import javax.swing.UIManager; 
import javax.swing.UnsupportedLookAndFeelException; import javax.swing.border.LineBorder; 
public class SlidingPane { 
    private SlidePane slidePane = new SlidePane(); 
    public static void main(String[] args) { 
        new SlidingPane(); 
    } 
    public SlidingPane() { EventQueue.invokeLater(new Runnable() {
        @Override public void run() { 
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) { } 
        JButton slideButton = new JButton("Slide"); 
        slideButton.addActionListener(new ActionListener() 
        { @Override public void actionPerformed(ActionEvent e) { 
            slidePane.slide(); 
            } 
        }); 
        JFrame frame = new JFrame("Testing"); 
        JPanel glassPane = new JPanel(null); 
        glassPane.setOpaque(false); 
        glassPane.add(slidePane); 
        frame.setGlassPane(glassPane); 
        glassPane.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        frame.add(new JLabel("Look ma, no hands!"), gbc); 
        frame.add(slideButton, gbc); frame.setSize(400, 400); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); } }); 
    } 
        public class SlidePane extends JPanel { 
            private long startTime = -1; 
            private int runTime = 1000; private int startX; 
            private int targetX; private boolean slideIn = false; 
            private Timer slideTimer; 
            public SlidePane() { 
                setBackground(Color.DARK_GRAY); 
                setBorder(new LineBorder(Color.BLACK)); 
                setLocation(-getPreferredSize().width, 0); 
                setLayout(new GridBagLayout()); 
                JLabel label = new JLabel("I'm your overload"); 
                label.setForeground(Color.WHITE); 
                add(label); 

                slideTimer = new Timer(40, new ActionListener() { 
                    @Override 
                    public void actionPerformed(ActionEvent e) { 
                    long diff = System.currentTimeMillis() - startTime; 
                    double progress = (double)diff / (double)runTime; if (progress >= 1d) 
                    {   progress = 1d; 
                        slideTimer.stop(); 
                        startTime = -1; 
                    }
                     Container parent = getParent(); 
                     int height = parent.getHeight(); 
                     setSize(getPreferredSize().width, height); 
                     int x = calculateProgress(startX, targetX, progress); 
                     setLocation(x, 0);
                     revalidate(); 
                     repaint(); } 
                    }); 
                    }
                      protected int calculateProgress(int startValue, int endValue, double fraction) 
                      {
                           int value = 0; 
                           int distance = endValue - startValue; 
                           value = (int) Math.round((double) distance * fraction); 
                           value += startValue; 
                           return value; 
                      }
                            @Override 
                           public Dimension getPreferredSize() {
                                return new Dimension(200, 400); } 

                           public void slide() { 
                            slideTimer.stop(); 
                            startTime = System.currentTimeMillis(); 
                            slideIn = !slideIn; 
                            startX = getX();
                             targetX = 0; 
                            if (!slideIn) { 
                            targetX = -getPreferredSize().width; 
                            } 
                            slideTimer.start(); 
                        } 
                    } 
                } 