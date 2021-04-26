package Commons;

import Models.Customer;

import java.util.Comparator;

public class NameOrBirthdayComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer, Customer t1) {
        int i = customer.getHoTen().compareTo(t1.getHoTen());
        if (i == 0) {
            return customer.getNgaySinh().compareTo(t1.getNgaySinh());
        }
        return i;
    }
}
