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
        NetworkPackage bai = model.checkLogInInfo(username, password);
        if (bai.getType().equals(NetworkType.StudentData)) {
            StudentDataPackage studentDataPackage = (StudentDataPackage) bai;
            String studentAux = gson.toJson(studentDataPackage);
            return new ResponseEntity<String>(studentAux, HttpStatus.OK);
        }else if(bai.getType().equals(NetworkType.TeacherData))
        {
            TeacherDataPackage teacherDataPackage = (TeacherDataPackage) bai;
            String teacherAux = gson.toJson(teacherDataPackage);
            return new ResponseEntity<String>(teacherAux, HttpStatus.OK);
        }   else return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }


    //model.assignGrade(id, course, grade);
}
