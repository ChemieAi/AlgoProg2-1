/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo2;

/**
 *
 * @author asus
 **/
  
    public class UnderGraduate extends Student{

   
    private String track;
    private static int UGCounter;
    

    public UnderGraduate(int studentID, String name, String surname, String track) {
        super(studentID, name, surname);
        this.track = track;
        this.UGCounter++;
    }

    public UnderGraduate() {
        super();
        this.track = null;
        this.UGCounter++;
    }

    public UnderGraduate(UnderGraduate UG) {
        super(UG.getStudentID(),UG.getName(),UG.getSurname());
        this.track = UG.track;
        this.UGCounter++; // Ortalama hesaplamalarında kullanılmak üzere statik sınıf sayacı
    }
    @Override
    public String toString(){
        return super.toString() + " Track: " + getTrack();
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    /**
     * @return the UGCounter
     */
    public static int getUGCounter() {
        return UGCounter;
    }

    public static void setNCCounter(int UGCounter) {
        UnderGraduate.UGCounter = UGCounter;
    }
    }

   



