package testMovieGo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import obj.CreditCard;

/* Since this system has not connect to external payment system */
/* Assume pay method must success */
public class testCreditCard {
    @Test
    public void testPay() {
        CreditCard creditCardPayment = new CreditCard();
        boolean actual = creditCardPayment.pay(1.0);
        assertEquals(true, actual);
    }
}
