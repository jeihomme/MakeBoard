package board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Main {

	private static final Logger logger
	= LoggerFactory.getLogger(Main.class);
	
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public void main(
			HttpSession session
			) {
		
		logger.info("---main---");

	}
}
