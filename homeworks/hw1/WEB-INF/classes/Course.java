package ada.hw1;

public class Course{
    private int id;
    private String title;
    private String category;
    private String instructor;

    public Course(int id, String title, String category, String instructor){
            this.id = id;
            this.title = title;
            this.category = category;
            this.instructor = instructor;
    }

    public boolean compare(String query){
        if (query.equalsIgnoreCase(String.valueOf(id)) || title.toLowerCase().contains(query.toLowerCase()) || query.equalsIgnoreCase(category) || instructor.toLowerCase().contains(query.toLowerCase()))
            return true;
        return false;
    }

    @Override
    public String toString(){
        return title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}