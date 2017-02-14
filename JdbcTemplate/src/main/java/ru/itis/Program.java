package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.config.SpringConfig;
import ru.itis.dao.UsersDao;
import ru.itis.model.User;
import ru.itis.service.UsersService;

public class Program {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis/context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UsersDao usersDao = context.getBean(UsersDao.class);

        User user = usersDao.find(1L);

        System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());

        UsersService service = context.getBean(UsersService.class);

        System.out.println(service.isRegistered("Vladislav"));


    }
}
