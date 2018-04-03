package token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jdk.internal.jline.internal.Log;

//@Component
//public class AppRunner implements CommandLineRunner {
//
//    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
//
//    private final BookRepository bookRepository;
//
//    public AppRunner(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        logger.info(".... Fetching books");
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
//    }
//
//}

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Component
public class AppRunner implements CommandLineRunner {

	private static Logger log = LoggerFactory.getLogger(Application.class);


	@Autowired
	private TokenService tokenService;

	public AppRunner() {
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("Spring Boot Conditional Caching and Other Caching Annotations Example");
		
		log.info( "Fetching the Token for the first time");
		log.info(tokenService.getToken());
		
		log.info( "Fetching the Token for the second time, this fetch should be from the cache");
		log.info(tokenService.getToken());
		
		log.info( "Delete the Existing Token");
		tokenService.deleteToken();
		
		log.info ("Fetch the new Token");
		tokenService.fetchToken();
		
		log.info("Get the newly Fetched Token first attempt");
		log.info(tokenService.getToken());
		
		log.info("Get the newly Fetched Token second attempt");
		log.info(tokenService.getToken());

	}

	
}