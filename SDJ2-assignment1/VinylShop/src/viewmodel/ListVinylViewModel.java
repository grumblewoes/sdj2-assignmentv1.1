package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vinyl;
import model.VinylModel;

public class ListVinylViewModel
{
  private ObservableList<VinylViewModel> list;
  private ObjectProperty<VinylViewModel> selectedVinylProperty;
  private StringProperty errorProperty;

  private VinylModel model;
  private ViewState viewState;
  private VinylViewModel vinylViewModel;

  public void ListVinylViewModel(VinylModel model, ViewState viewState) {
    this.model = model;
    this.viewState = viewState;
    this.list = FXCollections.observableArrayList();
    this.selectedVinylProperty = new SimpleObjectProperty<>();
    this.errorProperty = null;
    this.vinylViewModel = null;
  }
  public void clear() {
    list.clear();
    errorProperty.set("");
    selectedVinylProperty.set(null);
  }
  public boolean remove() {
    if (selectedVinylProperty.get()== null) {
      errorProperty.set("Nothing is selected");
      return false;
    }
      else if (selectedVinylProperty.get()!= null)
      {
        model.removeVinyl(selectedVinylProperty.get().getTitleProperty().get());
        return true;
      }
      return true;
  }
  public ObservableList<VinylViewModel> getAll() {
    for (Vinyl v : model.getAllVinyls())
    {
      list.add(new VinylViewModel(v));
    }
    return list;
  }
  public void setSelected(VinylViewModel vinylVm) {
    this.selectedVinylProperty.set(vinylVm);
  }
  public StringProperty getErrorProperty() {
    return errorProperty;
  }

  public void returnVinyl() {
    if (selectedVinylProperty.get()== null) {
      errorProperty.set("Nothing is selected");
  }
    else {
    model.returnVinyl(viewState.getTitle());
    }
  }


}
