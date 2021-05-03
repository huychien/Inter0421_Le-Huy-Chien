package Controller;

import Model.Bean.Service;
import Model.Repository.RentTypeRepository;
import Model.Repository.ServiceRepository;
import Model.Repository.ServiceTypeRepository;
import Model.Service.CustomerService;
import Model.Service.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServiceServlet", value = "/Service")
public class ServiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("services", ServiceService.findAll(request));
            request.getRequestDispatcher("/service/showAll.jsp").forward(request, response);
        } else if ("create".equals(action)) {
            request.setAttribute("rent_types", RentTypeRepository.findAll(request));
            request.setAttribute("service_types", ServiceTypeRepository.findAll(request));
            request.getRequestDispatcher("/service/add.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));

        if ("create".equals(action)) {
            Service service = new Service(0, service_name, service_area, service_cost, service_max_people,
                    RentTypeRepository.getRentType(rent_type_id, request), ServiceTypeRepository.getServiceType(service_type_id, request),
                    standard_room, description_other_convenience, pool_area, number_of_floors);

            boolean check = ServiceService.addService(service, request);
            if (check) {
                request.setAttribute("massage", "Create successfully!");
                request.setAttribute("services", ServiceService.findAll(request));
                request.getRequestDispatcher("/service/showAll.jsp").forward(request, response);
            } else {
                request.setAttribute("massage", "Information service invalid!");
                request.getRequestDispatcher("/service/add.jsp").forward(request, response);
            }
        }
    }
}
