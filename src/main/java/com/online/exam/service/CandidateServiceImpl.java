package com.online.exam.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.online.exam.dao.CandidateDAO;
import com.online.exam.entity.Candidate;
import com.online.exam.exception.CandidateNotFoundException;
import com.online.exam.exception.QuestionBankNotFoundException;

@Component
@Transactional
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private CandidateDAO cDao;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
//	@Autowired
//	PasswordEncoder crypt;
	@Override
	public List<Candidate> getAllCandidates() {
//		List<Candidate> cList = cDao.findAll();
		return cDao.findAll();
	}
//	
//	@Bean
//	private BCryptPasswordEncoder getBCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Override
	public Candidate getCandidateById(Integer candidateId) {
if(!cDao.existsById(candidateId)) {
			
			throw new CandidateNotFoundException("the candidate is not found for the  id  "+candidateId);
		}

		Optional<Candidate> optional = cDao.findById(candidateId);
//		if(!optional.isPresent()){
//        	System.out.println("***error***");
//           // throw new StudentNotFoundException("student not found for id="+id);
//        }
        Candidate cand=optional.get();
		return cand;
	}

	@Override
	public Candidate addCandidate(Candidate candidate) {
		//candidate.setPassword(bcryptEncoder.encode(candidate.getPassword()));
		cDao.save(candidate);
		return candidate;
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		boolean exists=cDao.existsById(candidate.getCandidateId());
		if(!exists){
		      
            throw new CandidateNotFoundException("candidate doesn't exists for id="+candidate.getCandidateId());
        }

		return cDao.save(candidate);
	}

	@Override
	public void deleteCandidateById(Integer candidateId) {
if(!cDao.existsById(candidateId)) {
			
			throw new CandidateNotFoundException("the candidate is not deleted for the  id  "+candidateId);
		}
		cDao.deleteById(candidateId);		
	}

//	@Override
//	public Candidate updateCandidate(Candidate can) {
//		boolean exists=cDao.existsById(can.getCandidateId());
//		if(!exists){
//		      
//            throw new CandidateNotFoundException("candidate doesn't exists for id="+can.getCandidateId());
//        }
//
//		return cDao.save(can);
//	}
}