package Model;

public class Education_degree {
    private int education_id;
    private String education_name;

    public Education_degree() {
    }

    public Education_degree(int education_id, String education_name) {
        this.education_id = education_id;
        this.education_name = education_name;
    }

    public int getEducation_id() {
        return education_id;
    }

    public void setEducation_id(int education_id) {
        this.education_id = education_id;
    }

    public String getEducation_name() {
        return education_name;
    }

    public void setEducation_name(String education_name) {
        this.education_name = education_name;
    }
}
