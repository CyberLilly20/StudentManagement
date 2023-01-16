package se.lexicon.data_access.impl;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.StudentDao;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoListImpl implements StudentDao {

   private List<Student> students = new ArrayList<Student>();
   @Override
   public Student save(Student student) {
      if(student== null)throw new IllegalArgumentException("Student was null");
      //student.setId(student.getId());
      students.add(student);

      return student;
   }
   @Override
   public Student find(int id) {
      if(id == 0) throw new IllegalArgumentException("Id was null");
      Optional<Student> optionalStudent = students.stream()
              .filter(student1 -> student1.getId() == id)
              .findFirst();
      return optionalStudent.orElse(null);

   }

   public List<Student> findAll() {
      return new ArrayList<>(students);
   }

   public void delete(int id) {
      if(id == 0) throw new IllegalArgumentException("Id was null");
      Student studentToFind = find(id);
      if(studentToFind == null)throw new IllegalArgumentException("Student nor found");
      students.remove(studentToFind);

   }
}
