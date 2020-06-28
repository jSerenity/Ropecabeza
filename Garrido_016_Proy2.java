import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.*;

public class Garrido_016_Proy2 extends JFrame {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private int intentos = 0;
    private static String[] presentation = { "Universidad Tecnologica de Panama",
            "Facultad de Ing. de Sistemas Computacionales", "Carrera: Desarrollo de Software", "Profesor: Ricardo Chan",
            "Estudiante: Alba Garrido", "Cedula: 7-709-2016", "Grupo: ILS222", "Fecha: 31 de Mayo de 2020" };
    Spy objSpy = new Spy();
    JButton verSpy;
    private JLabel spyLabel = new JLabel();
    private JLabel Intentos = new JLabel("intentos: 0");
    boolean DisplaySpy = false;

    public Garrido_016_Proy2() {
        super("Puzzle..");
        initComponents();
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected void initComponents() {

        final JPanel panelButton = new JPanel();
        final JPanel panelMandos = new JPanel(new FlowLayout());
        final JPanel panelpresen = new JPanel();
        final JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.LIGHT_GRAY);
        panelInfo.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelInfo.setLayout(new GridLayout(40, 1));
        panelInfo.add(Intentos);

        JButton Start = new JButton("Iniciar");
        Start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

            }
        });

        panelMandos.add(Start, BorderLayout.WEST);
        panelMandos.setBorder(new EmptyBorder(10, 10, 10, 10));
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mover(e.getSource());
            }
        };

        panelButton.setLayout(null);
        for (int y = ROWS; y > 0; y--) {
            for (int x = 1; x < COLS; x++) {

                XYBotones button = new XYBotones(y + "", y, x);
                button.addActionListener(buttonListener);

                panelButton.add(button);
                button.setBounds(y * 50, x * 50, 50, 50);
                panelButton.updateUI();
            }
        }

        panelpresen.setLayout(new GridLayout(20, 2));
        panelpresen.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelpresen.setBackground(Color.LIGHT_GRAY);
        panelpresen.setBorder(new EmptyBorder(10, 10, 10, 10));
        for (final String text : presentation) {
            final JLabel label = new JLabel();
            label.setText(text);
            panelpresen.add(label);
        }
        panelMandos.setBackground(Color.LIGHT_GRAY);

        add(panelMandos, BorderLayout.NORTH);
        add(panelpresen, BorderLayout.WEST);
        JPanel p = new JPanel(new BorderLayout());

        p.add(panelButton, BorderLayout.CENTER);
        add(p, BorderLayout.CENTER);
        add(panelInfo, BorderLayout.EAST);
    }

    public void mover(Object b) {
        var test = ((XYBotones) b);
        var bx = ((XYBotones) b).getRow();
        var by = ((XYBotones) b).getCol();
        for (int x = bx * 50; x < 150; x++) 
        {
           test.setBounds(x, by*50, 50, 50);
        }
      
    }

   
  
    

   

   

   
}
