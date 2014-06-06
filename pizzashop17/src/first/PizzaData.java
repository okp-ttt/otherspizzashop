package first;

//import java.net.URL;

import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PizzaData {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Long id; //int noを Long idに変更
   
  @Persistent
  private String crust;
  
  @Persistent
  private int piman=0;
  
  @Persistent
  private int cheese=0;
  
  @Persistent
  private int tomato=0;
  
  @Persistent
  private int sarami=0;
  
  @Persistent
  private int coon=0;
  
  @Persistent
  private int order=0;

  public PizzaData(String[] topping, String crust) {
      super();
     /* this.piman=0;
      this.cheese=0;
      this.tomato=0;
      this.sarami=0;
      this.coon=0;
      */for(int i=0; i<topping.length; i++){
      	if(topping[i].equals("piman")) this.piman=1;
    	else if(topping[i].equals("cheese")) this.cheese=1;
    	else if(topping[i].equals("tomato")) this.tomato=1;
    	else if(topping[i].equals("sarami"))  this.sarami=1;
    	else if(topping[i].equals("coon")) this.coon=1;
      }
      this.crust = crust;
      //this.no=no+1;
  }

 /* public String getTopping() {
      return topping;
  }

  public void setTopping(String topping) {
      this.topping = topping;
  }*/
  
  public Long getId() {//はまざき追加
      return id;
  }

  /*public int getNo(){ //はまざき追加
	  return no;
  }*/
  
  public String getCrust() {
      return crust;
  }

  public void setCrust(String crust) {
      this.crust = crust;
  }
  public int getPiman(){
	  return piman;
  }
  public int getCheese(){
	  return cheese;
  }
  public int getTomato(){
	  return tomato;
  }
  public int getSarami(){
	  return sarami;
  }
  public int getCoon(){
	  return coon;
  }
  public int getOrder(){
	  return order;
  }
  
  public void setOrder(int order) {
      this.order = order;
  }
  
}