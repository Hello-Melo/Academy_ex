package test_jsp;

import java.util.Scanner;

public class Triangle {

	      private int w;
	      private int h;
	      private double ar;
	 
	      
	      public int getX() {
	         return w;
	      }
	      public void setX(int w) {
	         this.w = w;         
	      }
	      public int getY() {
	         return h;
	       }
	      public void setY(int h) {
	         this.h = h;
	      }
	      public double getAr() {
	         ar = (w * h) / 2.;
	         return ar;
	      }
	      
	      public void cmpArea() {
	     	  System.out.println("삼각형의 면적은 : " + getAr());
       } 
	      
	 
	   //삼각형의 면적을 구하기 위한 요소들을  선언하기

	   public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      System.out.print(" 밑변 입력 >>> ");
	      int w = sc.nextInt();
	      System.out.print(" 높이 입력 >>> ");
	      int h = sc.nextInt();
	      Triangle tr01 = new Triangle();
	      tr01.setX(w);
	      tr01.setY(h);
	    
	   
	       System.out.println
	      (" 삼격형의 밑변은 : " + tr01.getX() );
	      System.out.println
	      (" 삼격형의 높이는 : " + tr01.getY());
	      tr01.cmpArea();
	      
	      sc.close();
	   }//삼각형의 밑변과 높이 입력하여 면적 산출
	   //면적산출 void Compiler 로 표현하여야하는데 몰겠다 Compiler가....

	}
	
