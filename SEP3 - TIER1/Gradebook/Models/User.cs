using System.Text.Json.Serialization;

namespace WebApplication.Models {
    
    public class User {
        
        [JsonPropertyName("username")]
        public string UserName { get; set; }
        [JsonPropertyName("password")]
        public string Password { get; set; }
        [JsonPropertyName("securityLevel")]
        public int SecurityLevel { get; set; }
        
    }
}