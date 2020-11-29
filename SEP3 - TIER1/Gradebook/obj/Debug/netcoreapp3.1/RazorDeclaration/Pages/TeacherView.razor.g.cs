#pragma checksum "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\TeacherView.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "69b1ab9a1f68752e70b70d91f39344b3cf133ff7"
// <auto-generated/>
#pragma warning disable 1591
#pragma warning disable 0414
#pragma warning disable 0649
#pragma warning disable 0169

namespace WebApplication.Pages
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Components;
#nullable restore
#line 1 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using WebApplication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using WebApplication.Shared;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\TeacherView.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\TeacherView.razor"
using WebApplication.Authentication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\TeacherView.razor"
using System.Text.Json;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\TeacherView.razor"
using WebApplication.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\TeacherView.razor"
using WebApplication.NetworkPackages;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/Teacher")]
    public partial class TeacherView : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
        }
        #pragma warning restore 1998
#nullable restore
#line 255 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\TeacherView.razor"
       
    Teacher teacher = CustomAuthenticationStateProvider.CachedTeacher;
    ITeacherService teacherService = new TeacherService();
    string ErrorLabel;
    
    //Regarding selected student
    string selectedClassAsString;
    string selectedStudentAsString;
    Class selectedClass = new Class();
    Student selectedStudent = new Student();
    bool studentSelected;
    List<string> selectedStudentCourses = new List<string>();
    //Regarding new grade
    string selectedCourseAsString;
    string selectedGradeAsString;
    //Regarding new absence
    string selectedNewAbsenceCourse;
    string selectedAbsenceCourse;
    string selectedAbsenceDate;

    void ClassSelected(ChangeEventArgs e)
    {
        selectedClassAsString = e.Value.ToString();
        selectedClass = JsonSerializer.Deserialize<Class>(selectedClassAsString);
    }

    bool NewGradeButtonDisabled()
    {
        return (selectedCourseAsString == null || selectedGradeAsString == null);
    }

    bool NewAbsenceButtonDisabled()
    {
        return (selectedNewAbsenceCourse == null);
    }
    
    bool MotivateAbsenceButtonDisabled()
    {
        return (selectedAbsenceCourse == null || selectedAbsenceDate == null);
    }

    async Task AssignGrade()
    {
        NetworkPackage package = await teacherService.AssignGrade(selectedStudent.id, selectedCourseAsString, Int32.Parse(selectedGradeAsString), teacher.id);
        Console.WriteLine(selectedStudent.id + " " + selectedCourseAsString + " " + Int32.Parse(selectedGradeAsString));
        if (package != null)
        {
            TeacherDataPackage teacherDataPackage = (TeacherDataPackage) package;
            CustomAuthenticationStateProvider.CachedTeacher = teacherDataPackage.data;
            teacher = teacherDataPackage.data;
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - GRADE ASSIGNMENT");
        }
    }

    async Task AssignAbsence()
    {
        NetworkPackage package = await teacherService.AssignAbsence(selectedStudent.id, selectedNewAbsenceCourse, teacher.id);
        Console.WriteLine(selectedStudent.id + " " + selectedNewAbsenceCourse);
        if (package != null)
        {
            TeacherDataPackage teacherDataPackage = (TeacherDataPackage) package;
            CustomAuthenticationStateProvider.CachedTeacher = teacherDataPackage.data;
            teacher = teacherDataPackage.data;
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - ABSENCE ASSIGNMENT");
        }
    }

    async Task MotivateAbsence()
    {
        Console.WriteLine(selectedStudent.id + " " + selectedAbsenceCourse + " " + selectedAbsenceDate + " " + teacher.id);
        NetworkPackage package = await teacherService.MotivateAbsence(selectedStudent.id, selectedAbsenceCourse, selectedAbsenceDate, teacher.id);
        if (package != null)
        {
            TeacherDataPackage teacherDataPackage = (TeacherDataPackage) package;
            CustomAuthenticationStateProvider.CachedTeacher = teacherDataPackage.data;
            teacher = teacherDataPackage.data;
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - ABSENCE MOTIVATION");
        }
    }

    private void ExtractCourses(ChangeEventArgs e)
    {
        studentSelected = true;
        selectedStudentAsString = e.Value.ToString();
        selectedStudent = JsonSerializer.Deserialize<Student>(selectedStudentAsString);
    //Console.WriteLine(selectedStudent.firstName);

        for (int i = 0; i < selectedClass.courses.Count; i++)
        {
            if (i == 0 && selectedStudentCourses != null)
                selectedStudentCourses = new List<string>();
            selectedStudentCourses.Add(selectedClass.courses[i].name);
        }
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJSRuntime JSRuntime { get; set; }
    }
}
#pragma warning restore 1591
