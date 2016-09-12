package com.cleveroad.fanlayoutmanager;

import android.content.Context;

/**
 * Created by Alex Yarovoi 16.08.2016
 */
public class FanLayoutManagerSettings {

    private static final float DEFAULT_VIEW_WIDTH_DP = 120;
    private static final float DEFAULT_VIEW_HEIGHT_DP = 160;

    private float viewWidthDp;
    private float viewHeightDp;

    private int viewWidthPx;
    private int viewHeightPx;

    private boolean isFanRadiusEnable;

    private float angleItemBounce;

    private FanLayoutManager.Mode mode = FanLayoutManager.Mode.OVERLAPPING;

    private FanLayoutManagerSettings(Builder builder) {
        viewWidthDp = builder.viewWidthDp;
        viewHeightDp = builder.viewHeightDp;
        isFanRadiusEnable = builder.isFanRadiusEnable;
        angleItemBounce = builder.angleItemBounce;
        viewWidthPx = builder.viewWidthPx;
        viewHeightPx = builder.viewHeightPx;
        mode = builder.mode;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public float getViewWidthDp() {
        return viewWidthDp;
    }

    public float getViewHeightDp() {
        return viewHeightDp;
    }

    public boolean isFanRadiusEnable() {
        return isFanRadiusEnable;
    }

    public float getAngleItemBounce() {
        return angleItemBounce;
    }

    public int getViewWidthPx() {
        return viewWidthPx;
    }

    public int getViewHeightPx() {
        return viewHeightPx;
    }

    public FanLayoutManager.Mode getMode() {
        return mode;
    }

    public void setMode(FanLayoutManager.Mode mode) {
        this.mode = mode;
    }

    /**
     * {@code FanLayoutManagerSettings} builder static inner class.
     */
    public static final class Builder {
        private Context context;
        private float viewWidthDp;
        private float viewHeightDp;
        private boolean isFanRadiusEnable;
        private float angleItemBounce;
        private int viewWidthPx;
        private int viewHeightPx;
        private FanLayoutManager.Mode mode = FanLayoutManager.Mode.OVERLAPPING;

        private Builder(Context context) {
            this.context = context;
        }

        /**
         * Sets the {@code viewWidthDp} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param viewWidthDp the {@code viewWidthDp} to set
         * @return a reference to this Builder
         */
        public Builder withViewWidthDp(float viewWidthDp) {
            this.viewWidthDp = viewWidthDp;
            this.viewWidthPx = Math.round(context.getResources().getDisplayMetrics().density * viewWidthDp);

            return this;
        }

        /**
         * Sets the {@code viewHeightDp} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param viewHeightDp the {@code viewHeightDp} to set
         * @return a reference to this Builder
         */
        public Builder withViewHeightDp(float viewHeightDp) {
            this.viewHeightDp = viewHeightDp;
            this.viewHeightPx = Math.round(context.getResources().getDisplayMetrics().density * viewHeightDp);
            return this;
        }

        /**
         * Sets the {@code fanRadius} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param isFanRadiusEnable the {@code isFanRadiusEnable} to set
         * @return a reference to this Builder
         */
        public Builder withFanRadius(boolean isFanRadiusEnable) {
            this.isFanRadiusEnable = isFanRadiusEnable;
            return this;
        }

        /**
         * Sets the {@code angleItemBounce} and returns a reference to this Builder so that the methods can be chained together.
         *
         * @param angleItemBounce the {@code angleItemBounce} to set
         * @return a reference to this Builder
         */
        public Builder withAngleItemBounce(float angleItemBounce) {
            this.angleItemBounce = angleItemBounce;
            return this;
        }


        /**
         * Sets the {@code mode} and returns a reference to this Builder so that the methods can be chained together.
         * @param mode the {@code mode} to set
         * @return  a reference to this Builder
         */
        public Builder withMode(FanLayoutManager.Mode mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Returns a {@code FanLayoutManagerSettings} built from the parameters previously set.
         *
         * @return a {@code FanLayoutManagerSettings} built with parameters of this {@code FanLayoutManagerSettings.Builder}
         */
        public FanLayoutManagerSettings build() {
            if (Float.compare(viewWidthDp, 0F) == 0) {
                withViewWidthDp(DEFAULT_VIEW_WIDTH_DP);
            }
            if (Float.compare(viewHeightDp, 0F) == 0) {
                withViewHeightDp(DEFAULT_VIEW_HEIGHT_DP);
            }
            return new FanLayoutManagerSettings(this);
        }
    }
}
