public class ApplyDiscountEverynOrders {
    public static int counter = 0;
    private int n, discount;
    private int[] prices;

    public ApplyDiscountEverynOrders(int n, int discount, int[] products, int[] prices) {
        this.prices = new int[200];

        this.n = n;
        this.discount = discount;
        for(int i = 0; i < products.length; i++){
            this.prices[products[i] - 1] = prices[i];    
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        counter++;

        double total = 0;

        for(int i = 0; i < product.length; i++){
            total += prices[product[i] - 1] * amount[i];
        }

        if(counter == n){
            return (total * ((100 - Double.valueOf(discount))/100));
        }else{
            return total;
        }
    }
}
