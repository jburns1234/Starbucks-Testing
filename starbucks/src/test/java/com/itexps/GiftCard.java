/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */
package com.itexps;

/**
 *
 * @author Gabriel Muntean
 */
public class GiftCard {
    
   
     private String RecipientName;
     private String RecipientEmail;
     private String SendersName;
     private String SendersEmail;
     private String Message;

    public String getRecipientName() {
        return RecipientName;
    }

    public String getRecipientEmail() {
        return RecipientEmail;
    }

    public String getSendersName() {
        return SendersName;
    }

    public String getSendersEmail() {
        return SendersEmail;
    }

    public String getMessage() {
        return Message;
    }

    public void setRecipientName(String RecipientName) {
        this.RecipientName = RecipientName;
    }

    public void setRecipientEmail(String RecipientEmail) {
        this.RecipientEmail = RecipientEmail;
    }

    public void setSendersName(String SendersName) {
        this.SendersName = SendersName;
    }

    public void setSendersEmail(String SendersEmail) {
        this.SendersEmail = SendersEmail;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public GiftCard(String RecipientName, String RecipientEmail, String SendersName, String SendersEmail, String Message) {
        this.RecipientName = RecipientName;
        this.RecipientEmail = RecipientEmail;
        this.SendersName = SendersName;
        this.SendersEmail = SendersEmail;
        this.Message = Message;
    }

    @Override
    public String toString() {
        return "GiftCard{" + "RecipientName=" + RecipientName + ", RecipientEmail=" + RecipientEmail + ", SendersName=" + SendersName + ", SendersEmail=" + SendersEmail + ", Message=" + Message + '}';
    }

   
     
     
}



