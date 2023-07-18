
package in.ineuron.dao;

import in.ineuron.dto.Blog;

public interface IBlogDao {
	public String insertBlog(Blog blog);

	public Blog searchBlog(String blogTitle);
}