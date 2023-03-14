package com.online.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.online.exam.entity.Candidate;
@Service
public interface CandidateService {
	public List<Candidate> getAllCandidates();
	public Candidate getCandidateById(Integer candidate);
	public Candidate addCandidate(Candidate candidate);
	public Candidate updateCandidate(Candidate candidate);
	public void deleteCandidateById(Integer candidateId);
	//public Candidate updateCandidate(Candidate can);
	
	
	
}
