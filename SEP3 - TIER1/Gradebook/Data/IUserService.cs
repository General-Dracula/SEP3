using System.Threading.Tasks;

namespace WebApplication.Data {
public interface IUserService
    {
        Task<string> ValidateLoginAsync(string username, string password);
    }
}