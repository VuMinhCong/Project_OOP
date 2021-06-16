import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ThemMon extends Frame implements ActionListener
{
	Panel panelCenter = new Panel();
	Panel panelSub = new Panel(new GridLayout(3,2,10,10));
	Panel panelSouth = new Panel();
	Panel panelSpace = new Panel();
	Label lbSpace = new Label(" ");
	Label lbThemMon = new Label("THAY DOI MON",Label.CENTER);
	Label lbTenBan = new Label("Ten Ban:");
	Label lbKqua = new Label();
	Label lbTenDouong = new Label("Do uong:");
	Label lbSoluong = new Label("So luong them:");
	Choice chBanID = new Choice();
	Choice chTenBan = new Choice();
	Choice chDoUongID = new Choice();
	Choice chTenDoUong = new Choice();
	TextField txtSoLuong = new TextField(20);
	Button buttLuu = new Button("   Luu   ");
	Button buttThoat = new Button(" Thoat ");
	java.sql.Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	public ThemMon(String title)
	{
		super(title);
		lbThemMon.setFont(new Font("Tahoma",Font.BOLD,20));
		add(lbThemMon,BorderLayout.NORTH);
		panelSub.add(lbTenBan);
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Ban");
			rs.next();
			while(!rs.isAfterLast())
			{
				chBanID.addItem(rs.getString(1));
				chTenBan.addItem(rs.getString(2));
				rs.next();
			}
		}
		catch(SQLException se)
		{
			System.err.println("Error: "+se.getMessage());
		}
		panelSub.add(chTenBan);
		panelSub.add(lbTenDouong);
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Thuc_don");
			rs.next();
			while(!rs.isAfterLast())
			{
				chDoUongID.addItem(rs.getString(1));
				chTenDoUong.addItem(rs.getString(2));
				rs.next();
			}
		}
		catch(SQLException se)
		{
			System.err.println("Error: "+se.getMessage());
		}
		panelSub.add(chTenDoUong);
		panelSub.add(lbSoluong);
		panelSub.add(txtSoLuong);
		panelCenter.add(panelSub);
		panelSpace.add(lbSpace);
		panelCenter.add(panelSpace);
		add(panelCenter,BorderLayout.CENTER);
		panelSouth.add(buttLuu);
		panelSouth.add(buttThoat);
		add(panelSouth,BorderLayout.SOUTH);
		buttLuu.addActionListener(this);
		buttThoat.addActionListener(this);
		setFont(new Font("Arial",Font.PLAIN,13));
		setLocation(200, 50);
		pack();
		setVisible(true);
		setResizable(false);
	}
	//phuong thuc xu ly su kien
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==buttLuu)
			Luu();
		if(e.getSource() == buttThoat)
		{
			setVisible(false);
		}
	}
	//ham su thay doi tren du lieu ma nguoi dung nhap vao
	public void Luu()
	{
		try
		{
			connect();
			//rs chua cac ban ghi tren bang Goi_mon
			rs = stmt.executeQuery("SELECT * FROM Goi_mon");
			String Ban = chBanID.getItem(chTenBan.getSelectedIndex());
			String DoUong = chDoUongID.getItem(chTenDoUong.getSelectedIndex());
			rs.next();
			int i =1;
			while(!((rs.getString(2).equals(Ban))&&(rs.getString(3).equals(DoUong))))
			{
				rs.next();
				i++;
			}
			rs.absolute(i);
			rs.updateLong(4, (rs.getLong(4)+(Long.valueOf(txtSoLuong.getText()))));
			rs.updateRow();//cap nhat lai ban ghi co trong rs va bang Goi_mon
			txtSoLuong.setText("");
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.toString());
		}
	}
	public void connect()
	{
		try 
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (ClassNotFoundException ex) 
		{
			System.out.print("Error: " + ex.getMessage());
		}
		try
		{
			String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=c:/cafe.mdb";
			con = DriverManager.getConnection(url);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(SQLException se)
		{
			System.err.println("Error: "+se.getMessage());
		}
	}
}
