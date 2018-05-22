package com.kai;

import gui.ava.html.image.generator.HtmlImageGenerator;

/**
 * Created by FengKai on 2018/5/7.
 */
public class Main21 {

    public static void main(String[] args) throws InterruptedException {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        //imageGenerator.loadHtml("<b>Hello World!</b> Please goto <a title=\"Goto Google\" href=\"http://www.google.com\">Google</a>.");
        imageGenerator.loadUrl("https://www.baidu.com/img/bd_logo1.png");
        Thread.sleep(1000);
        imageGenerator.saveAsImage("hello-world.png");
        imageGenerator.saveAsHtmlWithMap("hello-world.html", "hello-world.png");
    }
}
