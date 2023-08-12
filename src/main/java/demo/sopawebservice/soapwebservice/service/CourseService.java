package demo.sopawebservice.soapwebservice.service;

import demo.sopawebservice.soapwebservice.model.Course;

import java.util.List;

public interface CourseService {
    Course findById(int id);
    List<Course> findAll();
}
