package me.mawood.data_api_client.objects;

public class DataType
{
  private String name;
  private String tag;
  private String symbol;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

    @Override
    public String toString()
    {
        return "DataType{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
