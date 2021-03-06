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
