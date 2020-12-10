package com.vti.test;

import java.util.Date;
import java.util.List;

import com.vti.entity.Group;
import com.vti.entity.Question_Level;
import com.vti.repository.GroupRepository;
import com.vti.repository.QuestionLevelRepository;

public class Question_LevelTest {
	public static void main(String[] arg) {
		QuestionLevelRepository questionLevelRepository = new QuestionLevelRepository();

		System.out.println("***********GET ALL Question_Level***********");

		List<Question_Level> questionLevels = questionLevelRepository.getAllQuestion_Levels();
		for (Question_Level questionLevel : questionLevels) {
			System.out.println(questionLevel);
		}	 
 }
}