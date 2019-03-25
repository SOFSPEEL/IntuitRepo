package com.example.intuitrepos.views;

import android.os.Parcelable;

public
interface CallbackSelected {
    void selected(Parcelable item);
    void notify(int position);
}
