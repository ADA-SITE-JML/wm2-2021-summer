package ada.wm2.bookauthor.service;

import ada.wm2.bookauthor.bean.AuthorBean;
import ada.wm2.bookauthor.entity.AuthorEntity;
import ada.wm2.bookauthor.repo.AuthorRepo;
import ada.wm2.bookauthor.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService
{
	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private BookRepo bookRepo;

	public List<AuthorBean> getAllAuthors()
	{
		List<AuthorBean> authorBeans = new ArrayList<>();
		
		authorRepo.findAll().forEach(authorEntity -> {
			authorBeans.add(new AuthorBean(authorEntity));
		});
		
		return authorBeans;
	}
	
	public AuthorBean getAuthorWithID(Integer ID)
	{
		Optional<AuthorEntity> authorOptional = authorRepo.findById(ID);
		
		AuthorBean authorBean = null;
		
		if (authorOptional.isPresent())
		{
			authorBean = new AuthorBean(authorOptional.get());
		}
		
		return authorBean;
	}
	
	public AuthorEntity getAuthorEntityWithID(Integer ID)
	{
		return authorRepo.findById(ID).orElse(null);
	}
	
	public AuthorEntity saveAuthor(AuthorEntity authorEntity)
	{
		return authorRepo.save(authorEntity);
	}
	
	public void deleteAuthor(AuthorEntity authorEntity)
	{
		authorRepo.delete(authorEntity);
	}

	public ArrayList<String> getBookNames(Integer author_id){
		ArrayList<Integer> book_ids = authorRepo.getbooks(author_id);
		ArrayList<String> book_names = new ArrayList<>();
		for (int i = 0; i < book_ids.size(); i++){
			book_names.add(bookRepo.getBookByID(book_ids.get(i)));
		}

		System.out.println(book_names);
		return book_names;
	}


}
