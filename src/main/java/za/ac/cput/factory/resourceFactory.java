package za.ac.cput.factory;


import za.ac.cput.domain.resource;
import za.ac.cput.util.Helper;

public class resourceFactory {
    public static resource createResource(String resourceID, String exercises, String textbooks, String slideshows) {

        if (Helper.isEmpty(resourceID) || Helper.isEmpty(textbooks) || Helper.isEmpty(exercises) || Helper.isEmpty(slideshows)) {
            return null;
        }

        if (!Helper.isValidEmail(resourceID)) {
            return null;
        }
        return new resource
                .Builder()
                .resourcesID()
                .textbooks()
                .exercises()
                .slideshows()
                .build();
    }
}
