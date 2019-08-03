public class User {
    private String id;
    private String name;
    private String phoneNumber;
    private double availableFunds;
    private boolean isPremiumMember;
    private boolean processSuccessful = false;

    User(String id, String name, String phoneNumber, double availableFunds) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.availableFunds = availableFunds;
        this.isPremiumMember = false;
    }

    User(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.availableFunds = 0.00;
        this.isPremiumMember = false;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public double getAvailableFunds() {
        return this.availableFunds;
    }

    public boolean withdrawFunds(double amount) { // Method to deduct funds
        //return false;
        if ((this.availableFunds - amount) >= 0) {
            this.availableFunds = this.availableFunds - amount;
            this.processSuccessful = true;
            System.out.println(this.name + ", " + amount + " is deducted from your account. Remaining balance is " + this.availableFunds);
        } else {
            System.out.println(this.name + ", Sorry, you do not have enough funds to proceed. Current balance is" + this.availableFunds);
            this.processSuccessful = false;
        }
        return this.processSuccessful;
    }


    public void addFunds(double amount) { // Method to add funds
        if (amount > 0) {
            this.availableFunds = this.availableFunds + amount;
            System.out.println("Your new balance is, " + this.availableFunds);
        } else {
            System.out.println("Invalid transaction. Please insert an amount greater than zero");
        }
    }


    public void buyContent(Content content) { //Buy a content
        double price = content.getPrice();
        if (this.isPremiumMember) // Adding premium membership discount
            price = price * .8;
        withdrawFunds(price);

        if (this.processSuccessful)
            System.out.println("Item " + content.getName() + " is purchased");
    }


    public void becomePremium() { //Premium membership process
        if (this.isPremiumMember == true) { //Check whether the user is already a premium member
            System.out.println(this.name + ", you are already a premium member");
        } else { //If not a premium member deduct 100 from funds and make the user a premium member
            if (this.withdrawFunds(100)) {
                this.isPremiumMember = true;
                System.out.println(this.name + " became a premium member");
            }

        }
    }

}