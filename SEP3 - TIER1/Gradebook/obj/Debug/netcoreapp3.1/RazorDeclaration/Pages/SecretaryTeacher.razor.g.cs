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
#line 2 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryTeacher.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryTeacher.razor"
using WebApplication.Authentication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryTeacher.razor"
using WebApplication.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryTeacher.razor"
using WebApplication.NetworkPackages;

#line default
#line hidden
#nullable disable
#nullable restore
#line 6 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryTeacher.razor"
using System.Text.Json;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/SecretaryTeacher")]
    public partial class SecretaryTeacher : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
        }
        #pragma warning restore 1998
#nullable restore
#line 85 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryTeacher.razor"
       
    Secretary secretary = CustomAuthenticationStateProvider.CachedSecretary;
    ISecretaryService SecretaryService = new SecretaryService();
    string ErrorLabel;

    //Regarding creating a teacher
    string createTeacherFirstName;
    string createTeacherLastName;
    string createTeacherPassword;

    //Regarding editing a teacher
    Teacher selectedTeacher;
    string selectedTeacherAsString;
    string editedTeacherPassword;

    void ResetCreateFields()
    {
        createTeacherFirstName = "";
        createTeacherLastName = "";
        createTeacherPassword = "";
    }
    
    void ResetEditFields()
    {
        editedTeacherPassword = "";
    }

    bool TeacherCreationBool()
    {
        return !(createTeacherFirstName != null && createTeacherLastName != null && createTeacherPassword != null);
    }

    bool TeacherEditBool()
    {
        return (editedTeacherPassword == null);
    }

    bool teacherIsSelected()
    {
        return (selectedTeacherAsString == null);
    }

    async Task CreateTeacher()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to create this teacher?")) return;
        NetworkPackage package = await SecretaryService.CreateTeacher(createTeacherFirstName, createTeacherLastName, createTeacherPassword);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ResetCreateFields();
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - CREATE TEACHER");
            ErrorLabel = "There was an error";
        }
    }

    async Task EditTeacher()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to edit this teacher?")) return;
        selectedTeacher = JsonSerializer.Deserialize<Teacher>(selectedTeacherAsString);
        NetworkPackage package = await SecretaryService.EditTeacher(selectedTeacher.Id, editedTeacherPassword);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ResetEditFields();
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - EDIT TEACHER");
            ErrorLabel = "There was an error";
        }
    }

    async Task DeleteTeacher()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to delete this teacher?")) return;
        selectedTeacher = JsonSerializer.Deserialize<Teacher>(selectedTeacherAsString);
        NetworkPackage package = await SecretaryService.DeleteTeacher(selectedTeacher.Id);
        Console.WriteLine(selectedTeacher.Id);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - DELETE TEACHER");
            ErrorLabel = "There was an error";
        }
    }

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJSRuntime JSRuntime { get; set; }
    }
}
#pragma warning restore 1591
