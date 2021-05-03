package Controller;

import Model.Bean.Contract;
import Model.Repository.ServiceRepository;
import Model.Service.ContractService;
import Model.Service.CustomerService;
import Model.Service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ContractServlet", value = "/Contract")
public class ContractServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("contracts", ContractService.findAll(request));
            request.getRequestDispatcher("/contract/showAll.jsp").forward(request, response);
        } else if ("create".equals(action)) {
            request.setAttribute("services", ServiceRepository.findAll(request));
            request.getRequestDispatcher("/contract/add.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        Date contract_start_date = Date.valueOf(request.getParameter("contract_start_date"));
        Date contract_end_date = Date.valueOf(request.getParameter("contract_end_date"));
        double contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(request.getParameter("contract_total_money"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));

        if ("create".equals(action)) {
            Contract contract = new Contract(0, contract_start_date, contract_end_date, contract_deposit, contract_total_money,
                    CustomerService.getCustomer(customer_id, request), EmployeeService.getEmployee(employee_id, request), ServiceRepository.getService(service_id, request));

            boolean check = ContractService.addContract(contract, request);
            if (check) {
                request.setAttribute("massage", "Create successfully!");
                request.setAttribute("contracts", ContractService.findAll(request));
                request.getRequestDispatcher("/contract/showAll.jsp").forward(request, response);
            } else {
                request.setAttribute("massage", "Information contract invalid!");
                request.getRequestDispatcher("/contract/add.jsp").forward(request, response);
            }
        }
    }
}
