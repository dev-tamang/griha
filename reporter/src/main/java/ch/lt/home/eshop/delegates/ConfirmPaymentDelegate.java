package ch.lt.home.eshop.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("confirmPayment")
public class ConfirmPaymentDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        //@TODO do something
    }
}
