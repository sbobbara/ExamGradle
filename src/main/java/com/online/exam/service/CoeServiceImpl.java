package com.online.exam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.exam.dao.QuestionDao;
import com.online.exam.entity.Candidate;
import com.online.exam.entity.Questions;
import com.online.exam.exception.QuestionBankNotFoundException;
import com.online.exam.exception.QuestionNotFoundException;

@Component
@Transactional
public class CoeServiceImpl implements CoeService{
	
@Autowired
private QuestionDao qDao;	

	@Override
	public Questions add(Questions question) {
		Questions ques = qDao.save(question);
		return ques;
	
}

//	@Override
//	public Questions deleteQuestions(Integer questionId) {
//		Questions ques= deleteQuestions(questionId);
//		qDao.deleteById(questionId);
//		return ques;
//	}

	@Override
	public Questions editQuestions(Questions ques) {
		boolean exists=qDao.existsById(ques.getQuestionId());
		if(!exists){
		      
            throw new QuestionNotFoundException("question doesn't exists for id="+ques.getQuestionId());
        }
		return qDao.save(ques);	
	}

	@Override
	public List<Questions> showQuestions() {
		List<Questions> quesList = qDao.findAll();
		return quesList;
	}

//	@Override
//	public Questions findByquestionId(int questionId) {
//		return qDao.findByquestionId(questionId);
//	}

	@Override
	public void deleteQuestions(Integer questionId) {
if(!qDao.existsById(questionId)) {
			
			throw new QuestionNotFoundException("the question is not deleted for the  id  "+questionId);
		}
		qDao.deleteById(questionId);
	}

@Override
public Questions getQuestionById(Integer questionId) {
	if(!qDao.existsById(questionId)) {
		
		throw new QuestionNotFoundException("the question is not found for the  id  "+questionId);
	}
	Optional<Questions> optional = qDao.findById(questionId);
//	if(!optional.isPresent()){
//    	System.out.println("***error***");
//       // throw new StudentNotFoundException("student not found for id="+id);
//    }
    Questions ques=optional.get();
	return ques;
}

//	@Override
//	public Questions findByquestionId(Integer questionId) {
//		// TODO Auto-generated method stub
//		return qDao.findByquestionId(questionId);
//	}

	

	

	

	
}


