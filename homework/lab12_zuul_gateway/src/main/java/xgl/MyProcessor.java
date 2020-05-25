package xgl;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface MyProcessor {

	String MYOUTPUT = "myoutput";

	@Output("myoutput")
	MessageChannel myoutput();

	String MYINPUT = "myinput";

	@Input("myinput")
	SubscribableChannel myinput();
}
