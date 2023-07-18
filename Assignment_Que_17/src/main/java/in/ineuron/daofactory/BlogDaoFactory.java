package in.ineuron.daofactory;

import in.ineuron.dao.BlogDaoImpl;
import in.ineuron.dao.IBlogDao;

public class BlogDaoFactory {
	//make constructor private to avoid object creation 
		private BlogDaoFactory() {} 

		private static IBlogDao blogDao = null;

		public static IBlogDao getBlogDao() {

			//singleton pattern code
			if(blogDao == null) {
				blogDao = new BlogDaoImpl();
			}
			return blogDao;
		}
}