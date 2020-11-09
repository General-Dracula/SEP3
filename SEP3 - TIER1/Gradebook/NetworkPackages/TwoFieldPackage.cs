namespace WebApplication.NetworkPackages
{
    public class TwoFieldPackage : NetworkPackage
    {
        private string firstField;
        private string secondField;

        public TwoFieldPackage(NetworkType type, string firstField, string secondField, long id) : base(type, id)
        {
            this.firstField = firstField;
            this.secondField = secondField;
        }

        public string GetFirstField()
        {
            return firstField;
        }

        public string GetSecondField()
        {
            return secondField;
        }

        public string toString()
        {
            return GetType().ToString();
        }
    }
}