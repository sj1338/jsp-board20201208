package reply.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import reply.dao.ReplyDao;

public class ReplyDeleteAllService {
	private ReplyDao dao = new ReplyDao();

	public void add() {
		Connection conn = ConnectionProvider.getConnection();
		
		try {
			dao.deleteAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
}
