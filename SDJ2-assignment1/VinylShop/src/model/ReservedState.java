package model;

public class ReservedState implements LendingState
{
  @Override public void click(Vinyl vinyl)
  {
    vinyl.setState(new BorrowedState());
  }
}
