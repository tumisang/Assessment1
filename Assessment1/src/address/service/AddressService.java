package address.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressService {

    private static Gson gson = new Gson();

    private AddressService() {

    }

    public static List<Address> getAddressListFromJson() {
        List<Address> addressList = new ArrayList<>();

        try {
            JsonReader reader = new JsonReader(new FileReader("src/addresses.json"));
            Address[] addresses = gson.fromJson(reader, Address[].class);
            addressList = Arrays.asList(addresses);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addressList;
    }

    public static String prettyPrintAddress(Address address) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(address.getAddressLineDetail()).append(" - ").append(address.getCityOrTown()).append(" - ").append(address.getProvinceOrState()).append(" - ").append(address.getPostalCode()).append(" - ").append(address.getCountry());

        return stringBuilder.toString();
    }

    public static void prettyPrintAllAddresses(List<Address> addressList) {
        for (Address address : addressList) {
            System.out.println(AddressService.prettyPrintAddress(address));
        }
        System.out.println();
    }

    public static void prettyPrintAddressesOfAType(List<Address> addressList) {
        addressList.stream().filter(address -> address.getType().getName().contains("Postal") ||
                        address.getType().getName().contains("Physical") ||
                        address.getType().getName().contains("Business"))
                .forEach(address -> System.out.println(AddressService.prettyPrintAddress(address)));
        System.out.println();
    }

    public static void printHeader() {
        System.out.println("Line details - city - province/state - postal code – country \n".toUpperCase());
    }

}
