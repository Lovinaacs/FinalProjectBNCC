package finalproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
	JPanel p1, p2, p3, p4;
	JLabel menuCode, menuName, menuPrice, menuStock, CodeUp, PriceUp, StockUp, CodeDel;
	JTextField codeTf, nameTf, priceTf, stockTf, CodeUpTf, PriceUpTf, StockUpTf, CodeDelTf;
	JButton insertButton, updateButton, deleteButton;

	public Main() {

		menuCode = new JLabel("Kode Menu: ");
		menuCode.setBounds(30, 50, 150, 50);
		codeTf = new JTextField();
		codeTf.setBounds(150, 60, 200, 30);
		menuName = new JLabel("Nama Menu:");
		menuName.setBounds(30, 90, 150, 50);
		nameTf = new JTextField();
		nameTf.setBounds(150, 100, 200, 30);
		menuPrice = new JLabel("Harga Menu:");
		menuPrice.setBounds(30, 130, 150, 50);
		priceTf = new JTextField();
		priceTf.setBounds(150, 140, 200, 30);
		menuStock = new JLabel("Stok Menu:");
		menuStock.setBounds(30, 170, 150, 50);
		stockTf = new JTextField();
		stockTf.setBounds(150, 180, 200, 30);

		insertButton = new JButton("Insert Menu");
		insertButton.setBounds(120, 250, 150, 30);
		insertButton.addActionListener(this);

		p1 = new JPanel();
		p1.add(menuCode);
		p1.add(codeTf);
		p1.add(menuName);
		p1.add(nameTf);
		p1.add(menuPrice);
		p1.add(priceTf);
		p1.add(menuStock);
		p1.add(stockTf);
		p1.add(insertButton);

		p2 = new JPanel();

		CodeUp = new JLabel("Kode Menu: ");
		CodeUp.setBounds(30, 50, 150, 50);
		CodeUpTf = new JTextField();
		CodeUpTf.setBounds(150, 60, 200, 30);
		PriceUp = new JLabel("Harga Menu:");
		PriceUp.setBounds(30, 90, 150, 50);
		PriceUpTf = new JTextField();
		PriceUpTf.setBounds(150, 100, 200, 30);
		StockUp = new JLabel("Stok Menu:");
		StockUp.setBounds(30, 130, 150, 50);
		StockUpTf = new JTextField();
		StockUpTf.setBounds(150, 140, 200, 30);

		updateButton = new JButton("Update Menu");
		updateButton.setBounds(120, 200, 150, 30);
		updateButton.addActionListener(this);

		p3 = new JPanel();
		p3.add(CodeUp);
		p3.add(CodeUpTf);
		p3.add(PriceUp);
		p3.add(PriceUpTf);
		p3.add(StockUp);
		p3.add(StockUpTf);
		p3.add(updateButton);

		CodeDel = new JLabel("Kode Menu:");
		CodeDel.setBounds(30, 90, 150, 50);
		CodeDelTf = new JTextField();
		CodeDelTf.setBounds(150, 100, 200, 30);

		deleteButton = new JButton("Delete Menu");
		deleteButton.setBounds(120, 200, 150, 30);
		deleteButton.addActionListener(this);

		p4 = new JPanel();
		p4.add(CodeDel);
		p4.add(CodeDelTf);
		p4.add(deleteButton);

		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(0, 0, 390, 368);
		tp.add("Insert Menu", p1);
		tp.add("View Menu", p2);
		tp.add("Update Menu", p3);
		tp.add("Delete Menu", p4);
		this.add(tp);

		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		setFrame();

	}

	public void setFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("PT PUDDING MENU");
		this.setSize(400, 400);
		this.setLayout(null);
		this.setVisible(true);
	}

	public static void main(String args[]) {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == insertButton) {

			String Menu = nameTf.getText();
			String Kode = codeTf.getText();
			String Price = priceTf.getText();
			String Stock = stockTf.getText();

			if (Menu.isEmpty() || Kode.isEmpty() || Price.isEmpty() || Stock.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Informasi belum lengkap");
			} else {
				if (!Kode.startsWith("KD-") || Kode.length() != 6) {
					JOptionPane.showMessageDialog(this, "Format penulisan kode -> KD-XXX");
				} else {
					JOptionPane.showMessageDialog(this,
							"Menu " + Menu + " dengan kode " + Kode + " berhasil ditambahkan");
				}
			}

		}

		if (e.getSource() == updateButton) {
			String Kode = CodeUp.getText();
			String Price = PriceUp.getText();
			String Stock = StockUp.getText();
			if (Kode.isEmpty() || Price.isEmpty() || Stock.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Informasi belum lengkap");
			} else {
				if (!Kode.startsWith("KD-") || Kode.length() != 6) {
					JOptionPane.showMessageDialog(this, "Format penulisan kode -> KD-XXX");
				} else {
					JOptionPane.showMessageDialog(this, "Menu dengan kode " + Kode + " berhasil diupdate");
				}
			}
		}

		if (e.getSource() == deleteButton) {
			String Kode = CodeDel.getText();
			if (Kode.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Informasi belum lengkap");
			} else {
				if (!Kode.startsWith("KD-") || Kode.length() != 6) {
					JOptionPane.showMessageDialog(this, "Format penulisan berupa KD-XXX");
				} else {
					JOptionPane.showMessageDialog(this, "Menu dengan kode " + Kode + " berhasil dihapus");
				}
			}

		}
	}

}
