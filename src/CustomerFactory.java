public class CustomerFactory {
    public static Customer createCustomer(String customerType){
        if(customerType.equals("guest")){
            return new GuestCustomer("Joe","456 ABC","c123","0147896");
        }
        else if(customerType.equals("vip")){
            return new VIPCustomer("Yuu","789 ABC","c456","09058754");
        }
        else if(customerType.equals("supervip")){
            return SuperVIPCustomer.getOnlySuperVIP();
        }
        else return null;
    }
}
