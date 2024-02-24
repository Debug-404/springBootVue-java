package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.StudentMapper;
import com.model.Student;
import com.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;


    public List<Student> findAll() {
        return studentMapper.findAll();
    }


    //查询学生
    public PageInfo<Student> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Student> list = studentMapper.find(search);
        return new PageInfo<>(list);
    }

    public Student selectStudentById(String id) {
        return studentMapper.selectStudentById(id);
    }


    public boolean selectPassword(User user) {
        Student student = studentMapper.selectStudentById(user.getId());
        return student.getPassword().equals(user.getPassword());
    }


    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }


    public int deleteStudent(String id) {
        return studentMapper.deleteStudent(id);
    }


    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public void repair(Map<String, Object> map) {
        studentMapper.repair(map);
    }

    public int stuNum() {
        return studentMapper.stuNum();
    }
}
