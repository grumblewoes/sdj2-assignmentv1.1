package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import model.Vinyl;
import viewmodel.ListVinylViewModel;
import viewmodel.VinylViewModel;

public class VinylListViewController
{
  @FXML private Label errorLabel;

  @FXML private TableView<VinylViewModel> table;
  @FXML private TableColumn<VinylViewModel,String> titleColumn;
  @FXML private TableColumn<VinylViewModel,String> artistColumn;
  @FXML private TableColumn<VinylViewModel,Integer> yearColumn;
  @FXML private TableColumn<VinylViewModel,String> statusColumn;

  private ListVinylViewModel vinylListViewModel;
  private Region root;
  private ViewHandler viewHandler;


  public void init(ViewHandler viewHandler, ListVinylViewModel vinylListViewModel, Region root ){
    this.root = root;
    this.viewHandler = viewHandler;
    this.vinylListViewModel = vinylListViewModel;

    //bind
    titleColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getTitleProperty());
    artistColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getArtistProperty());
    yearColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getYearProperty().asObject());
    statusColumn.setCellValueFactory( cellData -> cellData.getValue()
        .getStatusProperty());
    table.setItems(vinylListViewModel.getAll());

    reset();

  }

  public Region getRoot(){
    return root;
  }

  @FXML private void clickReserve(){
    vinylListViewModel.setSelected(table.getSelectionModel().getSelectedItem());
    viewHandler.openView("Manage");
  }

  @FXML private void clickReturn(){
    vinylListViewModel.setSelected(table.getSelectionModel().getSelectedItem());
    vinylListViewModel.returnVinyl();
  }

  @FXML private void clickBorrow(){
    vinylListViewModel.setSelected(table.getSelectionModel().getSelectedItem());
    viewHandler.openView("Manage");
  }

  @FXML private void clickRemove(){
    vinylListViewModel.setSelected(table.getSelectionModel().getSelectedItem());
    System.out.println(vinylListViewModel.remove());
  }

  public void reset()
  {

    errorLabel.setText(null);
  }
}
