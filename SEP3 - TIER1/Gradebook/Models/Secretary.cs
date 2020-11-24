using System.Collections.Generic;

namespace WebApplication.Models
{
    public class Secretary
    {
        public string id { get; set; }
        public string password { get; set; }
        public List<Teacher> teachers { get; set; }
        public List<Class> classes { get; set; }
    }
}