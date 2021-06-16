import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class GhepBan extends Frame implements ActionListener
{
	Panel panelSub = new Panel(new GridLayout(5,2));
	Panel panelSpace = new Panel();
	Panel panelCenter = new Panel();
	Panel panelSouth = new Panel();
	Label lbSpace = new Label("  ");
	Label lbChinh = new Label("GHEP BAN",Label.CENTER);
	Label lbBanGhep1 = new Label("Ban can ghep 1:     ");
	Label lbBanGhep2 = new Label("Ban can ghep 2:     ");
	Label lbBanGhep3 = new Label("Ban sau khi ghep:   ");
	Choice chBanGhep1 = new Choice();
	Choice chMaBan1 = new Choice();
	Choice chMaBan2 = new Choice();
	Choice chBanGhep2 = new Choice();
	Choice chMaBan3 = new Choice();
	Choice chBanGhep3 = new Choice();
	Button buttLuu = new Button("Luu");
	Button buttThoat = new Button("Thoat");
	java.sql.Connection con;
	java.sql.Statement stmt;
	ResultSet rs;
	public GhepBan(String title)
	{
		super(title);
		lbChinh.setFont(new Font("Tahoma",Font.BOLD,20));
		add(lbChinh,BorderLayout.NORTH);
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Ban");
			rs.next();
			while(!rs.isAfterLast())
			{
				chMaBan1.addItem(rs.getString(1));
				chBanGhep1.addItem(rs.getString(2));
				rs.next();
			}
		}
		catch(Exception e){}
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Ban");
			rs.next();
			while(!rs.isAfterLast())
			{
				chMaBan2.addItem(rs.getString(1));
				chBanGhep2.addItem(rs.getString(2));
				rs.next();
			}
		}
		catch(Exception e){}
		try
		{
			connect();
			rs = stmt.executeQuery("SELECT * FROM Ban");
			rs.next();
			while(!rs.isAfterLast())
			{
				chMaBan3.addItem(rs.getString(1));
				chBanGhep3.addItem(rs.getString(2));
				rs.next();
			}
		}
		catch(Exception e){}
		panelSub.add(lbBanGhep1);
		panelSub.add(chBanGhep1);
		panelSub.add(new Label());
		panelSub.add(new Label());
		panelSub.add(lbBanGhep2);
		panelSub.add(chBanGhep2);
		panelSub.add(new Label());
		panelSub.add(new Label());
		panelSub.add(lbBanGhep3);
		panelSub.add(chBanGhep3);
		panelSpace.add(lbSpace);
		panelCenter.add(panelSub);
		panelCenter.add(panelSpace);
		add(panelCenter,BorderLayout.CENTER);
		panelSouth.add(buttLuu);
		panelSouth.add(buttThoat);
		add(panelSouth,BorderLayout.SOUTH);
		buttLuu.addActionListener(this);
		buttThoat.addActionListener(this);
		setFont(new Font("Arial",Font.PLAIN,14));
		setLocation(250,50);
		setSize(400, 250);
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
			String Ban1 = chMaBan1.getItem(chBanGhep1.getSelectedIndex());
			String Ban2 = chMaBan2.getItem(chBanGhep2.getSelectedIndex());
			String Ban3 = chMaBan3.getItem(chBanGhep3.getSelectedIndex());
			rs = stmt.executeQuery("SELECT * FROM Goi_mon");
			System.out.println(Ban1);
			rs.next();
			String strBan = rs.getString(2);
			String strDoUong;
			Long l;
			//bien k dung de luu lai so ban ghi cau rs truoc khi co su thay doi
			//bien n dung de khoi tao ma goi cho ban ghi moi khi trong rs co hai 
			//ban ghi co DoUongID giong nhau, voi so luong la tong so luong cua 
			//hai ban ghi tren.
			int i=1,j,k=0,n=100,size=0;
			int rowNum[] = new int[20];
			while((!rs.isAfterLast())&&(((strBan.equals(Ban1)))||(strBan.equals(Ban2))))
			{
				k++;
				rs.next();
			}
			while((i<=k)&&(((strBan.equals(Ban1)))||(strBan.equals(Ban2))))
			{
				rs.absolute(i++);
				strBan=rs.getString(2);
				strDoUong=rs.getString(3);
				l = rs.getLong(4);
				rs.moveToInsertRow();
				rs.updateString(2, Ban3);
				rs.updateRow();
				for(j=i;j<=k;j++)
				{
					rs.absolute(j);
					if(rs.getString(3).equals(strDoUong))
					{
						rowNum[size++]=i-1;
						rs.moveToInsertRow();
						rs.updateLong(1, n++);
						rs.updateString(2,Ban3);
						rs.updateString(3, rs.getString(3));
						rs.updateLong(4,(l+rs.getLong(4)));
						rs.updateRow();
					}
				}
			}
			//xoa ban ghi cua hai ban ghi truoc khi ghep
			for(i=0;i<rowNum.length;i++)
			{
				rs.absolute(rowNum[i]);
				rs.deleteRow();
			}
			
		}
		catch(SQLException se){}
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
