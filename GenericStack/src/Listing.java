
public class Listing implements GenericInterface
{  private String name;
   private String address;
   private String number;
   public Listing()
  {  name = "";
      address = "";
      number = "";
  }
   public Listing(String n, String a, String num )
  {  name = n;
      address = a;
      number = num;
  }
  public String toString( )
  {  return ("Name is " + name + '\n' +
                   "Address is " + address + '\n' +
                   "Number is " + number + '\n');
  }
  public Listing deepCopy( )
  {  Listing clone = new Listing(name, address, number);
      return clone;
  }
}

