package Model.Service;

import Model.Bean.Position;
import Model.Repository.PositionRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class PositionService {
    public static ArrayList<Position> findAllPosition(HttpServletRequest request) {
        return PositionRepository.findAllPosition(request);
    }

    public static Position getPosition(int id, HttpServletRequest request) {
        return PositionRepository.getPosition(id, request);
    }
}
