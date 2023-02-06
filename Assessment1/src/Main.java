import address.service.Address;
import address.service.AddressService;
import address.service.AddressValidator;
import common.factor.*;

import java.util.List;

public class Main {

    private static List<Address> addressList = AddressService.getAddressListFromJson();

    public static void main(String[] args) {

        // check common denominator
        findCommonDenominator();

        //address service
        addressService();

        //validate address
        validateAddress();
    }

    private static void findCommonDenominator() {
        int[] intArray = {8, 24, 16, 32};
        int commonDenominator = CommonDenominatorValidator.highestCommonFactor(intArray);
        System.out.println("The common denominator is: " + commonDenominator + "\n");
    }

    private static void addressService() {

        AddressService.printHeader();
        System.out.println(AddressService.prettyPrintAddress(addressList.get(0)));
        System.out.println();
        AddressService.prettyPrintAllAddresses(addressList);
        AddressService.prettyPrintAddressesOfAType(addressList);


    }

    private static void validateAddress() {
        for (Address address : addressList) {
            boolean isValidPostalCode = AddressValidator.isAddressPostalCodeValid(address);
            if (!isValidPostalCode) {
                System.out.println("Invalid Postal Code Format For Address ID:" + address.getId());
            }
            boolean isZAProvincePresent = AddressValidator.isZAProvincePresent(address);
            if (!isZAProvincePresent) {
                System.out.println("Invalid Province For Address ID:" + address.getId());
            }

        }
    }
}