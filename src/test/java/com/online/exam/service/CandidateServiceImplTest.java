package com.online.exam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.online.exam.entity.Candidate;


@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(CandidateServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class CandidateServiceImplTest {

	@Autowired
	private CandidateService cService;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	void testGetAllCandidate() {
		List<Candidate> cList= cService. getAllCandidates();
		assertTrue(!cList.isEmpty());
	}

	@Test
	void testAdd() {
		Candidate can = new Candidate(1,"Sunny","sunny@gmail.com",(long) 1230987645, "sunny", "bvrm", "bvraju");
//		boolean success =cService.add(can);
//		assertTrue(success);
		can = cService.addCandidate(can);
	}

//	
	@Test
	void testFindByuserid() {
		Candidate can = new Candidate(1,"Sunny","sunny@gmail.com",(long) 1230987645, "sunny", "bvrm", "bvraju");
		cService.addCandidate(can);
		int id=can.getCandidateId();
		Candidate cFound=cService.getCandidateById(1);
		//Assertions.assertEquals(cFound.getFullname(),"Sunny");
		
	}

}
