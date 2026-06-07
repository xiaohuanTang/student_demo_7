package com.example.week7.repository;

import com.example.week7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByStudentNo(String studentNo);

    List<Student> findByNameContaining(String name);

    List<Student> findByClassName(String className);

    List<Student> findByAgeGreaterThanEqual(Integer age);

    @Query("select s from Student s where (:className is null or s.className = :className) " +
            "and (:major is null or s.major = :major)")
    List<Student> searchByClassAndMajor(@Param("className") String className,
                                        @Param("major") String major);

    @Query(value = "select * from student where age between :minAge and :maxAge order by age", nativeQuery = true)
    List<Student> findByAgeRange(@Param("minAge") Integer minAge,
                                 @Param("maxAge") Integer maxAge);
}
