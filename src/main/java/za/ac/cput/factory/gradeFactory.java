package za.ac.cput.factory;

import za.ac.cput.domain.grade;
import za.ac.cput.util.Helper;

public class gradeFactory {
    public static grade createGrade(String gradeID, String gradeStudentID){

        if (Helper.isEmpty(gradeID) || Helper.isEmpty(gradeStudentID)) {
            return null;
        }

        if(!Helper.isValidEmail(gradeID)){
            return null;
        }

        return new grade
                .Builder()
                .gradeID()
                .gradeStudentID()
                .build();
    }
}
