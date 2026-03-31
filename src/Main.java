import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class ConversorMoedasGUI extends JFrame {

    // - My properties for convertion calc
    private final double TAX_RUPEES = 0.44;
    private final double TAX_GIL = 54.87;
    private final double TAX_GOLDEN = 2.23;
    private final double MAX_INF = 0.05;
    private final double MIN_INF = -0.03;

    private JTextField inputUSD;
    private JTextArea resultArea;
    private Random rand = new Random();

    public ConversorMoedasGUI() {
        // - Config
        setTitle("Conversor de Moedas Fantasy");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // - Interface
        add(new JLabel("Saldo em USD:"));
        inputUSD = new JTextField(10);
        add(inputUSD);

        JButton btnCalcular = new JButton("Converter");
        add(btnCalcular);

        resultArea = new JTextArea(5, 25);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        // - Btn
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processarConversao();
            }
        });
    }

    private double calcularInflacao(double min, double max) {
        return min + (max - min) * rand.nextDouble();
    }

    private void processarConversao() {
        try {
            double usdValor = Double.parseDouble(inputUSD.getText());

            double calcRupees = TAX_RUPEES * (1 + calcularInflacao(MIN_INF, MAX_INF));
            double calcGil = TAX_GIL * (1 + calcularInflacao(MIN_INF, MAX_INF));
            double calcGolden = TAX_GOLDEN * (1 + calcularInflacao(MIN_INF, MAX_INF));

            String res = String.format(
                    "Rupees: %.2f\nGil: %.2f\nGolden: %.2f",
                    usdValor * calcRupees, usdValor * calcGil, usdValor * calcGolden
            );

            resultArea.setText(res);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
    }

    void main() {
        SwingUtilities.invokeLater(() -> new ConversorMoedasGUI().setVisible(true));
    }
}