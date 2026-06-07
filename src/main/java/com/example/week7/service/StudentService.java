package com.example.week7.service;

import com.example.week7.entity.Student;
import com.example.week7.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("学生不存在"));
    }

    @Transactional
    public Student save(Student student) {
        validate(student);
        return studentRepository.save(student);
    }

    @Transactional
    public Student update(Long id, Student student) {
        Student old = getById(id);
        old.setStudentNo(student.getStudentNo());
        old.setName(student.getName());
        old.setGender(student.getGender());
        old.setAge(student.getAge());
        old.setClassName(student.getClassName());
        old.setMajor(student.getMajor());
        validate(old);
        return studentRepository.save(old);
    }

    @Transactional
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("学生不存在");
        }
        studentRepository.deleteById(id);
    }

    public List<Student> search(String name, String className, String major) {
        if (StringUtils.hasText(className) || StringUtils.hasText(major)) {
            return studentRepository.searchByClassAndMajor(emptyToNull(className), emptyToNull(major));
        }
        if (StringUtils.hasText(name)) {
            return studentRepository.findByNameContaining(name);
        }
        return listAll();
    }

    public List<Student> ageRange(Integer minAge, Integer maxAge) {
        if (minAge == null || maxAge == null || minAge > maxAge) {
            throw new IllegalArgumentException("年龄范围不正确");
        }
        return studentRepository.findByAgeRange(minAge, maxAge);
    }

    private void validate(Student student) {
        if (!StringUtils.hasText(student.getStudentNo())) {
            throw new IllegalArgumentException("学号不能为空");
        }
        if (!StringUtils.hasText(student.getName())) {
            throw new IllegalArgumentException("姓名不能为空");
        }
        if (student.getAge() != null && (student.getAge() < 0 || student.getAge() > 100)) {
            throw new IllegalArgumentException("年龄不合法");
        }
    }

    private String emptyToNull(String value) {
        return StringUtils.hasText(value) ? value : null;
    }
}
