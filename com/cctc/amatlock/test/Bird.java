package com.cctc.amatlock.test;

import java.awt.*;

public class Bird extends CoreObject
{
    public boolean jumpping = false;
    private boolean falling = true;
    /**
     * Creates the core object. All subclasses
     * will call this with super.
     * The super call to the Rectangle class.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param color
     */
    public Bird(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);

    }

    private boolean onGround()
    {
        Land land1 = Screen.getInstance().land1;
        Land land2 = Screen.getInstance().land2;
        Land land3 = Screen.getInstance().land3;
        if(intersects(land1) || intersects(land2) || intersects(land3))
        {
            return true;
        }
        return false;
    }

//    private boolean isFalling()
//    {
//        if(!onGround())
//        {
//
//            falling = true;
//        }
//        return false;
//    }

    @Override
    public void tick()
    {
        if(jumpping)
        {
            velY -= 0.2;
            if(velY < -10)
            {
                jumpping = false;
                falling = true;
            }
        }

        if(onGround() && !jumpping)
        {
            falling = false;
            setVelY(0);
        }
        if(falling)
        {
           velY += 0.997;
        }

        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
