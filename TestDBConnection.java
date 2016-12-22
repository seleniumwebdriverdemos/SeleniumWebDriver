import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public class TestDBConnection {

	
	public static void main(String[] args) throws AddressException, SQLException, ClassNotFoundException, MessagingException {

		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id = 1"));

	}

}
