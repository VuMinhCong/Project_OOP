import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GoiMon extends Frame implements ActionListener
{
	Panel panelCenter = new Panel();
	Panel panelSub = new Panel(new GridLayout(4,2,10,10));
	Panel panelSouth = new Panel();
	Panel panelSpace = new Panel();
	Label lbSpace = new Label(" ");
	Label lbGoiMon = new Label("GOI MON",Label.CENTER);
	Label lbMaGoi = new Label("Luot goi:");
	Label lbBan = new Label("Ban:");
	Label lbDoUong = new Label("Do uong:");
	Label lbSoLuong = new Label("So luong:");
	TextField txtMaGoi = new TextField("Vd: 23 la Ban 2,Luot goi 3");
	Choice chBan = new Choice();
	Choice chTenBan = new Choice();
	Choice chDoUong = new Choice();
	Choice chTenDoUong = new Choice();
	TextField txtSoLuong = new TextField();
	Button buttLuu = new Button("   Luu   ");
	Button buttThoat = new Button(" Thoat ");
	java.sql.Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	public GoiMon(String title)
	{
		super(title);
		lbGoiMon.setFont(new Font("Tahoma",Font.BOLD,20));
		add(lbGoiMon,BorderLayout.NORTH);
		panelSub.add(lbMaGoi);
		panelSub.add(txtMaGoi);
		panelSub.add(lbBan);
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Ban");
			rs.next();
			while(!rs.isAfterLast())
			{
				chBan.addItem(rs.getString(1));
				chTenBan.addItem(rs.getString(2));
				rs.next();
			}
		}
		catch(Exception e){}
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Thuc_don");
			rs.next();
			while(!rs.isAfterLast())
			{
				chDoUong.addItem(rs.getString(1));
				chTenDoUong.addItem(rs.getString(2));
				rs.next();
			}
		}
		catch(Exception e){}

		panelSub.add(chTenBan);
		panelSub.add(lbDoUong);
		panelSub.add(chTenDoUong);
		panelSub.add(lbSoLuong);
		panelSub.add(txtSoLuong);
		panelCenter.add(panelSub);
		panelSpace.add(lbSpace);
		panelCenter.add(panelSpace);
		add(panelCenter,BorderLayout.CENTER);
		panelSouth.add(buttLuu);
		add(panelSouth,BorderLayout.SOUTH);
		panelSouth.add(buttThoat);
		add(panelSouth,BorderLayout.SOUTH);
		buttLuu.addActionListener(this);
		buttThoat.addActionListener(this);
		setFont(new Font("Arial",Font.PLAIN,14));
		setLocation(180,50);
		setSize(500, 250);
		setResizable(false);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==buttLuu)
			Luu();
		if(e.getSource() == buttThoat)
		{
			setVisible(false);
		}
	}
	public void Luu()
	{
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Goi_mon");
			rs.moveToInsertRow();
			rs.updateLong(1, Long.parseLong(txtMaGoi.getText()));
			int n = chTenBan.getSelectedIndex();
			rs.updateString(2, chBan.getItem(n));
			int m = chTenDoUong.getSelectedIndex();
			rs.updateString(3,chDoUong.getItem(m));
			rs.updateLong(4, Long.parseLong(txtSoLuong.getText()));
			rs.insertRow();
			txtMaGoi.setText("");
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
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //Nap trinh dieu khien Access
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
