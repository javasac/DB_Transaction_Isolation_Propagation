package com.sachin.CountryCityOneMany.events;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class AddEventListener
{
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleBeforeCommit(Object event)
    {
        System.out.println("Method handleBeforeCommit = " + event.toString());
        System.out.println("Event handled before transaction commit.");
        // Custom logic before commit (e.g., validate business rules)
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleAfterCommit(Object event)
    {
        System.out.println("Method handleAfterCommit = " + event.toString());
        System.out.println("Event handled after transaction commit.");
        // Logic to handle successful commit (e.g., sending a notification)
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleAfterRollback(Object event)
    {
        System.out.println("Method handleAfterRollback = " + event.toString());
        System.out.println("Event handled after transaction rollback.");
        // Logic for handling rollback (e.g., cleanup operations)
    }
}
