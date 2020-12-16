package reply.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import reply.service.ReplyDeleteAllService;

public class ReplyDeleteAllHandler implements CommandHandler {
	private ReplyDeleteAllService deleteAllSerivce = new ReplyDeleteAllService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		deleteAllSerivce.add();
		
		return "replyDeleteAllSuccess";
	}

}
