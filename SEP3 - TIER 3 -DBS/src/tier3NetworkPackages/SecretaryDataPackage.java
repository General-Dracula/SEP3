package tier3NetworkPackages;

import Data.Secretary;

public class SecretaryDataPackage  extends NetworkPackage
{
    private Secretary data;

    public SecretaryDataPackage(NetworkType type, Secretary data,  Long id)
    {
        super(type, id);
        this.data = data;
    }

    public Secretary getData()
    {
        return data;
    }

    public void setData(Secretary data)
    {
        this.data = data;
    }
}
