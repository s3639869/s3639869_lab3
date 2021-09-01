import java.util.ArrayList;
import java.util.Scanner;

public class VideoStore {
	private CustomerList customerList;
	private VideoList videoList;
	
	public VideoStore() {
		this.videoList = new VideoList();
		this.customerList = new CustomerList();
	}

	public Video getVideo(String ID) {
		return videoList.getVideo(ID);
	}
	
	public boolean addVideo(Video vid) {
		return videoList.addVideo(vid);
	}
	
	public Customer getCustomer(String ID) {
		return customerList.getCustomer(ID);
	}
	
	public boolean addCustomer(Customer cust) {
		return customerList.addCustomer(cust);
	}

	public CustomerList getCustomerList() {
		return customerList;
	}

	public VideoList getVideoList() {
		return videoList;
	}

	public static void main(String[] args) {
		VideoStore myStore = new VideoStore();
		//create 3 video items
		Video vid = new Video("VD001", "Divergent", "Action", 1, false);
		myStore.addVideo(vid);
		vid = new Video("VD002", "Green Eggs and Ham", "Comedy", 1, false);
		myStore.addVideo(vid);
		vid = new Video("VD003", "Gone with the wind", "Drama", 2, false);
		myStore.addVideo(vid);
		
		//create 3 customers
		Customer cust = new VIPCustomer("Ngo Bao Chau", "12 Math Avenue", "VIP001", "0203050813");
		myStore.addCustomer(cust);
		cust.borrowVid(myStore.getVideo("VD001"));
		cust = new GuestCustomer("Pham Nhat Vuong", "12 Money Road", "G002", "0399999999");
		myStore.addCustomer(cust);
		cust.borrowVid(myStore.getVideo("VD002"));
		cust = new GuestCustomer("Nguyen Xuan Phuc", "12 Politics Street", "G003", "0311112222");
		myStore.addCustomer(cust);
		cust.borrowVid(myStore.getVideo("VD003"));

		//Test design patterns
		System.out.println("\nDesign patterns test\n");
		//Create singleton SuperVIP customer
		SuperVIPCustomer superVIP = SuperVIPCustomer.getOnlySuperVIP();
		System.out.println(superVIP);

		//Attempt to create another SuperVIP customer but it will return the same one
		SuperVIPCustomer superVIP2 = SuperVIPCustomer.getOnlySuperVIP();
		System.out.println(superVIP2);

		//Use iterator to print all customers in customer list
		while (myStore.getCustomerList().hasNext()){
			System.out.println(myStore.getCustomerList().next());
		}

		//Use iterator to print all videos in video list
		while (myStore.getVideoList().hasNext()){
			System.out.println(myStore.getVideoList().next());
		}

		//Test CustomerFactory
		System.out.println("\nPlease provide a customer type to test CustomerFactory: (guest, vip or supervip)\n");
		Scanner myScanner = new Scanner(System.in);
		String customerType = myScanner.nextLine();
		Customer firstCustomer = CustomerFactory.createCustomer(customerType);
		System.out.println("First customer is: "+firstCustomer+" of type "+firstCustomer.getClass().getSimpleName());

		customerType = myScanner.nextLine();
		Customer secondCustomer = CustomerFactory.createCustomer(customerType);
		System.out.println("Second customer is: "+secondCustomer+" of type "+secondCustomer.getClass().getSimpleName());

		customerType = myScanner.nextLine();
		Customer thirdCustomer = CustomerFactory.createCustomer(customerType);
		System.out.println("Third customer is: "+thirdCustomer+" of type "+thirdCustomer.getClass().getSimpleName());
	}

}
