using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Secretary
    {
        public string Id { get; set; }
        public string Password { get; set; }
        public List<Teacher> Teachers { get; set; }
        public List<Class> Classes { get; set; }
    }
}