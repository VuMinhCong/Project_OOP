import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TroGiup extends Frame implements ActionListener
{
	Label lbTroGiup = new Label("TRO GIUP",Label.CENTER);
	TextArea txaTroGiup = new TextArea();
	Button buttThoat = new Button("Thoat");
	public TroGiup(String title)
	{
		super(title);
		lbTroGiup.setFont(new Font("Tahoma",Font.BOLD,20));
		add(lbTroGiup,BorderLayout.NORTH);
		txaTroGiup.setEditable(false);
		txaTroGiup.setText("\t\tCHUONG TRINH QUAN LY QUAN CAFE\n\t\t\tCoffee Manager V1.0\n Day la chuong trinh giup cho viec quan ly quan cafe tro nen de dang,chinh xac hon.\nChuong trinh nay bao gom cac chuc nang co ban nhu sau:\nNhap Danh sach nhung mon ma Khach muon goi.\nSua doi mon ma khach da goi truoc do. \nNeu khach co nhu cau tach ban(vi du nhu anh chi nao do muon danh le...).\nTinh tien mot cach chinh xac cho tung ban.\nVa rat nhieu tinh nang khac cho moi nguoi kham pha..." );
		add(txaTroGiup,BorderLayout.CENTER);
		add(buttThoat,BorderLayout.SOUTH);
		buttThoat.addActionListener(this);
		setFont(new Font("Times New Roman",Font.PLAIN,15));
		setBounds(120, 100,600,280);
		setResizable(false);
		//pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == buttThoat)
			setVisible(false);
	}


}
