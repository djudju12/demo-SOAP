package demo.sopawebservice.soapwebservice.service.impl;

import demo.sopawebservice.soapwebservice.model.Course;
import demo.sopawebservice.soapwebservice.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private static final List<Course> courses = new ArrayList<>();

    static {
        var c1 = new Course(1, "Hello", "World");
        var c2 = new Course(2, "Olá", "Mundo");
        var c3 = new Course(3, "Hola", "Mundo");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
    }


    @Override
    public Course findById(int id) {
        for(Course c: courses) {
            if (c.getId() == id)
                return c;
        }

        return null;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }
}
