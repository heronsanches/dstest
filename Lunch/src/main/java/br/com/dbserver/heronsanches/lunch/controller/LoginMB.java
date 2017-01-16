package br.com.dbserver.heronsanches.lunch.controller;

import br.com.dbserver.heronsanches.lunch.model.sb.stateless.LoginSBLocal;
import br.com.dbserver.heronsanches.lunch.utils.PasswordUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Heron Sanches
 */
@Named(value = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {
   
   @EJB
   private LoginSBLocal lsbl;
   private String email;
   private String psw;
   

   /**
    * Creates a new instance of LoginMB
    */
   public LoginMB() {
      System.out.println("LoginMB");
   }
   
   
   public String login(){
            
      System.out.println("login() email: "+email);
      String pswEncrypted = lsbl.getEncryptedPassword(email);
      
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