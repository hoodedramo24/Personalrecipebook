package com.example.personalrecipebook;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long iD;
    private String title;
    @Column(length = 5000)
    private String ingredients;
    @Column(length = 5000)
    private String directions;

    public Recipe(String title, String ingredients, String directions) {
        this.title = title;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Recipe() {
    }

    public Long getiD() {
        return iD;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "iD=" + iD +
                ", title='" + title + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", directions='" + directions + '\'' +
                '}';
    }
}
