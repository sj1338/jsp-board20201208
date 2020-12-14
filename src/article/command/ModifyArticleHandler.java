package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ModifyArticleService;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ModifyArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "modifyForm";
	
	private ReadArticleService readService = new ReadArticleService();
	private ModifyArticleService modifyService = new ModifyArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
			if(req.getMethod().equalsIgnoreCase("GET")) {
				return processForm(req, res);
			} else if (req.getMethod().equalsIgnoreCase("POST")) {
				return processSubmit(req, res);
			} else {
				res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
		}
		
		private String processForm(HttpServletRequest req, HttpServletResponse res)
		throws IOException {
			try {
				String noVal = req.getParameter("no");
				int no = Integer.parseInt(noVal);
				ArticleDate articleDate = readSerivice.getArticle(no, false);
				User authUser = (User) req.getSession().getAttribute("authUser");
				if(!canModify(authUser, articleData)) {
					res.sendError(HttpServletResponse.);
			}
		}
		
	}
}
