package viewmodel;

import model.Vinyl;
import model.VinylModel;

public class ViewModelFactory

{
  private ViewState viewState;
  private ManageVinylViewModel manageViewModel;
  private ListVinylViewModel listViewModel;
  private VinylModel model;

  public ViewModelFactory (VinylModel model) {
    this.viewState = new ViewState();
    this.manageViewModel = new ManageVinylViewModel(model, viewState);
    this.listViewModel = new ListVinylViewModel();
  }
  public ManageVinylViewModel getManageVinylViewModel() {
    return manageViewModel;
  }
  public ListVinylViewModel getListVinylViewModel() {
    return listViewModel;
  }
}
