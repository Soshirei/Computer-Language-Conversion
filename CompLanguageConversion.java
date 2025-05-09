package Cabrera;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class CompLanguageConversion {

	static String[] ope = { "None", "+", "-", "*", "/" };
	public static void main(String[] args) {

		JFrame f = new JFrame("Computer Language Conversion");
		f.setSize(614, 400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(3);

		JPanel p = new JPanel();
		p.setBackground(new Color(14, 1, 30));
		p.setSize(700, 700);
		p.setLayout(null);
		f.add(p);

		JLabel l = new JLabel("Decimal Converter");
		l.setForeground(Color.WHITE);
		l.setFont(new Font("Arial Black", Font.PLAIN, 20));
		l.setBounds(15, 5, 400, 25);
		p.add(l);

		JTextField bf = new JTextField();
		bf.setBounds(150, 50, 435, 35);
		p.add(bf);
		JTextField of = new JTextField();
		of.setBounds(150, 100, 435, 35);
		p.add(of);
		JTextField hf = new JTextField();
		hf.setBounds(150, 150, 435, 35);
		p.add(hf);
		JTextField df = new JTextField();
		df.setBounds(150, 200, 435, 35);
		p.add(df);
		bf.setEditable(false);
		of.setEditable(false);
		hf.setEditable(false);
		df.setEditable(false);
		
		JLabel bin = new JLabel("Binary");
		bin.setForeground(Color.WHITE);
		bin.setFont(new Font("Arial Black", Font.PLAIN, 20));
		bin.setBounds(15, 50, 400, 25);
		p.add(bin);
		JLabel oct = new JLabel("Octal");
		oct.setForeground(Color.WHITE);
		oct.setFont(new Font("Arial Black", Font.PLAIN, 20));
		oct.setBounds(15, 100, 400, 25);
		p.add(oct);
		JLabel hex = new JLabel("Hexa");
		hex.setForeground(Color.WHITE);
		hex.setFont(new Font("Arial Black", Font.PLAIN, 20));
		hex.setBounds(15, 150, 400, 25);
		p.add(hex);
		JLabel dec = new JLabel("Dec");
		dec.setForeground(Color.WHITE);
		dec.setFont(new Font("Arial Black", Font.PLAIN, 20));
		dec.setBounds(15, 200, 400, 25);
		p.add(dec);
		
		JButton equ = new JButton("Convert");
		equ.setBackground(Color.DARK_GRAY);
		equ.setForeground(Color.WHITE);
		equ.setBounds(225, 250, 150, 80);
		equ.addActionListener(e -> {
			JTextField num1 = new JTextField();
			JTextField num2 = new JTextField();
			JComboBox<String> op = new JComboBox(ope);

			Object[] operatorSelection = { "Select Operator", op };

			int operatorResult = JOptionPane.showConfirmDialog(null, operatorSelection, "Choose Operation",
					JOptionPane.OK_CANCEL_OPTION);

			if (operatorResult == JOptionPane.OK_OPTION) {
				String selectedOp = (String) op.getSelectedItem();

				if ("None".equals(selectedOp)) {
					Object[] inputOne = { "Enter Decimal Number", num1 };
					int singleResult = JOptionPane.showConfirmDialog(null, inputOne, "Single Number Conversion",
							JOptionPane.OK_CANCEL_OPTION);
					if (singleResult == JOptionPane.OK_OPTION) {
						try {
							int value = Integer.parseInt(num1.getText().trim());
							df.setText(String.valueOf(value));
							bf.setText(Integer.toBinaryString(value));
							of.setText(Integer.toOctalString(value));
							hf.setText(Integer.toHexString(value).toUpperCase());
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(f, "Please enter a valid integer.", "Input Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					Object[] i = { "Number 1", num1, "Number 2", num2 };
					int doubleResult = JOptionPane.showConfirmDialog(null, i, "Arithmetic Operation",
							JOptionPane.OK_CANCEL_OPTION);
					if (doubleResult == JOptionPane.OK_OPTION) {
						try {
							double n1 = Double.parseDouble(num1.getText().trim());
							double n2 = Double.parseDouble(num2.getText().trim());
							double output = 0;

							switch (selectedOp) {
							case "+":
								output = n1 + n2;
								break;
							case "-":
								output = n1 - n2;
								break;
							case "*":
								output = n1 * n2;
								break;
							case "/":
								if (n2 == 0) {
									JOptionPane.showMessageDialog(f, "Cannot divide by zero.", "Math Error",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
								output = n1 / n2;
								break;
							}

							int resultInt = (int) Math.round(output);
							df.setText(String.valueOf(resultInt));
							bf.setText(Integer.toBinaryString(resultInt));
							of.setText(Integer.toOctalString(resultInt));
							hf.setText(Integer.toHexString(resultInt).toUpperCase());

						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(f, "Please enter valid numbers.", "Input Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		p.add(equ);
		f.setVisible(true);
	}

}
