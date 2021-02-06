package net.javaci.SecurityDemo.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENT_LIST = Arrays.asList(
            new Student(1, "Koray"),
            new Student(2, "Ozkan"),
            new Student(3, "Volkan")
    );

    @GetMapping(path = "/{id}")
    //@PreAuthorize("hasAuthority('read')")
    public Student getStudent(@PathVariable("id") Integer id) {
        return STUDENT_LIST.stream().filter(s-> s.getId().equals(id)).findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('update')")
    public void updateStudent(@RequestBody Student student) {
        System.out.println("Update called for sudent:" + student);
    }

    @DeleteMapping(path = "/{id}")
    //@PreAuthorize("hasAuthority('delete')")
    public void deleteStudent(@PathVariable("id") Integer id) {
        System.out.println("Delete called for sudent:" + id);
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('create')")
    public void addStudent(@RequestBody Student student) {
        System.out.println("addStudent called for sudent:" + student);
    }

}
