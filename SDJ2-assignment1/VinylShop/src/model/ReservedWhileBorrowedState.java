package model;

public class ReservedWhileBorrowedState implements LendingState
{
  @Override public void click(Vinyl vinyl)
  {
    vinyl.setState(new ReservedState());
  }
}
