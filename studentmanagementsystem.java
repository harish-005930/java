package jdbc1;

import java.sql.*;
import java.util.*;
class studentmanagementsystem{
	static  final String url="jdbc:mysql://localhost:3306/college";
	static  final String username="root";
	static  final String pw="root";
	static Connection con;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,pw);
			System.out.println("Connection Successfully");
			int ch;
			do {
				System.out.println("Menu:");
				System.out.println("1.insert");
				System.out.println("2.view");
				System.out.println("3.update");
				System.out.println("4.delete");
				System.out.println("5.search");
				System.out.println("6.exit");
				System.out.println("Enter a Choice:");
				ch=sc.nextInt();
				switch(ch) {
				case 1:insertvalue();break;
				case 2:readvalue1();break;
				case 3:updatevalue();break;
				case 4:deletevalue();break;
				case 5:search();break;
				case 6:System.out.println("Exit");break;
				default:System.out.println("Invalid Choice");
				}
			}while(ch!=6);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				
			}
		}
		
	}
	static void createtable() throws SQLException{
		String q="create table tbname(id int primary key auto_increment,name varchar(30),age int,dprt varchar(30));";
		Statement st=con.createStatement();
		int state=st.executeUpdate(q);
		System.out.println("Table Created Sucessfully");
	}
	static void insertvalue() throws SQLException{
		String q="insert into tbname(name,age,dprt) values('AAA',26,'CSE'),('BBB',28,'AIDS');";
		String q1="insert into tbname(name,age,dprt) values(?,?,?);";
		System.out.println("Enter name:");
//		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter age:");
//		sc.nextLine();
		int age=sc.nextInt();
		System.out.println("Enter department:");
		sc.nextLine();
		String dprt= sc.nextLine();
		PreparedStatement ss=con.prepareStatement(q1);
		ss.setString(1,name);
		ss.setInt(2,age);
		ss.setString(3,dprt);
		Statement st=con.createStatement();
		int state=st.executeUpdate(q);
		int state1=ss.executeUpdate();

		System.out.println("Table values inserted Sucessfully");
	}
	static void readvalue1() throws SQLException{
		String q="select*from tbname";
		Statement st=con.createStatement();
		ResultSet s=st.executeQuery(q);
		while(s.next()) {
			System.out.println(s.getInt(1)+" "+s.getString(2)+" "+s.getInt(3)+" "+s.getString(4));
		}
		
	}
	static void updatevalue() throws SQLException{
		String name=sc.nextLine();
		int id=sc.nextInt();
		
		String q="update tbname set name=? where id=?";
		PreparedStatement st=con.prepareStatement(q);
		st.setString(1,name);
		st.setInt(2,id);
		int s=st.executeUpdate();
		System.out.println("the value is updated");
	}

	static void deletevalue() throws SQLException{
		
		int id=sc.nextInt();
		
		String q="delete from tbname  where id=?";
		PreparedStatement st=con.prepareStatement(q);
		
		st.setInt(1,id);
		int s=st.executeUpdate();
		System.out.println("the value is deleted");
	}

static void search() throws SQLException{
	int id=sc.nextInt();
	String q="select *from tbname where id=?";
	PreparedStatement st = con.prepareStatement(q);
	st.setInt(1, id);
	ResultSet r=st.executeQuery();
	while(r.next()) {
		System.out.println(r.getInt(1)+" "+r.getString(2)+" "+r.getInt(3)+" "+r.getString(4));
	}
	System.out.println("the value is searched");
}
static void countvalue() throws SQLException{
	String q="select count(*)from tbname";
	Statement st = con.createStatement();
	ResultSet rs=st.executeQuery(q);
	while(rs.next()) {
		System.out.println("the total="+rs.getInt(1));
	}

	//System.out.println("the total");
}
}
