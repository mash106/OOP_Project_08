package com.example.oop_project_group_8.Mahir_2211582;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class BrowseProductSceneController {

    @FXML
    private ComboBox<String> productTypeComboBox;

    @FXML
    private TableView<Product> productCatalogTable;

    @FXML
    private TableColumn<Product, String> productNameTC;

    @FXML
    private TableColumn<Product, String> speciesTC;

    @FXML
    private TableColumn<Product, String> productDetailsTC;

    @FXML
    private TableColumn<Product, Double> priceTC;

    private ObservableList<Product> productList;

    private ObservableList<Product> filteredList;

    @FXML
    public void initialize() {
        productTypeComboBox.setItems(FXCollections.observableArrayList(
                "All", "Fish Feed", "Fingerlings", "Water Quality Enhancers"
        ));

        productList = FXCollections.observableArrayList(
                new Product("Tilapia Fingerlings", "Fingerlings", "Healthy fingerlings (100 pcs)", 250.0),
                new Product("Rohu Fingerlings", "Fingerlings", "High-quality hatchery Rohu (100 pcs)", 300.0),
                new Product("Carp Feed", "Fish Feed", "Nutrient-rich feed for carp (50 kg bag)", 2500.0),
                new Product("Pangasius Feed", "Fish Feed", "Specialized feed for Pangasius (50 kg bag)", 3000.0),
                new Product("pH Balancer", "Water Quality Enhancers", "Improves water quality (1 kg)", 1500.0),
                new Product("Dissolved Oxygen Booster", "Water Quality Enhancers", "Ensures optimal oxygen levels (500 g)", 2000.0),
                new Product("Catla Fingerlings", "Fingerlings", "Healthy Catla fingerlings (100 pcs)", 350.0),
                new Product("Mrigal Fingerlings", "Fingerlings", "High-quality Mrigal (100 pcs)", 400.0),
                new Product("Shrimp Feed", "Fish Feed", "Specialized feed for shrimp (50 kg bag)", 2800.0),
                new Product("Floating Feed", "Fish Feed", "Ideal for surface feeders (50 kg bag)", 2600.0),
                new Product("Probiotic", "Water Quality Enhancers", "Improves fish gut health (1 kg)", 1800.0),
                new Product("Organic Fertilizer", "Water Quality Enhancers", "Boosts plankton growth (25 kg bag)", 1000.0),
                new Product("Silver Carp Fingerlings", "Fingerlings", "Healthy silver carp (100 pcs)", 300.0),
                new Product("Grass Carp Fingerlings", "Fingerlings", "Ideal for weed control (100 pcs)", 320.0),
                new Product("Fish Vitamins", "Fish Feed", "Enhances fish growth (1 kg)", 2200.0),
                new Product("Amur Carp Fingerlings", "Fingerlings", "Hardy and fast-growing (100 pcs)", 450.0),
                new Product("Barramundi Fingerlings", "Fingerlings", "Premium quality Barramundi (50 pcs)", 500.0),
                new Product("Aquatic pH Stabilizer", "Water Quality Enhancers", "Maintains stable pH levels (1 kg)", 1600.0),
                new Product("Plankton Booster", "Water Quality Enhancers", "Increases natural food availability (500 g)", 1200.0),
                new Product("Mud Carp Fingerlings", "Fingerlings", "Well-adapted for local environments (100 pcs)", 380.0)
        );

        productNameTC.setCellValueFactory(new PropertyValueFactory<>("productName"));
        speciesTC.setCellValueFactory(new PropertyValueFactory<>("species"));
        productDetailsTC.setCellValueFactory(new PropertyValueFactory<>("productDetails"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));

        productCatalogTable.setItems(productList);
        productTypeComboBox.setOnAction(e -> filterProductList());
    }

    @FXML
    public void viewProductDetailsButtonOnAction(ActionEvent actionEvent) {
        Product selectedProduct = productCatalogTable.getSelectionModel().getSelectedItem();

        if (selectedProduct != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/productDetailScene.fxml"));
                Parent root = loader.load();

                ProductDetailSceneController controller = loader.getController();
                controller.setProduct(selectedProduct);
                Stage stage = (Stage) productCatalogTable.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please select a product to view details.");
        }
    }

    private void filterProductList() {
        String selectedType = productTypeComboBox.getValue();

        if (selectedType == null || selectedType.equals("All")) {
            productCatalogTable.setItems(productList);
        } else {
            // Filter products by selected type
            filteredList = FXCollections.observableArrayList();
            for (Product product : productList) {
                if (product.getSpecies().equalsIgnoreCase(selectedType)) {
                    filteredList.add(product);
                }
            }
            productCatalogTable.setItems(filteredList);
        }
    }

    public static class Product {
        private final String productName;
        private final String species;
        private final String productDetails;
        private final double price;

        public Product(String productName, String species, String productDetails, double price) {
            this.productName = productName;
            this.species = species;
            this.productDetails = productDetails;
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public String getSpecies() {
            return species;
        }

        public String getProductDetails() {
            return productDetails;
        }

        public double getPrice() {
            return price;
        }
    }
}
