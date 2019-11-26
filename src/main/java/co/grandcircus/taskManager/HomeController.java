package co.grandcircus.taskManager;

import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.taskManager.dao.TaskRepo;
import co.grandcircus.taskManager.dao.UserRepo;
import co.grandcircus.taskManager.model.Task;
import co.grandcircus.taskManager.model.User;

@Controller
public class HomeController {

	@Autowired
	UserRepo uRepo;
	
	@Autowired
	TaskRepo tRepo;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index", "msg", "");
	}
	
	@RequestMapping("login")
	public ModelAndView login(String email, String password) {
		TreeSet<String> account = uRepo.getUserAccount(email,password);
		if (account.size() > 0) {
			
			ModelAndView userView = new ModelAndView("viewTasks");
			
			Integer userId = parseUID(account.toString());
			System.out.println("id:" + userId);
			List<String> tasks = tRepo.getTasksById(userId.toString());
			List<Task> taskList = tRepo.getTaskListById(userId.toString());
			System.out.println(taskList);

			//List<String> taskList = new ArrayList<>(tasks);
			
			userView.addObject("tasks",taskList);
			
			return userView;
		}
		return new ModelAndView("index","msg","Given account doesn't exist.  Please try another email or password.");
	}
	
	@RequestMapping("createNewAccount")
	public ModelAndView createNewAccount() {
		System.out.println("");
		return new ModelAndView("/newAccountPage");
	}
	
	@RequestMapping("startUpdateForm")
	public ModelAndView updateForm(Task t){
		return new ModelAndView("updateTask","task",t);
	}
	
	@RequestMapping("updateTask")
	public ModelAndView updateTask(Task newTask) {
		tRepo.updateTask(newTask.getDescription(), newTask.getDueDate(), newTask.getComplete(), newTask.getId());
		return new ModelAndView("/viewTasks");
	}
	
	@PostMapping("addAccount")
	public ModelAndView addAccount(@RequestParam("email") String email, @RequestParam("pswd") String password) {
		uRepo.save(new User(email,password));
		return new ModelAndView("accountConfirmation");
	}
	
	static int parseUID(String input) {
		input=input.substring(1);
		input=input.substring(0,(input.length() - 1));
		return Integer.valueOf(input);
	}
	
	
	

}
