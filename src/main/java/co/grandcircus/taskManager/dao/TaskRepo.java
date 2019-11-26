package co.grandcircus.taskManager.dao;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.grandcircus.taskManager.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {
	@Query("select description from Task where owner_ID = :givenID")
	List<String> getTasksById(@Param("givenID") String uid);
	
	@Query("from Task where owner_ID = :givenID")
	List<Task> getTaskListById(@Param("givenID") String uid);
	
	@Modifying
	@Query("update Task set description = :description, dueDate = :dueDate, complete = :complete where id = :id")
	void updateTask(@Param("description")String description, @Param("dueDate")GregorianCalendar dueDate, @Param("complete")Boolean complete, @Param("id")int id);
}
