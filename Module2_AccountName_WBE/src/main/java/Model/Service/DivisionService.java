package Model.Service;

import Model.Bean.Division;
import Model.Repository.DivisionRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class DivisionService {

    public static ArrayList<Division> findAllDivision(HttpServletRequest request) {
        return DivisionRepository.findAllDivision(request);
    }

    public static Division getDivision(int id, HttpServletRequest request) {
        return DivisionRepository.getDivision(id, request);
    }
}
