package address.service;

public class AddressValidator {

    private AddressValidator() {

    }

    public static boolean isAddressPostalCodeValid(Address address) {

        boolean isValidPostalCode = true;
        try {
            Integer.parseInt(address.getPostalCode());
        } catch (ClassCastException classCastException) {
            isValidPostalCode = false;
            classCastException.printStackTrace();
        }
        return isValidPostalCode;
    }

    public static boolean isZAProvincePresent(Address address) {
        boolean isZAProvincePresent = true;
        if (address.getCountry().getCode().equalsIgnoreCase("za")) {
            if (address.getProvinceOrState() == null || (address.getProvinceOrState().getCode() == null || address.getProvinceOrState().getCode().isEmpty()) || (address.getProvinceOrState().getName() == null || address.getProvinceOrState().getName().isEmpty())) {
                isZAProvincePresent = false;
            }
        }
        return isZAProvincePresent;
    }
}
