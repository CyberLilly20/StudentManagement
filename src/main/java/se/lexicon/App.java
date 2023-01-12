package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.service.impl.StudentManagementConsoleImpl;
import se.lexicon.util.UserInputService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService =context.getBean(UserInputService.class);
        StudentManagementConsoleImpl studentManagementConsole = context.getBean(StudentManagementConsoleImpl.class);

        Student createdStudent = studentManagementConsole.create();
        System.out.println(studentManagementConsole.save(createdStudent));


    }
}
