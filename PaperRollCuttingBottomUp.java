//Tobias Lennon
//R00191512
//SDH2-B
package Non_Linear_Assignment_2;

public class PaperRollCuttingBottomUp {

    public static void paperRollCuttingBottomUp(int n, double[] price){
        int i, j;
        double q;

        if(n > 0) {
            //Array r holds the maximum possible revenue generated for every increment up to n.
            double[] r = new double[n + 1];
            //Paper roll cut to length 0 is worth €0.
            r[0] = 0;
            //First cut position.
            int[] s = new int[n + 1];
            //Looping through the problem size (n).
            for(j = 1; j <= n; j++) {
                //q is initially a minimum value, but is then later set to the max revenue for each length.
                q = Integer.MIN_VALUE;
                //Loop finds maximum revenue for all possible cuts.
                for(i = 1; i < price.length; i++ ) {
                    if(j - i >= 0) {
                        //If q is less than new price.
                        if(q < price[i] + r[j - i]) {
                            //q is set to new price.
                            q = price[i] + r[j - i];
                            //Stores first cut position for each size (First cut position for size j is i).
                            s[j] = i;
                        }
                    }
                    //The best possible revenue for a paper roll cut of size j will be saved into array r (Memoization).
                    r[j] = q;
                }
            }
            //Printing revenue for paper roll of length n to 2 decimal places.
            System.out.println("The best revenue for a paper roll of length " + n + " is €" + String.format("%.2f", r[n])
                    + "\n\nThe cuts that made up highest revenue were: ");
            //Loop prints the cuts used to make the highest revenue.
            for(i = 1; i <= n; i++) {
                System.out.print("Cut #" + i + " = "+ s[n] + "\n");
                //n - s[n] gets index of next cut.
                n -= s[n];
            }
        }
        else {
            System.out.println("Error, enter positive integer.");
        }
    }

    public static void main(String[] args){
        //Price list represents prices of cuts in order, since there is no 4th cut is it valued at 0.
        double[] price = {0, 1.2, 3, 5.8, 0, 10.1};
        paperRollCuttingBottomUp(4, price);
    }
}
