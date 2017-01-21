
package lunch.hour.utils;

import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author Heron Sanches
 */
public class PasswordUtils {
   
   /**This class is thread-safe.
    http://www.jasypt.org/api/jasypt/1.9.0/org/jasypt/util/password/StrongPasswordEncryptor.html#StrongPasswordEncryptor()
   */
   public static final StrongPasswordEncryptor PASSWORD_ENCRYPTOR = new StrongPasswordEncryptor();
   
   
   private PasswordUtils(){}
   
   
}