package model;

public class Vinyl
{
  private String title, artist, status, reservedBy, borrowedBy;
  private int year;
  private boolean pendingRemoval;

  private LendingState state;

  public Vinyl(String title, String artist, int year) {
    this.title = title;
    this.artist = artist;
    this.year = year;

    status = "available";
    reservedBy = "";
    borrowedBy = "";
    pendingRemoval = false;
    state = new AvailableState();
  }

  public void setState(LendingState state) {
    this.state = state;
  }

  public void click()
  {
    state.click(this);
  }

  public String getTitle() { return title; }

  public String getArtist() { return artist; }

  public int getYear() { return year; }

  public String getStatus() { return status; }

  public void setStatus(String status) { this.status = status; }

  public boolean isPendingRemoval() { return pendingRemoval; }

  public void setPendingRemoval(boolean remove) { this.pendingRemoval = remove; }

  public String getReservedBy() { return reservedBy; }

  public Vinyl setReservedBy(String who) { reservedBy = who; return this; }

  public Vinyl setBorrowedBy(String who) { borrowedBy = who; return this; }

  public String getBorrowedBy() { return borrowedBy; }
}
