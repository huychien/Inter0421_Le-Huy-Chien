package Model.Service;

import Model.Bean.Education_degree;
import Model.Repository.EducationRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class EducationService {

    public static ArrayList<Education_degree> findAllEducation(HttpServletRequest request) {
        return EducationRepository.findAllEducation(request);
    }

    public static Education_degree getEducation(int id, HttpServletRequest request) {
        return EducationRepository.getEducation(id, request);
    }
}
