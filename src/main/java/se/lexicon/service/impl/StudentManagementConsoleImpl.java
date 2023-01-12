package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.List;
import java.util.Optional;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    UserInputService userInputService;

    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    public Student create() {
        System.out.println("Enter student id : ");
        int id = userInputService.getInt();
        if (id == 0) throw new IllegalArgumentException("Id number can not be 0!");
        System.out.println("Enter your name: ");
        String name = userInputService.getString();
        if (name == null) throw new IllegalArgumentException("Name can not be null!");
        Student student = new Student(id, name);
        return student;

    }

    public Student save(Student student) {
        Student createStudent = studentDao.save(student);
        return createStudent;
    }

    public Student find(int id) {
        if (id == 0) throw new IllegalArgumentException("id was null");
        return studentDao.find(id);


    }

    public Student remove(int id) {
        if (id == 0) throw new IllegalArgumentException("id was null");
        Student studentToFind = find(id);
        studentDao.delete(id);

        return studentToFind;
    }

    public List<Student> findAll() {
        List<Student> studentList = studentDao.findAll();
        return studentList;
    }

    public Student edit(Student student) {
        if(student == null) throw new IllegalArgumentException("Data not found!");
        //todo: not done

        return studentDao.save(student);
    }
}
