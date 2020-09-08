package com.modemi4.codenames;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Game {

    Context context;
    public Card[] cardViews = new Card[15];


    Game(Context context, View layout) {
        this.context = context;
        TypedArray cardViewResourseIds = context.getResources().obtainTypedArray(R.array.CardImageViewIds);
        for(int i = 0; i < cardViewResourseIds.length(); i++) {
            int res = cardViewResourseIds.getResourceId(i, -1);
            cardViews[i] = layout.findViewById(res);
        }
        cardViewResourseIds.recycle();

        // picture setting
        List<Integer> picResourseIds = new ArrayList<>();

        TypedArray picTypedArray = context.getResources().obtainTypedArray(R.array.pictureIds);
        for(int i = 0 ; i < picTypedArray.length(); i++)
            picResourseIds.add(picTypedArray.getResourceId(i, -1));
        picTypedArray.recycle();
        Collections.shuffle(picResourseIds);

        for (int i = 0; i < cardViews.length; i++) {
            int res = picResourseIds.get(i);
            cardViews[i].setImageResourceId(res);
        }

        //type setting
        List<Card.Types> types = new ArrayList<>();
        for (int i = 0; i < cardViews.length; i++) {
            if(i < 5)
                types.add(Card.Types.RED);
            else if(i < 10)
                types.add(Card.Types.BLUE);
            else if(i < 14)
                types.add(Card.Types.WHITE);
            else
                types.add(Card.Types.BLACK);
        }
        Collections.shuffle(types);
        for (int i = 0; i < cardViews.length; i++) {
            cardViews[i].Type = types.get(i);
        }

        //for(int i = 0; i < cardViews.length)
        //animation
        Animation cardRowAppearLTR = AnimationUtils.loadAnimation(context, R.anim.card_row_appear_ltr);
        Animation cardRowAppearRTL = AnimationUtils.loadAnimation(context, R.anim.card_row_appear_rtl);
        LinearLayout row1 =  layout.findViewById(R.id.row1);
        LinearLayout row2 =  layout.findViewById(R.id.row2);
        LinearLayout row3 =  layout.findViewById(R.id.row3);
        row1.startAnimation(cardRowAppearLTR);
        row2.startAnimation(cardRowAppearRTL);
        row3.startAnimation(cardRowAppearLTR);
    }
}
