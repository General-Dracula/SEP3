#pragma checksum "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "3333d91dcd89d3a4e6f4e819ef627bdd673e5843"
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
#line 2 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
using WebApplication.Models;

#line default
#line hidden
#nullable disable
#nullable restore
#line 3 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
using WebApplication.Authentication;

#line default
#line hidden
#nullable disable
#nullable restore
#line 4 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
using WebApplication.Data;

#line default
#line hidden
#nullable disable
#nullable restore
#line 5 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
using WebApplication.NetworkPackages;

#line default
#line hidden
#nullable disable
    [Microsoft.AspNetCore.Components.RouteAttribute("/SecretaryLogin")]
    public partial class SecretaryLogin : Microsoft.AspNetCore.Components.ComponentBase
    {
        #pragma warning disable 1998
        protected override void BuildRenderTree(Microsoft.AspNetCore.Components.Rendering.RenderTreeBuilder __builder)
        {
            __builder.AddMarkupContent(0, "<head><link rel=\"stylesheet\" href=\"css/overallTheme.css\"></head>\r\n\r\n\r\n");
            __builder.OpenElement(1, "div");
            __builder.AddAttribute(2, "class", "blue-border container");
            __builder.AddMarkupContent(3, "<br>\r\n        ");
            __builder.AddMarkupContent(4, "<div class=\"row\"><div class=\"col\"><h3 class=\"center-horiz\">Change log-in</h3></div></div>\r\n    <br>\r\n    ");
            __builder.OpenElement(5, "div");
            __builder.AddAttribute(6, "class", "row");
            __builder.OpenElement(7, "div");
            __builder.AddAttribute(8, "class", "col-3 center-horiz");
            __builder.AddMarkupContent(9, "<label for=\"user\">Username:</label>\r\n            ");
            __builder.OpenElement(10, "input");
            __builder.AddAttribute(11, "type", "text");
            __builder.AddAttribute(12, "class", "form-control");
            __builder.AddAttribute(13, "id", "user");
            __builder.AddAttribute(14, "placeholder", "1234");
            __builder.AddAttribute(15, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 24 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
                                                                                         changedUsername

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(16, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => changedUsername = __value, changedUsername));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.AddMarkupContent(17, "\r\n            ");
            __builder.OpenElement(18, "button");
            __builder.AddAttribute(19, "class", "btn btn-default btn-success");
            __builder.AddAttribute(20, "style", "margin: 1em");
            __builder.AddAttribute(21, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 25 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
                                                                                      ChangeUsername

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(22, "disabled", 
#nullable restore
#line 25 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
                                                                                                                 ChangeUsernameButtonDisabled()

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(23, "Change Username");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(24, "\r\n        ");
            __builder.OpenElement(25, "div");
            __builder.AddAttribute(26, "class", "col-3 center-horiz");
            __builder.AddMarkupContent(27, "<label for=\"pass\">Password:</label>\r\n            ");
            __builder.OpenElement(28, "input");
            __builder.AddAttribute(29, "type", "password");
            __builder.AddAttribute(30, "class", "form-control");
            __builder.AddAttribute(31, "id", "pass");
            __builder.AddAttribute(32, "placeholder", "********");
            __builder.AddAttribute(33, "value", Microsoft.AspNetCore.Components.BindConverter.FormatValue(
#nullable restore
#line 29 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
                                                                                                 changedPassword

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(34, "onchange", Microsoft.AspNetCore.Components.EventCallback.Factory.CreateBinder(this, __value => changedPassword = __value, changedPassword));
            __builder.SetUpdatesAttributeName("value");
            __builder.CloseElement();
            __builder.AddMarkupContent(35, "\r\n            ");
            __builder.OpenElement(36, "button");
            __builder.AddAttribute(37, "class", "btn btn-default btn-success");
            __builder.AddAttribute(38, "style", "margin: 1em");
            __builder.AddAttribute(39, "onclick", Microsoft.AspNetCore.Components.EventCallback.Factory.Create<Microsoft.AspNetCore.Components.Web.MouseEventArgs>(this, 
#nullable restore
#line 30 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
                                                                                      ChangePassword

#line default
#line hidden
#nullable disable
            ));
            __builder.AddAttribute(40, "disabled", 
#nullable restore
#line 30 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
                                                                                                                 ChangePasswordButtonDisabled()

#line default
#line hidden
#nullable disable
            );
            __builder.AddContent(41, "Change Password");
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.CloseElement();
            __builder.AddMarkupContent(42, "\r\n    ");
            __builder.OpenElement(43, "p");
            __builder.AddAttribute(44, "class", "center-horiz");
            __builder.AddAttribute(45, "style", "color: red");
            __builder.AddContent(46, 
#nullable restore
#line 33 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
                                                ErrorLabel

#line default
#line hidden
#nullable disable
            );
            __builder.CloseElement();
            __builder.CloseElement();
        }
        #pragma warning restore 1998
#nullable restore
#line 36 "W:\Univer\SEP\SEP3\SEP3 - TIER1\Gradebook\Pages\SecretaryLogin.razor"
       
    Secretary secretary = CustomAuthenticationStateProvider.CachedSecretary;
    ISecretaryService SecretaryService = new SecretaryService();
    string ErrorLabel;
    string changedUsername;
    string changedPassword;

    bool ChangeUsernameButtonDisabled()
    {
        return (changedUsername == null);
    }
    
    bool ChangePasswordButtonDisabled()
    {
        return (changedPassword == null);
    }
    
    async Task ChangeUsername()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to change your username?")) return;
        NetworkPackage package = await SecretaryService.ChangeSecretaryUsername(changedUsername);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ResetFields();
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - CHANGE USERNAME");
            ErrorLabel = "There was an error";
        }
    }
    
    async Task ChangePassword()
    {
        if (!await JSRuntime.InvokeAsync<bool>("confirm", "Are you sure you want to change your password?")) return;
        NetworkPackage package = await SecretaryService.ChangeSecretaryPassword(changedPassword);
        if (package != null)
        {
            SecretaryDataPackage secretaryDataPackage = (SecretaryDataPackage) package;
            CustomAuthenticationStateProvider.CachedSecretary = secretaryDataPackage.data;
            secretary = secretaryDataPackage.data;
            ResetFields();
            ErrorLabel = "";
        }
        else if (package == null)
        {
            Console.WriteLine("BAD REQUEST - CHANGE PASSWORD");
            ErrorLabel = "There was an error";
        }
    }

    void ResetFields()
    {
        changedPassword = "";
        changedUsername = "";
    }

#line default
#line hidden
#nullable disable
        [global::Microsoft.AspNetCore.Components.InjectAttribute] private IJSRuntime JSRuntime { get; set; }
    }
}
#pragma warning restore 1591