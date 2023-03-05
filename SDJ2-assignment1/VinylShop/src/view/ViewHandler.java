package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Stage primaryStage;
  private Scene currentScene;
  private ViewModelFactory viewModelFactory;
  private VinylListViewController vinylListViewController;
  private ManageViewController manageViewController;

  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewModelFactory = viewModelFactory;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage){
    this.primaryStage = primaryStage;
    openView("Vinyl List");
  }

  public void openView(String id){
    Region root = null;

    switch(id)
    {
      case "Vinyl List":
        root = loadVinylListViewController("VinylList.fxml");
        break;

      case "Manage":
        root = loadManageViewController("Manage.fxml");
        break;

    }
    currentScene.setRoot(root);
    String title = " ";
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.show();

  }
  public Region loadVinylListViewController(String fxml)
  {
    Region root;
    if (vinylListViewController ==null)
    {
     try
     {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource(fxml));
       root = loader.load();
       vinylListViewController = loader.getController();
       vinylListViewController.init(this, viewModelFactory.getListVinylViewModel(), root);

     }
     catch(Exception e)
     {
      e.printStackTrace();
     }

    }
    else {
      vinylListViewController.reset();
    }
    return vinylListViewController.getRoot();
  }

  public Region loadManageViewController(String fxml)
  {
    Region root;
    if (manageViewController ==null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        root = loader.load();
        manageViewController = loader.getController();
        manageViewController.init(this, viewModelFactory.getManageVinylViewModel(), root);

      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
      manageViewController.reset();
    }
    return manageViewController.getRoot();

  }
}
