package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.config.SpringConfig;
import ru.itis.dao.UsersDao;
import ru.itis.model.Auto;
import ru.itis.model.User;
import ru.itis.service.UsersService;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("ru.itis/context.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UsersDao usersDao = context.getBean(UsersDao.class);

        User user = usersDao.find(1L);

        System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());

        UsersService service = context.getBean(UsersService.class);

        System.out.println(service.isRegistered("Vladislav"));

        List<User> users = usersDao.findAll();

        List<Auto> autos = service.getAllAuto();

        User user1 = autos.get(0).getUser();

        System.out.println(user1.getName());
        int i = 0;


    }
}
