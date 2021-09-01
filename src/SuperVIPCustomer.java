public class SuperVIPCustomer extends Customer{
    private static SuperVIPCustomer onlySuperVIP;
    private SuperVIPCustomer(String name, String address, String iD, String phone) {
        super(name, address, iD, phone);
        System.out.println("A super VIP has arrived!");
    }
    public static SuperVIPCustomer getOnlySuperVIP(){
        if(onlySuperVIP==null){
            onlySuperVIP = new SuperVIPCustomer("John","123 ABC","v123","0123456");
        }
        return onlySuperVIP;
    }
}
