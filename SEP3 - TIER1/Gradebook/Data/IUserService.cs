using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data {
public interface IUserService
{
    Task<User> ValidateLoginAsync(string username, string password);
    User ValidateLogin(string username, string password);
}
}