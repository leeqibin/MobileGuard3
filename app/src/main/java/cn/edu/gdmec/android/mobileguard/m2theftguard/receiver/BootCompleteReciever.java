package cn.edu.gdmec.android.mobileguard.m2theftguard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import cn.edu.gdmec.android.mobileguard.App;

/**
 * Created by student on 17/10/17.
 */

public class BootCompleteReciever extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){
        ((App)(context.getApplicationContext())).correctSIM();
    }
}
