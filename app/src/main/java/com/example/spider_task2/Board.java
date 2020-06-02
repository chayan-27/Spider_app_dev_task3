package com.example.spider_task2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Board extends View {
    Bitmap mDrawBitmap;
    Canvas mBitmapCanvas;
    boolean clicked;
    int x, y, score1, score2;
    Bitmap cross;
    Rect cross1;
    Rect cross2;
    Point point;
    List<Point> list = new ArrayList<>();
    List<Point> list1 = new ArrayList<>();
    List<Point> list2 = new ArrayList<>();
    int x1, y1;
    int turn = 0;
    boolean exists = false;
    Paint paint = new Paint();
    int c = 0;
    MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), R.raw.correct);
    String check = Gameplay.single;
    int comp = 0;
    boolean exists1;
    boolean play1, play2, play3, play4;
    int ac = 0;
    boolean n1 = true, n2 = true;
    boolean a = false;
    boolean b = false;


    public Board(Context context) {
        super(context);
        // check=Gameplay.single;

    }

    public Board(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Board(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Board(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(8);
        if (mDrawBitmap == null) {
            mDrawBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mBitmapCanvas = new Canvas(mDrawBitmap);
        }
        for (int i = 400; i <= 1000; i += 200) {
            canvas.drawLine(200, i, 800, i, paint);
            canvas.drawLine(i - 200, 400, i - 200, 1000, paint);
        }
        if (check.equals("no")) {
            if (clicked) {
                for (int i = 0; i < list.size(); i++) {
                    Point p = list.get(i);
                    if (p.x == x1 && p.y == y1) {
                        exists = true;
                        break;
                    } else {
                        exists = false;
                    }
                }
                if (!exists) {
                    point = new Point();
                    point.set(x1, y1);
                    if (turn == 0) {
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        turn = 1;
                    } else {
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.zero);
                        list2.add(point);
                        turn = 0;
                    }
                    list.add(point);

                    if (cross != null) {
                        cross1 = new Rect(x1, y1, x1 + 200, y1 + 200);
                        cross2 = new Rect(x1, y1, x1 + 200, y1 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                        checkrow(x1, y1);
                    }

                }
                clicked = false;
            }
        } else {
            if (clicked == false) {

                turn = 1;
                if (c == 0) {
                    point = new Point();
                    point.set(200, 400);
                    cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                    list1.add(point);
                    list.add(point);
                    cross2 = new Rect(200, 400, 200 + 200, 400 + 200);
                    mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                    c++;
                    checkrow(200, 400);

                } else if (c == 2) {
                    /*for (int i = 0; i < list.size(); i++) {
                        Point p = list.get(i);
                        if ((p.x == 600 && p.y == 800)||(p.x==400&&p.y==400)||(p.x==200&&p.y==600)) {
                            exists = true;
                            if((p.x==400&&p.y==400)||(p.x==200&&p.y==600)){
                                exists1=true;
                            }
                            break;
                        } else {
                            exists = false;
                        }
                    }
                    if(!exists){
                        if(exists1==false) {
                            point = new Point();
                            point.set(600, 800);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(600, 800, 600 + 200, 800 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                        }else{
                            point = new Point();
                            point.set(400, 600);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(400, 600, 400 + 200, 600 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                        }
                     }else{
                        point = new Point();
                        point.set(600, 400);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                     }*/
                    Point p = list.get(1);
                    int xcor = p.x;
                    int ycor = p.y;
                    if ((xcor == 400 && ycor == 400) || (xcor == 200 && ycor == 600) || (xcor == 400 && ycor == 800) || (xcor == 600 && ycor == 600)) {
                        point = new Point();
                        point.set(400, 600);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(400, 600, 400 + 200, 600 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        play1 = true;
                        c++;
                        if (xcor == 600 && ycor == 600) {
                            a = true;
                        } else if (xcor == 200 && ycor == 600) {
                            b = true;
                        }
                        checkrow(400, 600);
                    } else if ((xcor == 400 && ycor == 600)) {
                        point = new Point();
                        point.set(600, 800);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(600, 800, 600 + 200, 800 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        play2 = true;
                        c++;
                        checkrow(400, 600);
                    } else if ((xcor == 200 && ycor == 800)) {
                        point = new Point();
                        point.set(600, 800);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(600, 800, 600 + 200, 800 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        play3 = true;
                        c++;
                        checkrow(600, 800);
                    } else if ((xcor == 600 && ycor == 400) || (xcor == 600 && ycor == 800)) {
                        point = new Point();
                        point.set(200, 800);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        play4 = true;
                        c++;
                        checkrow(200, 800);
                        if ((xcor == 600 && ycor == 400)) {
                            n2 = true;
                            n1 = false;
                        } else {
                            n1 = true;
                            n2 = false;
                        }
                    }


                } else if (c == 4) {
                   /* for (int i = 0; i < list.size(); i++) {
                        Point p = list.get(i);
                        if (p.x == 600 && p.y == 600) {
                            exists = true;
                            break;
                        } else {
                            exists = false;
                        }
                    }
                    if(!exists){
                        point = new Point();
                        point.set(600, 600);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(600, 600, 600 + 200, 600 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                    }else{
                        point = new Point();
                        point.set(200, 600);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(200, 600, 200 + 200, 600 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                    }*/
                    Point p = list.get(3);
                    int xcor = p.x;
                    int ycor = p.y;
                    if (play1) {
                        if (xcor == 600 && ycor == 800) {
                            if (a == false) {
                                point = new Point();
                                point.set(200, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(200, 800);
                            } else {
                                point = new Point();
                                point.set(600, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 400);
                            }
                        } else if (xcor == 600 && ycor == 800) {
                            point = new Point();
                            point.set(600, 400);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(600, 400);
                        } else {
                            point = new Point();
                            point.set(600, 800);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(600, 800, 600 + 200, 800 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(600, 800);
                            launch();
                        }
                    }
                    if (play2) {
                        boolean t1 = true, t2 = true;
                        if (xcor == 600 && ycor == 400) {
                            t1 = false;
                            t2 = true;
                            ac = 1;
                        } else if (xcor == 200 && ycor == 800) {
                            t1 = true;
                            t2 = false;
                            ac = 2;
                        }


                        if (t1 == true && t2 == true) {
                            boolean p1 = true, p2 = true;

                            if (xcor == 600 && ycor == 600) {
                                p1 = false;
                                p2 = true;
                                ac = 3;
                            } else if (xcor == 200 && ycor == 600) {
                                p1 = true;
                                p2 = false;
                                ac = 4;
                            }
                            if (p1 && p2) {
                                boolean q1 = true, q2 = true;
                                if (xcor == 400 && ycor == 400) {
                                    q1 = false;
                                    q2 = true;
                                    ac = 5;
                                } else if (xcor == 400 && ycor == 800) {
                                    q1 = true;
                                    q2 = false;
                                    ac = 6;
                                }
                                if (q1 == true && q2 == false) {
                                    point = new Point();
                                    point.set(400, 400);
                                    cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                    list1.add(point);
                                    list.add(point);
                                    cross2 = new Rect(400, 400, 400 + 200, 400 + 200);
                                    mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                    c++;
                                    checkrow(400, 400);
                                } else if (q1 == false && q2 == true) {
                                    point = new Point();
                                    point.set(400, 800);
                                    cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                    list1.add(point);
                                    list.add(point);
                                    cross2 = new Rect(400, 800, 400 + 200, 800 + 200);
                                    mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                    c++;
                                    checkrow(400, 800);
                                }
                            } else if (p1 == true && p2 == false) {
                                point = new Point();
                                point.set(600, 600);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 600, 600 + 200, 600 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 600);
                            } else if (p1 == false && p2 == true) {
                                point = new Point();
                                point.set(200, 600);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(200, 600, 200 + 200, 600 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(200, 600);
                            }
                        } else if (t1 == false && t2 == true) {
                            point = new Point();
                            point.set(200, 800);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(200, 800);
                        } else if (t1 == true && t2 == false) {
                            point = new Point();
                            point.set(600, 400);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(600, 400);
                        }
                    }
                    if (play3) {
                        if (xcor == 400 && ycor == 600) {
                            point = new Point();
                            point.set(600, 400);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(600, 400);
                        } else {
                            point = new Point();
                            point.set(400, 600);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(400, 600, 400 + 200, 600 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(400, 600);
                            launch();

                        }
                    }
                    if (play4) {
                        if (xcor == 200 && ycor == 600) {

                               /*bo Point po=list2.get(0);
                                if(po.x==600&&po.y==400){
                                    n1=false;
                                    n2=true;
                                }else if(po.x==600&&po.y==800){
                                    n1=true;
                                    n2=false;
                                }*/
                            if (n1 == true && n2 == false) {
                                point = new Point();
                                point.set(600, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 400);
                            } else if (n1 == false && n2 == true) {
                                point = new Point();
                                point.set(600, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 800, 600 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 800);
                            }

                        } else {
                            point = new Point();
                            point.set(200, 600);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(200, 600, 200 + 200, 600 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(200, 600);
                            launch();
                        }
                    }

                } else if (c == 6) {
                  /*  for (int i = 0; i < list.size(); i++) {
                        Point p = list.get(i);
                        if (p.x == 200 && p.y == 800) {
                            exists = true;
                            break;
                        } else {
                            exists = false;
                        }
                    }
                    if(!exists){
                        point = new Point();
                        point.set(200, 800);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                    }else{
                        point = new Point();
                        point.set(600, 400);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                    }*/
                    Point p = list2.get(2);
                    int xcor = p.x;
                    int ycor = p.y;
                    if (play1) {
                        if (((xcor == 200 && ycor == 600) || (xcor == 400 && ycor == 400) || (xcor == 600 && ycor == 600) || (xcor == 400 && ycor == 800)) && a == false) {
                            point = new Point();
                            point.set(600, 400);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(600, 400);
                            launch();
                        } else if (xcor == 600 && ycor == 400 && a == false && b == false) {
                            point = new Point();
                            point.set(200, 600);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(200, 600, 200 + 200, 600 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(200, 600);
                            launch();
                        } else {
                            if (a) {
                                if (xcor == 400 && ycor == 400) {
                                    point = new Point();
                                    point.set(200, 800);
                                    cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                    list1.add(point);
                                    list.add(point);
                                    cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                                    mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                    c++;
                                    checkrow(200, 800);
                                    launch();
                                } else if (xcor == 200 && ycor == 800) {
                                    point = new Point();
                                    point.set(400, 400);
                                    cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                    list1.add(point);
                                    list.add(point);
                                    cross2 = new Rect(400, 400, 400 + 200, 400 + 200);
                                    mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                    c++;
                                    checkrow(400, 400);
                                    launch();
                                } else {
                                    point = new Point();
                                    point.set(400, 400);
                                    cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                    list1.add(point);
                                    list.add(point);
                                    cross2 = new Rect(400, 400, 400 + 200, 400 + 200);
                                    mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                    c++;
                                    checkrow(400, 400);
                                    launch();
                                }
                            } else {
                                launch();
                            }


                        }
                    }
                    if (play2) {
                        if (ac == 1) {
                            if (xcor == 200 && ycor == 600) {
                                point = new Point();
                                point.set(400, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(400, 800, 400 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(400, 800);
                                launch();
                            } else {
                                point = new Point();
                                point.set(200, 600);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(200, 600, 200 + 200, 600 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(200, 600);
                                launch();

                            }

                        } else if (ac == 2) {
                            if (xcor == 400 && ycor == 400) {
                                point = new Point();
                                point.set(600, 600);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 600, 600 + 200, 600 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 600);
                                launch();
                            } else {
                                point = new Point();
                                point.set(400, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(400, 400, 400 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(400, 400);
                                launch();

                            }

                        } else if (ac == 3) {
                            if (xcor == 200 && ycor == 800) {
                                point = new Point();
                                point.set(600, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 400);
                                launch();
                            } else {
                                point = new Point();
                                point.set(200, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(200, 800);
                                launch();

                            }

                        } else if (ac == 4) {
                            if (xcor == 600 && ycor == 400) {
                                point = new Point();
                                point.set(200, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(200, 800);
                                launch();
                            } else {
                                point = new Point();
                                point.set(600, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 400);
                                launch();

                            }

                        } else if (ac == 5) {
                            if (xcor == 200 && ycor == 800) {
                                point = new Point();
                                point.set(600, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 400);
                                launch();
                            } else {
                                point = new Point();
                                point.set(200, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(200, 800);
                                launch();

                            }

                        } else if (ac == 6) {
                            if (xcor == 600 && ycor == 400) {
                                point = new Point();
                                point.set(200, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(200, 800, 200 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(200, 800);
                                launch();
                            } else {
                                point = new Point();
                                point.set(600, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(600, 400, 600 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(600, 400);
                                launch();

                            }

                        }
                    }
                    if (play3) {
                        if (xcor == 400 && ycor == 400) {
                            point = new Point();
                            point.set(600, 600);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(600, 600, 600 + 200, 600 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(600, 600);
                            launch();
                        } else {
                            point = new Point();
                            point.set(400, 400);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(400, 400, 400 + 200, 400 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(400, 400);
                            launch();

                        }

                    }
                    if (play4) {
                        if (xcor == 400 && ycor == 600) {
                            if (n1 == true && n2 == false) {
                                point = new Point();
                                point.set(400, 400);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(400, 400, 400 + 200, 400 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(400, 400);
                                launch();
                            } else {
                                point = new Point();
                                point.set(400, 800);
                                cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                                list1.add(point);
                                list.add(point);
                                cross2 = new Rect(400, 800, 400 + 200, 800 + 200);
                                mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                                c++;
                                checkrow(400, 800);
                                launch();
                            }

                        } else {
                            point = new Point();
                            point.set(400, 600);
                            cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                            list1.add(point);
                            list.add(point);
                            cross2 = new Rect(400, 600, 400 + 200, 600 + 200);
                            mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                            c++;
                            checkrow(400, 600);
                            launch();

                        }
                    }


                } else if (c == 8) {
                    launch();
                  /*  for (int i = 0; i < list.size(); i++) {
                        Point p = list.get(i);
                        if (p.x == 400 && p.y == 400) {
                            exists = true;
                            break;
                        } else {
                            exists = false;
                        }
                    }
                    if(!exists){
                        point = new Point();
                        point.set(400,400);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(400, 400, 400 + 200, 400 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                    }else{
                        point = new Point();
                        point.set(400, 800);
                        cross = BitmapFactory.decodeResource(getResources(), R.drawable.cross);
                        list1.add(point);
                        list.add(point);
                        cross2 = new Rect(400, 800, 400 + 200, 800 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                    }*/

                }
            } else {
                turn = 0;
                for (int i = 0; i < list.size(); i++) {
                    Point p = list.get(i);
                    if (p.x == x1 && p.y == y1) {
                        exists = true;
                        break;
                    } else {
                        exists = false;
                    }
                }
                if (!exists) {
                    point = new Point();
                    point.set(x1, y1);

                    cross = BitmapFactory.decodeResource(getResources(), R.drawable.zero);
                    list2.add(point);


                    list.add(point);

                    if (cross != null) {
                        cross1 = new Rect(x1, y1, x1 + 200, y1 + 200);
                        cross2 = new Rect(x1, y1, x1 + 200, y1 + 200);
                        mBitmapCanvas.drawBitmap(cross, null, cross2, null);
                        c++;
                        checkrow(x1, y1);
                    }
                    clicked = false;
                    postInvalidate();

                }

            }

        }
        canvas.drawBitmap(mDrawBitmap, 0, 0, new Paint());
        if (check.equals("no")) {
            if (c == 9) {
                /*Intent intent=new Intent(getContext(),Results.class);
                if(score1>score2){
                    intent.putExtra("winner","Player1 wins");
                }else if(score2>score1){
                    intent.putExtra("winner","Player2 wins");
                }else{
                    intent.putExtra("winner","Its a Draw");
                }
                getContext().startActivity(intent);*/
                launch();

            }
        }

    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        x = (int) motionEvent.getX();
        y = (int) motionEvent.getY();
        exists = false;


        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (x >= 200 && x <= 400 && y >= 400 && y <= 600) {
                    x1 = 200;
                    y1 = 400;
                    clicked = true;
                    return true;
                } else if (x >= 400 && x <= 600 && y >= 400 && y <= 600) {
                    x1 = 400;
                    y1 = 400;
                    clicked = true;
                    return true;
                } else if (x >= 600 && x <= 800 && y >= 400 && y <= 600) {
                    x1 = 600;
                    y1 = 400;
                    clicked = true;
                    return true;
                } else if (x >= 200 && x <= 400 && y >= 600 && y <= 800) {
                    x1 = 200;
                    y1 = 600;
                    clicked = true;
                    return true;
                } else if (x >= 400 && x <= 600 && y >= 600 && y <= 800) {
                    x1 = 400;
                    y1 = 600;
                    clicked = true;
                    return true;
                } else if (x >= 600 && x <= 800 && y >= 600 && y <= 800) {
                    x1 = 600;
                    y1 = 600;
                    clicked = true;
                    return true;
                } else if (x >= 200 && x <= 400 && y >= 800 && y <= 1000) {
                    x1 = 200;
                    y1 = 800;
                    clicked = true;
                    return true;
                } else if (x >= 400 && x <= 600 && y >= 800 && y <= 1000) {
                    x1 = 400;
                    y1 = 800;
                    clicked = true;
                    return true;
                } else if (x >= 600 && x <= 800 && y >= 800 && y <= 1000) {
                    x1 = 600;
                    y1 = 800;
                    clicked = true;
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                postInvalidate();
                break;
        }
        return true;
    }

    public void checkrow(int x1, int y1) {
        boolean line1 = false, line2 = false, line3 = false, line4 = false, line5 = false, line6 = false, line7 = false, line8 = false;
        List<Point> listing;

        if (turn == 1) {
            listing = list1;

        } else {
            listing = list2;

        }

        if (x1 == 200 && y1 == 400) {

            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 + 200 && point.y == y1 + 200) {
                        line1 = true;
                    }
                    if (point.x == x1 + 400 && point.y == y1 + 400) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 + 200 && point.y == y1) {
                        line3 = true;
                    }
                    if (point.x == x1 + 400 && point.y == y1) {
                        line4 = true;
                    }
                }
                if (!(line5 && line6)) {
                    if (point.x == x1 && point.y == y1 + 200) {
                        line5 = true;
                    }
                    if (point.x == x1 && point.y == y1 + 400) {
                        line6 = true;
                    }
                }

            }
            if (line1 && line2) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;

                } else {
                    score2++;

                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }
            if (line5 && line6) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line5 = false;
                line6 = false;
            }

        } else if (x1 == 400 && y1 == 400) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 - 200 && point.y == y1) {
                        line1 = true;
                    }
                    if (point.x == x1 + 200 && point.y == y1) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 && point.y == y1 + 200) {
                        line3 = true;
                    }
                    if (point.x == x1 && point.y == y1 + 400) {
                        line4 = true;
                    }
                }
            }
            if (line1 && line2) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }


        } else if (x1 == 600 && y1 == 400) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 - 200 && point.y == y1 + 200) {
                        line1 = true;
                    }
                    if (point.x == x1 - 400 && point.y == y1 + 400) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 - 200 && point.y == y1) {
                        line3 = true;
                    }
                    if (point.x == x1 - 400 && point.y == y1) {
                        line4 = true;
                    }
                }
                if (!(line5 && line6)) {
                    if (point.x == x1 && point.y == y1 + 200) {
                        line5 = true;
                    }
                    if (point.x == x1 && point.y == y1 + 400) {
                        line6 = true;
                    }
                }

            }
            if (line1 && line2) {

                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {

                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }
            if (line5 && line6) {

                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line5 = false;
                line6 = false;
            }


        } else if (x1 == 200 && y1 == 600) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 + 200 && point.y == y1) {
                        line1 = true;
                    }
                    if (point.x == x1 + 400 && point.y == y1) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 && point.y == y1 + 200) {
                        line3 = true;
                    }
                    if (point.x == x1 && point.y == y1 - 200) {
                        line4 = true;
                    }
                }


            }
            if (line1 && line2) {

                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }


        } else if (x1 == 400 && y1 == 600) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 + 200 && point.y == y1) {
                        line1 = true;
                    }
                    if (point.x == x1 - 200 && point.y == y1) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 && point.y == y1 - 200) {
                        line3 = true;
                    }
                    if (point.x == x1 && point.y == y1 + 200) {
                        line4 = true;
                    }
                }
                if (!(line5 && line6)) {
                    if (point.x == x1 + 200 && point.y == y1 - 200) {
                        line5 = true;
                    }
                    if (point.x == x1 - 200 && point.y == y1 + 200) {
                        line6 = true;
                    }
                }
                if (!(line7 && line8)) {
                    if (point.x == x1 + 200 && point.y == y1 + 200) {
                        line7 = true;
                    }
                    if (point.x == x1 - 200 && point.y == y1 - 200) {
                        line8 = true;
                    }
                }

            }


            if (line1 && line2) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }
            if (line5 && line6) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line5 = false;
                line6 = false;
            }
            if (line7 && line8) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line7 = false;
                line8 = false;
            }


        } else if (x1 == 600 && y1 == 600) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 - 200 && point.y == y1) {
                        line1 = true;
                    }
                    if (point.x == x1 - 400 && point.y == y1) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 && point.y == y1 + 200) {
                        line3 = true;
                    }
                    if (point.x == x1 && point.y == y1 - 200) {
                        line4 = true;
                    }
                }


            }
            if (line1 && line2) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }

        } else if (x1 == 200 && y1 == 800) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 + 200 && point.y == y1 - 200) {
                        line1 = true;
                    }
                    if (point.x == x1 + 400 && point.y == y1 - 400) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 + 200 && point.y == y1) {
                        line3 = true;
                    }
                    if (point.x == x1 + 400 && point.y == y1) {
                        line4 = true;
                    }
                }
                if (!(line5 && line6)) {
                    if (point.x == x1 && point.y == y1 - 200) {
                        line5 = true;
                    }
                    if (point.x == x1 && point.y == y1 - 400) {
                        line6 = true;
                    }
                }

            }
            if (line1 && line2) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }
            if (line5 && line6) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line5 = false;
                line6 = false;
            }

        } else if (x1 == 400 && y1 == 800) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 - 200 && point.y == y1) {
                        line1 = true;
                    }
                    if (point.x == x1 + 200 && point.y == y1) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 && point.y == y1 - 200) {
                        line3 = true;
                    }
                    if (point.x == x1 && point.y == y1 - 400) {
                        line4 = true;
                    }
                }


            }
            if (line1 && line2) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }


        } else if (x1 == 600 && y1 == 800) {
            for (int i = 0; i < listing.size() - 1; i++) {
                Point point = listing.get(i);
                if (!(line1 && line2)) {
                    if (point.x == x1 - 200 && point.y == y1 - 200) {
                        line1 = true;
                    }
                    if (point.x == x1 - 400 && point.y == y1 - 400) {
                        line2 = true;
                    }
                }
                if (!(line3 && line4)) {
                    if (point.x == x1 - 200 && point.y == y1) {
                        line3 = true;
                    }
                    if (point.x == x1 - 400 && point.y == y1) {
                        line4 = true;
                    }
                }
                if (!(line5 && line6)) {
                    if (point.x == x1 && point.y == y1 - 200) {
                        line5 = true;
                    }
                    if (point.x == x1 && point.y == y1 - 400) {
                        line6 = true;
                    }
                }

            }
            if (line1 && line2) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line1 = false;
                line2 = false;
            }
            if (line3 && line4) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line3 = false;
                line4 = false;
            }
            if (line5 && line6) {
                mediaPlayer.start();
                if (turn == 1) {
                    score1++;
                } else {
                    score2++;
                }
                line5 = false;
                line6 = false;
            }

        }
    }

    public void launch() {
        Intent intent = new Intent(getContext(), Results.class);
        if (score1 > score2) {
            intent.putExtra("winner", Gameplay.player1);
            intent.putExtra("dec", "Player1 wins");
        } else if (score2 > score1) {
            intent.putExtra("winner", Gameplay.player2);
            intent.putExtra("dec", "Player2 wins");
        } else {
            intent.putExtra("winner", "Its a Draw");
            intent.putExtra("dec", "Its a Draw");
        }
        getContext().startActivity(intent);
    }


}
