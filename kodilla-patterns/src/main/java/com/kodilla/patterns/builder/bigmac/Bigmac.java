package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final Roll roll;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredients> ingredients;

    public enum Sauce {
        STANDARD,
        Isle1000,
        BARBEQUE
    }

    public enum Roll {
        STANDARD,
        SESAME
    }

    public enum Ingredients {
        LETTUCE,
        ONION,
        BACKON,
        CHILLI,
        CHAMPIGNON,
        SHRIMPS,
        CHEESE
    }

    public Bigmac(Roll roll, int burgers, Sauce sauce, List<Ingredients> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Roll getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class BigmacBuilder {
        private Roll rol1;
        private int burgers;
        private Sauce sauce;
        private List<Ingredients> ingredients = new ArrayList<>();



        public BigmacBuilder roll(Roll roll) {
            this.rol1 = roll;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(rol1, burgers, sauce, ingredients);
        }
    }
}
