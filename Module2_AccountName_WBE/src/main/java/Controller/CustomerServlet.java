package Controller;

import Model.Bean.Customer;
import Model.Service.CustomerService;
import Model.Service.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "CustomerServlet", value = "/Customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            this.loadList(request, response);

        } else if ("create".equals(action)) {
            request.setAttribute("customer_types", CustomerTypeService.findAllCustomerType(request));
            request.getRequestDispatcher("/customer/add.jsp").forward(request, response);

        } else if ("delete".equals(action)) {
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            CustomerService.deleteCustomer(customer_id, request);

        } else if ("update".equals(action)) {
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            request.setAttribute("customer_types", CustomerTypeService.findAllCustomerType(request));
            request.setAttribute("customer", CustomerService.getCustomer(customer_id, request));
            request.getRequestDispatcher("/customer/update.jsp").forward(request, response);

        } else if ("search".equals(action)) {
            String customer_name = request.getParameter("customer_name");
            request.setAttribute("customers", CustomerService.searchCustomer(customer_name, request));
            request.getRequestDispatcher("/customer/showAll.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String customer_name = request.getParameter("customer_name");
        Date customer_birthday = Date.valueOf(request.getParameter("customer_birthday"));
        int customer_gender = Integer.parseInt(request.getParameter("customer_gender"));
        String customer_id_card = request.getParameter("customer_id_card");
        String customer_phone = request.getParameter("customer_phone");
        String customer_email = request.getParameter("customer_email");
        String customer_address = request.getParameter("customer_address");
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type"));

        if ("create".equals(action)) {
            Customer customer = new Customer(CustomerTypeService.getCustomerType(customer_type_id, request), customer_name, customer_birthday,
                    customer_gender, customer_id_card, customer_phone, customer_email, customer_address);

            boolean check = CustomerService.addCustomer(customer, request);
            if (check) {
                request.setAttribute("massage", "Create successfully!");
                this.loadList(request, response);
            } else {
                request.setAttribute("massage", "Information customer invalid!");
                request.getRequestDispatcher("/customer/add.jsp").forward(request, response);
            }
        } else if ("update".equals(action)) {
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
            Customer customer = new Customer(customer_id, CustomerTypeService.getCustomerType(customer_type_id, request), customer_name, customer_birthday,
                    customer_gender, customer_id_card, customer_phone, customer_email, customer_address);

            boolean check = CustomerService.updateCustomer(customer, request);
            if (check) {
                request.setAttribute("massage", "Update successfully!");
                this.loadList(request, response);
            } else {
                request.setAttribute("massage", "Information customer invalid!");
                request.setAttribute("customer_types", CustomerTypeService.findAllCustomerType(request));
                request.setAttribute("customer", CustomerService.getCustomer(customer_id, request));
                request.getRequestDispatcher("/customer/update.jsp").forward(request, response);
            }
        }
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", CustomerService.findAll(request));
        request.getRequestDispatcher("/customer/showAll.jsp").forward(request, response);
    }
}
