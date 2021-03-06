package webstudents.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@Setter
@Getter
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private SchoolGroup group;

    @JsonIgnore
    @OneToMany(targetEntity = Mark.class,
            mappedBy = "studentId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Mark> markSet;

    public Student(String firstName, String lastName, SchoolGroup group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
