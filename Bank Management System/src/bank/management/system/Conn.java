package bank.management.system;

/* There are 5 step to connect JDBC
1) Register the Driver
2) Create Connection
3) Create Statement
4) Execute Query
5) Close Connection
 */
import java.sql.*;

public class Conn {

    Connection c;//step no 2
    Statement s;//step no 3

    public Conn() {
        try {
            /*Class.forName(com.mysql.cj.jdbc.Driver);//step no 1*/
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "system");//step no 2
            s = c.createStatement();//step no 3
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
