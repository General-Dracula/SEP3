package com.example.tier1Mediator;

import com.example.model.Tier1Model;
import com.example.tier3NetworkPackages.*;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class Tier1ApiConnection {
    @Autowired
    Tier1Model model;

    private Gson gson;


    public Tier1ApiConnection(Tier1Model model)
    {
        this.model = model;
        gson = new Gson();

    }


    @PostMapping("/users")
    public ResponseEntity<String> getUser(@RequestBody TwoFieldPackage user)
    {
        String username = user.getFirstField();
        String password = user.getSecondField();
        NetworkPackage networkPackage = model.checkLogInInfo(username, password);
        if (networkPackage.getType().equals(NetworkType.StudentData)) {
            StudentDataPackage studentDataPackage = (StudentDataPackage) networkPackage;
            String studentAux = gson.toJson(studentDataPackage);
            return new ResponseEntity<String>(studentAux, HttpStatus.OK);
        }else if(networkPackage.getType().equals(NetworkType.TeacherData))
        {
            TeacherDataPackage teacherDataPackage = (TeacherDataPackage) networkPackage;
            String teacherAux = gson.toJson(teacherDataPackage);
            return new ResponseEntity<String>(teacherAux, HttpStatus.OK);
        }else if(networkPackage.getType().equals(NetworkType.SecretaryData))
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) networkPackage;
            String secretaryAux = gson.toJson(secretaryDataPackage);
            return new ResponseEntity<String>(secretaryAux, HttpStatus.OK);
        }   else return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/teachers/assigngrade")
    public ResponseEntity<String> assignGrade(@RequestParam String studentID, @RequestParam String course, @RequestParam int grade, @RequestParam String teacherID)
    {
        NetworkPackage networkPackage = model.assignGrade(studentID, course, grade, teacherID);
        String response = gson.toJson(networkPackage);
        if(networkPackage.getType().equals(NetworkType.TeacherError))
        {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

    @GetMapping("/teachers/assignabsence")
    public ResponseEntity<String> assignabsence(@RequestParam String studentID, @RequestParam String course, @RequestParam String teacherID)
    {
        NetworkPackage networkPackage = model.assignAbsence(studentID, course, teacherID);
        String response = gson.toJson(networkPackage);
        if(networkPackage.getType().equals(NetworkType.TeacherError))
        {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

    @GetMapping("/teachers/motivateabsence")
    public ResponseEntity<String> motivateabsence(@RequestParam String studentID, @RequestParam String course, @RequestParam String date, @RequestParam String teacherID)
    {
        System.out.println("AJUNGE ABSENCE MOTIVATE");
        NetworkPackage networkPackage = model.motivateAbsence(studentID, course, date, teacherID);
        String response = gson.toJson(networkPackage);
        if(networkPackage.getType().equals(NetworkType.TeacherError))
        {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

}
