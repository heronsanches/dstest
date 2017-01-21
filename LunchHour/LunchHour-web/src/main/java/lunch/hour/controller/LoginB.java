package lunch.hour.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import lunch.hour.sb.stateless.LoginSBLocal;
import lunch.hour.utils.PasswordUtils;

/**
 *
 * @author Heron Sanches
 */
@Named
@SessionScoped
public class LoginB implements Serializable {
   
   @EJB
   private LoginSBLocal loginSB;
   private String email;
   private String psw;
   

   /**
    * Creates a new instance of LoginMB
    */
   public LoginB() {
      System.out.println("LoginMB");
   }
   
   
   public String login(){
            
      String pswEncrypted = loginSB.getEncryptedPassword(email);
      
      if(pswEncrypted != ""){
         
         if(PasswordUtils.PASSWORD_ENCRYPTOR.checkPassword(psw, pswEncrypted)){
            
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("loginEmail", email);
            psw = "";
                    
            return "lunch?faces-redirect=true";
            
         }
                  
      }      
      
      return ""; //TODO
      
   }

   
   public String logout(){
      
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
      return "login?faces-redirect=true";
      
   }
   
   
   /** getters and setters */
   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPsw() {
      return psw;
   }

   public void setPsw(String psw) {
      this.psw = psw;
   } 
   
   
}