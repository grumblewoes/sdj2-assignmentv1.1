package viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Vinyl;

public class VinylViewModel
{
  private StringProperty titleProperty;
  private StringProperty artistProperty;
  private IntegerProperty yearProperty;
  private StringProperty statusProperty;

  public VinylViewModel(Vinyl vinyl) {
    this.titleProperty = new SimpleStringProperty(vinyl.getTitle());
    this.artistProperty = new SimpleStringProperty(vinyl.getArtist());
    this.yearProperty = new SimpleIntegerProperty(vinyl.getYear());
    this.statusProperty = new SimpleStringProperty(vinyl.getStatus());
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
}
