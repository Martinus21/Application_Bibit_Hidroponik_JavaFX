package component;

import com.jfoenix.controls.JFXCheckBox;
import data.Cart;
import data.DataCart;
import data.Seed;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CardSeed {
    private String name;
    private Seed seed;
    private String description;
    private VBox card;
    private HBox cardContent;
    private Boolean isChecked = false;

    public CardSeed(Seed seed) {
        this.seed = seed;
        this.name = seed.getName();
        this.description = seed.getDescription();
        VBox paddingCard = new VBox();
        paddingCard.setPadding(new Insets(10.0, 15.0, 10.0, 15.0));
        // ISI CONTENT
        Text nameText = new Text(this.name);
        nameText.setFont(Font.font("Chilanka", FontWeight.BOLD, 30));
        nameText.setFill(Color.WHITE);
        Text descriptionText = new Text(this.description);
        descriptionText.setFont(Font.font("Chilanka", 15));
        descriptionText.setFill(Color.WHITE);
        JFXCheckBox checkedBtn = new JFXCheckBox(isChecked ? "Uncheck" : "Check");
        checkedBtn.setText("");
        checkedBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onChecked();
            }
        });

        card = new VBox();
        card.setStyle("-fx-background-color: #29d06c;");
        card.setPadding(new Insets(24.0, 16.0, 24.0, 16.0));
        VBox.setMargin(card, new Insets(24.0, 16.0, 24.0, 16.0));
        card.setPrefSize(1025, 100);
        card.setAlignment(Pos.CENTER);
        card.getChildren().add(nameText);
        card.getChildren().add(descriptionText);
        card.getChildren().add(paddingCard);
        card.getChildren().add(checkedBtn);
    }

    public VBox getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void onChecked() {
        isChecked = !isChecked;
        if(isChecked) {
            DataCart.getInstance().add(this.seed);
        } else {
            DataCart.getInstance().remove(this.seed);
        }
        for (Cart cart :
                DataCart.getInstance().get()) {
            System.out.println(cart.getSeed().getName());
        }
        System.out.println("=====================");
    }
}
