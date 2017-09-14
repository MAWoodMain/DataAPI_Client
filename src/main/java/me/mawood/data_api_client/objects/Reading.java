package me.mawood.data_api_client.objects;

public class Reading
{
  private Double reading;
  private long timestamp;

    public Reading()
    {
    }

    public Reading(Double reading, long timestamp)
    {
        this.reading = reading;
        this.timestamp = timestamp;
    }

    public Double getReading() {
    return reading;
  }

  public void setReading(Double reading) {
    this.reading = reading;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

    @Override
    public String toString()
    {
        return "Reading{" +
                "reading=" + reading +
                ", timestamp=" + timestamp +
                '}';
    }
}
