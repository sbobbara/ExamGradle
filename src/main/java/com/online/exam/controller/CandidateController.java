package com.online.exam.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.exam.entity.Candidate;
import com.online.exam.entity.QuestionBank;
import com.online.exam.service.CandidateService;




@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService cService;

	@GetMapping("/getall")
	public List<Candidate> getAllCandidates() {
		
		return cService.getAllCandidates();

	}

	@GetMapping("/getcandidatebyid/{cId}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable("cId") Integer candidateId){
		return new ResponseEntity<Candidate>(cService.getCandidateById(candidateId), HttpStatus.OK);
	}

	@PostMapping("/registercandidate")
	public Candidate addCandidate(@RequestBody Candidate candidate) {

		return cService.addCandidate(candidate);
	}

	@PutMapping("/updatecandidate")
	public Candidate updateCandidate(@RequestBody Candidate candidate) {
		return cService.updateCandidate(candidate);

	}

	
//	@PutMapping("/updatecandidate")
//	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate can,HttpServletRequest request) {
//		HttpSession session= request.getSession();
//		Candidate candidate =cService.updateCandidate(can);
//		if (candidate == null) {
//			return new ResponseEntity("Sorry we can't update the candidate with id" + can.getCandidateId(), HttpStatus.OK);
//		}
//		String role=(String) session.getAttribute("role");
////		if(!role.equalsIgnoreCase("admin")) {
////			//logger.error("Not eligible not customer");
////			//throw new UserNotFoundException("You are not eligible to edit questionbank");
////		}
//		return new ResponseEntity<Candidate>(candidate, HttpStatus.OK);
//	}
	@DeleteMapping("/candidate/{cId}")
	public void deleteCandidateById(@PathVariable Integer cId) {
		this.cService.deleteCandidateById(cId);
	}

}
