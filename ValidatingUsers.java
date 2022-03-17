import java.util.*;
import java.lang.*;
import java.util.regex.*;

class TransactionParty {
  String seller;
  String buyer;

  public TransactionParty(String seller, String buyer) {
    this.seller = seller;
    this.buyer = buyer;
  }

}

class Receipt{
  TransactionParty transactionParty;
  String productsQR;

  public Receipt(TransactionParty transactionParty, String productsQR) {
    this.transactionParty = transactionParty;
    this.productsQR = productsQR;
  }

}

// Product QR
// ^[A-Za-z]+([\\s\\'-a-zA-Z])*([A-Za-z]{1,})$

class GenerateReceipt{
  public int verifyParty(Receipt r) {
                     //"^[A-Za-z]+([\\s\\'a-zA-Z-]+)*([A-Za-z]{1,})$"
    String nameRegex = "^[A-Za-z]+([\\s\\'a-zA-Z-]+)*([a-zA-Z]{1,})$";
    Pattern namePattern = Pattern.compile(nameRegex);
    if(namePattern.matcher(r.transactionParty.seller).find() && namePattern.matcher(r.transactionParty.buyer).find())
      return 2;
    else if(namePattern.matcher(r.transactionParty.seller).find() || namePattern.matcher(r.transactionParty.buyer).find())
      return 1;
    else
      return 0;
  }

  public String calcGST(Receipt r) {
    String first[] = r.productsQR.split("@");
    String second[][] = new String[3][2];
    int sum = 0;
    for(int i=0; i<second.length; i++) {
      second[i] = first[i].split(",");
      sum += Integer.parseInt(second[i][0])*Integer.parseInt(second[i][1]);
    }
    // return String(sum);
    sum *= 0.12;
    return Integer.toString(sum);
  }
}

