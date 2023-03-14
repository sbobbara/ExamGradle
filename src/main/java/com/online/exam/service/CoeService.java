package com.online.exam.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.online.exam.entity.Questions;


@Service
public interface CoeService {
Questions add(Questions ques);

	
	//Questions deleteQuestions(Integer questionId);
	
	Questions editQuestions(Questions ques);
	
	List<Questions> showQuestions();


	


	//Questions findByquestionId(int questionId);


	void deleteQuestions(Integer questionId);


	//Questions findByquestionId(Integer questionId);


	Questions getQuestionById(Integer questionId);


	
}