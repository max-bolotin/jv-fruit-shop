package core.basesyntax.model;

import java.util.Objects;

public class Fruit {
    private String name;
    private int amount;

    public Fruit(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fruit)) {
            return false;
        }
        Fruit fruit = (Fruit) o;
        return getAmount() == fruit.getAmount()
                && Objects.equals(getName(), fruit.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAmount());
    }

    @Override
    public String toString() {
        return "Fruit{"
                + "name='" + name + '\''
                + ", amount=" + amount
                + '}';
    }
}
