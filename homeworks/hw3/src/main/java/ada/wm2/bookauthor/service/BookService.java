package ada.wm2.bookauthor.service;

import ada.wm2.bookauthor.bean.BookBean;
import ada.wm2.bookauthor.entity.BookEntity;
import ada.wm2.bookauthor.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
	@Autowired
	private BookRepo bookRepo;
	
	public List<BookBean> getAllBooks()
	{
		List<BookBean> bookBeans = new ArrayList<>();
		
		bookRepo.findAll().forEach(bookEntity -> {
			bookBeans.add(new BookBean(bookEntity));
		});
		
		return bookBeans;
	}
	
	public BookBean getBookWithID(Integer ID)
	{
		Optional<BookEntity> bookOptional = bookRepo.findById(ID);
		
		BookBean bookBean = null;
		
		if (bookOptional.isPresent())
		{
			bookBean = new BookBean(bookOptional.get());
		}
		
		return bookBean;
	}
	
	public BookEntity getBookEntityWithID(Integer ID)
	{
		return bookRepo.findById(ID).orElse(null);
	}
	
	public void saveBook(BookEntity bookEntity)
	{
		bookRepo.save(bookEntity);
	}
	
	public void deleteBook(BookEntity bookEntity)
	{
		bookRepo.delete(bookEntity);
	}
}
