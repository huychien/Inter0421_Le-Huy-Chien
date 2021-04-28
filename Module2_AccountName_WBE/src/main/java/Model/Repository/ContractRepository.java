package Model.Repository;

import Model.Bean.Contract;

import java.util.ArrayList;

public interface ContractRepository {
    ArrayList<Contract> searchContract(String customerName);
    void deleteContract(int id);
    void updateContract(int id);
    void addContract(Contract contract);
}
