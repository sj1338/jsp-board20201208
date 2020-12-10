package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.User;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class RemoveMemberService {
	private MemberDao memberDao = new MemberDao();
	
	public void removeMember(User user, String password) {
		// 0. 커넥션 얻기
		Connection con = null;
		try {
		con = ConnectionProvider.getConnection();
		con.setAutoCommit(false);
		
		// 1. dao의 selectById로 member객체 얻기
		
		Member m = memberDao.selectById(con, user.getId());
		System.out.println(m);
		//    1.1 member없으면 MemberNotFoundException 발생
		
		if(m == null) {
			throw new MemberNotFoundException();
		}
		
		// 2. password와 member.password가 같은 지 확인
		//    2.1 다르면 InvalidPasswordException 발생
		
		
		if(!password.equals(m.getPassword())) {
			throw new InvalidPasswordException();
		}
		
		memberDao.delete(con, m.getId());
		
		// 3. delete() 실행
		con.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close();
		}
	}
}
