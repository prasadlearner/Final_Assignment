package in.ineuron.service;

import in.ineuron.dto.Blog;

public interface IBlogService {
	public String insertBlog(Blog blog);

	public Blog searchBlog(String blogTitle);
}