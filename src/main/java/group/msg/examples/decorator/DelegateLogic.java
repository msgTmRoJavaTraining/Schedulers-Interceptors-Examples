package group.msg.examples.decorator;

import javax.ejb.Stateless;

@Stateless
public class DelegateLogic implements BusinessLogic {

  @Override
  public String performSomeBusinessLogic() {
    return "Some business logic performed";
  }

  @Override
  public String performOtherBusinessLogic() {
    return "Other business logic performed";
  }
}