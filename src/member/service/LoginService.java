package member.service;

import java.sql.Connection;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	private MemberDao memberDao = new MemberDao();
	
	public User login(String id, String password) {
		try(Connection con = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(con, id);
			if(member == null) {
				throw new LoginFailException();
			}
			if(!member.matchPassword(password)) {
				throw new LoginFailException();
			}
			
			return new User(member.getId(), member.getName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
