package Model.Service;

import Model.Bean.Contract;
import Model.Repository.ContractRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ContractService {
    public static ArrayList<Contract> findAll(HttpServletRequest request) {
        return ContractRepository.finAll(request);
    }

    public void deleteContract(int id) {

    }

    public void updateContract(int id) {

    }

    public static boolean addContract(Contract contract, HttpServletRequest request) {
        return ContractRepository.addContract(contract, request);
    }
}
