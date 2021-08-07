package com.bharath.ws.soap;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * @author olysenko
 */
public class UTPasswordCallback implements CallbackHandler {

   private Map<String, String> passwords = new HashMap<>();

   public UTPasswordCallback() {
      passwords.put("admin", "admin");
   }

   @Override
   public void handle(Callback[] callbacks) {
      for (Callback callback : callbacks) {
         if (callback instanceof WSPasswordCallback) {
            WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
            String password = passwords.get(passwordCallback.getIdentifier());
            if (password != null) {
               passwordCallback.setPassword(password);
               return;
            }
         }
      }
   }
}
