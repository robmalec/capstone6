package co.grandcircus.taskManager.dao;

import java.util.GregorianCalendar;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.grandcircus.taskManager.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("select id from User where email = :givenEmail AND password = :givenPassword")
	TreeSet<String> getUserAccount(@Param("givenEmail") String email, @Param("givenPassword") String password);
}
