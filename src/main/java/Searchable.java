// Defining our interface
public interface Searchable {
    // Contract -> Describes something which can be searched.
    // What-they-will-return method-name
    String toString();

    // Define the parameters of the method -> type etc...
    boolean hasMatch(String searchTerm);
}
