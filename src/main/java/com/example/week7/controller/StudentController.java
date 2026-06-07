package com.example.week7.controller;

import com.example.week7.entity.Student;
import com.example.week7.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> list(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String className,
                              @RequestParam(required = false) String major) {
        return studentService.search(name, className, major);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @GetMapping("/age-range")
    public List<Student> ageRange(@RequestParam Integer minAge,
                                  @RequestParam Integer maxAge) {
        return studentService.ageRange(minAge, maxAge);
    }
}
