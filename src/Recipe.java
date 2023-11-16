import java.util.List;

// Record class in Java 11 and above
// Record class represent Recipe class
record Recipe(String name, String cuisine, List<String> ingredients) {

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}

/*
class Recipe { // This way can be used in Java 8 and above as well
    private final String name;
    private final String cuisine;
    private final List<String> ingredients;

    public Recipe(String name, String cuisine, List<String> ingredients) {
        this.name = name;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}*/
