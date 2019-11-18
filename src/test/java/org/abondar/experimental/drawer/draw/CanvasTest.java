package org.abondar.experimental.drawer.draw;

import org.abondar.experimental.drawer.exception.CanvasException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CanvasTest {

    private Canvas canvas = Canvas.getInstance();

    @Test
    public void drawCanvasTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.render();
    }

    @Test
    public void isNotOnCanvasXTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()-> canvas.drawLine(new Point(25, 0), new Point(25, 5)));
    }

    @Test
    public void isNotOnCanvasYTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()-> canvas.drawLine(new Point(3, 7), new Point(3, 8)));
    }


    @Test
    public void drawVerticalLineTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.drawLine(new Point(1, 2), new Point(1, 3));

        assertEquals('x',canvas.getCanvas()[2][1]);
        assertEquals('x',canvas.getCanvas()[3][1]);

        canvas.render();
    }

    @Test
    public void drawVerticalLineEdgeTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()->canvas.drawLine(new Point(1, 0), new Point(1, 5)));
    }


    @Test
    public void drawVerticalLineLeftSideTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()->canvas.drawLine(new Point(0, 0), new Point(0, 5)));
    }

    @Test
    public void drawVerticalLineRightSideTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()->canvas.drawLine(new Point(21, 0), new Point(21, 5)));
    }


    @Test
    public void drawHorizontalLineTest() throws CanvasException{
        canvas.createCanvas(20, 4);
        canvas.drawLine(new Point(1, 3), new Point(5, 3));

        assertEquals('x',canvas.getCanvas()[3][4]);
        canvas.render();
    }

    @Test
    public void drawMultiLineTest() throws CanvasException{
        canvas.createCanvas(20, 4);
        canvas.drawLine(new Point(1, 3), new Point(5, 3));
        canvas.drawLine(new Point(1, 2), new Point(1, 4));
        canvas.render();
    }

    @Test
    public void drawHorizontalLineEdgeTest(){
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()-> canvas.drawLine(new Point(0, 3), new Point(21, 3)));

    }

    @Test
    public void drawHorizontalLineUpperEdgeTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()-> canvas.drawLine(new Point(1, 0), new Point(21, 0)));
    }

    @Test
    public void drawHorizontalLineDownEdgeTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()-> canvas.drawLine(new Point(1, 5), new Point(21, 5)));
    }


    @Test
    public void drawPointTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.drawLine(new Point(1, 2), new Point(1, 2));

        assertEquals('x',canvas.getCanvas()[2][1]);
        canvas.render();
    }

    @Test
    public void drawRectangleTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.drawRectangle(new Point(16, 1), new Point(20, 3));

        assertEquals('x',canvas.getCanvas()[1][17]);
        assertEquals('x',canvas.getCanvas()[2][16]);
        assertEquals('x',canvas.getCanvas()[3][19]);

        canvas.render();
    }

    @Test
    public void drawRectangleWrongPointXTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()-> canvas.drawRectangle(new Point(25, 1), new Point(20, 3)));
    }

    @Test
    public void drawRectangleWrongPointYTest() {
        canvas.createCanvas(20, 4);
        assertThrows(CanvasException.class,()-> canvas.drawRectangle(new Point(16, 1), new Point(20, 1)));
    }


    @Test
    public void bucketFillTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.bucketFill(new Point(10, 3), 'o');

        assertEquals('o',canvas.getCanvas()[3][10]);
        assertEquals('o',canvas.getCanvas()[1][3]);
        assertEquals('o',canvas.getCanvas()[2][1]);

        canvas.render();
    }

    @Test
    public void bucketFillLinesTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.drawLine(new Point(1, 4), new Point(19, 4));
        canvas.bucketFill(new Point(1, 2), 'o');

        assertEquals('x',canvas.getCanvas()[4][1]);
        assertEquals('x',canvas.getCanvas()[4][7]);
        assertEquals('x',canvas.getCanvas()[4][12]);

        assertEquals('o',canvas.getCanvas()[1][3]);
        assertEquals('o',canvas.getCanvas()[1][20]);

        canvas.render();
    }

    @Test
    public void bucketFillRectangleTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.drawRectangle(new Point(16, 1), new Point(20, 3));
        canvas.bucketFill(new Point(10, 3), 'o');

        assertEquals(' ',canvas.getCanvas()[2][17]);
        assertEquals(' ',canvas.getCanvas()[2][18]);
        assertEquals(' ',canvas.getCanvas()[2][19]);

        canvas.render();
    }

    @Test
    public void bucketFillLineEdgeTest() throws CanvasException{
        canvas.createCanvas(20, 4);
        canvas.drawLine(new Point(1, 2), new Point(6, 2));
        canvas.drawLine(new Point(6, 3), new Point(6, 4));
        canvas.bucketFill(new Point(10, 3), 'o');

        assertEquals(' ',canvas.getCanvas()[3][1]);
        assertEquals(' ',canvas.getCanvas()[3][2]);

        assertEquals(' ',canvas.getCanvas()[4][3]);
        assertEquals(' ',canvas.getCanvas()[4][4]);

        canvas.render();
    }

    @Test
    public void bucketFillBetweenLinesTest() throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.bucketFill(new Point(10, 3), 'o');
        canvas.drawLine(new Point(1, 2), new Point(11, 2));
        canvas.drawLine(new Point(15, 2), new Point(20, 2));

        assertEquals('o',canvas.getCanvas()[2][12]);

        canvas.render();
    }

    @Test
    public void clearCanvasTest()throws CanvasException {
        canvas.createCanvas(20, 4);
        canvas.drawLine(new Point(1, 2), new Point(11, 2));
        canvas.clearCanvas();

        assertEquals(' ',canvas.getCanvas()[2][7]);

        canvas.render();
    }

}
