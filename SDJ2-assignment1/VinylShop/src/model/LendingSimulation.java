package model;

import java.util.ArrayList;

public class LendingSimulation
{
  VinylModel model;
  public LendingSimulation(VinylModel model){
    this.model = model;
    
    new Thread( () -> {
      String[] bidders = { "Anna", "Jakub", "Catarina","Julia","Damian" };
      while(true){

        try{
          String name = bidders[(int)Math.floor(Math.random()*bidders.length)];
          ArrayList<Vinyl> list =  model.getAllVinyls();
          if(list.size()==0) break;
          Vinyl v =list.get((int)Math.floor(Math.random()*list.size()));


          double r = Math.random();
          if(r<0.2){
            model.reserveVinyl(v.getTitle(),name);
  //          reserve
          }else if(r<0.5){
            model.borrowVinyl(v.getTitle(),name);
  //          borrow
          }else if(r< 0.9){
            model.returnVinyl(v.getTitle());
  //          return
          }else{
  //          remove
            model.removeVinyl(v.getTitle());
          }
        }catch  (Exception e){
          System.out.println(e.getMessage());
        }

      }
    }).start();
    
  }
}
