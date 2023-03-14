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
@Import(CoeServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class CoeServiceImplTest {

	@Autowired
	private CoeService coeService;
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
		System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	void testAdd() {
		Questions question = new Questions(1,"java","oop","features","op","oo",4);
		
		question = coeService.add(question);
	}

//	@Test
//	void testDeleteQuestions() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEditQuestions() {
//		fail("Not yet implemented");
//	}

	@Test
	void testShowQuestions() {
		List<Questions> quesList= coeService. showQuestions();
		assertTrue(!quesList.isEmpty());
	}

	@Test
	void testGetByquestionId() {
		Questions ques = new Questions(1,"java","oop","features","op","oo",4);
		coeService.add(ques);
		int id=ques.getQuestionId();
		Questions qFound=coeService.getQuestionById(7);
	}

}
