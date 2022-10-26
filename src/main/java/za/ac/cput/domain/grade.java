package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class grade implements Serializable {

    @Id @Column (name = "grade")

    private String gradeID;
    private String gradeStudentID;

    protected grade(){

    }

    private grade(Builder builder){

        this.gradeID = builder.gradeID;
        this.gradeStudentID = builder.gradeStudentID;

    }

    public static grade save(grade grade2) {
        return null;
    }

    public String getGradeID() {
        return gradeID;
    }

    public void setGradeID(String gradeID) {
        this.gradeID = gradeID;
    }

    public String getGradeStudentID() {
        return gradeStudentID;
    }

    public void setGradeStudentID(String gradeStudentID) {
        this.gradeStudentID = gradeStudentID;
    }

    @Override
    public String toString() {
        return "grade{" +
                "gradeID=" + gradeID +
                ", gradeStudentID=" + gradeStudentID +
                '}';
    }

    public static class Builder {
        private String gradeID;
        private String gradeStudentID;

        public Builder gradeID(){
            this.gradeID = gradeID;
            return this ;
        }

        public Builder gradeStudentID(){
            this.gradeStudentID = gradeStudentID;
            return this ;
        }

        public Builder copy(grade g){
            this.gradeID = g.gradeID;
            this.gradeStudentID = g.gradeStudentID;

            return this;
        }

        public grade build(){
            return new grade(this);
        }

    }


}
