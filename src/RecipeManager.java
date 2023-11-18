import java.util.*;

public class RecipeManager {
    private static final Map<String, Recipe> recipes = new HashMap<>();
    // Use HashMap instead of TreeMap for faster lookup and insertion time for recipes
    // with the same name and cuisine type in the same order of insertion time.
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        // For Main Menu
        while (true) {
            System.out.println("\nRecipe Management System");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Search Recipes by Ingredients");
            System.out.println("4. Delete Recipe");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // For Add Recipe
                    addRecipe();
                    break;
                case 2: // For View Recipes
                    viewRecipes();
                    break;
                case 3: // For Search Recipes by Ingredients
                    searchByIngredients();
                    break;
                case 4: // For Delete Recipe
                    deleteRecipe();
                    break;
                case 5: // For Exit
                    System.out.println("Exiting the program..."); // Exit the program
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    // For Add Recipe
    private static void addRecipe() {
        System.out.print("Enter recipe name: ");
        String name = userInput.nextLine();

        System.out.print("Enter cuisine type: ");
        String cuisine = userInput.nextLine();

        System.out.print("Enter ingredients (comma-separated): ");
        String[] ingredientsArray = userInput.nextLine().split(",");
        // Use comma as delimiter for an ingredient list in the input string.

        List<String> ingredients = new ArrayList<>(); // Use ArrayList for faster insertion time

        for (String ingredient : ingredientsArray) {
            ingredients.add(ingredient.trim()); // Trim spaces from each ingredient in the list
        }

        // For Record class in Java 11 and above
        Recipe recipe = new Recipe(name, cuisine, ingredients);
        recipes.put(name, recipe);

        System.out.println("Recipe added successfully!");
    }

    // For View Recipes
    private static void viewRecipes() {
        if (recipes.isEmpty()) { // Check if the map is empty or not
            System.out.println("No recipes available.");
        } else { // If the map is not empty
            for (Recipe recipe : recipes.values()) {
                System.out.println(recipe); // Print each recipe
            }
        }
    }

    // For Search Recipes by Ingredients
    private static void searchByIngredients() {
        System.out.print("Enter ingredients to search (comma-separated): ");
        String[] searchIngredientsArray = userInput.nextLine().split(",");

        List<String> searchIngredients = new ArrayList<>(); // Use ArrayList for faster insertion time

        for (String ingredient : searchIngredientsArray) {
            searchIngredients.add(ingredient.trim()); // Trim spaces from each ingredient in the list
        }

        for (Recipe recipe : recipes.values()) { // For each recipe in the map

            // If the recipe contains all the ingredients in the search list
            if (new HashSet<>(recipe.ingredients()).containsAll(searchIngredients)) {
                System.out.println(recipe); // Print the recipe
            }
        }
    }

    // For Delete Recipe
    private static void deleteRecipe() {
        System.out.print("Enter the name of the recipe to delete: ");
        String recipeName = userInput.nextLine();

        Recipe deletedRecipe = recipes.remove(recipeName); // Remove the recipe from the map

        // Check if the recipe was deleted successfully
        if (deletedRecipe != null) {
            System.out.println("Recipe deleted successfully: " + deletedRecipe.name());
        } else { // If the recipe was not found
            System.out.println("Recipe not found: " + recipeName);
        }
    }
}