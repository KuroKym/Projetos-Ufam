package testeGUI;

import javax.swing.*;
import java.awt.*;

public class TesteCompJField {
    public static void main(String[] args) {
        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField("Texto inicial");
        JPasswordField passwordField = new JPasswordField();

        textField1.setEditable(false);
        textField1.setText("Texto Inicial");
        String textFromTextField = textField1.getText();
        String selectedTextFromTextField = textField1.getSelectedText();
        textField1.setFont(new Font("Dialog", Font.ITALIC, 8));
        textField1.setHorizontalAlignment(SwingConstants.CENTER);

        // Para visualizar as caixas de texto, você deve adicioná-las a um contêiner (por exemplo, um JFrame).
        JFrame frame = new JFrame("Teste de Componentes JTextField");
        frame.setLayout(new FlowLayout());
        frame.add(textField1);
        frame.add(textField2);
        frame.add(passwordField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
