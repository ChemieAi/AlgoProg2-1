/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo2;

/**
 *
 * @author asus
 */
public class Graduate extends Student {

    private String subject;
    private String advisor;
    private static int GCounter = 0; // Ortalama hesaplamalarında kullanılmak üzere statik sınıf sayacı

    public Graduate(int studentID, String name, String surname, String subject, String advisor) {
        super(studentID, name, surname);
        this.subject = subject;
        this.advisor = advisor;
        this.GCounter++;
    }

    public Graduate() {
        super();
        this.subject = null;
        this.advisor = null;
        this.GCounter++;
    }

    public Graduate(Graduate G) {
        super(G.getStudentID(),G.getName(),G.getSurname());
        this.subject = G.subject;
        this.advisor = G.advisor;
        this.GCounter++;
    }
    @Override
    public String toString(){
        return super.toString() + " Subject: " + subject + " Advisor: " + advisor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public static int getGCounter() {
        return GCounter;
    }

    public static void setGCounter(int GCounter) {
        Graduate.GCounter = GCounter;
    }
}