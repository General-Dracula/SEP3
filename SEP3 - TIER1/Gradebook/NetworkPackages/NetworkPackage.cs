namespace WebApplication.NetworkPackages
{
    public class NetworkPackage
    {
        private NetworkType _networkType;
        private long _id;

        public NetworkPackage(NetworkType networkType, long id)
        {
            this._networkType = networkType;
            this._id = id;
        }

        public NetworkType GetType()
        {
            return _networkType;
            
        }
        
        public long GetId()
        {
            return _id;
        }

        public void SetId(long id)
        {
            this._id = id;
        }
    }
}