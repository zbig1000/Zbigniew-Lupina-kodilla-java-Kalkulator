package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;


    public Bigmac(String roll, int burgers, String sauce, List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
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
        private String bigRoll;
        private int burgers;
        private String bigSauce;
        private List<String> ingredients = new ArrayList<>();

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

        public BigmacBuilder roll(Roll roll) {
            this.bigRoll = roll.toString();
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.bigSauce = sauce.toString();
            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient) {
            ingredients.add(ingredient.toString());
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bigRoll, burgers, bigSauce, ingredients);
        }
    }
}
