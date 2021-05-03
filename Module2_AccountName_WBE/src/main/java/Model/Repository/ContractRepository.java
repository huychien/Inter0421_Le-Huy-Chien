package Model.Repository;

import Model.Bean.*;
import Connection.ConnectionUtils;
import Model.Service.CustomerService;
import Model.Service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContractRepository {

    public static ArrayList<Contract> finAll(HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" SELECT * FROM Furama.HopDong");
            ResultSet result = ps.executeQuery();
            ArrayList<Contract> list = new ArrayList<>();

            while (result.next()) {
                int contract_id = result.getInt("IdHopDong");
                Date contract_start_date = result.getDate("NgayLamHopDong");
                Date contract_end_date = result.getDate("NgayKetThuc");
                double contract_deposit = result.getDouble("TienDatCoc");
                double contract_total_money = result.getDouble("TongTien");
                int customer_id = result.getInt("IdKhachHang");
                int employee_id = result.getInt("IdNhanVien");
                int service_id = result.getInt("IdDichVu");

                Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money,
                        CustomerService.getCustomer(customer_id, request), EmployeeService.getEmployee(employee_id, request), ServiceRepository.getService(service_id, request));
                list.add(contract);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean addContract(Contract contract, HttpServletRequest request) {
        try {
            Connection connection = ConnectionUtils.getMyConnect(request);

            PreparedStatement ps = connection.prepareStatement(" INSERT INTO HopDong(IdNhanVien, IdKhachHang, IdDichVu, " +
                    " NgayLamHopDong, NgayKetThuc, TienDatCoc, TongTien) " +
                    " VALUE (?, ?, ?, ?, ?, ?, ?); ");
            setData(contract, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private static void setData(Contract contract, PreparedStatement ps) throws SQLException {
        ps.setInt(1, contract.getEmployee().getEmployee_id());
        ps.setInt(2, contract.getCustomer().getCustomer_id());
        ps.setInt(3, contract.getService().getService_id());
        ps.setDate(4, contract.getContract_start_date());
        ps.setDate(5, contract.getContract_end_date());
        ps.setDouble(6, contract.getContract_deposit());
        ps.setDouble(7, contract.getContract_total_money());
        ps.executeUpdate();
    }
}
