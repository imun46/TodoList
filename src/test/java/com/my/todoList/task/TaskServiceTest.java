//package com.my.todoList.task;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.my.todoList.task.dto.TaskDto;
//
//@SpringBootTest
//class TaskServiceTest {
//	@Autowired
//	private TaskService taskService;
//	
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
////	@Test
//	void testCreateTask() throws Exception {
//		LocalDate date = LocalDate.now();
//		TaskDto task = TaskDto.builder()
//				.title("똥싸기")
//				.content("아침에 똥싸는게 좋잖아")
//				.startDate(date)
//				.endDate(date)
//				.categoryNo(1)
//				.userNo(2)
//				.build();
//		System.out.println(taskService.createTask(task));
//	}
//
////	@Test
//	void testDeleteTask() throws Exception {
//		System.out.println(taskService.deleteTask(10));
//	} 
//
////	@Test
//	void testUpdate() throws Exception {
//		LocalDate date = LocalDate.now();
//		TaskDto task = TaskDto.builder()
//				.taskNo(3)
//				.title("똥싸기")
//				.content("아침에 똥싸는게 좋잖아")
//				.startDate(date)
//				.endDate(date)
//				.state("active")
//				.build();
//		System.out.println(taskService.update(task));
//	}
//	
//	@Test
//	void testFindTaskByTaskNo() throws Exception {
//		System.out.println(taskService.findTaskByTaskNo(12));
//	}
//
////	@Test
//	void testFindTaskByUserNo() throws Exception {
//		System.out.println(taskService.findTaskByUserNo(2));
//	}
//
//}
