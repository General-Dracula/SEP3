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
        } else if (networkPackage.getType().equals(NetworkType.TeacherData)) {
            TeacherDataPackage teacherDataPackage = (TeacherDataPackage) networkPackage;
            String teacherAux = gson.toJson(teacherDataPackage);
            return new ResponseEntity<String>(teacherAux, HttpStatus.OK);
        } else if (networkPackage.getType().equals(NetworkType.SecretaryData)) {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) networkPackage;
            String secretaryAux = gson.toJson(secretaryDataPackage);
            return new ResponseEntity<String>(secretaryAux, HttpStatus.OK);
        } else return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/teachers/assigngrade")
    public ResponseEntity<String> assignGrade(@RequestParam String studentID, @RequestParam String course, @RequestParam int grade, @RequestParam String teacherID)
    {
        NetworkPackage networkPackage = model.assignGrade(studentID, course, grade, teacherID);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.TeacherError)) {
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
        if (networkPackage.getType().equals(NetworkType.TeacherError)) {
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
        if (networkPackage.getType().equals(NetworkType.TeacherError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }


    //model.createTeacher("firstName", "lastName", "password");


    @GetMapping("/secretary/createteacher")
    public ResponseEntity<String> createteacher(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password)
    {
        System.out.println("AJUNGE CREATE TEACHER");
        NetworkPackage networkPackage = model.createTeacher(firstName, lastName, password);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

    @GetMapping("/secretary/editteacher")
    public ResponseEntity<String> createteacher(@RequestParam String id, @RequestParam String password)
    {
        System.out.println("AJUNGE EDIT TEACHER");
        NetworkPackage networkPackage = model.editTeacher(id, password);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @GetMapping("/secretary/deleteteacher")
    public ResponseEntity<String> deleteteacher(@RequestParam String id)
    {
        System.out.println("AJUNGE DELETE TEACHER");
        NetworkPackage networkPackage = model.deleteTeacher(id);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @GetMapping("/secretary/createstudent")
    public ResponseEntity<String> createstudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String password, @RequestParam String phoneNr, @RequestParam String birthday)
    {
        System.out.println("AJUNGE CREATE STUDENT");
        NetworkPackage networkPackage = model.createStudent(firstName, lastName, address, password, phoneNr, birthday);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/secretary/deletestudent")
    public ResponseEntity<String> deletestudent(@RequestParam String id)
    {
        System.out.println("AJUNGE DELETE STUDENT");
        NetworkPackage networkPackage = model.deleteStudent(id);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/secretary/editstudent")
    public ResponseEntity<String> editstudent(@RequestParam String studentId, @RequestParam String address, @RequestParam String password, @RequestParam String phoneNr)
    {
        System.out.println("AJUNGE EDIT TEACHER");
        NetworkPackage networkPackage = model.editStudent(studentId, address, password, phoneNr);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/secretary/createclass")
    public ResponseEntity<String> createclass(@RequestParam String classNr, @RequestParam String classLetter, @RequestParam String teacherId)
    {
        System.out.println("AJUNGE CREATE TEACHER");
        NetworkPackage networkPackage = model.createClass(classNr, classLetter, teacherId);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

    @GetMapping("/secretary/deleteclass")
    public ResponseEntity<String> deleteclass(@RequestParam String classLetter, @RequestParam String classNr)
    {
        System.out.println("AJUNGE DELETE STUDENT");
        NetworkPackage networkPackage = model.deleteClass(classLetter, classNr);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @GetMapping("/secretary/addstudent")
    public ResponseEntity<String> addstudent(@RequestParam String classNr, @RequestParam String classLetter, @RequestParam String studentId)
    {
        System.out.println("AJUNGE ADD STUDENT");
        NetworkPackage networkPackage = model.classAddStudent(classNr, classLetter, studentId);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/secretary/removestudent")
    public ResponseEntity<String> removestudent(@RequestParam String classNr, @RequestParam String classLetter, @RequestParam String studentId)
    {
        System.out.println("AJUNGE REMOVE STUDENT");
        System.out.println("----" + classNr + "-----" + classLetter + "----" + studentId);
        NetworkPackage networkPackage = model.classRemoveStudent(classNr, classLetter, studentId);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @GetMapping("/secretary/addcourse")
    public ResponseEntity<String> addcourse(@RequestParam String classNr, @RequestParam String classLetter, @RequestParam String courseName)
    {
        System.out.println("AJUNGE ADD COURSE");
        NetworkPackage networkPackage = model.classAddCourse(classNr, classLetter, courseName);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/secretary/removecourse")
    public ResponseEntity<String> removecourse(@RequestParam String classNr, @RequestParam String classLetter, @RequestParam String courseName)
    {
        System.out.println("AJUNGE REMOVE COURSE");
        NetworkPackage networkPackage = model.classRemoveCourse(classNr, classLetter, courseName);
        String response = gson.toJson(networkPackage);
        if (networkPackage.getType().equals(NetworkType.SecretaryError)) {
            System.out.println("BAD REQUEST");
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("E BINE");
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

}