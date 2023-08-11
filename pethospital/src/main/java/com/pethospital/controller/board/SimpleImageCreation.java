package com.pethospital.controller.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SimpleImageCreation {
    public static void main(String[] args) {
        int width = 400; // 이미지의 너비
        int height = 200; // 이미지의 높이
        
        String textToDraw = "안녕하세요, Java 이미지!"; // 그릴 텍스트
        
        BufferedImage image = createImageWithText(width, height, textToDraw);
        
        // 이미지를 파일로 저장합니다.
        File outputFile = new File("dynamic_text_image.png");
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.println("이미지가 성공적으로 생성되고 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("이미지 저장 중 오류 발생: " + e.getMessage());
        }
    }
    
    private static BufferedImage createImageWithText(int width, int height, String text) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        // 이미지의 그래픽 컨텍스트를 얻습니다.
        Graphics2D graphics = image.createGraphics();
        
        // 배경색을 설정합니다.
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        
        // 이미지에 텍스트를 그립니다.
        graphics.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 20);
        graphics.setFont(font);
        graphics.drawString(text, 50, 100);
        
        graphics.dispose(); // 그래픽 컨텍스트를 해제합니다.
        
        return image;
    }
}