package model;

import java.util.ArrayList;

public class LendingSimulation
{
  public LendingSimulation(VinylModelManager model){
    
    new Thread(() -> {
      String[] bidders = { "Anna", "Jakub", "Catarina","Julia","Damian" };
      while(true){
        try
        {
          Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }


        try{
          String name = bidders[(int)Math.floor(Math.random()*bidders.length)];
          ArrayList<Vinyl> list =  model.getAllVinyls();
          if(list.size()==0) break;

          Vinyl v =list.get((int)Math.floor(Math.random()*list.size()));
//
          String action = "";
          double r = Math.random();
          if(r<0.3){
  //          reserve
            action="reserve";
            model.reserveVinyl(v.getTitle(),name);
          }else if(r<0.6){
  //          borrow
            action="borrow";
            model.borrowVinyl(v.getTitle(),name);
          }else if(r< 0.9){
  //          return
            action="return";
            model.returnVinyl(v.getTitle());
          }else{
  //          remove
            action="remove";
            model.removeVinyl(v.getTitle());
          }
          System.out.println("---simulation: { name:"+name+", vinyl: "+v.getTitle() +", action: "+action  + " }");
        }catch  (Exception e){
          System.out.println(e.getMessage());
        }

      }
    }).start();
    
  }
}

