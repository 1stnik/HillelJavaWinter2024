import dto.Student;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import mapper.DateMapper;
import service.DBService;
import service.impl.DBServiceImpl;
import validate.GroupNumberValidator;

public class RunApp {

    public static void main(String[] args) throws SQLException, ParseException {

        DBService dbService = new DBServiceImpl();

        do {
            System.out.println("-------- Student db ---------");
            System.out.println("Please select action:");
            System.out.println("0 - Exit from application");
            System.out.println("1 - Look list of groups");
            System.out.println("2 - Look list of students by group");
            System.out.println("3 - Insert student");
            System.out.println("4 - Delete student");
            Scanner sc = new Scanner(System.in);

            Integer action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.exit(-1);
                case 1:
                    dbService.getGroupList().forEach(System.out::println);
                    break;
                case 2:
                    String groupNumber = "";
                    do {
                        System.out.println("Please enter number group in formant : GR-XX");
                        groupNumber = sc.nextLine().toUpperCase();
                    } while (!GroupNumberValidator.validateNumber(groupNumber));

                    dbService.getStudentsListByGroup(groupNumber).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Please enter first name:");
                    String firstNAme = sc.nextLine();
                    System.out.println("Please enter last name:");
                    String lastName = sc.nextLine();
                    System.out.println("Please enter date of birth : YYYY-MM-DD");
                    String dateOfBirth = sc.nextLine();
                    System.out.println("Please enter email:");
                    String email = sc.nextLine();
                    System.out.println("Please enter number group in formant : GR-XX");
                    groupNumber = sc.nextLine().toUpperCase();
                    System.out.println("Please enter country name:");
                    String country = sc.nextLine();

                    dbService.createStudent(new Student()
                        .setFirstName(firstNAme)
                        .setLastName(lastName)
                        .setDateOfBirth(DateMapper.convertDateFromString(dateOfBirth))
                        .setGroup(groupNumber)
                        .setEmail(email)
                        .setCountry(country)
                    );
                    break;
                case 4:
                    System.out.println("Please enter password for check ability delete users");

                    String password = sc.nextLine();
                    if (password.equals("root")) {
                        System.out.println("Please enter student id for delete");
                        int id = sc.nextInt();
                        dbService.deleteStuden(id);
                    }
                    break;
                default: System.out.println("Incorrect enter. Please try again!!!");
            }
        } while (true);
    }

}
