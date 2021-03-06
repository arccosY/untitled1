package com.company;


import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


//import java.awt.*;
//import java.awt.*;


public class Main extends JFrame {

    private static List<String> readUsingScanner(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
//        Scanner scanner = new Scanner(, StandardCharsets.UTF_8.name());
//        здесь мы можем использовать разделитель, например: "\\A", "\\Z" или "\\z"
//        String data = scanner.useDelimiter("\\A").next();
//        scanner.close();
//        return data;

    }
    static final int w = 1920;
    static final int h = 1080;

    public static void draw(Graphics2D g) throws IOException {
        String fileName= "C:/Users/Тим/Downloads/uaz_1.txt";
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

//        String s="0";
//        s= readUsingScanner(fileName);
        int k=0;
        double u[][] = new double[1000][3];
        double vn[][] = new double[1000][3];
        double vt[][] = new double[1000][3];
        double f[][]= new double[1000][3];
        int ff[]=new int [3];

        int kk=0;
        for(String l : readUsingScanner(fileName)){
            k++;
            l.split(" ");

            if(l.length()!=0) {
                if (l.charAt(0) == 'v' && l.charAt(1)==' ') {
                    kk=kk+1;
                    String s="";
                    int qq=0;
                    for(int i=2;i<l.length();i++)
                    {
                        if(l.charAt(i)!=' ')
                        {
                            s=s+l.charAt(i);
                        }
                        else
                        {
                            u[kk][qq]=Double.parseDouble(s);
                            s="";
                            qq=qq+1;
                        }
                    }
                    u[kk][qq]=Double.parseDouble(s);
                    s="";
                    qq=qq+1;
                }

                if (l.charAt(0) == 'v' && l.charAt(1)=='t') {
                    kk=0;
                    String s="";
                    int qq=0;
                    for(int i=3;i<l.length();i++)
                    {
                        if(l.charAt(i)!=' ')
                        {
                            s=s+l.charAt(i);
                        }
                        else
                        {
                            vt[i][qq]=Double.parseDouble(s);
                            s="";

                            qq=qq+1;
                        }
                    }

                }
                if (l.charAt(0) == 'v' && l.charAt(1)=='n') {

                    String s="";
                    int qq=0;
                    for(int i=3;i<l.length();i++)
                    {
                        if(l.charAt(i)!=' ')
                        {
                            s=s+l.charAt(i);
                        }
                        else
                        {
                            vn[i][qq]=Double.parseDouble(s);
                            s="";

                            qq=qq+1;
                        }
                    }

                }
                if (l.charAt(0) == 'f' && l.charAt(1)==' ') {
                    kk=kk+1;
                    String s="";
                    int qq=0;
                    int ss=0;
                    for(int i=2;i<l.length();i++)
                    {

                        if(l.charAt(i)!=' ' && l.charAt(i)!='/')
                        {
                            s=s+l.charAt(i);
                        }
                        if(l.charAt(i)=='/')
                        {
                            if(qq==0) {
                                ff[ss] = Integer.parseInt(s);
                            }
                            qq=qq+1;
                        }
                        if(l.charAt(i)==' ') {
                            ss = ss + 1;
                            s="";
                            qq=0;
                        }
                    }
                    int hh=ff[0];
                    double x1=vt[hh][0]+300;
                    double y1=vt[hh][1]+300;
                    double x4=u[hh][0]+300;
                    double y4=u[hh][1]+300;
                    hh=ff[1];
                    double x2=vt[hh][0]+300;
                    double y2=vt[hh][1]+300;
                    double x5=u[hh][0]+300;
                    double y5=u[hh][1]+300;
                    hh=ff[2];
                    double x3=vt[hh][0]+300;
                    double y3=vt[hh][1]+300;
                    double x6=u[hh][0]+300;
                    double y6=u[hh][1]+300;

                    RenderObj.renderTriangle(img, x4, y4, x5, y5, x6,y6,x1,y1,x2,y2,x3,y3);
                }
            }
        }


        //  Render.renderTriangle(img, 1366, 500, 500, 300, 400,400);


        /*if (l.charAt(0) == 'v' && l.charAt(1) == 't') {
                    kk = 0;
                    String s = "";
                    int qq = 0;
                    for (int i = 3; i < l.length(); i++) {
                        if (l.charAt(i) != ' ') {
                            s = s + l.charAt(i);
                        } else {
                            vt[i][qq] = Double.parseDouble(s);
                            s = "";

                            qq = qq + 1;
                        }
                    }

                }
                if (l.charAt(0) == 'v' && l.charAt(1) == 'n') {

                    String s = "";
                    int qq = 0;
                    for (int i = 3; i < l.length(); i++) {
                        if (l.charAt(i) != ' ') {
                            s = s + l.charAt(i);
                        } else {
                            vn[i][qq] = Double.parseDouble(s);
                            s = "";

                            qq = qq + 1;
                        }
                    }

                }*/
        /*System.out.println("=========================");
        if (ss == 1) {
            int hh = Integer.parseInt(s);
            s = "";

            xn[qq] = vn[hh][0] ;
            yn[qq] = vn[hh][1] ;
            zn[qq]= vn[hh][2] ;
        }
        if (ss == 2) {
            int hh = Integer.parseInt(s);
            s = "";

        }*/

        //  Render.renderTriangle(img, 1366, 500, 500, 300, 400,400);



        //Создаем буффер в который рисуем кадр.


        //Рисуем кадр.


        g.drawImage(img, 0, 0, null);
    }



    //магический код позволяющий всему работать, лучше не трогать
    public static void main(String[] args) throws InterruptedException, IOException {
        Main jf = new Main();
        jf.setSize(w, h);//размер экрана
        jf.setUndecorated(false);//показать заголовок окна
        jf.setTitle("Влад бумага");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.createBufferStrategy(2);
        //в бесконечном цикле рисуем новый кадр
        while (true) {
            long frameLength = 1000 / 1; //пытаемся работать из рассчета  60 кадров в секунду
            long start = System.currentTimeMillis();
            BufferStrategy bs = jf.getBufferStrategy();
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            g.clearRect(0, 0, jf.getWidth(), jf.getHeight());
            draw(g);

            bs.show();
            g.dispose();

            long end = System.currentTimeMillis();
            long len = end - start;
            if (len < frameLength) {
                Thread.sleep(frameLength - len);
            }
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    //Вызывается когда клавиша отпущена пользователем, обработка события аналогична keyPressed
    public void keyReleased(KeyEvent e) {

    }
}