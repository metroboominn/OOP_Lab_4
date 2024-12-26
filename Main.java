import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Main 
{
    public static void main(String[] args) 
	{

        final ArrayList<String> labelstypos = new ArrayList<String>(); // задание массива строк
			labelstypos.add("Солнце светит");
			labelstypos.add("Книга интересная, сюжет захватывающий");
			labelstypos.add("Яркая одежда");
			labelstypos.add("Стильный образ");
			labelstypos.add("Красивая архитектура");
			labelstypos.add("Вкусный кофе");


        final JFrame frame = new JFrame("Движение строк по экрану"); // создание окна, задание его параметров
			frame.setPreferredSize(new Dimension(640, 480)); // размеры экрана
			frame.setVisible(true); // видимость
			frame.setLayout(null); // расположение

        final JLabel textlabel = new JLabel(); // создание текстового контейнера, задание его параметров
			textlabel.setLocation(-1, 0); // местоположение
			textlabel.setSize(300, 20); // размер
			frame.add(textlabel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();


        Timer timer = new Timer(17, new ActionListener() 
		{
            int speedX, speedY; 
            Random rnd = new Random(); // создание переменных для скорости, создание генератора случайных чисел
			
            @Override
            public void actionPerformed(ActionEvent arg0) 
			{
                Point loc = textlabel.getLocation(); // определение местоположения текста

                if (loc.x > frame.getWidth() || loc.y > frame.getHeight() || loc.x < 0 || loc.y < 0) // если выходит за пределы экрана
				{
                    textlabel.setLocation(frame.getWidth()/2, frame.getHeight()/2); // переместить в центр окна
                    speedX = -10+rnd.nextInt(20); // задать случайную скорость по ширине
                    speedY = -10+rnd.nextInt(20); // задать случайную скорость по высоте
                    textlabel.setText(labelstypos.get(rnd.nextInt(labelstypos.size()-1))); // задать случайную строку
                } 
				else 
				{
                    textlabel.setLocation(loc.x + speedX, loc.y + speedY); // свдинуть текст с заданной скоростью
                }
            }
		}
		);
        timer.start(); // запуск таймера
	}
}