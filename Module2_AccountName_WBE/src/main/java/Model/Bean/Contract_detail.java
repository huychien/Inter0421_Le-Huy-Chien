package Model.Bean;

import Model.Bean.Attach_service;
import Model.Bean.Contract;

public class Contract_detail {
    private int contract_detail_id;
    private Contract contract;
    private Attach_service attach_service;
    private int quantity;

    public Contract_detail() {
    }

    public Contract_detail(int contract_detail_id, Contract contract, Attach_service attach_service, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract = contract;
        this.attach_service = attach_service;
        this.quantity = quantity;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Attach_service getAttach_service() {
        return attach_service;
    }

    public void setAttach_service(Attach_service attach_service) {
        this.attach_service = attach_service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
