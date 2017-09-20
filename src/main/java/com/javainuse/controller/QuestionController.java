package com.javainuse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.QuesionObject;
import com.javainuse.service.QuestionService;

@RestController
public class QuestionController {


	private final QuestionService Service;

	@Autowired
	public QuestionController(QuestionService service) {
		this.Service = service;
	}

	@RequestMapping(value = "/getNextQuestion", method = RequestMethod.GET, produces = "application/json")
	public QuesionObject getQuestions(@RequestParam(required = true) String questionId,@RequestParam(required = true) String answerId) {

		QuesionObject product = new QuesionObject();
		product.setQuestionId(Integer.parseInt(questionId));
		product.setAnswerId(Integer.parseInt(answerId));
		
		Service.getProductDiscount(product);

		return product;
	}
	
	
	@RequestMapping(value = "/getQuestions", method = RequestMethod.GET, produces = "application/json")
	public List<QuesionObject> getQuestions() {

		List<QuesionObject> questionList = new ArrayList<QuesionObject>();
		
		QuesionObject question = new QuesionObject();
		question.setQuestionId(1);
		question.setQuestion("What do you like most?");
		question.setAnswer("1.Tea, 2.Coffee");
		questionList.add(question);
		
		
		QuesionObject questionTwo = new QuesionObject();
		questionTwo.setQuestionId(2);
		questionTwo.setQuestion("Do you like to travel?");
		questionTwo.setAnswer("1.Yes, 2.No");
		questionList.add(questionTwo);
		
		QuesionObject questionThree = new QuesionObject();
		questionThree.setQuestionId(3);
		questionThree.setQuestion("Are you having headeche problem?");
		questionThree.setAnswer("1.Yes, 2.No");
		questionList.add(questionThree);
		
		
		QuesionObject questionFour = new QuesionObject();
		questionFour.setQuestionId(4);
		questionFour.setQuestion("Do you have digestion problem");
		questionFour.setAnswer("1.Yes, 2.No");
		questionList.add(questionFour);

		return questionList;
	}

}

	
	

