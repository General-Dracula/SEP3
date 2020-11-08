package com.example.tier3NetworkPackages;

public class NetworkPackage
{
  private NetworkType type;
  private long id;

  public NetworkPackage(NetworkType type, Long id)
  {
    this.type = type;
    this.id = id;
  }

  public NetworkType getType()
  {
    return type;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }
}
