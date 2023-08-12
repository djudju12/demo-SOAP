package demo.sopawebservice.soapwebservice.soap;

import demo.sopawebservice.soapwebservice.model.Course;
import demo.sopawebservice.soapwebservice.service.CourseService;
import demo.sopawebservice.soapwebservice.xml.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CourseDetailsEp {

    private final CourseService courseService;

    public CourseDetailsEp(CourseService courseService) {
        this.courseService = courseService;
    }

    @PayloadRoot(namespace = "http://www.demosoap.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse getCourseDetailsResponse(
            @RequestPayload GetCourseDetailsRequest request
    ) {
        var response = new GetCourseDetailsResponse();
        var courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("dasdsad");
        courseDetails.setDescription("Muasdsdando");
        response.setCourseDetails(courseDetails);
        return response;
    }

    @PayloadRoot(namespace = "http://www.demosoap.com/courses", localPart = "GetAllCourseDetailsRequest")
    @ResponsePayload
    public GetAllCourseDetailsResponse getAllCourseDetails(
            @RequestPayload GetAllCourseDetailsRequest request
    ){
        List<Course> courses = courseService.findAll();
        var response = new GetAllCourseDetailsResponse();
        var responseCourses = response.getCourses();
        courses.stream().map(this::map).forEach(responseCourses::add);
        return response;
    }

    @PayloadRoot(namespace = "http://www.demosoap.com/courses", localPart = "GetCourseDetailsByIdRequest")
    @ResponsePayload
    public GetCourseDetailsByIdResponse getCourseDetailsByIdResponse(
            @RequestPayload GetCourseDetailsByIdRequest request
    ){
        Course course = courseService.findById(request.getId());
        var response = new GetCourseDetailsByIdResponse();
        response.setCourseDetails(map(course));
        return response;
    }

    private CourseDetails map(Course course) {
        var details = new CourseDetails();
        details.setId(course.getId());
        details.setDescription(course.getDescription());
        details.setName(course.getName());
        return details;
    }

}
