package org.abondar.experimental.drawer.draw;


import org.abondar.experimental.drawer.exception.CanvasException;
import org.abondar.experimental.drawer.util.MessageUtil;

import java.util.Arrays;

/**
 * Canvas object
 *
 * @author a.bondar
 */
public class Canvas {


    private static final char HORIZONTAL_EDGE_CHAR = '-';
    private static final char VERTICAL_EDGE_CHAR   = '|';
    private static final char LINE_CHAR            = 'x';
    private char[][] canvas;
    private int height;
    private int width;
    private int heightEdge;
    private int widthEdge;

    private static Canvas instance;

    private Canvas(){}

    public static Canvas getInstance(){
        if (instance == null){
            instance = new Canvas();
        }

        return instance;
    }

    public void createCanvas(int width, int height){

       this.width = width;
       this.height = height;


       canvas = new char[height+2][width+2];
       Arrays.stream(canvas).forEach(chars -> Arrays.fill(chars, ' '));

       this.widthEdge= width+1;
       this.heightEdge = height+1;
        for (int i=0;i<heightEdge;i++){
            canvas[i][0] = VERTICAL_EDGE_CHAR;
            canvas[i][width+1] = VERTICAL_EDGE_CHAR;
        }

        for (int i=0;i<widthEdge+1;i++){
            canvas[0][i] = HORIZONTAL_EDGE_CHAR;
            canvas[height+1][i] = HORIZONTAL_EDGE_CHAR;

        }

    }

    public void drawLine(Point start,Point end) throws CanvasException {
        if (canvas==null){
            throw  new CanvasException(MessageUtil.EMPTY_CANVAS);
        }

        if(!isOnCanvas(start) || !isOnCanvas(end)){
            throw new CanvasException(MessageUtil.POINT_IS_NOT_ON_CANVAS);
        }

        if (start.getX()!=end.getX() && start.getY()!=end.getY()){
            throw new CanvasException(MessageUtil.UNSUPPORTED_LINE_TYPE);
        } else if (start.getX()==end.getX() && start.getY()!=end.getY()){
            drawVertical(start,end);
        } else if (start.getY()==end.getY() && start.getX()!=end.getX()){
            drawHorizontal(start,end);
        } else {
            canvas[start.getY()][start.getX()] = LINE_CHAR;
        }

    }

    public void drawRectangle(Point leftUp,Point rightDown) throws CanvasException {
       if (leftUp.getX()>=rightDown.getX() || leftUp.getY()>=rightDown.getY()){
           throw new CanvasException(MessageUtil.WRONG_POINT);
       }

       var leftDown = new Point(leftUp.getX(),rightDown.getY());
       var rightUp  = new Point(rightDown.getX(),leftUp.getY());

       drawLine(leftUp,rightUp);
       drawLine(leftUp,leftDown);
       drawLine(leftDown,rightDown);
       drawLine(rightUp,rightDown);

    }

    public void bucketFill(Point start, char color){
        if (!isOnCanvas(start)){
            return;
        }

        if (canvas[start.getY()][start.getX()]==color  ||
                canvas[start.getY()][start.getX()]==LINE_CHAR ){
            return;
        }
        canvas[start.getY()][start.getX()] = color;

        bucketFill(new Point(start.getX()+1,start.getY()),color);
        bucketFill(new Point(start.getX()-1,start.getY()),color);
        bucketFill(new Point(start.getX(),start.getY()+1),color);
        bucketFill(new Point(start.getX(),start.getY()-1),color);

    }

    public void clearCanvas() throws CanvasException{
        if (canvas==null){
            throw  new CanvasException(MessageUtil.EMPTY_CANVAS);
        }

        for (int i=0;i<heightEdge;i++){
            for (int j=0;j<widthEdge+1;j++){
              if (canvas[i][j]!=' ' && canvas[i][j]!=HORIZONTAL_EDGE_CHAR && canvas[i][j]!=VERTICAL_EDGE_CHAR){
                  canvas[i][j] = ' ';
              }
            }
        }


    }


    private boolean isOnCanvas(Point point){
       if (point.getX()>=widthEdge || point.getX()==0){
           return false;
       }

        if (point.getY()>=heightEdge || point.getY()==0){
            return false;
        }

       return true;
    }

    private void drawVertical(Point start,Point end){
        for (int i=start.getY();i<end.getY()+1;i++){
            if ((i!=0 && i!=heightEdge) && (start.getX()!=0 && start.getX()!=widthEdge)){
                canvas[i][start.getX()]=LINE_CHAR;
            }

        }
    }

    private void drawHorizontal(Point start, Point end) {
        for (int i=start.getX();i<end.getX()+1;i++){
            if ((i!=0 && i!=widthEdge) && (start.getY()!=0 && start.getY()!=heightEdge)){
                canvas[start.getY()][i]=LINE_CHAR;
            }

        }
    }

    public void render() throws CanvasException{
        for (int i=0;i<height+2;i++){
            for (int j=0;j<width+2;j++){
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }

    }


    public char[][] getCanvas() {
        return canvas;
    }

}
