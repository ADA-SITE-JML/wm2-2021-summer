package ada.wm2.bookauthor.controller;

import ada.wm2.bookauthor.entity.AuthorEntity;
import ada.wm2.bookauthor.entity.BookEntity;
import ada.wm2.bookauthor.service.AuthorService;
import ada.wm2.bookauthor.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
//@RequestMapping("/main")
public class HomeController
{
	Logger log = LoggerFactory.getLogger("HomeController");
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;

	// LOGIN

//	@GetMapping("/login")
//	public String showLogin() {
//		return "login";
//	}

	// BOOK

	@GetMapping
	public String getHome(Model model)
	{
		model.addAttribute("bookList", bookService.getAllBooks());
		model.addAttribute("authorList", authorService.getAllAuthors());
		return "home";
	}
	
	@GetMapping("/edit-book/{bookID}")
	public String getBookEditPage(Model model, @PathVariable Integer bookID)
	{
		model.addAttribute("book", bookService.getBookWithID(bookID));
		return "bookEditPage";
	}
	
	@PostMapping("/save-edited-book/{bookID}")
	public String saveEditedBook(@PathVariable Integer bookID,
	                             @RequestParam String name,
	                             @RequestParam String pubDate)
	{
		BookEntity bookEntity = bookService.getBookEntityWithID(bookID);
		if (bookEntity != null)
		{
			bookEntity.setName(name);
			bookEntity.setPubDate(pubDate);
			bookService.saveBook(bookEntity);
		}
		return "redirect:/";
	}
	
	@PostMapping("/delete-book/{bookID}")
	public String deleteBook(@PathVariable Integer bookID)
	{
		BookEntity bookEntity = bookService.getBookEntityWithID(bookID);
		if (bookEntity != null) bookService.deleteBook(bookEntity);
		return "redirect:/";
	}
	
	@GetMapping("/add-book")
	public String getBookAddPage()
	{
		return "bookAddPage";
	}
	
	@PostMapping("/add-book")
	public String addNewBook(@RequestParam String name,
	                         @RequestParam String pubDate)
	{
		BookEntity bookEntity = new BookEntity(name, pubDate);
		bookService.saveBook(bookEntity);
		return "redirect:/";
	}
	
	
	// AUTHOR

	@PostMapping("/delete-author/{authorID}")
	public String deleteAuthor(@PathVariable Integer authorID)
	{
		AuthorEntity authorEntity = authorService.getAuthorEntityWithID(authorID);
		if (authorEntity != null) authorService.deleteAuthor(authorEntity);
		return "redirect:/";
	}
	
	@GetMapping("/edit-author/{authorID}")
	public String getAuthorEditPage(Model model, @PathVariable Integer authorID)
	{
		model.addAttribute("author", authorService.getAuthorWithID(authorID));
		model.addAttribute("allBooks", bookService.getAllBooks());
		return "authorEditPage";
	}
	
	@PostMapping("/save-edited-author/{authorID}")
	public String saveEditedAuthor(@PathVariable Integer authorID,
								   /*@Valid*/ @RequestParam String name,
								   @RequestParam String birthDate/*,
								   BindingResult bindingResult*/)
	{
//		if (bindingResult.hasErrors()) {
//			log.error("There are validation error for Author!");
//			return "authorEditPage";
//		}
//		log.info("Author saved and edited successfully!");
		AuthorEntity authorEntity = authorService.getAuthorEntityWithID(authorID);
		if (authorEntity != null)
		{
			authorEntity.setName(name);
			authorEntity.setBirthDate(birthDate);
			authorService.saveAuthor(authorEntity);
		}
		return "redirect:/";
	}
	
	@GetMapping("/add-author")
	public String getAuthorAddPage()
	{
		return "authorAddPage";
	}
	
	@PostMapping("/add-author")
	public String addNewAuthor(@Valid @RequestParam String name,
	                           @Valid @RequestParam String birthDate,
							   BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			log.error("There are validation error for Author add part!");
			return "authorAddPage";
		}

		log.info("Author added successfully!");
		AuthorEntity authorEntity = new AuthorEntity(name, birthDate);
		authorService.saveAuthor(authorEntity);
		return "redirect:/";
	}

	@GetMapping ("/sample")
	public ResponseEntity getBookByAuthor(@RequestParam Integer author_id){

		return ResponseEntity.ok(authorService.getBookNames(author_id));
	}


	// WELCOME

	@GetMapping("/welcome")
	public String showWelcome(Model model){
		model.addAttribute("message", "welcome to hw 3");
		return "welcome";
	}

}
