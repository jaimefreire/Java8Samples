package problems.akkasampletest.service;

import com.google.inject.Singleton;

/**
 * Created by jfreire on 22.07.17.
 */
@Singleton
public class MessageHandlerService {
    public static final String BEAN_NAME = "messageHandlerService";

    public final String substr(String message, int index) {
        return "Happy bday " + message.substring(index);
    }
}

