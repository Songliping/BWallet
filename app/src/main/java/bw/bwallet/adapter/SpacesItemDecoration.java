package bw.bwallet.adapter;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Wei JiaQi on 2018/1/30.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;
        private int wtop;

    public SpacesItemDecoration(int space,int wtop) {
            this.space = space;
            this.wtop = wtop;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.left = space;
            outRect.top = space;
        }
    }
