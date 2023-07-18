package in.ineuron.service;

import in.ineuron.dao.IBlogDao;
import in.ineuron.daofactory.BlogDaoFactory;
import in.ineuron.dto.Blog;

public class BlogServiceImpl implements IBlogService {
	IBlogDao dao = BlogDaoFactory.getBlogDao();

	@Override
	public String insertBlog(Blog blog) {
		System.out.println("BlogServiceImpl.insertBlog()");
		return dao.insertBlog(blog);
	}

	@Override
	public Blog searchBlog(String blogTitle) {
		System.out.println("BlogServiceImpl.searchBlog()");
		return dao.searchBlog(blogTitle);
	}

}