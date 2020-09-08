package com.modemi4.codenames;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class Card extends androidx.appcompat.widget.AppCompatImageView {

    public boolean Activated = false;
    public Types Type;

    public Card(Context context) {
        super(context);
    }

    public Card(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Card(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setImageResourceId(int imageResourceId) {
        super.setImageResource(imageResourceId);
    }

    public enum Types {
        BLUE, RED, WHITE, BLACK
    }
}
