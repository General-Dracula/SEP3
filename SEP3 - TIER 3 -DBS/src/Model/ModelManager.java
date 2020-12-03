package Model;

import Data.*;
import Data.Secretary;
import Data.Class;
import Tier2Mediator.Tier2Connection;
import Tier2Mediator.Tier2SocketConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ModelManager implements Model, Tier2Model {
    Tier2Connection tier2Connection;
    String dateField = "";

    java.sql.Date date2 = new java.sql.Date(1000);

    Connection con;

    ////TESTING
    ArrayList<Grade> grades = new ArrayList<Grade>();
    ArrayList<Grade> gradesB = new ArrayList<Grade>();
    ArrayList<Absence> absences = new ArrayList<Absence>();
    Student student;
    ArrayList<Teacher> teachers;
    Class aClass;
    Class bClass;
    ArrayList<Student> studentsA, studentsB;
    ArrayList<Class> classes;
    Secretary secretary;

    public ModelManager()
    {
        tier2Connection = new Tier2SocketConnection(this);
        tier2Connection.connect(6969);
        tier2Connection.waitFromTier2();


        SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        java.util.Date date = new Date();
        dateField = formatterDate.format(date);

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SEP3-DBS", "postgres", "MuiePSD2020");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        Runnable runnable2 = () -> {
            while (true) {

                try {
                    dateField = formatterDate.format(date);
                    Thread.sleep(980*60*60*24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(runnable2);
        t2.setDaemon(true);
        t2.start();

//        courses.add(new Course("Math"));
//        courses.add(new Course("Computer Science"));
//        courses.add(new Course("Romanian"));
//        courses.add(new Course("English"));
//        courses.add(new Course("German"));
//        courses.add(new Course("French"));
//        courses.add(new Course("Physics"));
//        courses.add(new Course("Biology"));
//        courses.add(new Course("Chemistry"));
//        courses.add(new Course("Geography"));
//        courses.add(new Course("Physical Education"));
//        courses.add(new Course("Economics"));



        //testing
        grades.add(new Grade(7, "01/02/2020", "Math"));
        grades.add(new Grade(10, "01/02/2020", "Math"));
        grades.add(new Grade(9, "01/02/2020", "Math"));
        grades.add(new Grade(10, "01/02/2020", "Math"));
        grades.add(new Grade(8, "01/02/2020", "Romanian"));
        grades.add(new Grade(5, "01/02/2020", "Romanian"));
        grades.add(new Grade(7, "01/02/2020", "Chemistry"));
        grades.add(new Grade(5, "01/02/2020", "Chemistry"));
        grades.add(new Grade(10, "01/02/2020", "English"));
        grades.add(new Grade(10, "01/02/2020", "English"));
        grades.add(new Grade(2, "01/02/2020", "Chemistry"));
        grades.add(new Grade(10, "01/02/2020", "Computer Science"));
        grades.add(new Grade(9, "01/02/2020", "Computer Science"));
        grades.add(new Grade(10, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(10, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(9, "01/02/2020", "Computer Science"));
        gradesB.add(new Grade(10, "01/02/2020", "Computer Science"));

        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", true, "Romanian"));
        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", true, "Math"));
        absences.add(new Absence("01/02/2020", false, "Math"));
        absences.add(new Absence("01/02/2020", false, "Chemistry"));
        absences.add(new Absence("01/02/2020", false, "English"));
        absences.add(new Absence("01/02/2020", false, "Computer Science"));
        absences.add(new Absence("01/02/2020", true, "Computer Science"));
        absences.add(new Absence("01/02/2020", true, "Computer Science"));

        studentsA = new ArrayList<Student>();
        studentsB = new ArrayList<Student>();

        student = new Student("1", "Dodonica", "Puta mica", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsA.add(student);
        student = new Student("3", "Paul", "Balan", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsA.add(student);
        student = new Student("4", "Mircea", "Dobre", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", grades, absences);
        studentsB.add(student);
        student = new Student("5", "Sandu", "Chilat", "Sugi pula dodon 13", "01/12/2000", "1", "07442121", gradesB, absences);
        studentsB.add(student);

        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Math"));
        courses.add(new Course("Chemistry"));
        courses.add(new Course("English"));
        courses.add(new Course("Computer Science"));
        courses.add(new Course("Romanian"));


        ArrayList<Course> courses2 = new ArrayList<Course>();
        courses2.add(new Course("Math"));
        courses2.add(new Course("Chemistry"));
        courses2.add(new Course("English"));
        courses2.add(new Course("Computer Science"));
        courses2.add(new Course("Romanian"));
        courses2.add(new Course("Sugilimie"));


        aClass = new Class(12, 'A', "112", studentsA, courses);
        bClass = new Class(11, 'B', "112", studentsB, courses2);
        classes = new ArrayList<Class>();
        classes.add(aClass);
        classes.add(bClass);

        teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("2", "Baba", "Cloanta", "2", classes));


        secretary = new Secretary("0", "0", teachers, classes);

    }

    synchronized private String getNewId()
    {
        String maxNr = "0";

        for (int i = 0; i < teachers.size(); i++)
            if (Integer.parseInt(teachers.get(i).getId()) > Integer.parseInt(maxNr))
                maxNr = teachers.get(i).getId();

        for (int i = 0; i < studentsA.size(); i++)
            if (Integer.parseInt(studentsA.get(i).getId()) > Integer.parseInt(maxNr))
                maxNr = studentsA.get(i).getId();

        for (int i = 0; i < studentsB.size(); i++)
            if (Integer.parseInt(studentsB.get(i).getId()) > Integer.parseInt(maxNr))
                maxNr = studentsB.get(i).getId();

        if (Integer.parseInt(secretary.getId()) > Integer.parseInt(maxNr))
            maxNr = secretary.getId();

        maxNr = String.valueOf(Integer.parseInt(maxNr) + 1);

        return maxNr;
    }

    private ArrayList<Class> getClasses()
    {
        ArrayList<Class> classes = new ArrayList<Class>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();


        try {
            ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.class").executeQuery();
            while (rs.next())
            {
                    ResultSet rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.student_class_link WHERE class_id = " +  rs.getString(1)).executeQuery();
                    while(rs2.next())
                    {
                        students.add(this.getStudentData(rs2.getString(2)));
                    }


                ResultSet rs3 = con.prepareStatement("SELECT * FROM gradebook_dbs.course WHERE class_id ='" + rs.getString(1) + "'").executeQuery();
                while (rs3.next())
                {
                    courses.add(new Course(rs3.getString(2)));
                }

                classes.add(new Class(rs.getInt(2), rs.getString(3).charAt(0), "", students, courses));
                courses = new ArrayList<Course>();
                students = new ArrayList<Student>();
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return classes;
    }

    private ArrayList<Class> getTeacherClasses(String teacherID)
    {
        ArrayList<Class> classes = new ArrayList<Class>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Course> courses = new ArrayList<Course>();

        ArrayList<String> classesTeached = new ArrayList<String>();


        try {
            ResultSet rs2 = null;
            rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.teacher_class_link WHERE teacher_id ='" + teacherID + "'").executeQuery();
            while (rs2.next())
            {
                classesTeached.add(rs2.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.class").executeQuery();
            while (rs.next())
            {
                boolean continues = false;

                for(int i = 0; i < classesTeached.size(); i++)
                    if(classesTeached.get(i).equals(rs.getString(1)))
                        continues = true;

                if(continues)
                {
                    ResultSet rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.student_class_link WHERE class_id = " + rs.getString(1)).executeQuery();
                    while (rs2.next()) {
                        students.add(this.getStudentData(rs2.getString(2)));
                    }


                    ResultSet rs3 = con.prepareStatement("SELECT * FROM gradebook_dbs.course WHERE class_id ='" + rs.getString(1) + "'").executeQuery();
                    while (rs3.next()) {
                        courses.add(new Course(rs3.getString(2)));
                    }

                    classes.add(new Class(rs.getInt(2), rs.getString(3).charAt(0), "", students, courses));
                    courses = new ArrayList<Course>();
                    students = new ArrayList<Student>();
                }
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return classes;
    }

    private Teacher getTeacherData(String id)
    {
        System.out.println("----------TEACHER DATA ");
        Teacher teacher = null;
        ArrayList<Class> classes = this.getTeacherClasses(id);


        ResultSet rs3 = null;
        try {
            rs3 = con.prepareStatement("SELECT * FROM gradebook_dbs.teacher WHERE id ='" + id + "'").executeQuery();
            while (rs3.next())
            {
                teacher = new Teacher(rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), classes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teacher;
    }

    private Student getStudentData(String id)
    {
        System.out.println("----------STUDENT DATA ");
//

        ArrayList<Grade> grades = new ArrayList<Grade>();

        try {
            ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.grades WHERE student_id ='" + id + "'").executeQuery();
            while (rs.next())
            {
                if (rs.getString(5).equals(id))
                {
                    grades.add(new Grade(Integer.parseInt(rs.getString(2)), rs.getString(3), rs.getString(4)));
                }
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }


        ArrayList<Absence> absences = new ArrayList<Absence>();

        try {
            ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.absence WHERE student_id ='" + id + "'").executeQuery();
            while (rs.next())
            {
                if (rs.getString(5).equals(id))
                {
                    absences.add(new Absence( rs.getString(2),  rs.getBoolean(3),  rs.getString(4)));
                }
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }


        try {
            ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.student WHERE id ='" + id + "'").executeQuery();
            while (rs.next())
            {
                if (rs.getString(1).equals(id))
                {
                    return new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getString(5), rs.getString(6), grades, absences);
                }
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private ArrayList<Teacher> getTeachers()
    {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();

        ResultSet rs3 = null;
        try {
            rs3 = con.prepareStatement("SELECT * FROM gradebook_dbs.teacher").executeQuery();
            while (rs3.next())
            {
                teachers.add( new Teacher(rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4), null));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    private Secretary getSecretaryData(String id)
    {
        System.out.println("----------SECRETARY DATA ");


        Secretary secretary = null;


        try {
            ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.secretary").executeQuery();
            while (rs.next()) {

                    secretary = new Secretary(rs.getString(2), rs.getString(2), this.getTeachers(),this.getClasses() );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return secretary;
    }

    private String isUserValid(String id, String password)
    {

        if(id.charAt(0) != 'T' && id.charAt(0) != 'S')
        {
            try {
                ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.student WHERE id ='" + id + "'").executeQuery();
                while (rs.next()) {
                    if (rs.getString(1).equals(id) && rs.getString(5).equals(password)) {
                        return "Student";
                    } else System.out.println(rs.getString(1) + " - " + rs.getString(5));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

            if(id.charAt(0) == 'T')
            {
                id = id.substring(1);
            try {
                ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.teacher WHERE id ='" + id + "'").executeQuery();
                while (rs.next()) {
                    if (rs.getString(1).equals(id) && rs.getString(4).equals(password)) {
                        return "Teacher";
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        if(id.charAt(0) == 'S')
        {
            id = id.substring(1);
            try {
                ResultSet rs = con.prepareStatement("SELECT * FROM gradebook_dbs.secretary WHERE username ='" + id + "'").executeQuery();
                while (rs.next()) {
                    if (rs.getString(2).equals(id) && rs.getString(3).equals(password)) {
                        return "Secretary";
                    } else System.out.println("NOPE");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void CheckLogInData(String id, String password, long id2)
    {
        ///FOR NOW
        String validUser = isUserValid(id, password);
        if (validUser == null) {
            tier2Connection.logInError("There was an error", id2);
            System.out.println("!!!!!!!!!!!!!!!!");
        } else if (validUser.equals("Student"))
            tier2Connection.openStudent(getStudentData(id), id2);
        else if (validUser.equals("Teacher"))
            tier2Connection.openTeacher(getTeacherData(id.substring(1)), id2);
        else if (validUser.equals("Secretary"))
            tier2Connection.openSecretary(getSecretaryData(id.substring(1)), id2);
    }

    @Override
    public void TeacherAssignGrade(String studentId, String course, String grade, String teacherID, Long id)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!ASSIGN GRADE");

        teacherID.substring(1);
        try {
            con.prepareStatement("INSERT INTO gradebook_dbs.grades VALUES(DEFAULT, '" + grade + "', '" + dateField +"', '" + course +"', '" + studentId +"')").executeUpdate();
            tier2Connection.openTeacher(getTeacherData(teacherID), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tier2Connection.teacherError("Something is wrong boyy", id);
    }


    public void TeacherAssignAbsence(String studentId, String course, String teacherID, long id)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!ASSIGN Absence");

        teacherID.substring(1);

        try {
            con.prepareStatement("INSERT INTO gradebook_dbs.absence VALUES(DEFAULT, '" + this.dateField +"', 'false', '" + course + "', '" + studentId + "')").executeUpdate();
            tier2Connection.openTeacher(getTeacherData(teacherID), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        tier2Connection.teacherError("Something is wrong boyy", id);
    }

    public void TeacherMotivateAbsence(String studentID, String course, String date, String teacherID, long id)
    {
        System.out.println("!!!!!!!!!!!!!!!!!!MOTIVATE ABSENCE");

        teacherID.substring(1);


        try {
            con.prepareStatement("UPDATE gradebook_dbs.absence SET motivated = 'true' WHERE student_id = '" + studentID +"' AND date = '" + date + "' AND course = '" + course + "'").executeUpdate();
            tier2Connection.openTeacher(getTeacherData(teacherID), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        tier2Connection.teacherError("Something is wrong boyy", id);
    }

    @Override
    public void SecretaryCreateTeacher(String firstName, String lastName, String password, long id)
    {
        try {
            con.prepareStatement("INSERT INTO gradebook_dbs.teacher VALUES(DEFAULT, '" + firstName +"', '" + lastName + "', '" + password + "')").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void SecretaryEditTeacher(String id, String password, long id2)
    {
        try {
            con.prepareStatement("UPDATE gradebook_dbs.teacher SET password = '" + password + "' WHERE id = '" + id + "';").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tier2Connection.secretaryError("Teacher not found", id2);
    }

    @Override
    public void SecretaryDeleteTeacher(String firstField, long id)
    {
        try {
            ResultSet rs2 = null;
            rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.teacher_class_link WHERE teacher_id ='" + firstField + "'").executeQuery();
            while (rs2.next())
            {
                tier2Connection.secretaryError("Teacher is still teaching a class", id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.prepareStatement("DELETE FROM gradebook_dbs.teacher WHERE id = '" + firstField + "'").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Teacher not found", id);
        }


    }

    @Override
    public void SecretaryCreateStudent(Student data, Long id)
    {
        try {
            con.prepareStatement("INSERT INTO gradebook_dbs.student VALUES(DEFAULT, '" + data.getFirstName() + "', '" + data.getLastName() + "', '" + data.getAddress() + "', '" + data.getViewGradePassword() + "', '" + data.getPhoneNumber() + "', '" + data.getBirthday() + "')").executeUpdate();
            ResultSet rs3 = con.prepareStatement("SELECT * FROM gradebook_dbs.student WHERE first_name = '" + data.getFirstName() + "' AND birthdate = '" + data.getBirthday() + "'").executeQuery();
            while (rs3.next())
            {
                con.prepareStatement("INSERT INTO gradebook_dbs.student_class_link VALUES(DEFAULT, '" + rs3.getString(1) + "', '3')").executeUpdate();
                tier2Connection.openSecretary(getSecretaryData("0"), id);
                return;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Something went wrong", id);
        }

    }

    @Override
    public void SecretaryDeleteStudent(String studentId, long id)
    {
        try {
            con.prepareStatement("DELETE FROM gradebook_dbs.student_class_link WHERE student_id = '" + studentId + "';").executeUpdate();
            con.prepareStatement("DELETE FROM gradebook_dbs.student WHERE id = '" + studentId + "';").executeUpdate();
            con.prepareStatement("DELETE FROM gradebook_dbs.absence WHERE student_id = '" + studentId + "';").executeUpdate();
            con.prepareStatement("DELETE FROM gradebook_dbs.grades WHERE student_id = '" + studentId + "';").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tier2Connection.secretaryError("Student not found", id);
    }

    @Override
    public void SecretaryEditStudent(String studentId, String address, String password, String phoneNr, Long id)
    {
        try {
        con.prepareStatement("UPDATE gradebook_dbs.student SET address = '" + address + "',  password = '" + password + "', phone_nr = '" + phoneNr + "' WHERE id = '" + studentId + "'").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
    } catch (SQLException e) {
            tier2Connection.secretaryError("Student not found", id);
        e.printStackTrace();
    }


    }

    @Override
    public void SecretaryDeleteClass(String classNr, String classLetter, Long id)
    {
        String auxID = null;
        try {
            ResultSet rs2 = null;
            rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.class WHERE year ='" + classNr + "' AND  letter ='" + classNr + "'").executeQuery();
            while (rs2.next())
            {
                auxID = rs2.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.prepareStatement("DELETE FROM gradebook_dbs.class WHERE id = '" + auxID + "'").executeUpdate();
            con.prepareStatement("DELETE FROM gradebook_dbs.student_class_link WHERE class_id = '" + auxID + "'").executeUpdate();
            con.prepareStatement("DELETE FROM gradebook_dbs.teacher_class_link WHERE class_id = '" + auxID + "'").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tier2Connection.secretaryError("Class not found", id);
    }



    @Override
    public void SecretaryCreateClass(String classNr, String classLetter, String teacherId, Long id)
    {

        try {
        con.prepareStatement("INSERT INTO gradebook_dbs.class VALUES(DEFAULT, '" + classNr + "', '" + classLetter + "')").executeUpdate();
        tier2Connection.openSecretary(getSecretaryData("0"), id);
        return;
    } catch (SQLException e) {
        e.printStackTrace();
        tier2Connection.secretaryError("SOMETHING WENT WRONG", id);
    }
    }


    @Override
    public void SecretaryCLassAddStudent(String classNr, String classLetter, String studentId, long id)
    {

        String auxID = null;
        try {
            ResultSet rs2 = null;
            rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.class WHERE year ='" + classNr + "' AND  letter ='" + classNr + "'").executeQuery();
            while (rs2.next())
            {
                auxID = rs2.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
                con.prepareStatement("INSERT INTO gradebook_dbs.student_class_link VALUES(DEFAULT, '" + studentId + "', '" + auxID + "')").executeUpdate();
                tier2Connection.openSecretary(getSecretaryData("0"), id);
                return;

        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Something went wrong", id);
        }


        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryClassRemoveStudent(String classNr, String classLetter, String studentId, long id)
    {

        try {
            con.prepareStatement("INSERT INTO gradebook_dbs.student_class_link VALUES(DEFAULT, '" + studentId + "', '3')").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Something went wrong", id);
        }

        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryClassAddCourse(String classNr, String classLetter, String courseName, long id)
    {
        String auxID = null;
        try {
            ResultSet rs2 = null;
            rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.class WHERE year ='" + classNr + "' AND  letter ='" + classNr + "'").executeQuery();
            while (rs2.next())
            {
                auxID = rs2.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            con.prepareStatement("INSERT INTO gradebook_dbs.course VALUES(DEFAULT, '" + courseName + "', '" + auxID + "')").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Something went wrong", id);
        }

        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryClassRemoveCourse(String classNr, String classLetter, String courseName, long id)
    {
        String auxID = null;
        try {
            ResultSet rs2 = null;
            rs2 = con.prepareStatement("SELECT * FROM gradebook_dbs.class WHERE year ='" + classNr + "' AND  letter ='" + classNr + "'").executeQuery();
            while (rs2.next())
            {
                auxID = rs2.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.prepareStatement("DELETE FROM gradebook_dbs.course WHERE name = '" + courseName + "' AND class_id = '" + auxID + "").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Something went wrong", id);
        }

        tier2Connection.secretaryError("Class not found", id);
    }

    @Override
    public void SecretaryChangeOwnUsername(String username, long id)
    {
        try {
            con.prepareStatement("UPDATE gradebook_dbs.secretary SET username = '" + username + "' WHERE id = '4'").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Something went wrong", id);
        }
    }

    @Override
    public void SecretaryChangeOwnPassword(String firstField, long id)
    {
        try {
            con.prepareStatement("UPDATE gradebook_dbs.secretary SET password = '" + firstField + "' WHERE id = '4'").executeUpdate();
            tier2Connection.openSecretary(getSecretaryData("0"), id);
            return;

        } catch (SQLException e) {
            e.printStackTrace();
            tier2Connection.secretaryError("Something went wrong", id);
        }
    }
}
