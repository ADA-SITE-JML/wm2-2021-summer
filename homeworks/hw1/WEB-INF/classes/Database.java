package ada.hw1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Database{

    private ArrayList<Course> courses = new ArrayList<>();

    public ArrayList<Course> getCourses(String filename){
            try{
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()){
                    String [] tokens = br.readLine().split(";");
                    courses.add(new Course(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3]));
                }

            }catch (IOException e){
                System.out.println("Error hapened while working with files: "+e);
            }

            return courses;
    }





}