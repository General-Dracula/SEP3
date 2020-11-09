using System.Threading.Tasks;
using WebApplication.Models;
using WebApplication.NetworkPackages;

namespace WebApplication.Data {
public interface IUserService
{
    Task<string> ValidateLoginAsync(string username, string password);
    User ValidateLogin(string username, string password);
}
}