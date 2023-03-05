package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class VinylModelManager implements VinylModel
{
  private ArrayList<Vinyl> vinylList;
  private PropertyChangeSupport property;


  public VinylModelManager(){
    vinylList = new ArrayList<>();
    property = new PropertyChangeSupport(this);
    new LendingSimulation(this);
  }

  @Override public Vinyl getVinylByTitle(String title)
  {
    if(title == null) return null;

    for(Vinyl v : vinylList)
      if(title.equals(v.getTitle()))
        return v;
      return null;
  }

  @Override public String getStatus(String title) { return getVinylByTitle(title).getStatus(); }

  @Override public void setStatus(String title, String status) { getVinylByTitle(title).setStatus(status);}

  @Override public void addVinyl(Vinyl v)
  {
    vinylList.add(v);
    property.firePropertyChange("Add",null,v);
  }

  @Override public void borrowVinyl(String title, String person)
  {
    getVinylByTitle(title).setBorrowedBy(person).click();
  }

  @Override public void reserveVinyl(String title, String person)
  {
    getVinylByTitle(title).setReservedBy(person).click();
  }

  @Override public void returnVinyl(String title)
  {
    Vinyl v = getVinylByTitle(title);
    if(v.isPendingRemoval() && v.getReservedBy()==null)
      vinylList.remove(v);
    v.setBorrowedBy(null).click();
  }

  @Override public void removeVinyl(String title)
  {
    Vinyl v = getVinylByTitle(title);
    v.setPendingRemoval(true);

    if( v.getBorrowedBy()==null && v.getReservedBy()==null)
      vinylList.remove(v);

  }

  @Override public ArrayList<Vinyl> getAllVinyls()
  {
    return vinylList;
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    property.removePropertyChangeListener(listener);
  }
}
