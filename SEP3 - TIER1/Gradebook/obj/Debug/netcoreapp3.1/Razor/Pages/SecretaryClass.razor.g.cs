#pragma checksum "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryClass.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "c0277580cea156feefad8b1ced3705d36a582ebd"
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
#line 1 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using System.Net.Http;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Authorization;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Forms;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Routing;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.AspNetCore.Components.Web;

#line default
#line hidden
#nullable disable
#nullable restore
#line 7 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using Microsoft.JSInterop;

#line default
#line hidden
#nullable disable
#nullable restore
#line 8 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using WebApplication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 9 "C:\Users\dobre\OneDrive\Desktop\SEP3\SEP3 - TIER1\Gradebook\_Imports.razor"
using WebApplication.Shared;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/SecretaryClass")]
    public partial class SecretaryClass : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.AddMarkupContent(0, "<head>\r\n    <link rel=\"stylesheet\" href=\"css/overallTheme.css\">\r\n</head>\r\n\r\n");
            __builder.OpenElement(1, "div");
            __builder.AddAttribute(2, "class", "blue-border container");
            __builder.AddMarkupContent(3, "\r\n    <br>\r\n    ");
            __builder.AddMarkupContent(4, "<div class=\"row\">\r\n        <div class=\"col\">\r\n            <h3 class=\"center-horiz\">Create Class</h3>\r\n        </div>\r\n    </div>\r\n    <br>\r\n    ");
            __builder.OpenElement(5, "div");
            __builder.AddAttribute(6, "class", "row");
            __builder.AddMarkupContent(7, "\r\n        ");
            __builder.OpenElement(8, "div");
            __builder.AddAttribute(9, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(10, "\r\n            ");
            __builder.AddMarkupContent(11, "<label for=\"classNumber\">Class number:</label>\r\n            ");
            __builder.OpenElement(12, "select");
            __builder.AddAttribute(13, "class", "form-control");
            __builder.AddAttribute(14, "id", "classNumber");
            __builder.AddMarkupContent(15, "\r\n                ");
            __builder.OpenElement(16, "option");
            __builder.AddAttribute(17, "value", true);
            __builder.AddAttribute(18, "selected", true);
            __builder.AddAttribute(19, "disabled", true);
            __builder.AddAttribute(20, "hidden", true);
            __builder.AddContent(21, "Choose number...");
            __builder.CloseElement();
            __builder.AddMarkupContent(22, "\r\n                ");
            __builder.OpenElement(23, "option");
            __builder.AddAttribute(24, "value", "12");
            __builder.AddContent(25, "12");
            __builder.CloseElement();
            __builder.AddMarkupContent(26, "\r\n                ");
            __builder.OpenElement(27, "option");
            __builder.AddAttribute(28, "value", "11");
            __builder.AddContent(29, "11");
            __builder.CloseElement();
            __builder.AddMarkupContent(30, "\r\n                ");
            __builder.OpenElement(31, "option");
            __builder.AddAttribute(32, "value", "10");
            __builder.AddContent(33, "10");
            __builder.CloseElement();
            __builder.AddMarkupContent(34, "\r\n                ");
            __builder.OpenElement(35, "option");
            __builder.AddAttribute(36, "value", "9");
            __builder.AddContent(37, "9");
            __builder.CloseElement();
            __builder.AddMarkupContent(38, "\r\n                ");
            __builder.OpenElement(39, "option");
            __builder.AddAttribute(40, "value", "8");
            __builder.AddContent(41, "8");
            __builder.CloseElement();
            __builder.AddMarkupContent(42, "\r\n                ");
            __builder.OpenElement(43, "option");
            __builder.AddAttribute(44, "value", "7");
            __builder.AddContent(45, "7");
            __builder.CloseElement();
            __builder.AddMarkupContent(46, "\r\n                ");
            __builder.OpenElement(47, "option");
            __builder.AddAttribute(48, "value", "6");
            __builder.AddContent(49, "6");
            __builder.CloseElement();
            __builder.AddMarkupContent(50, "\r\n                ");
            __builder.OpenElement(51, "option");
            __builder.AddAttribute(52, "value", "5");
            __builder.AddContent(53, "5");
            __builder.CloseElement();
            __builder.AddMarkupContent(54, "\r\n                ");
            __builder.OpenElement(55, "option");
            __builder.AddAttribute(56, "value", "4");
            __builder.AddContent(57, "4");
            __builder.CloseElement();
            __builder.AddMarkupContent(58, "\r\n                ");
            __builder.OpenElement(59, "option");
            __builder.AddAttribute(60, "value", "3");
            __builder.AddContent(61, "3");
            __builder.CloseElement();
            __builder.AddMarkupContent(62, "\r\n                ");
            __builder.OpenElement(63, "option");
            __builder.AddAttribute(64, "value", "2");
            __builder.AddContent(65, "2");
            __builder.CloseElement();
            __builder.AddMarkupContent(66, "\r\n                ");
            __builder.OpenElement(67, "option");
            __builder.AddAttribute(68, "value", "1");
            __builder.AddContent(69, "1");
            __builder.CloseElement();
            __builder.AddMarkupContent(70, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(71, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(72, "\r\n        ");
            __builder.OpenElement(73, "div");
            __builder.AddAttribute(74, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(75, "\r\n            ");
            __builder.AddMarkupContent(76, "<label for=\"classLetter\">Class letter:</label>\r\n            ");
            __builder.OpenElement(77, "select");
            __builder.AddAttribute(78, "class", "form-control");
            __builder.AddAttribute(79, "id", "classLetter");
            __builder.AddMarkupContent(80, "\r\n                ");
            __builder.OpenElement(81, "option");
            __builder.AddAttribute(82, "value", true);
            __builder.AddAttribute(83, "selected", true);
            __builder.AddAttribute(84, "disabled", true);
            __builder.AddAttribute(85, "hidden", true);
            __builder.AddContent(86, "Choose letter...");
            __builder.CloseElement();
            __builder.AddMarkupContent(87, "\r\n                ");
            __builder.OpenElement(88, "option");
            __builder.AddAttribute(89, "value", "A");
            __builder.AddContent(90, "A");
            __builder.CloseElement();
            __builder.AddMarkupContent(91, "\r\n                ");
            __builder.OpenElement(92, "option");
            __builder.AddAttribute(93, "value", "B");
            __builder.AddContent(94, "B");
            __builder.CloseElement();
            __builder.AddMarkupContent(95, "\r\n                ");
            __builder.OpenElement(96, "option");
            __builder.AddAttribute(97, "value", "C");
            __builder.AddContent(98, "C");
            __builder.CloseElement();
            __builder.AddMarkupContent(99, "\r\n                ");
            __builder.OpenElement(100, "option");
            __builder.AddAttribute(101, "value", "D");
            __builder.AddContent(102, "D");
            __builder.CloseElement();
            __builder.AddMarkupContent(103, "\r\n                ");
            __builder.OpenElement(104, "option");
            __builder.AddAttribute(105, "value", "E");
            __builder.AddContent(106, "E");
            __builder.CloseElement();
            __builder.AddMarkupContent(107, "\r\n                ");
            __builder.OpenElement(108, "option");
            __builder.AddAttribute(109, "value", "F");
            __builder.AddContent(110, "F");
            __builder.CloseElement();
            __builder.AddMarkupContent(111, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(112, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(113, "\r\n        ");
            __builder.OpenElement(114, "div");
            __builder.AddAttribute(115, "class", "col-4 center-horiz form-group");
            __builder.AddMarkupContent(116, "\r\n            ");
            __builder.AddMarkupContent(117, "<label for=\"classTeacher\">Class teacher:</label>\r\n            ");
            __builder.OpenElement(118, "select");
            __builder.AddAttribute(119, "class", "form-control");
            __builder.AddAttribute(120, "id", "classTeacher");
            __builder.AddMarkupContent(121, "\r\n                ");
            __builder.OpenElement(122, "option");
            __builder.AddAttribute(123, "value", true);
            __builder.AddAttribute(124, "selected", true);
            __builder.AddAttribute(125, "disabled", true);
            __builder.AddAttribute(126, "hidden", true);
            __builder.AddContent(127, "Choose teacher...");
            __builder.CloseElement();
            __builder.AddMarkupContent(128, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(129, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(130, "\r\n    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(131, "\r\n    <br>\r\n    ");
            __builder.AddMarkupContent(132, "<div class=\"row\">\r\n        <div class=\"col center-horiz\">\r\n            <button class=\"btn btn-default btn-success\">Create Class</button>\r\n        </div>\r\n    </div>\r\n    <br>\r\n");
            __builder.CloseElement();
            __builder.AddMarkupContent(133, "\r\n\r\n");
            __builder.OpenElement(134, "div");
            __builder.AddAttribute(135, "class", "container blue-border");
            __builder.AddAttribute(136, "style", "margin-top: 3em");
            __builder.AddMarkupContent(137, "\r\n    <br>\r\n    ");
            __builder.AddMarkupContent(138, "<div class=\"row\">\r\n        <div class=\"col\">\r\n            <h3 class=\"center-horiz\">Edit Class</h3>\r\n        </div>\r\n    </div>\r\n    <br>\r\n    ");
            __builder.AddMarkupContent(139, @"<div class=""row"">
        <div class=""col center-horiz"">
            <label for=""selectClass"">Select Class:</label>
            <select class=""form-control"" id=""selectClass""></select>
            <option value selected disabled hidden>Choose class...</option>
            <button class=""btn btn-default btn-danger"" style=""margin-left: 1em"">Delete Class</button>
            <p style=""margin-top: 1em"">Class average: ?</p>
        </div>
    </div>
    <br>
    ");
            __builder.OpenElement(140, "div");
            __builder.AddAttribute(141, "class", "row");
            __builder.AddMarkupContent(142, "\r\n        ");
            __builder.OpenElement(143, "div");
            __builder.AddAttribute(144, "class", "col-6 center-horiz");
            __builder.AddMarkupContent(145, "\r\n            ");
            __builder.OpenElement(146, "div");
            __builder.AddAttribute(147, "class", "row");
            __builder.AddMarkupContent(148, "\r\n                ");
            __builder.OpenElement(149, "div");
            __builder.AddAttribute(150, "class", "col form-group");
            __builder.AddMarkupContent(151, "\r\n                    ");
            __builder.AddMarkupContent(152, "<label for=\"addStudent\">Student:</label>\r\n                    ");
            __builder.OpenElement(153, "select");
            __builder.AddAttribute(154, "class", "form-control");
            __builder.AddAttribute(155, "id", "addStudent");
            __builder.AddMarkupContent(156, "\r\n                        ");
            __builder.OpenElement(157, "option");
            __builder.AddAttribute(158, "value", true);
            __builder.AddAttribute(159, "selected", true);
            __builder.AddAttribute(160, "disabled", true);
            __builder.AddAttribute(161, "hidden", true);
            __builder.AddContent(162, "Choose student...");
            __builder.CloseElement();
            __builder.AddMarkupContent(163, "\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(164, "\r\n                    ");
            __builder.AddMarkupContent(165, "<button class=\"btn btn-default btn-success\" style=\"margin-left: 1em\">Add Student</button>\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(166, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(167, "\r\n            <br>\r\n            ");
            __builder.OpenElement(168, "div");
            __builder.AddAttribute(169, "class", "row form-group");
            __builder.AddMarkupContent(170, "\r\n                ");
            __builder.OpenElement(171, "div");
            __builder.AddAttribute(172, "class", "col form-group");
            __builder.AddMarkupContent(173, "\r\n                    ");
            __builder.AddMarkupContent(174, "<label for=\"removeStudent\">Student:</label>\r\n                    ");
            __builder.OpenElement(175, "select");
            __builder.AddAttribute(176, "class", "form-control");
            __builder.AddAttribute(177, "id", "removeStudent");
            __builder.AddMarkupContent(178, "\r\n                        ");
            __builder.OpenElement(179, "option");
            __builder.AddAttribute(180, "value", true);
            __builder.AddAttribute(181, "selected", true);
            __builder.AddAttribute(182, "disabled", true);
            __builder.AddAttribute(183, "hidden", true);
            __builder.AddContent(184, "Choose student...");
            __builder.CloseElement();
            __builder.AddMarkupContent(185, "\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(186, "\r\n                    ");
            __builder.AddMarkupContent(187, "<button class=\"btn btn-default btn-danger\" style=\"margin-left: 1em\">Remove Student</button>\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(188, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(189, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(190, "\r\n        ");
            __builder.OpenElement(191, "div");
            __builder.AddAttribute(192, "class", "col-6 center-horiz form-group");
            __builder.AddMarkupContent(193, "\r\n            ");
            __builder.OpenElement(194, "div");
            __builder.AddAttribute(195, "class", "row");
            __builder.AddMarkupContent(196, "\r\n                ");
            __builder.OpenElement(197, "div");
            __builder.AddAttribute(198, "class", "col form-group");
            __builder.AddMarkupContent(199, "\r\n                    ");
            __builder.AddMarkupContent(200, "<label for=\"addCourse\">Course:</label>\r\n                    ");
            __builder.OpenElement(201, "select");
            __builder.AddAttribute(202, "class", "form-control");
            __builder.AddAttribute(203, "id", "addCourse");
            __builder.AddMarkupContent(204, "\r\n                        ");
            __builder.OpenElement(205, "option");
            __builder.AddAttribute(206, "value", true);
            __builder.AddAttribute(207, "selected", true);
            __builder.AddAttribute(208, "disabled", true);
            __builder.AddAttribute(209, "hidden", true);
            __builder.AddContent(210, "Choose course...");
            __builder.CloseElement();
            __builder.AddMarkupContent(211, "\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(212, "\r\n                    ");
            __builder.AddMarkupContent(213, "<button class=\"btn btn-default btn-success\" style=\"margin-left: 1em\">Add Course</button>\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(214, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(215, "\r\n            <br>\r\n            ");
            __builder.OpenElement(216, "div");
            __builder.AddAttribute(217, "class", "row form-group");
            __builder.AddMarkupContent(218, "\r\n                ");
            __builder.OpenElement(219, "div");
            __builder.AddAttribute(220, "class", "col form-group");
            __builder.AddMarkupContent(221, "\r\n                    ");
            __builder.AddMarkupContent(222, "<label for=\"removeCourse\">Course:</label>\r\n                    ");
            __builder.OpenElement(223, "select");
            __builder.AddAttribute(224, "class", "form-control");
            __builder.AddAttribute(225, "id", "removeCourse");
            __builder.AddMarkupContent(226, "\r\n                        ");
            __builder.OpenElement(227, "option");
            __builder.AddAttribute(228, "value", true);
            __builder.AddAttribute(229, "selected", true);
            __builder.AddAttribute(230, "disabled", true);
            __builder.AddAttribute(231, "hidden", true);
            __builder.AddContent(232, "Choose course...");
            __builder.CloseElement();
            __builder.AddMarkupContent(233, "\r\n                    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(234, "\r\n                    ");
            __builder.AddMarkupContent(235, "<button class=\"btn btn-default btn-danger\" style=\"margin-left: 1em\">Remove Course</button>\r\n                ");
            __builder.CloseElement();
            __builder.AddMarkupContent(236, "\r\n            ");
            __builder.CloseElement();
            __builder.AddMarkupContent(237, "\r\n        ");
            __builder.CloseElement();
            __builder.AddMarkupContent(238, "\r\n    ");
            __builder.CloseElement();
            __builder.AddMarkupContent(239, "\r\n    <br>\r\n");
            __builder.CloseElement();
        }
        #pragma warning restore 1998
    }
}
#pragma warning restore 1591