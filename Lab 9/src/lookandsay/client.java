package lookandsay;

import java.math.BigInteger;

public class client {

  public static void main(String[] args) {

    RIterator rIterator = new LookAndSayIterator(new BigInteger("1"));
    System.out.println(rIterator.next());
    System.out.println(rIterator.next());
    System.out.println(rIterator.prev());
    System.out.println(rIterator.next());


    System.out.println("-----------");

//    RIterator rIterator1 = new LookAndSayIterator();
//    System.out.println(rIterator.prev());
//    System.out.println(rIterator.prev());
  }

}
