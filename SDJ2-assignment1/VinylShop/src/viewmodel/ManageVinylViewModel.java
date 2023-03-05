package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Vinyl;
import model.VinylModel;

public class ManageVinylViewModel
{
  private StringProperty errorProperty;
  private StringProperty titleProperty;
  private StringProperty artistProperty;
  private IntegerProperty yearProperty;
  private StringProperty statusProperty;

  private ViewState viewState;
  private VinylModel model;

  public ManageVinylViewModel(VinylModel model, ViewState viewState)
  {
    errorProperty = new SimpleStringProperty();
    titleProperty = new SimpleStringProperty();
    artistProperty = new SimpleStringProperty();
    yearProperty = new SimpleIntegerProperty();
    statusProperty = new SimpleStringProperty();
    this.viewState = viewState;
    this.model = model;
  }
  public void reset() {

    String title = viewState.getTitle();
    Vinyl vinyl =  model.getVinylByTitle(title);

    errorProperty.set("");
    titleProperty.set(vinyl.getTitle());
    artistProperty.set(vinyl.getArtist());
    yearProperty.set(vinyl.getYear());
    statusProperty.set(vinyl.getStatus());
  }
  public StringProperty getErrorProperty() {
    return errorProperty;
  }
  public StringProperty getTitleProperty() {
    return titleProperty;
  }
  public StringProperty getArtistProperty() {
    return artistProperty;
  }
  public IntegerProperty getYearProperty() {
    return yearProperty;
  }
  public StringProperty getStatusProperty() {
    return statusProperty;
  }

  public void reserve(String who) {
 // if pending removal is false   if (//)
    try {
      model.reserveVinyl(viewState.getTitle(), who);
      model.setStatus(viewState.getTitle(), "reserved");
    }
    catch (Exception e){
      errorProperty.set(e.getMessage());
    }
  }
  public void borrow(String who) {
    try {
      model.borrowVinyl(viewState.getTitle(), who);
      model.setStatus(viewState.getTitle(), "borrowed");

    }
    catch (Exception e) {
      errorProperty.set(e.getMessage());
    }

  }

}

