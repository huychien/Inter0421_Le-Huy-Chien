package Controller;

import Model.Bean.*;
import Model.Service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EmployeeServlet", value = "/Employee")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            this.loadList(request, response);
        } else if ("create".equals(action)) {
            request.setAttribute("positions", PositionService.findAllPosition(request));
            request.setAttribute("divisions", DivisionService.findAllDivision(request));
            request.setAttribute("education_degrees", EducationService.findAllEducation(request));
            request.getRequestDispatcher("/employee/add.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));
            EmployeeService.deleteEmployee(employee_id, request);
            this.loadList(request, response);
        } else if ("update".equals(action)) {
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));
            setAttribute(request, response, employee_id);
        } else if ("search".equals(action)) {
            String employee_name = request.getParameter("employee_name");
            request.setAttribute("employees", EmployeeService.searchEmployee(employee_name, request));
            request.getRequestDispatcher("/employee/showAll.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String employee_name = request.getParameter("employee_name");
        Date employee_birthday = Date.valueOf(request.getParameter("employee_birthday"));
        String employee_id_card = request.getParameter("employee_id_card");
        String employee_phone = request.getParameter("employee_phone");
        String employee_email = request.getParameter("employee_email");
        String employee_address = request.getParameter("employee_address");
        double employee_salary = Double.parseDouble(request.getParameter("employee_salary"));
        int position_id = Integer.parseInt(request.getParameter("position"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree"));
        int division_id = Integer.parseInt(request.getParameter("division"));

        if ("create".equals(action)) {
            Employee employee = new Employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
                    employee_email, employee_address, PositionService.getPosition(position_id, request),
                    EducationService.getEducation(education_degree_id, request), DivisionService.getDivision(division_id, request));
            boolean check = EmployeeService.addEmployee(employee, request);
            if (check) {
                request.setAttribute("massage", "Create successfully!");
                this.loadList(request, response);
            } else {
                request.setAttribute("massage", "Information employee invalid!");
                request.getRequestDispatcher("/employee/add.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));
            Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
                    employee_email, employee_address, PositionService.getPosition(position_id, request),
                    EducationService.getEducation(education_degree_id, request), DivisionService.getDivision(division_id, request));
            boolean check = EmployeeService.addEmployee(employee, request);
            if (check) {
                request.setAttribute("massage", "Update successfully!");
                this.loadList(request, response);
            } else {
                request.setAttribute("massage", "Information employee invalid!");
                setAttribute(request, response, employee_id);
            }
        }
    }

    private void setAttribute(HttpServletRequest request, HttpServletResponse response, int employee_id) throws ServletException, IOException {
        request.setAttribute("positions", PositionService.findAllPosition(request));
        request.setAttribute("divisions", DivisionService.findAllDivision(request));
        request.setAttribute("education_degrees", EducationService.findAllEducation(request));
        request.setAttribute("employee", EmployeeService.getEmployee(employee_id, request));
        request.getRequestDispatcher("/employee/update.jsp").forward(request, response);
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("employees", EmployeeService.findAll(request));
        request.getRequestDispatcher("/employee/showAll.jsp").forward(request, response);
    }
}
