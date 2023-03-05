package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import utility.observer.IntegerToStringConverter;
import viewmodel.ManageVinylViewModel;

public class ManageViewController {

  @FXML
  private Label artistLabel;

  @FXML
  private Button buttonLabel;

  @FXML
  private Label errorLabel;

  @FXML
  private Label statusLabel;

  @FXML
  private Label titleLabel;

  @FXML
  private TextField whoField;

  @FXML
  private Label yearLabel;

  private ViewHandler viewHandler;

  private Region root;

  private ManageVinylViewModel manageVinylViewModel;

  private IntegerToStringConverter converter;

  @FXML
  void clickBorrowOrReserve(ActionEvent event) {
    String status = manageVinylViewModel.getStatusProperty().get();
    String who = whoField.getText();

    if (status.equals("borrow"))
      manageVinylViewModel.borrow(who);
    else
      manageVinylViewModel.reserve(who);
  }

  @FXML
  void goBack() {
    viewHandler.openView("Vinyl List");
  }

  public void init(ViewHandler viewHandler, ManageVinylViewModel manageVinylViewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.manageVinylViewModel = manageVinylViewModel;
    this.root = root;

    artistLabel.textProperty().bind(manageVinylViewModel.getArtistProperty());
    errorLabel.textProperty().bind(manageVinylViewModel.getErrorProperty());
    titleLabel.textProperty().bind(manageVinylViewModel.getTitleProperty());
    yearLabel.textProperty().bind(new SimpleStringProperty(manageVinylViewModel.getYearProperty().toString()));
    //set label to borrow/reserve depending on status

    reset();
  }

  public void reset()
  {
    titleLabel.setText(manageVinylViewModel.getTitleProperty().get());
    artistLabel.setText(manageVinylViewModel.getArtistProperty().get());
    yearLabel.setText(manageVinylViewModel.getYearProperty().getValue().toString());
    statusLabel.setText(manageVinylViewModel.getStatusProperty().get());

    errorLabel.setText(null);
  }

  public Region getRoot()
  {
    return root;
  }
}