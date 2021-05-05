package workflow.events;

import org.springframework.context.ApplicationEvent;

public class AccessTokenRetrivedEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public AccessTokenRetrivedEvent( String source ) {
        super(source);
    }

    public String getAccessToken() {
        return (String) this.source;
    }

}
