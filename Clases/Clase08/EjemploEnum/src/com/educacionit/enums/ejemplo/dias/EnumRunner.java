/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.educacionit.enums.ejemplo.dias;

/**
 *
 * @author Rodolfo Durante
 */
public class EnumRunner {

    public static void main(String[] args) {
        EnumHandler firstDay = new EnumHandler(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumHandler thirdDay = new EnumHandler(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumHandler fifthDay = new EnumHandler(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumHandler sixthDay = new EnumHandler(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumHandler seventhDay = new EnumHandler(Day.SUNDAY);
        seventhDay.tellItLikeItIs();

        /*
         La salida es:
         Mondays are bad.
         Midweek days are so-so.
         Fridays are better.
         Weekends are best.
         Weekends are best.
         */
    }

}
