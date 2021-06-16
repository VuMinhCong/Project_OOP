import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class TrangThai extends Frame implements ActionListener
{
	int n=0;//dung de duyet cac ban
	Panel panelSouth = new Panel();
	Label lbChinh = new Label("Trang thai Ban",Label.CENTER);
	TextArea txaChinh = new TextArea();
	Button buttXem = new Button("   Xem   ");
	Button buttThoat = new Button("  Thoat  ");
	Choice chMaBan = new Choice();
	Choice chTenBan = new Choice();
	java.sql.Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	public TrangThai(String title)
	{
		super(title);
		lbChinh.setFont(new Font("Tahoma",Font.BOLD,20));
		add(lbChinh,BorderLayout.NORTH);
		txaChinh.setEditable(false);
		txaChinh.setText("\tTen Ban\t\tTrang thai\n\n");
		add(txaChinh,BorderLayout.CENTER);
		panelSouth.add(buttXem);
		panelSouth.add(buttThoat);
		add(panelSouth,BorderLayout.SOUTH);
		buttXem.addActionListener(this);
		buttThoat.addActionListener(this);
		setFont(new Font("Arial",Font.PLAIN,14));
		setLocation(200,50);
		setSize(400, 400);
		setResizable(false);
		setVisible(true);
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Ban");
			rs.next();
			while(!rs.isAfterLast())
			{
				chMaBan.addItem(rs.getString(1));
				chTenBan.addItem(rs.getString(2));
				n++;
				rs.next();
			}
		}
		catch(Exception e){}
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==buttXem)
			Xem();
		if(e.getSource() == buttThoat)
		{
			setVisible(false);
		}
	}
	public void Xem()
	{
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT BanID FROM Goi_mon");
			for(int i = 0; i<n;i++)
			{
				String s = chMaBan.getItem(i);
				rs.first();
				boolean flag = false;
				while(!rs.isAfterLast())
				{
					if(rs.getString(1).equals(s))
					{
						flag = true;
						break;
					}
					rs.next();
				}
				if(flag == true)
					txaChinh.append("\t"+chTenBan.getItem(i)+"\t\t\tDa su dung");
				else
					txaChinh.append("\t"+chTenBan.getItem(i)+"\t\t\tChua su dung");
				txaChinh.append("\n");
			}
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
