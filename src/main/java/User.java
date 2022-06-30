/**
 * CLASS SYNTAX CHALLENGE
 * CREATE A USER CLASS FIELDS, GETTERS AND SETTERS
 *
 * USER CLASS RESPONSIBLE FOR
 * - STORING & GETTING NAME
 * - STORING & GETTING & SETTING SCORE
 *   - SCORE SHOULD BE 0 ON INITIALIZATION
 *   - SCORE CAN NOT GO BELOW 0 OR OVER 100
 * - STORING & GETTING & SETTING TREAT COUNT
 *  - TREAT COUNT SHOULD BE 5 ON INITIALIZATION
 *  - TREAT COUNT CAN NOT GO BELOW 0 OR OVER 10
 *
 */

public class User implements Searchable {

    private String name;
    private int score;
    private int treatCount;


    public User (String name) {
      this.name = name;
      this.score = 0;
      this.treatCount = 5;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTreatCount() {
        return treatCount;
    }

    public void setTreatCount(int treatCount) {
        this.treatCount = treatCount;
        checkTreats();
    }

    public void checkScore () {
        if (this.score < 0) {
            this.score = 0;
            System.out.println("Score cannot go below zero.");
        } else if (this.score > 100) {
            this.score = 100;
            System.out.println("Score cannot above one hundred.");
        }
    }

    public void checkTreats () {
        if (this.treatCount < 0) {
            this.treatCount = 0;
            System.out.println("Treats cannot go below zero.");
        } else if (this.treatCount > 10) {
            this.treatCount = 10;
            System.out.println("Treats cannot be above ten.");
        }
    }

    /**
     * USER METHODS CHALLENGE
     * ADD THE FOLLOWING METHODS
     *
     * - hasTreatsLeft()
     *  - CHECKS IF A USER HAS TREATS LEFT
     *  - RETURNS A BOOLEAN
     *
     * - decrementTreats()
     *  - IF A USER HAS TREATS LEFT DECREMENT THE TREAT COUNT
     *
     * - getInformation()
     *  - RETURNS A STRING IN THE FOLLOWING FORMAT
     *  - "\nName : NAME \nScore : SCORE \nTreat Count : TREAT COUNT\n"
     *  - THE CAPITAL LETTERS SHOULD BE REPLACED BY THE FIELDS IN THE CLASS
     *
     * - incrementScore()
     *  - INCREMENTS THE CURRENT SCORE BY 10
     *  - 1 IN 4 CHANCE TO GET A ANIMAL TOKEN
     *  - DOES NOT RETURN ANYTHING
     */

    public Boolean hasTreatsLeft () {
        if (this.treatCount>0) {
            return true;
        }
        return false;
    }

    public void decrementTreats () {
        if (hasTreatsLeft()) {
            setTreatCount(treatCount-1);
        }
    }

    @Override
    public String toString () {
        return String.format("\nName : %s \nType : %s \nTreat Count : %s", name, score, treatCount);
    }

    public void incrementScore () {
        setScore(score + 10);
        if ((int) (Math.random() * 4) == 0) {
            setTreatCount(treatCount + 1);
        }
    }

    public void giveTreat () {
        setTreatCount(treatCount-1);
    }

    @Override
    public boolean hasMatch(String searchTerm) {
        // Checks if the name field contains the search term which was pass in.
        // .contains() returns a boolean value.
        return name.toLowerCase().contains(searchTerm.toLowerCase());
    }
}
