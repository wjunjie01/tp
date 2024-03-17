package seedu.stockpal.data.product;

import seedu.stockpal.exceptions.InsufficientAmountException;
import seedu.stockpal.ui.Ui;

public class Product {
    protected Name name;
    protected Quantity quantity;
    protected Price price;
    protected Description description;
    protected Pid pid;

    public Product(String name, Integer quantity, Double price, String description, Integer pid) {
        this.name = new Name(name);
        this.quantity = new Quantity(quantity);
        this.price = new Price(price);
        this.description = new Description(description);
        this.pid = new Pid(pid);
    }

    public Name getName() {
        return this.name;
    }

    public Quantity getQuantity() {
        return this.quantity;
    }

    public Price getPrice() {
        return this.price;
    }

    public Description getDescription() {
        return this.description;
    }

    public Pid getPid() {
        return this.pid;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public boolean isPidMatch(Pid pid) {
        return this.pid.equals(pid);
    }

    public void increaseQuantity(Integer amountToChange) {
        quantity.updateIncreaseQuantity(amountToChange);
    }

    public void decreaseQuantity(Integer amountToChange) {
        try {
            quantity.updateDecreaseQuantity(amountToChange);
            Ui.printToScreen("Quantity updated. " + quantity);
        } catch (InsufficientAmountException e) {
            Ui.printToScreen("Insufficient amount in inventory. No change to quantity." + quantity);
        }
    }

    @Override
    public String toString() {
        return "" + this.name;
    }
}
