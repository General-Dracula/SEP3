#pragma checksum "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "b6620b22eee954115bd636bc83ff660d15d9a3ae"
// <auto-generated/>
#pragma warning disable 1591
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
#line 2 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
using BlazorDateRangePicker;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
using WebApplication.Authentication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
using WebApplication.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
using WebApplication.NetworkPackages;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
using System.Text.Json;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/SecretaryStudent")]
    public partial class SecretaryStudent : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.AddMarkupContent(0, "<head><link rel=\"stylesheet\" href=\"css/overallTheme.css\"></head>\r\n\r\n");
            __builder.OpenElement(1, "div");
            __builder.AddAttribute(2, "class", "blue-border container");
            __builder.AddMarkupContent(3, "<br>\r\n    ");
            __builder.AddMarkupContent(4, "<div class=\"row\"><div class=\"col\"><h3 class=\"center-horiz\">Create Student</h3></div></div>\r\n    <br>\r\n    ");
            __builder.OpenElement(5, "div");
            __builder.AddAttribute(6, "class", "row");
            __builder.OpenElement(7, "div");
            __builder.AddAttribute(8, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(9, "<label for=\"fname\">First name:</label>\r\n            ");
            __builder.OpenElement(10, "input");
            __builder.AddAttribute(11, "type", "text");
            __builder.AddAttribute(12, "class", "form-control");
            __builder.AddAttribute(13, "id", "fname");
            __builder.AddAttribute(14, "placeholder", "Adam");
            __builder.AddAttribute(15, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 25 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                          createStudentFirstName

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(16, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => createStudentFirstName = __value, createStudentFirstName));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(17, "\r\n        ");
            __builder.OpenElement(18, "div");
            __builder.AddAttribute(19, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(20, "<label for=\"lname\">Last name:</label>\r\n            ");
            __builder.OpenElement(21, "input");
            __builder.AddAttribute(22, "type", "text");
            __builder.AddAttribute(23, "class", "form-control");
            __builder.AddAttribute(24, "id", "lname");
            __builder.AddAttribute(25, "placeholder", "Adam");
            __builder.AddAttribute(26, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 29 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                          createStudentLastName

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(27, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => createStudentLastName = __value, createStudentLastName));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(28, "\r\n        ");
            __builder.OpenElement(29, "div");
            __builder.AddAttribute(30, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(31, "<label for=\"Address\">Address:</label>\r\n            ");
            __builder.OpenElement(32, "input");
            __builder.AddAttribute(33, "type", "text");
            __builder.AddAttribute(34, "class", "form-control");
            __builder.AddAttribute(35, "id", "Address");
            __builder.AddAttribute(36, "placeholder", "Raedersgade 8, 1tv, Horsens 8700");
            __builder.AddAttribute(37, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 33 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                                        createStudentAddress

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(38, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => createStudentAddress = __value, createStudentAddress));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(39, "\r\n    <br>\r\n    ");
            __builder.OpenElement(40, "div");
            __builder.AddAttribute(41, "class", "row");
            __builder.OpenElement(42, "div");
            __builder.AddAttribute(43, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(44, "<label for=\"password\">Password:</label>\r\n            ");
            __builder.OpenElement(45, "input");
            __builder.AddAttribute(46, "type", "password");
            __builder.AddAttribute(47, "class", "form-control");
            __builder.AddAttribute(48, "id", "password");
            __builder.AddAttribute(49, "placeholder", "********");
            __builder.AddAttribute(50, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 40 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                     createStudentPassword

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(51, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => createStudentPassword = __value, createStudentPassword));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(52, "\r\n        ");
            __builder.OpenElement(53, "div");
            __builder.AddAttribute(54, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(55, "<label for=\"phoneno\">Phone no.:</label>\r\n            ");
            __builder.OpenElement(56, "input");
            __builder.AddAttribute(57, "type", "text");
            __builder.AddAttribute(58, "class", "form-control");
            __builder.AddAttribute(59, "id", "phoneno");
            __builder.AddAttribute(60, "placeholder", "12 34 56 78");
            __builder.AddAttribute(61, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 44 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                   createStudentPhoneNr

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(62, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => createStudentPhoneNr = __value, createStudentPhoneNr));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(63, "\r\n        ");
            __builder.OpenElement(64, "div");
            __builder.AddAttribute(65, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(66, "<label>Birthday:</label>\r\n            ");
            __builder.OpenComponent<BlazorDateRangePicker.DateRangePicker>(67);
            __builder.AddAttribute(68, "SingleDatePicker", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.Boolean?>(
#nullable restore
#line 48 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                               true

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(69, "MinDate", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.DateTimeOffset?>(
#nullable restore
#line 48 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                              DateTime.Now.AddYears(-50)

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(70, "MaxDate", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.DateTimeOffset?>(
#nullable restore
#line 48 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                   DateTime.Now.AddYears(-5)

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(71, "Format", "dd-MM-yyyy");
            __builder.AddAttribute(72, "StartDate", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<System.DateTimeOffset?>(
#nullable restore
#line 48 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                                                                                    createStudentBirthdayAsDate

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(73, "StartDateChanged", Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.TypeCheck<Microsoft.AspNetCore.Components.EventCallback<System.DateTimeOffset?>>(Microsoft.AspNetCore.Components.EventCallback.Factory.Create<System.DateTimeOffset?>(this, Microsoft.AspNetCore.Components.CompilerServices.RuntimeHelpers.CreateInferredEventCallback(this, __value => createStudentBirthdayAsDate = __value, createStudentBirthdayAsDate))));
            __builder.CloseComponent();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(74, "\r\n    <br>\r\n    ");
            __builder.OpenElement(75, "div");
            __builder.AddAttribute(76, "class", "row");
            __builder.OpenElement(77, "div");
            __builder.AddAttribute(78, "class", "col center-horiz");
            __builder.OpenElement(79, "button");
            __builder.AddAttribute(80, "class", "btn btn-default btn-success");
            __builder.AddAttribute(81, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 54 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                  CreateStudent

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(82, "disabled", 
#nullable restore
#line 54 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                            StudentCreateBool()

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(83, "Create Student");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(84, "\r\n    <br>");
            __builder.CloseElement();
            __builder.AddMarkupContent(85, "\r\n\r\n");
            __builder.OpenElement(86, "div");
            __builder.AddAttribute(87, "class", "container blue-border");
            __builder.AddAttribute(88, "style", "margin-top: 3em");
            __builder.AddMarkupContent(89, "<br>\r\n    ");
            __builder.AddMarkupContent(90, "<div class=\"row\"><div class=\"col\"><h3 class=\"center-horiz\">Edit Student</h3></div></div>\r\n    <br>\r\n    ");
            __builder.OpenElement(91, "div");
            __builder.AddAttribute(92, "class", "row");
            __builder.OpenElement(93, "div");
            __builder.AddAttribute(94, "class", "col center-horiz");
            __builder.AddMarkupContent(95, "<label for=\"selectStudent\">Select Student:</label>\r\n            ");
            __builder.OpenElement(96, "select");
            __builder.AddAttribute(97, "class", "form-control");
            __builder.AddAttribute(98, "id", "selectStudent");
            __builder.AddAttribute(99, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 71 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                    selectedStudentAsString

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(100, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => selectedStudentAsString = __value, selectedStudentAsString));
            __builder.SetUpdatesAttributeName("value");
            __builder.OpenElement(101, "option");
            __builder.AddAttribute(102, "value", true);
            __builder.AddAttribute(103, "selected", true);
            __builder.AddAttribute(104, "disabled", true);
            __builder.AddAttribute(105, "hidden", true);
            __builder.AddContent(106, "Choose student...");
            __builder.CloseElement();
#nullable restore
#line 73 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                 foreach (Student student in students)
                {
                    string studentAsString = JsonSerializer.Serialize(student);

#line default
#line hidden
#nullable disable
            __builder.OpenElement(107, "option");
            __builder.AddAttribute(108, "value", 
#nullable restore
#line 76 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                    studentAsString

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(109, 
#nullable restore
#line 76 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                      student.Id

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(110, " - ");
            __builder.AddContent(111, 
#nullable restore
#line 76 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                    student.FirstName

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(112, " ");
            __builder.AddContent(113, 
#nullable restore
#line 76 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                       student.LastName

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
#nullable restore
#line 77 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                }

#line default
#line hidden
#nullable disable
            __builder.CloseElement();
            __builder.AddMarkupContent(114, "\r\n            ");
            __builder.OpenElement(115, "button");
            __builder.AddAttribute(116, "class", "btn btn-default btn-danger");
            __builder.AddAttribute(117, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 79 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                 DeleteStudent

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(118, "style", "margin-left: 1em");
            __builder.AddAttribute(119, "disabled", 
#nullable restore
#line 79 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                                   StudentIsSelected()

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(120, "Delete Student");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(121, "\r\n    <br>\r\n\r\n    ");
            __builder.OpenElement(122, "div");
            __builder.AddAttribute(123, "class", "row");
            __builder.OpenElement(124, "div");
            __builder.AddAttribute(125, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(126, "<label for=\"Address2\">Address:</label>\r\n            ");
            __builder.OpenElement(127, "input");
            __builder.AddAttribute(128, "type", "text");
            __builder.AddAttribute(129, "class", "form-control");
            __builder.AddAttribute(130, "id", "Address2");
            __builder.AddAttribute(131, "placeholder", "Raedersgade 8, 1tv, Horsens 8700");
            __builder.AddAttribute(132, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 87 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                                          editedStudentAddress

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(133, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => editedStudentAddress = __value, editedStudentAddress));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(134, "\r\n        ");
            __builder.OpenElement(135, "div");
            __builder.AddAttribute(136, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(137, "<label for=\"password2\">Password:</label>\r\n            ");
            __builder.OpenElement(138, "input");
            __builder.AddAttribute(139, "type", "password");
            __builder.AddAttribute(140, "class", "form-control");
            __builder.AddAttribute(141, "id", "password2");
            __builder.AddAttribute(142, "placeholder", "********");
            __builder.AddAttribute(143, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 91 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                       editedStudentPassword

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(144, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => editedStudentPassword = __value, editedStudentPassword));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(145, "\r\n        ");
            __builder.OpenElement(146, "div");
            __builder.AddAttribute(147, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(148, "<label for=\"phoneno2\">Phone no.:</label>\r\n            ");
            __builder.OpenElement(149, "input");
            __builder.AddAttribute(150, "type", "text");
            __builder.AddAttribute(151, "class", "form-control");
            __builder.AddAttribute(152, "id", "phoneno2");
            __builder.AddAttribute(153, "placeholder", "12 34 56 78");
            __builder.AddAttribute(154, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 95 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                                     editedStudentPhoneNr

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(155, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => editedStudentPhoneNr = __value, editedStudentPhoneNr));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(156, "\r\n    <br>\r\n    ");
            __builder.OpenElement(157, "div");
            __builder.AddAttribute(158, "class", "row");
            __builder.OpenElement(159, "div");
            __builder.AddAttribute(160, "class", "col center-horiz");
            __builder.OpenElement(161, "button");
            __builder.AddAttribute(162, "class", "btn btn-default btn-primary");
            __builder.AddAttribute(163, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 101 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                  EditStudent

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(164, "disabled", 
#nullable restore
#line 101 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                                                                          StudentEditBool()

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(165, "Edit Student");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(166, "\r\n    <br>");
            __builder.CloseElement();
            __builder.AddMarkupContent(167, "\r\n\r\n<br>\r\n");
            __builder.OpenElement(168, "p");
            __builder.AddAttribute(169, "class", "center-horiz");
            __builder.AddAttribute(170, "style", "color: red");
            __builder.AddContent(171, 
#nullable restore
#line 108 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
                                            ErrorLabel

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 110 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryStudent.razor"
       
    Secretary secretary = CustomAuthenticationStateProvider.CachedSecretary;
    ISecretaryService SecretaryService = new SecretaryService();
    List<Student> students = new List<Student>();
    string ErrorLabel;

    //Regarding creating a student
    string createStudentFirstName;
    string createStudentLastName;
    string createStudentAddress;
    string createStudentPassword;
    string createStudentPhoneNr;
    string createStudentBirthday;
    DateTimeOffset? createStudentBirthdayAsDate = new DateTimeOffset?();

    //Regarding editing a student
    Student selectedStudent;
    string selectedStudentAsString;
    string editedStudentAddress;
    string editedStudentPassword;
    string editedStudentPhoneNr;

    void ExtractStudents()
    {
        students = new List<Student>();
        foreach (Class _class in secretary.Classes)
        {
            if(_class.Students!=null)
                students.AddRange(_class.Students);
        }
    }

    bool StudentIsSelected()
    {
        Console.WriteLine(selectedStudentAsString);
        return (selectedStudentAsString == null);
    }
    
    bool StudentCreateBool()
    {
        return !(createStudentFirstName != null && createStudentLastName != null && createStudentAddress != null && createStudentPassword != null && createStudentPhoneNr != null && createStudentBirthdayAsDate != null);
    }
    
    bool StudentEditBool()
    {
        return !(editedStudentAddress != null && editedStudentPassword != null && editedStudentPhoneNr != null);
    }

    async Task CreateStudent()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to create this student?")) return;
        createStudentBirthday = createStudentBirthdayAsDate.ToString().Substring(0,10);
        NetworkPackage package = await SecretaryService.CreateStudent(createStudentFirstName, createStudentLastName, createStudentAddress, createStudentPassword, createStudentPhoneNr, createStudentBirthday);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ResetCreateFields();
            ExtractStudents();
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - CREATE STUDENT");
            ErrorLabel = "There was an error";
        }
    }

    async Task EditStudent()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to modify this student?")) return;
        selectedStudent = JsonSerializer.Deserialize<Student>(selectedStudentAsString);
        NetworkPackage package = await SecretaryService.EditStudent(selectedStudent.Id, editedStudentAddress, editedStudentPassword, editedStudentPhoneNr);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ResetEditFields();
            ExtractStudents();
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - EDIT STUDENT");
            ErrorLabel = "There was an error";
        }
    }

    async Task DeleteStudent()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to delete this student?")) return;
        selectedStudent = JsonSerializer.Deserialize<Student>(selectedStudentAsString);
        NetworkPackage package = await SecretaryService.DeleteStudent(selectedStudent.Id);
        Console.WriteLine(selectedStudent.Id);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ExtractStudents();
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - DELETE STUDENT");
            ErrorLabel = "There was an error";
        }
    }
    
    void ResetCreateFields()
    {
        createStudentFirstName = "";
        createStudentLastName = "";
        createStudentAddress = "";
        createStudentPassword = "";
        createStudentPhoneNr = "";
        createStudentBirthdayAsDate = null;
    }
    
    void ResetEditFields()
    {
        editedStudentAddress = "";
        editedStudentPassword = "";
        editedStudentPhoneNr = "";
    }

    protected override void OnInitialized()
    {
        base.OnInitialized();
        secretary = CustomAuthenticationStateProvider.CachedSecretary;
        ExtractStudents();
    }


#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJSRuntime JSRuntime { get; set; }
    }
}
#pragma warning restore 1591
