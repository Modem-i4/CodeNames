package com.modemi4.codenames;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

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
        int[] cardResourseIds = new int[] { R.id.i0, R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5, R.id.i6, R.id.i7, R.id.i8, R.id.i9, R.id.i10, R.id.i11, R.id.i12, R.id.i13, R.id.i14 };
        int[] picResourseIds = new int[] { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10, R.drawable.pic11, R.drawable.pic12, R.drawable.pic13, R.drawable.pic14, R.drawable.pic15, R.drawable.pic16, R.drawable.pic17, R.drawable.pic18, R.drawable.pic19, R.drawable.pic20, R.drawable.pic21, R.drawable.pic22, R.drawable.pic23, R.drawable.pic24, R.drawable.pic25, R.drawable.pic26, R.drawable.pic27, R.drawable.pic28, R.drawable.pic29, R.drawable.pic30 };

//        TypedArray cardResourseIdss = context.getResources().obtainTypedArray(R.array.CardImageViewIds);
//        Drawable drawable = cardResourseIdss.getResourceId(position, -1);
//        cardResourseIdss.recycle();

        for(int i = 0; i < cardResourseIds.length; i++) {
            cardViews[i] = layout.findViewById(cardResourseIds[i]);
        }

        // picture setting
        Collections.shuffle(Collections.singletonList(picResourseIds));

        for (int i = 0; i < cardResourseIds.length; i++) {
            cardViews[i].setImageResourceId(cardResourseIds[i]);
        }

//        Random rand = new Random();
//        List<Integer> idsInUse = new ArrayList<>();
//        for (int i = 0; i < cardResourseIds.length; i++) {
//            int pictreIndex = rand.nextInt(30)+1;
//            if(!idsInUse.contains(pictreIndex)) {
//                int res = context.getResources().getIdentifier("pic" + pictreIndex + ".png", "drawable", context.getPackageName());
//                cardViews[i].setImageResourceId(res);
//                idsInUse.add(pictreIndex);
//            } else {
//                i--;
//            }
//        }
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
    }
}
