package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class resource implements Serializable{

    @Id @Column (name = "resource")

    private String resourceID;
    private String textbooks;
    private String exercises;
    private String slideshows;

    protected resource(){

    }

    private resource(resource.Builder builder){

        this.resourceID = builder.resourceID;
        this.textbooks = builder.textbooks;
        this.exercises = builder.exercises;
        this.slideshows = builder.slideshows;

    }
    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public String getTextbooks() {
        return textbooks;
    }

    public void setTextbooks(String textbooks) {
        this.textbooks = textbooks;
    }

    public String getExercises() {
        return exercises;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public String getSlideshows() {
        return slideshows;
    }

    public void setSlideshows(String slideshows) {
        this.slideshows = slideshows;
    }

    @Override
    public String toString() {
        return "resource{" +
                "resourceID='" + resourceID + '\'' +
                ", textbooks='" + textbooks + '\'' +
                ", exercises='" + exercises + '\'' +
                ", slideshows='" + slideshows + '\'' +
                '}';
    }
    public static class Builder {
        private String resourceID;
        private String textbooks;
        private String exercises;
        private String slideshows;
        public Builder resourcesID(){
            this.resourceID = resourceID;
            return this ;
        }

        public Builder textbooks(){
            this.textbooks = textbooks;
            return this ;
        }

        public Builder exercises(){
            this.exercises = exercises;
            return this ;
        }

        public Builder slideshows(){
            this.slideshows = slideshows;
            return this ;
        }
        public resource.Builder copy(resource r){
            this.resourceID = r.resourceID;
            this.textbooks = r.textbooks;
            this.exercises = r.exercises;
            this.slideshows = r.slideshows;

            return this;
        }
        public resource build(){
            return new resource(this);
        }
    }


}
