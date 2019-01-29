package webstudents.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webstudents.models.Student;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByLastName(String lastName);

    @Query(value = "select * from students where students.students.group_id = ?",
            nativeQuery = true)
    List<Student> findAllInGroup(Integer groupId);

}
