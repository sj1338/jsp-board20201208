package article.service;

import java.util.List;

import article.model.Article;

public class ArticlePage {
	private int total; // 전체 게시물 수
	private int currentPage; // 현재 페이지
	private List<Article> content; // select 한 데이터 들
	private int totalPages; // 총 페이지 수
	private int startPage; // 시작 페이지
	private int endPage; // 마지막 페이지
	
	public ArticlePage(int total, int currentPage, int size, List<Article> content) {
		this.total = total;  // this.total은 클래스(위)에 있는 private int total 이란뜻이고 / 뒤 = total은 public ArticlePage(int total 요 토탈임을 서로 이어주는, 길을알려주는뜻
		this.currentPage = currentPage;
		this.content = content;
		
		if(total != 0) {
			this.totalPages = total / size; // size는 그냥 그 페이지의 글 목록 수
			if(total % size > 0) {
				this.totalPages++; // 글이 88개인데 한페이지당 표시가 10개면 짜투리가 8이되니까 페이지를 +1 해줘서 총 9페이지가 되게 하기 (9페이지에 글 8개)
			}
			
			this.startPage = (currentPage - 1) / 5 * 5 + 1; // int 는 소숫점 버린다는걸 잊지말기
			this.endPage = Math.min(startPage + 4, totalPages);
			
		}
	}
}
