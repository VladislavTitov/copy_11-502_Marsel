package ru.itis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.config.SpringConfig;
import ru.itis.models.User;
import ru.itis.service.UsersService;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UsersService service = context.getBean(UsersService.class);

        service.showUsers();

        Comparator<User> userComparator = new Comparator<User>() {
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Comparator<User> lambdaComparator = (userA, userB) -> userA.getAge() - userB.getAge();
    }
}
