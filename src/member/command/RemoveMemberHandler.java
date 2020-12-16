package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import member.service.RemoveMemberService;
import mvc.command.CommandHandler;

public class RemoveMemberHandler implements CommandHandler {
	private static final String FORM_VIEW = "removeMemberForm";
	private RemoveMemberService removeMemberSvc = new RemoveMemberService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;

	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");
		// 세션에서 user 객체 얻기(authUser attribute)
		
		HttpSession session = req.getSession(); // invalid 쓸수있게 사전작업 
		
		// password 파라미터를 얻기
		
		String password = req.getParameter("password");
		
		// - errors 맵을 만들어서
		// - request attribute에 넣고
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		// password 가 null 이거나 비어 있으면(empty)
		// - errors에 (코드와 true) 넣기
		// view의 이름을 리턴
		
		if (password == null || password.isEmpty()) { 
			errors.put("password", true);
		}
		
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
	
		System.out.println(password);
		// 서비스에게 일 시키기
		try {
			removeMemberSvc.removeMember(user, password);
			
			// 세션을 invalide() // 일을 성공시키기 전에 해야하니까 return 전에 써야함
			session.invalidate();
			return "removeMemberSuccess";
	
		
			
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			errors.put("invalidPassword", true);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
	}
	
	
}



