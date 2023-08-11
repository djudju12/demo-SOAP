package demo.sopawebservice.soapwebservice.soap;

import demo.sopawebservice.soapwebservice.xml.GetCourseDetailsRequest;
import demo.sopawebservice.soapwebservice.xml.GetCourseDetailsResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetails {


    @PayloadRoot(namespace = "http://www.demosoap.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse getCourseDetailsResponse(
            @RequestPayload GetCourseDetailsRequest request
    ) {
        var response = new GetCourseDetailsResponse();
        var courseDetails = new CourseDetails();
        courseDetails.setId
        response.setCourseDetails(courseDetails);
        return
    }
}
