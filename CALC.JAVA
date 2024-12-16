import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.CharSequence

public class EcuacionCuadratica extends JFrame {

    //Componentes de la interfaz gráfica
    private JTextField txtA, txtB, txtC;
    private JLabel lblResultado;

    public EcuacionCuadratica() {
        //Configuración básica de la ventana
        setTitle("Calculadora de Ecuación Cuadrática");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        //Etiqueta a
        add(new JLabel("Coeficiente a:"));
        txtA = new JTextField();
        add(txtA);
        //Etiqueta b
        add(new JLabel("Coeficiente b:"));
        txtB = new JTextField();
        add(txtB);
        //Etiqueta c
        add(new JLabel("Coeficiente c:"));
        txtC = new JTextField();
        add(txtC);

        //Botón para calcular
        JButton btnCalcular = new JButton("Calcular");
        add(btnCalcular);

        //Boton para limpiar
        JButton btnLimpiar = new JButton("Limpiar");
        add(btnLimpiar);

        //Etiqueta de resultado
        lblResultado = new JLabel("Resultado: ");
        add(lblResultado);

        //Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                calcularRaices();
            }
        });
    }

    //Calculo de raices
    private void calcularRaices() {
        try {
            //Obtener los valores de los cuadros de texto
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            //Calcular discriminante
            double discriminante = b * b - 4 * a * c;

            // Mostrar el resultado en la etiqueta
            if (discriminante > 0) {
                //Dos raíces reales
                double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                lblResultado.setText("Raíces reales: x1 = " + raiz1 + ", x2 = " + raiz2);
            } else if (discriminante == 0) {
                //Una raíz real (doble)
                double raiz = -b / (2 * a);
                lblResultado.setText("Raíz doble: x = " + raiz);
            } else {
                //Raíces complejas
                double realParte = -b / (2 * a);
                double imaginarioParte = Math.sqrt(-discriminante) / (2 * a);
                lblResultado.setText("Raíces complejas: x1 = " + realParte + " + " + imaginarioParte + "i, x2 = " + realParte + " - " + imaginarioParte + "i");
            }
        } catch (NumberFormatException ex) {
            lblResultado.setText("Por favor ingrese valores válidos.");
        } catch (ArithmeticException ex) {
            lblResultado.setText("Error en los cálculos.");
        }
      

    }

    public static void main(String[] args) {
        //Crear la ventana
        EcuacionCuadratica ventana = new EcuacionCuadratica();
        ventana.setVisible(true);
    }

    
}
