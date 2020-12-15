package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import auth.service.User;
import mvc.command.CommandHandler;
import reply.service.ReplyAddService;
import reply.service.ReplyDeleteAllService;

public class ReplyDeleteAllHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		return "replyDeleteAllSuccess";
	}

}
