package model;

public class BorrowedState implements LendingState
{
  @Override public void click(Vinyl vinyl)
  {
    if (vinyl.getBorrowedBy().equals(null))
      vinyl.setState(new AvailableState());
    else if (!vinyl.getReservedBy().equals(null))
      vinyl.setState(new ReservedWhileBorrowedState());

  }
}
