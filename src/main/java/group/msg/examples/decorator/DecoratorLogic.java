package group.msg.examples.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorLogic implements BusinessLogic {

  @Inject
  @Delegate
  @Any
  private BusinessLogic logic;

  @Override
  public String performSomeBusinessLogic() {
    return logic.performSomeBusinessLogic().replace("Some", "Decorated");
  }
}
