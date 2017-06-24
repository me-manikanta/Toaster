package mani.itachi.toaster;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ManikantaInugurthi on 20-06-2017.
 */

public class Toaster {
    /*
    * Text Cదlor
    * */
    private static final int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");

    /*
    * Toast Color
    * */
    private static final int ERROR_TOAST_COLOR = Color.parseColor("#D50000");
    private static final int INFO_TOAST_COLOR = Color.parseColor("#3F51B5");
    private static final int SUCCESS_TOAST_COLOR = Color.parseColor("#388E3C");
    private static final int WARNING_TOAST_COLOR = Color.parseColor("#FFA900");

    /*
    * Default Fonts
    * */
    private static final
    String SANS_SERIF_CONDENSED = "sans-serif-condensed";
    private static final
    String SANS_SERIF_LIGHT = "sans-serif-light";
    private static final
    String MONOSPACE = "MONOSPACE";
    private static final
    String SERIF = "SERIF";

    /*
    * Private Variables
    * */

    @NonNull
    private Context mContext;
    @ColorInt
    private int mTextColor, mBackgroundTintColor;
    @NonNull
    private String mMessage;
    private Drawable mIcon;
    private int mDuration, mGravity, mXOffset, mYOffset;
    private boolean mWithIcon, mShouldTint;
    private String mFont;
    private boolean mGravitySet;


    public Toaster(@NonNull Context context, @NonNull String message) {
        this.mContext = context;
        this.mMessage = message;
        this.mBackgroundTintColor = -1;
        this.mDuration = Toast.LENGTH_LONG;
        this.mFont = SANS_SERIF_CONDENSED;
        this.mWithIcon = false;
        this.mShouldTint = false;
        this.mTextColor = DEFAULT_TEXT_COLOR;
        this.mGravitySet = false;
    }

    public static Toaster makeText(@NonNull Context context, @NonNull String message) {
        return new Toaster(context, message);
    }

    public static @CheckResult
    Toaster error(@NonNull Context context, @NonNull String message) {
        return error(context, message, Toast.LENGTH_LONG);
    }

    public static @CheckResult
    Toaster error(@NonNull Context context, @NonNull String message, int duration) {
        Toaster toaster = new Toaster(context, message);
        toaster.setIcon(ToasterUtils.getDrawable(context, R.drawable.ic_error_outline_white_48dp))
                .setBackgroundColor(ERROR_TOAST_COLOR)
                .setDuration(duration);
        return toaster;
    }

    private static @CheckResult
    Toast custom(@NonNull Context context, @NonNull String message, Drawable icon,
                 @ColorInt int textColor, @ColorInt int tintColor, int duration,
                 boolean withIcon, boolean shouldTint, String font, boolean gravitySet, int gravity, int xOffset, int yOffset) {
        final Toast currentToast = new Toast(context);
        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.toaster_layout, null);
        final ImageView toastIcon = (ImageView) toastLayout.findViewById(R.id.toaster_icon);
        final TextView toastTextView = (TextView) toastLayout.findViewById(R.id.toaster_text);
        Drawable drawableFrame;

        if (shouldTint)
            drawableFrame = ToasterUtils.tint9PatchDrawableFrame(context, tintColor);
        else
            drawableFrame = ToasterUtils.getDrawable(context, R.drawable.toast_frame);
        ToasterUtils.setBackground(toastLayout, drawableFrame);

        if (withIcon) {
            if (icon == null)
                throw new IllegalArgumentException("Passing 'icon' as null if 'withIcon' is set to true");
            ToasterUtils.setBackground(toastIcon, icon);
        } else toastIcon.setVisibility(View.GONE);


        toastTextView.setTextColor(textColor);
        toastTextView.setText(message);
        toastTextView.setTypeface(Typeface.create(font, Typeface.NORMAL));

        currentToast.setView(toastLayout);
        currentToast.setDuration(duration);
        return currentToast;
    }

    public static @CheckResult
    Toaster success(@NonNull Context context, @NonNull String message) {
        return success(context, message, Toast.LENGTH_SHORT);
    }

    public static @CheckResult
    Toaster success(@NonNull Context context, @NonNull String message, int duration) {
        Toaster toaster = new Toaster(context, message);
        toaster.setIcon(ToasterUtils.getDrawable(context, R.drawable.ic_error_outline_white_48dp))
                .setBackgroundColor(SUCCESS_TOAST_COLOR)
                .setDuration(duration);
        return toaster;
    }

    public Toaster setBackgroundColor(@ColorInt int backgroundTintColor) {
        this.mBackgroundTintColor = backgroundTintColor;
        setShouldTint(true);
        return this;
    }

    private void setShouldTint(boolean mShouldTint) {
        this.mShouldTint = mShouldTint;
    }

    public Toaster setIcon(Drawable mIcon) {
        this.mIcon = mIcon;
        setWithIcon(true);
        return this;
    }

    private void setWithIcon(boolean mWithIcon) {
        this.mWithIcon = mWithIcon;
    }

    public Toaster setDuration(int mDuration) {
        this.mDuration = mDuration;
        return this;
    }

    public static @CheckResult
    Toaster info(@NonNull Context context, @NonNull String message) {
        return info(context, message, Toast.LENGTH_SHORT);
    }

    public static @CheckResult
    Toaster info(@NonNull Context context, @NonNull String message, int duration) {
        Toaster toaster = new Toaster(context, message);
        toaster.setIcon(ToasterUtils.getDrawable(context, R.drawable.ic_error_outline_white_48dp))
                .setBackgroundColor(INFO_TOAST_COLOR)
                .setDuration(duration);
        return toaster;
    }

    public static @CheckResult
    Toaster warning(@NonNull Context context, @NonNull String message) {
        return warning(context, message, Toast.LENGTH_SHORT);
    }

    public static @CheckResult
    Toaster warning(@NonNull Context context, @NonNull String message, int duration) {
        Toaster toaster = new Toaster(context, message);
        toaster.setIcon(ToasterUtils.getDrawable(context, R.drawable.ic_error_outline_white_48dp))
                .setBackgroundColor(WARNING_TOAST_COLOR)
                .setDuration(duration);
        return toaster;
    }

    public Toaster setTextColor(int mTextColor) {
        this.mTextColor = mTextColor;
        return this;
    }

    public Toaster setFont(String mFont) {
        this.mFont = mFont;
        return this;
    }

    public Toaster setGravity(int gravity, int xOffset, int yOffset) {
        this.mGravity = gravity;
        this.mXOffset = xOffset;
        this.mYOffset = yOffset;
        setGravity(true);
        return this;
    }

    private void setGravity(boolean gravitySet) {
        this.mGravitySet = gravitySet;
    }

    public void show() {
        custom(mContext, mMessage, mIcon, mTextColor, mBackgroundTintColor, mDuration, mWithIcon, mShouldTint, mFont, mGravitySet, mGravity, mXOffset, mYOffset).show();
    }

}
