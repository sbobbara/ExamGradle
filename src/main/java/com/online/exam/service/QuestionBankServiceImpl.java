package com.online.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.exam.dao.QuestionBankDao;
import com.online.exam.entity.QuestionBank;
import com.online.exam.entity.Questions;
import com.online.exam.exception.QuestionBankNotFoundException;



@Service
public class QuestionBankServiceImpl implements QuestionBankService{
	
	@Autowired
	private QuestionBankDao QuesBDao;

	@Override
	public QuestionBank add(QuestionBank questionbank) {
		QuestionBank question = QuesBDao.save(questionbank);
		return question;
	}

	@Override
	public QuestionBank deleteQuestionBank(Integer quesbankid) {
if(!QuesBDao.existsById(quesbankid)) {
			
			throw new QuestionBankNotFoundException("the qb is not deleted for the  id  "+quesbankid);
		}
		QuestionBank ques = deleteQuestionBank(quesbankid);
		QuesBDao.deleteById(quesbankid);
		return ques;
		
	}

	@Override
	public QuestionBank editQuestionbank(QuestionBank quesB) {
		boolean exists=QuesBDao.existsById(quesB.getQuesbankid());
        if(!exists){
      
            throw new QuestionBankNotFoundException("questionbank doesn't exists for id="+quesB.getQuesbankid());
        }
		return QuesBDao.save(quesB);
	}

	

	@Override
	public List<QuestionBank> showQuestionbank() {
		List<QuestionBank> quesbankList = QuesBDao.findAll();
		return quesbankList;
	}

	@Override
	public QuestionBank getQuestionBankById(int quesbankId) {
		if(!QuesBDao.existsById(quesbankId)) {
			
			throw new QuestionBankNotFoundException("the qb is not found for the  id  "+quesbankId);
		}
		Optional<QuestionBank> optional = QuesBDao.findById(quesbankId);
//		if(!optional.isPresent()){
//	    	//System.out.println("***error***");
//	        throw new QuestionBankNotFoundException("qb not found for id="+quesbankId);
//	    }
//		
	    QuestionBank quesb=optional.get();
		return quesb;
	}


//	@Override
//	public QuestionBank findByquesbankid(int quesbankid) {
//		return QuesBDao.findByquesbankid(quesbankid);
//	}

}
