package address.service;

import java.util.List;

public class Addresses {

    private List<Address> addressList;

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "addressList=" + addressList;
    }
}
