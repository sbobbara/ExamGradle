package com.online.exam.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
import com.online.exam.entity.QuestionBank;
import com.online.exam.entity.Questions;
@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(QuestionBankServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class QuestionbankServiceImplTest {

	
	@Autowired
	private QuestionBankService QuesBService;
	

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
	void testAdd() {
		QuestionBank questionbank = new QuestionBank(2,1, "java","oop");
		
	questionbank = QuesBService.add(questionbank);

	}

//	@Test
//	void testDeleteQuestionBank() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEditQuestionbank() {
//		fail("Not yet implemented");
//	}

	@Test
	void testShowQuestionbank() {
		List<QuestionBank> quesbankList= QuesBService. showQuestionbank();
		assertTrue(!quesbankList.isEmpty());
	}
	@Test
	void testGetQuestionBankById() {
		QuestionBank questionbank = new QuestionBank(3,1, "java","oop");
		QuesBService.add(questionbank);
		int id=questionbank.getQuesbankid();
		QuestionBank qFound=QuesBService.getQuestionBankById(12);
	}

}
