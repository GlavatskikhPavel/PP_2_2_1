package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//        User user1 = new User("Артем", "Соколов", "Socol@mail.ru");
//        User user2 = new User("Олег", "Кузнецов", "Kuz@yandex.ru");
//        User user3 = new User("Иван", "Суханов", "Suhanov@mail.ru");
//        User user4 = new User("Кирил", "Васильев", "Vasua@yandex.ru");
//
//        Car car1 = new Car("Volkswagen Tiguan", 150);
//        Car car2 = new Car("Toyota Camry", 181);
//        Car car3 = new Car("Ford Transit", 125);
//        Car car4 = new Car("Mercedes-Benz AMG", 190);
//
//        user1.setUserCar(car1);
//        user2.setUserCar(car2);
//        user3.setUserCar(car3);
//        user4.setUserCar(car4);
//
//        userService.add(user1);
//        userService.add(user2);
//        userService.add(user3);
//        userService.add(user4);
//
//        List<User> users = userService.getListUsers();
//        for (User user : users) {
//            System.out.println("Id = " + user.getId());
//            System.out.println("First Name = " + user.getFirstName());
//            System.out.println("Last Name = " + user.getLastName());
//            System.out.println("Email = " + user.getEmail());
//            System.out.println();
//        }

        userService.getUserByModelAndSeries("Volkswagen Tiguan", 151);
        context.close();
    }
}
